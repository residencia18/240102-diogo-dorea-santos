package quadrado;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuadradoTest {

	@Test
	void testClique() {

		
		//case 1: testar clique tecla 1
		Quadrado quadrado = new Quadrado("XXOXOXOXX");
		quadrado.clique(1);
		assertEquals("OOOOOXOXX", quadrado.getEstado());
		
		//case 2: testar clique tecla 2
		quadrado = new Quadrado("XXOXOXOXX");
		quadrado.clique(2);
		assertEquals("OOXXOXOXX", quadrado.getEstado());
		
		//case 3: testar clique tecla 3
		quadrado = new Quadrado("XXOXOXOXX");
		quadrado.clique(3);
		assertEquals("XOXXOOOXX", quadrado.getEstado());
		
		//case 4: testar clique tecla 4
		quadrado = new Quadrado("XXOXOXOXX");
		quadrado.clique(4);
		assertEquals("OXOOOXXXX", quadrado.getEstado());
		
		//case 5: testar clique tecla 5
		quadrado = new Quadrado("XXOXOXOXX");
		quadrado.clique(5);
		assertEquals("XOOOXOOOX", quadrado.getEstado());
		
		//case 6: testar clique tecla 6
		quadrado = new Quadrado("XXOXOXOXX");
		quadrado.clique(6);
		assertEquals("XXXXOOOXO", quadrado.getEstado());
		
		//case 7: testar clique tecla 7
		quadrado = new Quadrado("XXOXOXOXX");
		quadrado.clique(7);
		assertEquals("XXOOOXXOX", quadrado.getEstado());
		
		//case 8: testar clique tecla 8
		quadrado = new Quadrado("XXOXOXOXX");
		quadrado.clique(8);
		assertEquals("XXOXOXXOO", quadrado.getEstado());
		
		//case 9: testar clique tecla 9
		quadrado = new Quadrado("XXOXOXOXX");
		quadrado.clique(9);
		assertEquals("XXOXOOOOO", quadrado.getEstado());
	}

}
