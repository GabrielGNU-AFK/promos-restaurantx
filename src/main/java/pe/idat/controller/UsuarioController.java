package pe.idat.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.idat.dto.ClienteDTORequest;
import pe.idat.dto.ClienteDTOResponse;
import pe.idat.dto.UsuarioDTORequest;
import pe.idat.dto.UsuarioDTOResponse;
import pe.idat.model.Cliente;
import pe.idat.model.Usuario;
import pe.idat.repository.ClienteRepository;
import pe.idat.repository.UsuarioRepository;
import pe.idat.security.JwtUtil;
import pe.idat.security.UserDetailService;
import pe.idat.service.ClienteService;
import pe.idat.service.UsuarioService;


@RestController
@RequestMapping("/usuarios/v1")
public class UsuarioController {
	
	@Autowired
	private JwtUtil util;
	
	private final Logger logger=LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private ClienteService clienteservice;
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@Autowired
	private UserDetailService userDetailService;
	
	BCryptPasswordEncoder passEncode= new BCryptPasswordEncoder();

	
	@RequestMapping(path = "/iniciarSession", method = RequestMethod.POST)
	public ResponseEntity<?> iniciarSession(@RequestBody UsuarioDTORequest dto){
		
		Usuario user=userRepository.findByUsuario(dto.getUsuario());	
		Cliente userCliente= clienteRepository.findByUsuario(dto.getUsuario());
		Cliente cli= new Cliente();
		
		if(user==null) {
			return ResponseEntity.ok(new UsuarioDTOResponse(cli,false));
		}
		
		UserDetails detail = userDetailService.loadUserByUsername(dto.getUsuario());
		if(passEncode.matches(dto.getContrasenia(), detail.getPassword())) {
			logger.info(" Usuario: {}",userCliente);
			return ResponseEntity.ok(new UsuarioDTOResponse(userCliente,true));
			
		}else {
			return ResponseEntity.ok(new UsuarioDTOResponse(cli,false));
		}
		
		
		
	}
	
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<?> guardar(@RequestBody ClienteDTORequest request){
		
		List<Usuario> userName=service.listar().stream().filter(p->p.getUsuario().contains(request.getUsuario())).collect(Collectors.toList());
		Optional<Cliente> cli=clienteRepository.findByCorreo(request.getCorreo());
		logger.info(" Usuario: {}",userName);
		logger.info(" Correo: {}",cli);
		
		if(userName.isEmpty() && cli.isEmpty()) {	
			
			
			Usuario user=new Usuario();
		
			
			user.setUsuario(request.getUsuario());
			user.setPassword(passEncode.encode(request.getPassword()));
			user.setRol("ROLE_USER");
			user=userRepository.save(user);
			
			Cliente client=new Cliente(request);
			client.setUsuario(user);
			
			client=clienteRepository.save(client);
			return  ResponseEntity.ok(new ClienteDTOResponse(true, "Usted ah sido registrado satisfactoriamente."));
			}
		else {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
}
