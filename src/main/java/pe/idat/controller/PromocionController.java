package pe.idat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.idat.dto.MiPromoDTORequest;
import pe.idat.dto.MiPromoDTOResponse;
import pe.idat.dto.PromoDTORequest;
import pe.idat.model.Cliente;
import pe.idat.model.MisPromociones;
import pe.idat.model.Promocion;
import pe.idat.model.Restaurant;
import pe.idat.repository.MiPromoRepository;
import pe.idat.repository.PromocionRepository;
import pe.idat.repository.RestaurantRepository;
import pe.idat.service.ClienteService;
import pe.idat.service.MiPromocionService;
import pe.idat.service.PromocionService;
import pe.idat.service.RestaurantService;

@RestController
@RequestMapping("/promocion/v1")
public class PromocionController {
	
	@Autowired
	private PromocionService service;
	
	@Autowired
	private MiPromocionService miPromocionService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	
	
	@Autowired
	private PromocionRepository repository;
	
	
	@Autowired
	private MiPromoRepository miPromoRepository;
	
	@RequestMapping(path="/listar",method = RequestMethod.GET)
	public ResponseEntity<List<Promocion>> listar(){
		
		return new ResponseEntity<List<Promocion>>(service.listar(),HttpStatus.OK);
	}
	@RequestMapping(path="/listarByRestaurant/{id}",method = RequestMethod.GET)
	public ResponseEntity<List<Promocion>> listarPromoByRestaurant(@PathVariable Integer id){
		List<Promocion> lista=service.listarByRestaurantId(id);
		if(lista.equals(null)|| lista.isEmpty()) {
			return new ResponseEntity<List<Promocion>>(lista,HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Promocion>>(lista,HttpStatus.OK);
		}
		
		
	}
	
	

	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardarPromocion(@RequestBody PromoDTORequest dto){
		Restaurant restaurant= restaurantService.obtener(dto.getIdRestaurant());
		
		Promocion promocion=new Promocion(dto);
		
		promocion.setRestaurantes(restaurant);
		
		promocion=repository.save(promocion);
		
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path="/listarMisPromos",method = RequestMethod.GET)
	public ResponseEntity<List<MisPromociones>> listarMisPromos(){
		return new ResponseEntity<List<MisPromociones>>(miPromocionService.listar(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/listarByIdCliente/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<MisPromociones>> listarByIdCliente(@PathVariable Integer id){
		List<MisPromociones> lista=miPromocionService.listarByClienteId(id);
		if(lista.equals(null)||lista.isEmpty()) {
			return new ResponseEntity<List<MisPromociones>>(lista,HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<MisPromociones>>(lista,HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(path = "/guardarmipromo", method = RequestMethod.POST)
	public ResponseEntity<?> guardarMiPromocion(@RequestBody MiPromoDTORequest dto){
		Cliente cliente=clienteService.obtener(dto.getIdCliente());
		MisPromociones promo=new MisPromociones();
		promo.setClientes(cliente);
		promo.setMipromNombre(dto.getMipromNombre());
		promo.setDescrip(dto.getDescrip());
		promo.setFechaFin(dto.getFechaFin());
		promo.setMiproImage(dto.getMiproImage());
		promo.setMiproPrecio(dto.getMiproPrecio());
		
		promo=miPromoRepository.save(promo);

		return ResponseEntity.ok(new MiPromoDTOResponse(true,"Promoción registrada"));
	}
	
 	@RequestMapping(path="/eliminar/{id}",  method =RequestMethod.DELETE )
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		Promocion obj=service.obtener(id);
		if(obj !=null) {
			service.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		
	}

}
