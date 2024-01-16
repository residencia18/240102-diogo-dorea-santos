package filmes;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Filme {
	private String titulo, genero;
	private int ano;
	private ArrayList<String> elenco;
	
	public void adicionaAtor(String ator){
		
		elenco.add(ator);
	}
	
	public ArrayList<String> getElenco() {
		return elenco;
	}

	public void setElenco(ArrayList<String> elenco) {
		this.elenco = elenco;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	

	@Override
	public String toString() {
		return "Filme [titulo=" + titulo + ", genero=" + genero + ", ano=" + ano + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String json_str = "{\"titulo\":\"Os Arquivos JSON\",\"ano\":1998,\"genero\":\"Ficção\"}";
		
		JSONObject my_obj = new JSONObject(json_str);
		
		JSONArray my_cast = new JSONArray();
		my_cast.put("Diogo");
		my_cast.put("Tamires");
		my_cast.put("Cecilia");
		
		Filme filme = new Filme();
		
		filme.setTitulo(my_obj.getString("titulo"));
		filme.setGenero(my_obj.getString("genero"));
		filme.setAno(my_obj.getInt("ano"));
		
		System.out.println(filme.toString());
		
		



		

	}

}
