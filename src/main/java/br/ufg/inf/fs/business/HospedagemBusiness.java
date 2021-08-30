package br.ufg.inf.fs.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.fs.entities.Hospedagem;
import br.ufg.inf.fs.exceptions.HospedagemException;
import br.ufg.inf.fs.repositories.HospedagemRepository;

@Service
public class HospedagemBusiness {
	
	@Autowired
	private HospedagemRepository repository;
	
	public List<Hospedagem> findAll(){
		return repository.findAll();		
	}
	
	public Hospedagem findByIdHospedagem(Integer id) {
		Optional<Hospedagem> retorno = repository.findById(id);
		return retorno.get();
	}
	
	public Hospedagem insert(Hospedagem hospedagem) throws HospedagemException {
		this.validaHospedagem(hospedagem);
		return repository.save(hospedagem);
	}
	
	public Hospedagem update(Hospedagem hospedagem) throws HospedagemException {
		this.validaHospedagem(hospedagem);
		return repository.save(hospedagem);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	
	private void validaHospedagem(Hospedagem hospedagem) throws HospedagemException {
		if(hospedagem.getIdQuarto() == null) {
			throw new HospedagemException("0209");
		}
		if(hospedagem.getIdHospede() == null) {
			throw new HospedagemException("0208");
		}
		if(hospedagem.getDtCheckin() == null || hospedagem.getDtCheckout() == null) {
			throw new HospedagemException("0210");
		}
	}
}