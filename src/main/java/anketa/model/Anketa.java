package anketa.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="anketeVS")
public class Anketa {
	@Id
	private String id;
	private String pol;
	private int godine;
	private String statusZaposlenosti;
	private double mesecnaPrimanja;
	private String obavljenaKupovina;
	private String izvorSaznanjaZaOnlajnKupovinu;
	private String zastoJosNeOnlajnKupovina;
	private String najcesceMetodePlacanja;
	private double najcesciIznosNovca;
	private String razloziDaOnljanKupovini;
	private String nasiSajtovi;
	private String ponovnaOnlajnKupovina;
	private String aliAmazon;
	private int ocenaAA;
	private int isporuka;
	private String omiljenSajt;
	private String bitnost;
	
	public String getBitnost() {
		return bitnost;
	}
	public void setBitnost(String bitnost) {
		this.bitnost = bitnost;
	}
	private Proizvodi proizvodi;
	
	public Proizvodi getProizvodi() {
		return proizvodi;
	}
	public void setProizvodi(Proizvodi proizvodi) {
		this.proizvodi = proizvodi;
	}
	
	public String getObavljenaKupovina() {
		return obavljenaKupovina;
	}
	public void setObavljenaKupovina(String obavljenaKupovina) {
		this.obavljenaKupovina = obavljenaKupovina;
	}
	
	public String getOmiljenSajt() {
		return omiljenSajt;
	}
	public void setOmiljenSajt(String omiljenSajt) {
		this.omiljenSajt = omiljenSajt;
	}
	
	
	public String getNasiSajtovi() {
		return nasiSajtovi;
	}
	public void setNasiSajtovi(String nasiSajtovi) {
		this.nasiSajtovi = nasiSajtovi;
	}
	
	public String getAliAmazon() {
		return aliAmazon;
	}
	public void setAliAmazon(String aliAmazon) {
		this.aliAmazon = aliAmazon;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPol() {
		return pol;
	}
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	public String getStatusZaposlenosti() {
		return statusZaposlenosti;
	}
	public void setStatusZaposlenosti(String statusZaposlenosti) {
		this.statusZaposlenosti = statusZaposlenosti;
	}
	

	
	public String getIzvorSaznanjaZaOnlajnKupovinu() {
		return izvorSaznanjaZaOnlajnKupovinu;
	}
	public void setIzvorSaznanjaZaOnlajnKupovinu(String izvorSaznanjaZaOnlajnKupovinu) {
		this.izvorSaznanjaZaOnlajnKupovinu = izvorSaznanjaZaOnlajnKupovinu;
	}
	public String getZastoJosNeOnlajnKupovina() {
		return zastoJosNeOnlajnKupovina;
	}
	public void setZastoJosNeOnlajnKupovina(String zastoJosNeOnlajnKupovina) {
		this.zastoJosNeOnlajnKupovina = zastoJosNeOnlajnKupovina;
	}
	
	public String getNajcesceMetodePlacanja() {
		return najcesceMetodePlacanja;
	}
	public void setNajcesceMetodePlacanja(String najcesceMetodePlacanja) {
		this.najcesceMetodePlacanja = najcesceMetodePlacanja;
	}

	public String getRazloziDaOnljanKupovini() {
		return razloziDaOnljanKupovini;
	}
	public void setRazloziDaOnljanKupovini(String razloziDaOnljanKupovini) {
		this.razloziDaOnljanKupovini = razloziDaOnljanKupovini;
	}
	
	public int getGodine() {
		return godine;
	}
	public void setGodine(int godine) {
		this.godine = godine;
	}
	public double getMesecnaPrimanja() {
		return mesecnaPrimanja;
	}
	public void setMesecnaPrimanja(double mesecnaPrimanja) {
		this.mesecnaPrimanja = mesecnaPrimanja;
	}
	public double getNajcesciIznosNovca() {
		return najcesciIznosNovca;
	}
	public void setNajcesciIznosNovca(double najcesciIznosNovca) {
		this.najcesciIznosNovca = najcesciIznosNovca;
	}
	public int getOcenaAA() {
		return ocenaAA;
	}
	public void setOcenaAA(int ocenaAA) {
		this.ocenaAA = ocenaAA;
	}
	public int getIsporuka() {
		return isporuka;
	}
	public void setIsporuka(int isporuka) {
		this.isporuka = isporuka;
	}
	public String getPonovnaOnlajnKupovina() {
		return ponovnaOnlajnKupovina;
	}
	public void setPonovnaOnlajnKupovina(String ponovnaOnlajnKupovina) {
		this.ponovnaOnlajnKupovina = ponovnaOnlajnKupovina;
	}
	
	
	
	
	
	
	
}
