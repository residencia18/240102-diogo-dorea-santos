package Services;

import java.util.ArrayList;
import java.util.List;

import Models.Fatura;
import Models.Reembolso;
import Utils.EntityManagerUtil;
import dao.ReembolsoDAO;

public class ReembolsoService {
	
	private static List<Reembolso> reembolsos;
	
	public static List<Reembolso> getReembolsos() {
		if (reembolsos == null) {
			reembolsos = new ArrayList<>();
		}
		
		return reembolsos;
	}
		
	public static void setReembolsos(List<Reembolso> reembolsos) {
		ReembolsoService.reembolsos = reembolsos;
	}

	public static void addReembolso(Reembolso r) {
		if (reembolsos == null) {
			reembolsos = new ArrayList<>();
		}
		
		reembolsos.add(r);
		ReembolsoDAO.create(r, EntityManagerUtil.getEntityManager());
	}
	
	public static List<Reembolso> getReembolsosByFatura(Fatura f) {
		List<Reembolso> reembolsosFatura = new ArrayList<>();
		
		for (Reembolso reembolso : getReembolsos()) {
			if (reembolso.getFatura().equals(f)) {
				reembolsosFatura.add(reembolso);
			}
		}
		
		return reembolsosFatura;
	}
	
}
