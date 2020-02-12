package anketa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import anketa.model.Korisnik;
import anketa.repository.KorisnikRepository;

@Controller
@RequestMapping(value="/Korisnik")
public class KorisnikController {
	
	@Autowired
	KorisnikRepository kr;
	
	@RequestMapping(value="/pretplata", method=RequestMethod.POST)
	public String pretplata(Model m, String ime, String email) {
		
		Korisnik k=new Korisnik();
		k.setIme(ime);
		k.setEmail(email);
		
		Korisnik k1=kr.save(k);
		if(k1!=null) {
			m.addAttribute("poruka","Uspesna pretplata!");
		}
		return "PretplatiSe";
	}

}
