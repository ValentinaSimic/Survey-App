package anketa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import anketa.model.Korisnik;

public interface KorisnikRepository extends MongoRepository<Korisnik, String> {

}
