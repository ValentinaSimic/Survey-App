package anketa.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import anketa.model.Anketa;

public interface AnketaRepository extends MongoRepository<Anketa, String> {
	
	public List<Anketa> findByPol(String naziv);
	public List<Anketa> findByObavljenaKupovina(String naziv);
	public List<Anketa> findByPolAndObavljenaKupovina(String pol, String kupovina);
	public List<Anketa> findByIzvorSaznanjaZaOnlajnKupovinu(String izvor);
	public List<Anketa> findByObavljenaKupovinaAndPonovnaOnlajnKupovina(String jesu, String idalje);
	public List<Anketa> countByZastoJosNeOnlajnKupovina(String razlog);
	public List<Anketa> findByZastoJosNeOnlajnKupovina(String razlog);

	public List<Anketa> findTop3ByNasiSajtovi(String razlog);
	public List<Anketa> countByNasiSajtovi(String sajt);
	public List<Anketa> countByBitnost(String bitnost);
	public List<Anketa> findByProizvodi();
	public List<Anketa> findByAliAmazon(String text);
	
	//public List<Anketa> findTop3ByAliAndAmazon();

}
