package br.uefs.ecomp.scl.util;

import java.util.ArrayList;

/**
 * 
 * @author danie
 *
 */
public class Tree
	{
	private Node root;
	
	public Tree() {}
	
	/**
	 * 
	 * @param fKey
	 * @param root
	 * @return
	 */
	public static Node search(String fKey, Node root)
		{
		if(root == null) return null; //se vazia
		if(compare(fKey, root.getKey()) == 0) return root;  //se igual a raiz
		if(compare(fKey, root.getKey()) == 1) return search(fKey, root.getLeftChild()); // se menor que a raiz
		if(compare(fKey, root.getKey()) == -1) return search(fKey, root.getRightChild()); //se mair que a raiz
		return null;
		}
	/**
	 * 
	 */
	public void listAll()
		{
		this.listAll(this.root);
		}
	
	/**
	 * 
	 * @param root
	 */
	public void listAll(Node root) 
		{
		if(root != null)
			{
			System.out.println(root.getKey());
			this.listAll(root.getLeftChild());
			this.listAll(root.getRightChild());
			}
		}
	
	/**
	 * 
	 * @param rKey
	 * @return
	 */
	public Node remove(String rKey)
		{
		Node mother, node, p, q, root;
		root = this.root;
		
		node = (searchForRemove(rKey)).get(1);
		mother = (searchForRemove(rKey)).get(0);
		
		if(node == null) return root;
		
		if(node.getLeftChild() == null || node.getRightChild() == null)
			{
			if(node.getLeftChild() == null)
				{
				q = node.getRightChild();
				}
			else q = node.getLeftChild();
			}
		
		return null;
		}
	
	/**
	 * 
	 * @param rKey
	 * @return
	 */
	public ArrayList<Node> searchForRemove(String rKey)
		{
		Node current = this.root;
		Node father = null;
		ArrayList<Node> pair;
		
		while(current != null)
			{
			if(compare(rKey, current.getKey()) == 0)
				{
				pair = new ArrayList<Node>();
				pair.add(father);
				pair.add(current);
				return pair;
				}
			father = current;
			if(compare(rKey, current.getKey()) == 1) current = current.getLeftChild();
			else current = current.getRightChild();
			}
		return null;
		}
	
	
	
	
	
	/**
	 * 
	 * @param unbalancedRoot
	 * @return
	 */
	public Node right(Node unbalancedRoot)
		{
		Node aux = unbalancedRoot.getLeftChild();
		unbalancedRoot.setLeftChild(aux.getRightChild());
		aux.setRightChild(unbalancedRoot);
		
		unbalancedRoot.setHeight(max(hight(unbalancedRoot.getLeftChild()), hight(unbalancedRoot.getRightChild())) + 1);
		aux.setHeight(max(hight(aux.getLeftChild()), unbalancedRoot.getHeight()) + 1);
		
		return aux;
		}
	
	/**
	 * 
	 * @param unbalancedRoot
	 * @return
	 */
	public Node left(Node unbalancedRoot)
		{
		Node aux = unbalancedRoot.getRightChild();
		unbalancedRoot.setRightChild(aux.getLeftChild());
		aux.setLeftChild(unbalancedRoot);
		
		unbalancedRoot.setHeight(max(hight(unbalancedRoot.getLeftChild()), hight(unbalancedRoot.getRightChild())) + 1);
		aux.setHeight(max(hight(aux.getRightChild()), unbalancedRoot.getHeight()) + 1);
		
		return aux;
		}
	
	/**
	 * 
	 * @param unbalancedRoot
	 * @return
	 */
	public Node leftRight(Node unbalancedRoot)
		{
		unbalancedRoot.setLeftChild(left(unbalancedRoot.getLeftChild()));
		return right(unbalancedRoot);
		}
	
	/**
	 * 
	 * @param unbalancedRoot
	 * @return
	 */
	public Node rightLeft(Node unbalancedRoot)
		{
		unbalancedRoot.setRightChild(right(unbalancedRoot.getRightChild()));
		return left(unbalancedRoot);
		}
	
	/**
	 * 
	 * @param string1
	 * @param string2
	 * @return
	 */
	public static int compare(String string1, String string2)
		{
		int lenght1 = string1.length();
		int lenght2 = string2.length();
		int min = min(lenght1, lenght2);
		char char1, char2;
		
		//if(lenght1 != lenght2) return (lenght1 - lenght2);
		
		for(int i=0; i < min; i++)
			{
			char1 = Character.toLowerCase((string1.charAt(i)));
			char2 = Character.toLowerCase((string2.charAt(i)));
			 
			if(char1 < char2) return 1; //se a primeira string é menor
			if(char1 > char2) return (-1); //se segunda string for menor
			}
		if(lenght1 == min && min == lenght2) return 0; //se as duas forem iguais
		if(lenght1 == min) return 1; //se a primeira é menor e igual ao inicio da segunda
		return (-1);  // se a segunda é menor e igual ao inicio da primeira
		}
	
	
/*	private Node getRoot()
		{
		return this.root;
		}
	
	private void setRoot(Node newRoot)
		{
		this.root = newRoot;
		} */
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int max(int a, int b)
		{
		if(a > b) return a;
		return b;
		}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int min(int a, int b)
		{
		if(a < b) return a;
		return b;
		}
	
	/**
	 * 
	 * @param root
	 * @return
	 */
	public int hight(Node root) 
		{
		if(root == null) return (-1);
		return root.getHeight();
		}
	
	}
