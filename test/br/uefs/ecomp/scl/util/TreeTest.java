package br.uefs.ecomp.scl.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//import br.uefs.ecomp.scl.util.Tree;

class TreeTest 
	{

	@Test
	void compareTest() 
		{
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
	void maxTest() //testa função max
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
	
	@Test
	void a1() // testa a instancia
		{
		Tree c = new Tree();
		
		assertEquals(c.getRoot(), null);
		
		}
	
	@Test
	void a2() //inserção test
		{
		Tree c = new Tree();
		c.insert("A", 1);
		
		assertEquals(c.getRoot().getKey(), "A");
		
		c.insert("B", 2);
		assertEquals(c.getRoot().getKey(), "A");
		assertEquals(c.getRoot().getRightChild().getKey(), "B");
		
		c.insert("C", 3);
		assertTrue((c.getRoot().getKey()).equals("B"));
		
		}
	
	@Test
	void a3() // remoção teste
		{
		Tree c = new Tree();
		c.insert("A", 1);
		
		assertEquals(c.getRoot().getKey(), "A");
		
		c.insert("B", 2);
		assertEquals(c.getRoot().getKey(), "A");
		assertEquals(c.getRoot().getRightChild().getKey(), "B");
		
		c.insert("C", 3);
		assertTrue((c.getRoot().getKey()).equals("B"));
		
		
		c.remove("B");
		assertEquals(c.getRoot().getKey(), "A");
		assertEquals(c.getRoot().getRightChild().getKey(), "C");
		
		c.remove("A");
		assertEquals(c.getRoot().getKey(), "C");
		
		c.remove("C");
		assertEquals(c.getRoot(), null);
		
		}
	
	@Test
	void a4() //teste de busca
		{
		Tree c = new Tree();
		
		Object d;
		c.insert("A", 1);
		c.insert("B", 2);
		c.insert("C", 3);
		
		d = Tree.search("B", c.getRoot());
		assertEquals(2, (int) d);
		
		d = Tree.search("V", c.getRoot());
		assertNull(d);
		
		d = Tree.search("C", c.getRoot());
		assertEquals(3, (int) d);
		
		}
	
	@Test
	void a5() //teste de listar tudo
		{
		Tree c = new Tree();
		
		String s;
		c.insert("A", 1);
		c.insert("B", 2);
		c.insert("C", 3);
		
		s = c.listAll();
		assertEquals(s, "A - B - C - ");
		
		c.insert("Daniel", 23);
		s = c.listAll();
		assertEquals(s, "A - B - C - Daniel - ");
		
		c.insert("D", 4);
		s = c.listAll();
		assertEquals(s, "A - B - C - D - Daniel - ");
		
		}

	}
