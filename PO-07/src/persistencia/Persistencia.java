package persistencia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONObject;

import transporteViario.Cliente;
import transporteViario.Cobrador;
import transporteViario.Motorista;

public class Persistencia {
	
	public static void salvaCliente(Cliente passageiro) {
		
		try {
			
			FileWriter fw = new FileWriter("Arquivos/passageiros.csv");
			BufferedWriter bw = new BufferedWriter(fw);
			
			String str1 = passageiro.getNome();
			String str2 = passageiro.getCpf();
			String str3 = passageiro.getCartaoPessoal().getCardNumber();
			String json_str = "{\"nome\":\"" + str1 + "\",\"cpf\":\"" + str2 + "\",\"cartaoPessoal\":\"" + str3 + "\"}";
			JSONObject my_obj = new JSONObject(json_str);
			//System.out.println(my_obj);
			bw.write(my_obj.toString());
			bw.newLine();
			bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void salvaMotorista(Motorista motorista) {
		
		try {
			
			FileWriter fw = new FileWriter("Arquivos/motoristas.csv");
			BufferedWriter bw = new BufferedWriter(fw);
			
			String str1 = motorista.getNome();
			String str2 = motorista.getCpf();
			String str3 = motorista.getCnh();
			String str4 = motorista.getCtps();
			String json_str = "{\"nome\":\"" + str1 + "\",\"cpf\":\"" + str2 + "\",\"cnh\":\"" + str3 + "\",\"ctps\":\"" + str4 + "\"}";
			JSONObject my_obj = new JSONObject(json_str);
			//System.out.println(my_obj);
			bw.write(my_obj.toString());
			bw.newLine();
			bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public static void salvaCobrador(Cobrador cobrador) {
		
		try {
			
			FileWriter fw = new FileWriter("Arquivos/cobradores.csv");
			BufferedWriter bw = new BufferedWriter(fw);
			
			String str1 = cobrador.getNome();
			String str2 = cobrador.getCpf();
			String str3 = cobrador.getCtps();
			String json_str = "{\"nome\":\"" + str1 + "\",\"cpf\":\"" + str2 + "\",\"ctps\":\"" + str3 + "\"}";
			JSONObject my_obj = new JSONObject(json_str);
			//System.out.println(my_obj);
			bw.write(my_obj.toString());
			bw.newLine();
			bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	
	
	

}
