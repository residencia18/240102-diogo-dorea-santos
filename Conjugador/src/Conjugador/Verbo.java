package Conjugador;

import java.util.Scanner;

public class Verbo {
	
	private String radical, sufixo;
	
	
	
	public Verbo(String rad, String suf) {
		super();
		this.radical = rad;
		this.sufixo = suf;
	}

	public String getRadical() {
		return radical;
	}

	public void setRadical(String radical) {
		this.radical = radical;
	}

	public String getSufixo() {
		return sufixo;
	}

	public void setSufixo(String sufixo) {
		this.sufixo = sufixo;
	}

	public void conjugar() {
		
		System.out.println("Eu "+radical+"o");
		System.out.println("Tu "+radical+"as");
		System.out.println("Ele "+radical+"a");
		System.out.println("Nos "+radical+"amos");
		System.out.println("Vos "+radical+"ais");
		System.out.println("Eles "+radical+"am");
				
	}
	
	public static void main(String[] args) {
		String rad, suf, verb;
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o verbo");
		verb = sc.nextLine();
		suf = verb.substring(verb.length()-2,verb.length());
		rad = verb.substring(0,verb.length()-2);
		
		
		sc.close();
		Verbo verbo = new Verbo (rad, suf);
		verbo.conjugar();
	}

}