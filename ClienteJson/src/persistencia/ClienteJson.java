package persistencia;
import cliente.Cliente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONObject;

public class ClienteJson {
	
	public static void salvaCliente(String nomeArquivo, ArrayList<Cliente> clientes) {
		
		try {
			FileWriter fw = new FileWriter(nomeArquivo);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for (int i = 0; i < clientes.size(); i++) {
				
				String str1 = clientes.get(i).getNome();
				String str2 = clientes.get(i).getCpf();
				String str3 = clientes.get(i).getCnh();
				String json_str = "{\"nome\":\"" + str1 + "\",\"cpf\":\"" + str2 + "\",\"cnh\":\"" + str3 + "\"}";
				JSONObject my_obj = new JSONObject(json_str);
				//System.out.println(my_obj);
				bw.write(my_obj.toString());
				bw.newLine();
			}
				
				bw.close();
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	public static void recuperaCliente(String nomeArquivo) {
		
		try {
			FileReader fr = new FileReader(nomeArquivo);
			BufferedReader br = new BufferedReader(fr);
			
			String json_str;
			while ((json_str = br.readLine()) != null) {
				JSONObject my_obj = new JSONObject(json_str);
				System.out.println(my_obj);
			}
				
				br.close();
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
	}
	
}
