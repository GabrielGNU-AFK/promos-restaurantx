package pe.idat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.idat.model.Promocion;
import pe.idat.model.Restaurant;
import pe.idat.service.RestaurantService;

@RestController
@RequestMapping("/restaurant/v1")
public class RestaurantController {
	
	@Autowired
	private RestaurantService service;
	
	@RequestMapping(path="/listar/comidarapida",method = RequestMethod.GET)
	public ResponseEntity<List<Restaurant>> listar(){
		return new ResponseEntity<List<Restaurant>>(service.listarComidaRapida(),HttpStatus.OK);	
	}
	
	@RequestMapping(path="/listar/comidafamiliar",method = RequestMethod.GET)
	public ResponseEntity<List<Restaurant>> listarfamiliar(){
		return new ResponseEntity<List<Restaurant>>(service.listarComidaFamiliar(),HttpStatus.OK);	
	}
	
	@RequestMapping(path="/listar/comidagourmet",method = RequestMethod.GET)
	public ResponseEntity<List<Restaurant>> listargourmet(){
		return new ResponseEntity<List<Restaurant>>(service.listarComidaGourmet(),HttpStatus.OK);	
	}

	
	

}
