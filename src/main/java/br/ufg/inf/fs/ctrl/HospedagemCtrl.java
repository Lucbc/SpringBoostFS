package br.ufg.inf.fs.ctrl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufg.inf.fs.Messages;
import br.ufg.inf.fs.business.HospedagemBusiness;
import br.ufg.inf.fs.entities.Hospedagem;
import br.ufg.inf.fs.exceptions.HospedagemException;

@CrossOrigin
@RestController
@RequestMapping(value="hospedagens")
public class HospedagemCtrl {

	@Autowired
	private HospedagemBusiness business;
	
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public ResponseEntity<List<Hospedagem>> findAll(){
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		List<Hospedagem> list = new ArrayList<Hospedagem>();
		try {
			list = business.findAll();
			if(list.size() == 0) {
				headers.add("message", Messages.get("0207"));
			}
		}catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
			headers.add("message", Messages.get("0002"));
		}
		return new ResponseEntity<List<Hospedagem>>(list, headers, status);
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/paginator")
	public ResponseEntity<Page<Hospedagem>> paginator(Pageable pageable){
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		Page<Hospedagem> list = null;
		try {
			list = business.paginator(pageable);
			if(list.getSize() == 0) {
				headers.add("message", Messages.get("0107"));
			}
		}catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
			headers.add("message", Messages.get("0002"));
		}
		return new ResponseEntity<Page<Hospedagem>>(list, headers, status);
	}
	
	//@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<Hospedagem> findById(@PathVariable Integer id){
		Hospedagem retorno = new Hospedagem();
		
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		try {
			retorno = business.findByIdHospedagem(id);
			if(retorno == null) {
				headers.add("message", Messages.get("0207"));
			}
		}catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
			headers.add("message", Messages.get("0002"));
		}
		return new ResponseEntity<Hospedagem>(retorno, headers, status);
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<Hospedagem> insert(@RequestBody Hospedagem hospedagem){
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.CREATED;
		
		try {
			hospedagem = business.insert(hospedagem);
			headers.add("message", Messages.get("0201"));
		} catch (HospedagemException e) {
			headers.add("message", Messages.get(e.getMessage()));
			status = HttpStatus.BAD_REQUEST;
		} catch (Exception e) {
			headers.add("message", Messages.get("0202"));
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Hospedagem>(hospedagem, headers, status);
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	@PutMapping
	public ResponseEntity<Hospedagem> update(@RequestBody Hospedagem hospedagem){
		
		
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		
		try {
			hospedagem = business.update(hospedagem);
			headers.add("message", Messages.get("0203"));
		} catch (HospedagemException e) {
			headers.add("message", Messages.get(e.getMessage()));
			status = HttpStatus.BAD_REQUEST;
		} catch (Exception e) {
			headers.add("message", Messages.get("0204"));
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Hospedagem>(hospedagem, headers, status);
		
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.NO_CONTENT;
		
		try {
			business.delete(id);
		} catch (Exception e) {
			headers.add("message", Messages.get("0206"));
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Void>(headers, status);
	}
	
}