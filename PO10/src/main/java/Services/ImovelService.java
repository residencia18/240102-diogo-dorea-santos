package Services;

import java.util.ArrayList;
import java.util.List;

import Models.Imovel;

public class ImovelService {
	
	private static List<Imovel> imoveis;
	
	public static List<Imovel> getImoveis() {
		if (imoveis == null) {
			imoveis = new ArrayList<>();
		}
		
		return imoveis;
	}
	
	
	
	public static void setImoveis(List<Imovel> imoveis) {
		ImovelService.imoveis = imoveis;
	}



	public static void addImovel(Imovel i) {
		if (imoveis == null) {
			imoveis = new ArrayList<>();
		}
		
		imoveis.add(i);
	}
	
	public static void removeImovel(Imovel i) {
		imoveis.remove(i);
	}

}
