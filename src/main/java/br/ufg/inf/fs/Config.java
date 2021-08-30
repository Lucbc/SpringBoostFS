package br.ufg.inf.fs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.ufg.inf.fs.entities.Hospedagem;
import br.ufg.inf.fs.entities.Hospede;
import br.ufg.inf.fs.entities.Hotel;
import br.ufg.inf.fs.entities.Quarto;
import br.ufg.inf.fs.enums.CategoriaQuarto;
import br.ufg.inf.fs.repositories.HotelRepository;
import br.ufg.inf.fs.repositories.QuartoRepository;
import br.ufg.inf.fs.repositories.HospedagemRepository;
import br.ufg.inf.fs.repositories.HospedeRepository;

@Configuration
@Profile("dev")
public class Config  implements CommandLineRunner{

	@Autowired
	private HotelRepository hoteRepository;
	
	@Autowired
	private QuartoRepository quartoRepository;
	
	@Autowired
	private HospedeRepository hospedeRepository;
	
	@Autowired
	private HospedagemRepository hospedagemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		/*
		 * INSERIR NO MEU BANCO DE DADOS INFORMAÇÕES INICIAIS...
		 * */
		
		Hotel h1 = new Hotel(null, "Calderão Furado", "Beco Diagonal", 3);
		Hotel h2 = new Hotel(null, "Bates Hotel", "White Pine Bay", 2);
		Hotel h3 = new Hotel(null, "Hotel Overlook", "Colorado", 4);
		Hotel h4 = new Hotel(null, "Continental Hotel", "Ney York City", 5);
		
		h1 = hoteRepository.save(h1);
		h2 = hoteRepository.save(h2);
		h3 = hoteRepository.save(h3);
		h4 = hoteRepository.save(h4);
		
		Quarto q1 = new Quarto(null, h1, CategoriaQuarto.APARTAMENTO, 4, 1010, 200.0);
		Quarto q2 = new Quarto(null, h2, CategoriaQuarto.SIMPLES, 1, 7, 100.0);
		Quarto q3 = new Quarto(null, h3, CategoriaQuarto.PADRAO, 2, 306, 150.0);
		Quarto q4 = new Quarto(null, h4, CategoriaQuarto.LUXO, 3, 1313, 500.0);
		
		q1 = quartoRepository.save(q1);
		q2 = quartoRepository.save(q2);
		q3 = quartoRepository.save(q3);
		q4 = quartoRepository.save(q4);
		
		Hospede p1 = new Hospede(null, "Joao Luiz", 454545, "01/05/1990");
		Hospede p2 = new Hospede(null, "Julia Santana", 787878, "22/10/1992");
		Hospede p3 = new Hospede(null, "José Carlos", 121212, "15/03/1987");
		Hospede p4 = new Hospede(null, "Jade Santos", 989898, "07/12/2000");
		
		p1 = hospedeRepository.save(p1);
		p2 = hospedeRepository.save(p2);
		p3 = hospedeRepository.save(p3);
		p4 = hospedeRepository.save(p4);
		
		Hospedagem r1 = new Hospedagem(null, q1, p1, "20/09/2021", "25/09/2021");
		Hospedagem r2 = new Hospedagem(null, q2, p2, "10/10/2021", "18/10/2021");
		Hospedagem r3 = new Hospedagem(null, q3, p3, "01/09/2021", "30/09/2021");
		Hospedagem r4 = new Hospedagem(null, q4, p4, "01/12/2021", "01/01/2022");
		
		r1 = hospedagemRepository.save(r1);
		r2 = hospedagemRepository.save(r2);
		r3 = hospedagemRepository.save(r3);
		r4 = hospedagemRepository.save(r4);

	}
}