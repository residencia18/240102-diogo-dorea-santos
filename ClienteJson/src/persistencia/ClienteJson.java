package persistencia;
import cliente.Cliente;

import java.util.ArrayList;

import org.json.JSONObject;

public class ClienteJson {
	
	public static void salvaCliente(String nomeArquivo, ArrayList<Cliente> clientes) {
		
		String str1 = clientes.get(0).getNome();
		String str2 = clientes.get(1).getNome();
		System.out.println(str1);
		System.out.println(str2);
		//String json_str = "{\"+clientes.":\"Os Arquivos JSON\",\"ano\":1998,\"genero\":\"Ficção\"}";
		//JSONObject my_obj = new JSONObject(json_str);
	}
	
	public static void recuperaCliente(String nomeArquivo) {
		
		
		
	}
	
}
