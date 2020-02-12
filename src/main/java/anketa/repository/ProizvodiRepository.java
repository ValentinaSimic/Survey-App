package anketa.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import anketa.model.Proizvodi;

public interface ProizvodiRepository extends MongoRepository<Proizvodi, String> {
	
	/*List<Proizvodi> findByHrana();
	List<Proizvodi> findByTehnika();
	List<Proizvodi> findByOstalo();
	List<Proizvodi> findBOdevniPredmeti();*/
}
