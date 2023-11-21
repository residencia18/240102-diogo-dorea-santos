package exercicio10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class exercicio10 {
	int acerto;
	static String pergunta;
	List <String> alternativas =  new ArrayList<String>();
	
		public String getPergunta() {
		return pergunta;
	}

	public static void setPergunta(String _pergunta) {
		pergunta = _pergunta;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite a pergunta");
		exercicio10.setPergunta(sc.nextLine());
				

	}

}
