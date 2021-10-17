package br.ufg.inf.fs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
import br.ufg.inf.fs.entities.Regra;
import br.ufg.inf.fs.entities.Usuario;
import br.ufg.inf.fs.repositories.RegraRepository;
import br.ufg.inf.fs.repositories.UsuarioRepository;

@SuppressWarnings("unused")
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
	
	/*@SuppressWarnings("unused")
	@Autowired
	private UsuarioRepository usuarioRepository;*/

	@Autowired
	private RegraRepository regraRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		/*
		 * INSERIR NO MEU BANCO DE DADOS INFORMAÇÕES INICIAIS...
		 * */
		
		String[] tipoH = new String[] {"Hotel","Pousada","Resort","Hostel","Pensão"};
		String[] nomeH = new String[] {"Dos Passados","Das Emas","Dos Imigrantes","Da Alegria","Da cidade"};
		String[] localH = new String[] {"Goiânia","Anapolis","Brasilia","Trindade","Jatai"};
		
		for(int i = 0; i < 15; i++) {
			
			hoteRepository.save(new Hotel(null,tipoH[new Random().nextInt(5)]+ " " + nomeH[new Random().nextInt(5)],
								localH[new Random().nextInt(5)],
								new Random().nextInt(5) + 1));
		}
		
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
		
		String[] nomeHospede = new String[] {"João","José","Joana","Carlos","Gustavo"};
		String[] sobreNomeHospede = new String[] {"Lucas","Silva","Maria","Eduardo","Moreira"};
		String[] cpfHospede = new String[] {"123456","123789","456789","789456","987321"};
		String[] diaNascH = new String[] {"05","10","15","20","25"};
		String[] mesNascH = new String[] {"01","02","03","05","07"};
		String[] anoNascH = new String[] {"1990","1985","1995","2000","1980"};
		
		for(int i = 0; i < 15; i++) {
			
			hospedeRepository.save(new Hospede(null,nomeHospede[new Random().nextInt(5)]+ " " +
					sobreNomeHospede[new Random().nextInt(5)],cpfHospede[new Random().nextInt(5)],diaNascH[new Random().nextInt(5)] + "/" + mesNascH[new Random().nextInt(5)] + "/" + anoNascH[new Random().nextInt(5)]));

		}
		
		Hospede p1 = new Hospede(null, "Joao Luiz", "454545", "01/05/1990");
		Hospede p2 = new Hospede(null, "Julia Santana", "787878", "22/10/1992");
		Hospede p3 = new Hospede(null, "José Carlos", "121212", "15/03/1987");
		Hospede p4 = new Hospede(null, "Jade Santos", "989898", "07/12/2000");
		
		p1 = hospedeRepository.save(p1);
		p2 = hospedeRepository.save(p2);
		p3 = hospedeRepository.save(p3);
		p4 = hospedeRepository.save(p4);
		
		/*String[] nomeHospede = new String[] {"João","José","Joana","Carlos","Gustavo"};
		String[] sobreNomeHospede = new String[] {"Lucas","Silva","Maria","Eduardo","Moreira"};
		String[] cpfHospede = new String[] {"123456","123789","456789","789456","987321"};
		String[] diaNascH = new String[] {"05","10","15","20","25"};
		String[] mesNascH = new String[] {"01","02","03","05","07"};
		String[] anoNascH = new String[] {"1990","1985","1995","2000","1980"};*/
		
		String[] diaHospeda = new String[] {"05","10","15","20","25"};
		String[] mesHospeda = new String[] {"01","02","03","05","07"};
		String[] anoHospeda = new String[] {"2019","2020","2021","2022","2023"};
		
		for(int i = 0; i < 15; i++) {
			
			hospedagemRepository.save(new Hospedagem(null,quartoRepository.getById(new Random().nextInt(4)+1),hospedeRepository.getById(new Random().nextInt(5)+1),
					diaHospeda[new Random().nextInt(5)] + "/" + mesHospeda[new Random().nextInt(5)] + "/" + anoHospeda[new Random().nextInt(5)],
					diaHospeda[new Random().nextInt(5)] + "/" + mesHospeda[new Random().nextInt(5)] + "/" + anoHospeda[new Random().nextInt(5)]));
		}
		
		Hospedagem v1 = new Hospedagem(null, q1, p1, "20/09/2021", "25/09/2021");
		Hospedagem v2 = new Hospedagem(null, q2, p2, "10/10/2021", "18/10/2021");
		Hospedagem v3 = new Hospedagem(null, q3, p3, "01/09/2021", "30/09/2021");
		Hospedagem v4 = new Hospedagem(null, q4, p4, "01/12/2021", "01/01/2022");
		
		v1 = hospedagemRepository.save(v1);
		v2 = hospedagemRepository.save(v2);
		v3 = hospedagemRepository.save(v3);
		v4 = hospedagemRepository.save(v4);
		
		Regra r1 = regraRepository.save(new Regra("ADMIN"));
		Regra r2 = regraRepository.save(new Regra("USER"));
		/*@SuppressWarnings("unused")*/
		Regra r3 = regraRepository.save(new Regra("GUEST"));

		List<Regra> regras = new ArrayList<Regra>();

		regras.add(r1);
		regras.add(r2);

		/*
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		@SuppressWarnings("unused")
		Usuario usu1 = usuarioRepository.save(new Usuario("luiz", "Luiz Martins", encoder.encode("4321"), regras));

		regras = new ArrayList<Regra>();

		regras.add(r2);
		regras.add(r3);

		@SuppressWarnings("unused")
		Usuario usu2 = usuarioRepository.save(new Usuario("jose", "Jose Silva", encoder.encode("asdf"), regras));*/

	}
}