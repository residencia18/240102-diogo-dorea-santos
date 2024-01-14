package DadosEstatisticos;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DatasDeNascimento implements DadosEstatisticos{
	
	ArrayList<Date> datasNascimento;
	Date d = new Date();
	
	
	public Object Maximo() {
		return datasNascimento.stream().sorted().collect(Collectors.toList()).getLast();
	}
	
	public Object Minimo() {
		return datasNascimento.stream().sorted().collect(Collectors.toList()).getFirst();
	}
	
	public Object Ordenar() {
		return datasNascimento.stream().sorted().collect(Collectors.toList());
		
	}
			
	public Object Buscar(Date d) {
		return datasNascimento.equals(d);
	}
	

}
