package br.uefs.ecomp.scl.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//import br.uefs.ecomp.scl.util.Tree;

class TreeTest {

	@Test
	void compareTest() {
		String a, b, c, d, e, f;
		a = "Daniel";
		b = "daniel";
		c = "Santa rosa";
		d = "Nem sei";
		e = "esqueci";
		f = "Daniels";
		
		assertEquals(Tree.compare(a, b), 0);  //Strings iguais
		assertEquals(Tree.compare(a, f), 1);  //Primeira string (a) menor que segunda string
		assertEquals(Tree.compare(c, d), -1);  //Segunda String (d) menor que a primeira (c)
		assertEquals(Tree.compare(e, f), -1);  //Segunda string menor
	}
	
	@Test
	void maxTest()
		{
		int a, b, c, d, e, f;
		a = 1;
		b = 3244;
		c = -34;
		d = -1;
		e = 4;
		f = 0;
		
		assertEquals(a, Tree.max(a, f));
		assertEquals(b, Tree.max(b, f));
		assertEquals(e, Tree.max(a, e));
		assertEquals(b, Tree.max(b, c));
		assertEquals(d, Tree.max(c, d));
		}

}
