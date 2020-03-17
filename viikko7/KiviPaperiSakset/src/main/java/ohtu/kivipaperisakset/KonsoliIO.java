package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KonsoliIO implements IO {

    private Scanner lukija;

    public KonsoliIO() {
    	lukija = new Scanner(System.in);
    }

	@Override
	public String syote() {
		return lukija.nextLine();
	}

	@Override
	public void print(String s) {
		System.out.println(s);		
	}

}
