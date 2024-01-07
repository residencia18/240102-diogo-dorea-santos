package ArraysEListas;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayELista {
	
	public static void localizadorNome(ArrayList<String> listaNome) {
		
	}
	
	    public static boolean verificarNomeArray(String[] _arrayNomes, String _nome) {
	        for (String nome : _arrayNomes) {
	            if (nome.equals(_nome)) {
	                return true;
	            }
	        }
	        return false;
	    }
	    
	    public static boolean verificarNomeList(List _listNomes, String _nome) {
	        for (String nome : _listNomes) {
	            if (nome.equals(_nome)) {
	                return true;
	            }
	        }
	        return false;
	        
	        if (_listNomes.contains(_nome)){return true;}
	    }
	
	    public static void main(String[] args) {
	    	
	    	 String[] nomesArray = {"João", "Maria", "Pedro", "Ana"};
	    	 List nomesList = Arrays.asList(nomesArray);

	         String nomeProcurado = "Pedro";
	         if (verificarNomeArray(nomesArray, nomeProcurado)) {
	             System.out.println(nomeProcurado + " está presente no array.");
	         } else {
	             System.out.println(nomeProcurado + " não está presente no array.");
	         }
	         
	         if (verificarNomeList(nomesList, nomeProcurado)) {
	             System.out.println(nomeProcurado + " está presente no array.");
	         } else {
	             System.out.println(nomeProcurado + " não está presente no array.");
	         }
	     }
	
}
