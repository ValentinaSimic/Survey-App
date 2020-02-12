package anketa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MapReduceCommand;
import com.mongodb.MapReduceOutput;
import com.mongodb.MongoClient;
import com.mongodb.client.MapReduceIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import anketa.model.Anketa;
import anketa.model.Proizvodi;
import anketa.repository.AnketaRepository;
import anketa.repository.ProizvodiRepository;

@Controller
@RequestMapping(value = "/Anketa")
public class AnketaController {

	@Autowired
	AnketaRepository ar;

	@Autowired
	ProizvodiRepository pr;

	Proizvodi p = new Proizvodi();

	@RequestMapping(value = "/sacuvajOdgovor", method = RequestMethod.POST)
	public String saveAnketa(Model m, HttpServletRequest request) {

		Anketa a = new Anketa();

		String obavljenaKupovina = request.getParameter("obavljenaKupovina");
		if (obavljenaKupovina.equals("jesam")) {
			System.out.println("usoaoo");
			String pol = request.getParameter("pol");
			int godine = Integer.parseInt(request.getParameter("godine"));
			String statusZaposlenosti = request.getParameter("statusZaposlenosti");
			double mesecnaPrimanja = Double.parseDouble(request.getParameter("mesecnaPrimanja"));
			String izvorSaznanjaZaOnlajnKupovinu = request.getParameter("izvorSaznanjaZaOnlajnKupovinu");
			double najcesciIznosNovca = Integer.parseInt(request.getParameter("najcesciIznosNovca"));

			String najcesceMetodePlacanja = request.getParameter("najcesceMetodePlacanja");
			String nasiSajtovi = request.getParameter("nasiSajtovi");
			String omiljenSajt = request.getParameter("omiljenSajt");
			String razloziDaOnljanKupovini = request.getParameter("razloziDaOnljanKupovini");
			String ponovnaOnlajnKupovina = request.getParameter("ponovnaOnlajnKupovina");
			String bitnost = request.getParameter("bitnost");
			String aliAndAmazon = request.getParameter("aliAmazon");

			if (aliAndAmazon.equals("da")) {
				int ocenaAA = Integer.parseInt(request.getParameter("ocenaAA"));
				int isporuka = Integer.parseInt(request.getParameter("isporuka"));
				a.setOcenaAA(ocenaAA);
				a.setIsporuka(isporuka);
			}

			String proizvodi = request.getParameter("proizvodi");

			if (proizvodi.equals("hrana")) {

			}
			a.setPol(pol);
			a.setGodine(godine);
			a.setStatusZaposlenosti(statusZaposlenosti);
			a.setMesecnaPrimanja(mesecnaPrimanja);
			a.setObavljenaKupovina(obavljenaKupovina);
			a.setIzvorSaznanjaZaOnlajnKupovinu(izvorSaznanjaZaOnlajnKupovinu);
			a.setNajcesceMetodePlacanja(najcesceMetodePlacanja);
			a.setNajcesciIznosNovca(najcesciIznosNovca);
			a.setRazloziDaOnljanKupovini(razloziDaOnljanKupovini);
			a.setNasiSajtovi(nasiSajtovi);
			a.setPonovnaOnlajnKupovina(ponovnaOnlajnKupovina);
			a.setAliAmazon(aliAndAmazon);
			a.setOmiljenSajt(omiljenSajt);

			a.setBitnost(bitnost);

			String vrsta = request.getParameter("proizvodi");
			if (vrsta.equals("hrana")) {
				p.setHrana(1);
				// p.setHrana(p.getHrana() + 1);
			} else if (vrsta.equals("tehnika")) {
				p.setTehnika(1);
			} else if (vrsta.equals("odevniPredmeti")) {
				p.setOdevniPredmeti(1);
			} else {
				p.setOstalo(1);
			}
			a.setProizvodi(p);

		}

		else {
			a.setObavljenaKupovina(request.getParameter("obavljenaKupovina"));
			String zastoJosNeOnlajnKupovina = request.getParameter("zastoJosNeOnlajnKupovina");
			a.setZastoJosNeOnlajnKupovina(zastoJosNeOnlajnKupovina);
			System.out.println("ii ovde");
		}

		Anketa a1 = ar.save(a);
		if (a1 != null) {
			m.addAttribute("poruka", "Uspesno sacuvani odgovori");
		}

		return "AnketaOnlajnKupovina.jsp";
	}

