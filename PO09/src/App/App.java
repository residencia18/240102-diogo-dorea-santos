package App;

import Menu.Menu;
import Mockup.Mock;
import dao.DAO;

public class App {

	public static void main(String[] args) {
		
		//Apenas para testes
		Mock.gerarDadosAleatorios();
		
		DAO.conectar();
		
		Menu.menuPrincipal();

	}

}
