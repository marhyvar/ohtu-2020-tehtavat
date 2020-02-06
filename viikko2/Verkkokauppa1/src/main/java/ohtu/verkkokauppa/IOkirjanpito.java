package ohtu.verkkokauppa;

import java.util.ArrayList;

public interface IOkirjanpito {

	void lisaaTapahtuma(String tapahtuma);

	ArrayList<String> getTapahtumat();

}