	@RequestMapping(value = "/procenatKupovao", method = RequestMethod.GET)
	public String kupovao(HttpServletRequest request, Model model) {
		

		/*MongoClient mongoClient = new MongoClient("nastava.is.pmf.uns.ac.rs", 27017);
		MongoDatabase db = mongoClient.getDatabase("student");
		MongoCollection<Document> mnc=db.getCollection("anketeVS");
		mnc.deleteMany({"godine":{$lt :11}});*/
		//Zastp ne radi delete, pitaj profesorku.
		
		

		List<Anketa> sviUcesnici = ar.findAll();
		List<Anketa> kupovaliOnlajn = ar.findByObavljenaKupovina("jesam");
		double procenat = ((double) kupovaliOnlajn.size() / sviUcesnici.size()) * 100;

		request.getSession().setAttribute("procenatKupovao", (int) procenat);

		return "redirect:/Anketa/preporuka";

	}

	@RequestMapping(value = "/pol", method = RequestMethod.GET)
	public String polKupovina(HttpServletRequest request) {

		List<Anketa> anketeZ = ar.findByPolAndObavljenaKupovina("zenski", "jesam");
		List<Anketa> anketeM = ar.findByPolAndObavljenaKupovina("muski", "jesam");

		if (anketeZ.size() > anketeM.size()) {
			System.out.println("Zene cesce kupuju");
			request.getSession().setAttribute("pol", " preovladjuju zene");
		} else if (anketeZ.size() == anketeM.size()) {
			System.out.println("Muskarci i zene podjednako kupuju");
			request.getSession().setAttribute("pol", "podjednako kupuju i muskarci i zene");
		} else {
			System.out.println("Muskarci cesce kupuju");
			request.getSession().setAttribute("pol", "preovladjuju muskarci");

		}
		return "redirect:/Anketa/prosecanRacun";
	}

	@RequestMapping(value = "/prosecanRacun", method = RequestMethod.GET)
	public String mapReduce(HttpServletRequest request) {
		List<Anketa> ankete = ar.findByObavljenaKupovina("jesam");
		double racun = 0;
		double zarada = 0;
		int i = 0;
		for (Anketa a : ankete) {
			racun += a.getNajcesciIznosNovca();
			zarada += a.getMesecnaPrimanja();
			i++;
		}

		request.getSession().setAttribute("prosecnaPotrosnja", (int) racun / i);
		request.getSession().setAttribute("prosecnaZarada", (int) zarada / i);

		return "redirect:/Anketa/domaciStraniSajt";
	}

	@RequestMapping(value = "/preporuka", method = RequestMethod.GET)
	public String preporuka(HttpServletRequest request) {
		int prijatelji = ar.findByIzvorSaznanjaZaOnlajnKupovinu("prijatelji").size();
		int mediji = ar.findByIzvorSaznanjaZaOnlajnKupovinu("mediji").size();
		int drustveneMreze = ar.findByIzvorSaznanjaZaOnlajnKupovinu("drustveneMreze").size();
		int slucajno = ar.findByIzvorSaznanjaZaOnlajnKupovinu("slucajno").size();

		double ukupno = prijatelji + mediji + drustveneMreze + slucajno;

		double pp = (prijatelji / ukupno) * 100;
		double mp = (mediji / ukupno) * 100;
		double dmp = (drustveneMreze / ukupno) * 100;
		double sp = (slucajno / ukupno) * 100;
		request.getSession().setAttribute("pp", pp);
		request.getSession().setAttribute("mp", mp);
		request.getSession().setAttribute("dmp", dmp);
		request.getSession().setAttribute("sp", sp);
		System.out.println("Prijatelji prosecno: " + (int) pp + " mediji " + (int) mp + " drustveneMreze " + dmp
				+ " slucajno " + sp);
		return "redirect:/Anketa/mapReduceRasponGodina";
	}

