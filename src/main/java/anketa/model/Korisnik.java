package anketa.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="korisnikVS")
public class Korisnik {
	String ime;
	String email;
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
