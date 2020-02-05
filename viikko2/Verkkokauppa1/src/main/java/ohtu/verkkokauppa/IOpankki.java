package ohtu.verkkokauppa;

public interface IOpankki {

	boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);

}