	@RequestMapping(value = "/mapReduceRasponGodina", method = RequestMethod.GET)
	public String rasponGodina(HttpServletRequest request) {

		MongoClient mongoClient = new MongoClient("nastava.is.pmf.uns.ac.rs", 27017);
		MongoDatabase db = mongoClient.getDatabase("student");

		MapReduceIterable<Document> result = db.getCollection("anketeVS").mapReduce(
				"function(){emit(this.obavljenaKupovina,this.godine)}",
				"function(key, values){var najmladjiPotrosac=values[0]; var najstarijiPotrosac=values[0]; "
						+ "for(var i=1; i<values.length;i++) { if(values[i]<najmladjiPotrosac) najmladjiPotrosac=values[i];"
						+ " if(values[i]>najstarijiPotrosac) najstarijiPotrosac=values[i];} "
						+ "result= {najmladjiPotrosac,najstarijiPotrosac}; return result;}");
		for (Document d : result) {
			if (d.get("_id").equals("jesam"))
				request.getSession().setAttribute("rasponGodina", d.get("value").toString());
		}
		mongoClient.close();

		return "redirect:/Anketa/pol";
	}

	@RequestMapping(value = "/domaciStraniSajt", method = RequestMethod.GET)
	public String zaradaVSPotrosnja(HttpServletRequest request) {

		int domaciSajtovi = ar.countByNasiSajtovi("da").size();
		int straniSajtovi = ar.countByNasiSajtovi("ne").size();

		if (domaciSajtovi >= straniSajtovi) {
			request.getSession().setAttribute("domacaStranaKupovina", "domacih");
			List<Anketa> ankete = ar.findTop3ByNasiSajtovi("da");
			request.getSession().setAttribute("sajt1", ankete.get(0).getOmiljenSajt());
			request.getSession().setAttribute("sajt2", ankete.get(1).getOmiljenSajt());
			request.getSession().setAttribute("sajt3", ankete.get(2).getOmiljenSajt());
		} else {
			request.getSession().setAttribute("domacaStranaKupovina", "stranih");
			List<Anketa> ankete = ar.findTop3ByNasiSajtovi("ne");
			request.getSession().setAttribute("sajt1", ankete.get(0).getOmiljenSajt());
			request.getSession().setAttribute("sajt2", ankete.get(1).getOmiljenSajt());
			request.getSession().setAttribute("sajt3", ankete.get(2).getOmiljenSajt());
		}

		return "redirect:/Anketa/uBuducnostiKupovati";
	}

	@RequestMapping(value = "/mapReduceCekanjeAliExpress", method = RequestMethod.GET)
	public String cekanjeAliExpress(HttpServletRequest request) {
		
		MongoClient mongoClient = new MongoClient("nastava.is.pmf.uns.ac.rs", 27017);
		MongoDatabase db = mongoClient.getDatabase("student");

		MapReduceIterable<Document> result = db.getCollection("anketeVS").mapReduce(
				"function(){emit(this.obavljenaKupovina,this.isporuka)}",
				"function(key, values){var minDana=values[0]; var maxDana=values[0]; "
				+ "for(var i=0; i<values.length;i++) { if(values[i]<minDana) minDana=values[i]; if(values[i]>maxDana) maxDana=values[i];} "
				+ " var result= {minDana, maxDana}; return result;}");
		for (Document d : result) {
			if (d.get("_id").equals("jesam"))
				request.getSession().setAttribute("rasponDana", d.get("value"));
		}
		mongoClient.close();
		return "redirect:/Anketa/bitnaDostava";

	}

	@RequestMapping(value = "/bitnaDostava", method = RequestMethod.GET)
	public String bitnaDostava(HttpServletRequest request) {

		return "redirect:/Anketa/razloziNeOnlajnKupovini";
	}

	@RequestMapping(value = "/prosecnaOcenaAliAmazon", method = RequestMethod.GET)
	public String prosecnaOcenaAliAmazon(HttpServletRequest request) {

		List<Anketa> ankete = ar.findByAliAmazon("da");
		double j = 0, i = 0;
		for (Anketa a : ankete) {
			j += a.getOcenaAA();
			i++;
		}
		request.getSession().setAttribute("isplativost", (int) (j / i));
		/*
		 * List<Anketa> ankete1=ar.findTop3ByAliAndAmazon();
		 * request.getSession().setAttribute("komentar1",
		 * ankete1.get(0).getAliAndAmazon());
		 * request.getSession().setAttribute("komentar2",
		 * ankete1.get(1).getAliAndAmazon());
		 * request.getSession().setAttribute("komentar3",
		 * ankete1.get(2).getAliAndAmazon());
		 */
		System.out.println("Prosecna 1ocena za ALiAmazon je: " + j / i);
		return "redirect:/Anketa/mapReduceCekanjeAliExpress";
	}

