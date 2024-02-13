package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import transporteViario.Card;
import transporteViario.Cliente;
import transporteViario.Cobrador;
import transporteViario.Jornada;
import transporteViario.Motorista;
import transporteViario.Onibus;
import transporteViario.Veiculo;
import transporteViario.PontoParada;
import transporteViario.Trajeto;
import transporteViario.Trecho;

public class Persistencia {
	
	public static void salvaPassageiro(Cliente passageiro) {
		
		try {
			
			FileWriter fw = new FileWriter("Arquivos/passageiros.json");
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
	
	public static void recuperaPassageiro(ArrayList<Cliente> passageiros) {
		
		try {
			
			FileReader fr = new FileReader("Arquivos/passageiros.json");
			BufferedReader br = new BufferedReader(fr);
			String json_str;
			
			while ((json_str = br.readLine()) != null) {
				JSONObject my_obj = new JSONObject(json_str);
				Card cartaoAux = new Card(my_obj.getString("cartaoPessoal"));
				Cliente clienteAux = new Cliente(my_obj.getString("nome"), my_obj.getString("cpf"), cartaoAux);
				passageiros.add(clienteAux);
				System.out.println(my_obj);
			}	
				br.close();
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public static void salvaMotorista(Motorista motorista) {
		
		try {
			
			FileWriter fw = new FileWriter("Arquivos/motoristas.json");
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
	
	public static void recuperaMotorista(ArrayList<Motorista> motoristas) {
		
		try {
			
			FileReader fr = new FileReader("Arquivos/motoristas.json");
			BufferedReader br = new BufferedReader(fr);
			String json_str;
			
			while ((json_str = br.readLine()) != null) {
				JSONObject my_obj = new JSONObject(json_str);
				Motorista motoristaAux = new Motorista(my_obj.getString("nome"), my_obj.getString("cpf"), my_obj.getString("cnh"), my_obj.getString("ctps"));
				motoristas.add(motoristaAux);
				System.out.println(my_obj);
			}	
				br.close();
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void salvaCobrador(Cobrador cobrador) {
		
		try {
			
			FileWriter fw = new FileWriter("Arquivos/cobradores.json");
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
	
	public static void recuperaCobrador(ArrayList<Cobrador> cobradores) {
		
		try {
			
			FileReader fr = new FileReader("Arquivos/cobradores.json");
			BufferedReader br = new BufferedReader(fr);
			String json_str;
			
			while ((json_str = br.readLine()) != null) {
				JSONObject my_obj = new JSONObject(json_str);
				Cobrador cobradorAux = new Cobrador(my_obj.getString("nome"), my_obj.getString("cpf"), my_obj.getString("ctps"));
				cobradores.add(cobradorAux);
				System.out.println(my_obj);
			}	
				br.close();
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void salvaVeiculo(Onibus onibus) {
		
		try {
			
			FileWriter fw = new FileWriter("Arquivos/veiculos.json");
			BufferedWriter bw = new BufferedWriter(fw);
			
			String str1 = onibus.getPlaca();
			String str2 = onibus.getRenavam();
			String str3 = onibus.getChassi();
			String str4 = onibus.getFabricante();
			String str5 = onibus.getModelo();
			String str6 = onibus.getAno();
			String str7 = onibus.getNumero();
			
			String json_str = "{\"placa\":\"" + str1 + "\",\"renavam\":\"" + str2 + "\",\"chassi\":\"" + str3 + "\",\"fabricante\":\"" + str4 + "\",\"modelo\":\"" + str5 + "\",\"ano\":\"" + str6 + "\",\"numero\":\"" + str7 + "\"}";
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
	
	public static void recuperaVeiculo(ArrayList<Veiculo> veiculos) {
		
		try {
			FileReader fr = new FileReader("Arquivos/veiculos.json");
			BufferedReader br = new BufferedReader(fr);
			String json_str;
			
			while ((json_str = br.readLine()) != null) {
				
				JSONObject my_obj = new JSONObject(json_str);
				
				Onibus onibusAux = new Onibus(my_obj.getString("placa"), my_obj.getString("renavam"), my_obj.getString("chassi"), my_obj.getString("fabricante"), my_obj.getString("modelo"), my_obj.getString("ano"), my_obj.getString("numero"));
				veiculos.add(onibusAux);
				System.out.println(my_obj);
			}
			br.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	}
	
	
	public static void salvaPontoParada(PontoParada pontoParada) {
		
		try {
			
			FileWriter fw = new FileWriter("Arquivos/pontoParada.json");
			BufferedWriter bw = new BufferedWriter(fw);
			
			String str1 = pontoParada.getCod();
			String str2 = pontoParada.getHorario().toString();
			String json_str = "{\"cod\":\"" + str1 + "\",\"horario\":\"" + str2 + "\"}";
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
	
	public static void recuperaPontoParada(ArrayList<PontoParada> pontoParadas) {
		
		try {
			FileReader fr = new FileReader("Arquivos/pontoParada.json");
			BufferedReader br = new BufferedReader(fr);
			String json_str;
			
			while ((json_str = br.readLine()) != null) {
				
				JSONObject my_obj = new JSONObject(json_str);
				
				PontoParada pontoParadaAux = new PontoParada(my_obj.getString("cod"), LocalTime.parse(my_obj.getString("horario")));
				pontoParadas.add(pontoParadaAux);
				System.out.println(my_obj);
			}
			br.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	}
	
	public static void salvaTrecho(Trecho trecho) {
		
		try {
			
			FileWriter fw = new FileWriter("Arquivos/trechos.json");
			BufferedWriter bw = new BufferedWriter(fw);
			
			String str1 = trecho.getCod();
			String str2 = trecho.getOrigem().getCod();
			String str3 = trecho.getDestino().getCod();
			String str4 = trecho.getDuracaoParada().toString();
			String json_str = "{\"codTrecho\":\"" + str1 + "\",\"origem\":\"" + str2 + "\",\"destino\":\"" + str3 + "\",\"duracaoParada\":\"" + str4 + "\"}";
			JSONObject my_obj = new JSONObject(json_str);
			JSONArray passageiros = new JSONArray();
			for(Cliente passageiro : trecho.getEmbarques()) {
				passageiros.put(passageiro.getCpf());
			}
			my_obj.put("passageiros", passageiros);
			bw.write(my_obj.toString());
			bw.newLine();
			bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void salvaTrajeto(Trajeto trajeto) {
		
		try {
			
			FileWriter fw = new FileWriter("Arquivos/trajetos.json");
			BufferedWriter bw = new BufferedWriter(fw);
			
			String str1 = trajeto.getCod();
			String json_str = "{\"cod\":\"" + str1 + "\"}";
			
			JSONObject my_obj = new JSONObject(json_str);
			JSONArray trechos = new JSONArray();
			for(Trecho trecho : trajeto.getTrechos()) {
				trechos.put(trecho.getCod());
			}
			my_obj.put("trechos", trechos);
			bw.write(my_obj.toString());
			bw.newLine();
			bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void salvaJornada(Jornada jornada) {
		
		try {
			
			FileWriter fw = new FileWriter("Arquivos/jornadas.json");
			BufferedWriter bw = new BufferedWriter(fw);
			
			String str1 = jornada.getCod();
			String str2 = jornada.getMotorista().getCpf();
			String str3 = jornada.getCobrador().getCpf();
			String str4 = jornada.getVeiculo().getPlaca();
			String json_str = "{\"codJornada\":\"" + str1 + "\",\"motorista\":\"" + str2 + "\",\"cobrador\":\"" + str3 + "\",\"veiculo\":\"" + str4 + "\"}";
			JSONObject my_obj = new JSONObject(json_str);
			JSONArray trajetos = new JSONArray();
			for(Trajeto trajeto : jornada.getTrajetos()) {
				trajetos.put(trajeto.getCod());
			}
			my_obj.put("trajetos", trajetos);
			bw.write(my_obj.toString());
			bw.newLine();
			bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