	@RequestMapping(value = "/uBuducnostiKupovati", method = RequestMethod.GET)
	public String uBuducnostiKupovati(HttpServletRequest request) {
		double anketeBr = ar.findAll().size();
		double jesuIHoce = ar.findByObavljenaKupovinaAndPonovnaOnlajnKupovina("jesam", "da").size();
		double nisuIHoce = ar.findByObavljenaKupovinaAndPonovnaOnlajnKupovina("nisam", "da").size();
		request.getSession().setAttribute("kupovinaBuducnost",
				"Od onih koji jesu obavili onlajn kupovinu njih " + (int) (jesuIHoce / anketeBr * 100)
						+ "% opet planira , dok onih koji nisu a planiraju ima " + (int) (nisuIHoce / anketeBr * 100)
						+ "%.");
		return "redirect:/Anketa/bitnost";
	}

	@RequestMapping(value = "/razloziNeOnlajnKupovini", method = RequestMethod.GET)
	public String razloziNekoriscenaOnlajnKupovine(HttpServletRequest request) {

		double ukupno = ar.findByObavljenaKupovina("nisam").size();

		double nemamKarticu = ar.countByZastoJosNeOnlajnKupovina("nemamKarticu").size() / ukupno * 100;
		double procena = ar.countByZastoJosNeOnlajnKupovina("nemogucnostProceneKvaliteta").size() / ukupno * 100;
		double rizik = ar.countByZastoJosNeOnlajnKupovina("rizik").size() / ukupno * 100;
		double ponuda = ar.countByZastoJosNeOnlajnKupovina("neinteresantnePonude").size() / ukupno * 100;

		request.getSession().setAttribute("kartica", nemamKarticu);
		request.getSession().setAttribute("rizik", rizik);
		request.getSession().setAttribute("procena", procena);
		request.getSession().setAttribute("ponuda", ponuda);

		return "AnalizaOnlajnKupovine.jsp";

	}

	@RequestMapping(value = "/bitnost", method = RequestMethod.GET)
	public String bitnost(HttpServletRequest request) {

		double ukupno = ar.findByObavljenaKupovina("jesam").size();

		double cena = ar.countByBitnost("cena").size() / ukupno * 100;
		double sigurnost = ar.countByBitnost("sigurnost").size() / ukupno * 100;
		double dostava = ar.countByBitnost("dostava").size() / ukupno * 100;
		double iskustva = ar.countByBitnost("iskustvaDrugih").size() / ukupno * 100;

		request.getSession().setAttribute("cena", cena);
		request.getSession().setAttribute("sigurnost", sigurnost);
		request.getSession().setAttribute("dostava", dostava);
		request.getSession().setAttribute("iskustva", iskustva);
		return "redirect:/Anketa/proizvodi";

	}
	/// NE MOZE TAKO, MISLI NA NACIN NERELACIONIH BAZA !!!!!!!

	@RequestMapping(value = "/proizvodi", method = RequestMethod.GET)
	public String proizvodi(HttpServletRequest request) {

		int hrana = 0, odeca = 0, tehnika = 0, ostalo = 0;

		List<Anketa> ankete = ar.findByObavljenaKupovina("jesam");

		for (Anketa a : ankete) {
			hrana += a.getProizvodi().getHrana();
			odeca += a.getProizvodi().getOdevniPredmeti();
			tehnika += a.getProizvodi().getTehnika();
			ostalo += a.getProizvodi().getOdevniPredmeti();
		}

		double ukupno = hrana + odeca + tehnika + ostalo;

		request.getSession().setAttribute("hrana", hrana / ukupno);
		request.getSession().setAttribute("odeca", odeca / ukupno);
		request.getSession().setAttribute("tehnika", tehnika / ukupno);
		request.getSession().setAttribute("ostalo", ostalo / ukupno);

		return "redirect:/Anketa/prosecnaOcenaAliAmazon";
	}

}
