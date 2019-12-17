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
	
	public void insert(String key, Object data)
	    {
		// Atualiza a raiz caso tenha mudado.
		this.root = insert(key, data, this.root);
	    }



	public Node insert(String key, Object data, Node root)
		{
		Node newNode = new Node(key, data);
		
		if(root == null) return newNode; // se a árvore, vazia.
		
		if(compare(key, root.getKey()) == 1) //se a chave menor que a da raiz...
		    {
			root.setLeftChild(insert(key, data, root.getLeftChild())); //insere na subarvore a esquerda
			if(hight(root.getLeftChild()) - hight(root.getRightChild()) == 2) //verifica se houve desbalanceamento 
			    {
				if(compare(key, root.getLeftChild().getKey()) == 1) //se uma inserção externa... 
				    {
					root = right(root); //faz uma rotação simples a direita
					}
				else //se uma inserção interna 
				    {
					root = leftRight(root); //faz uma rotação dupla esquerda direita
					}
				}
			}
		else if(compare(key, root.getKey()) == -1) //se a chave maior que a da raiz... 
			{
			root.setRightChild(insert(key, data, root.getRightChild())); //insere na subarvore a direita
			if(hight(root.getRightChild()) - hight(root.getLeftChild()) == 2) //verifica se houve desbalanceamento
				{
				if(compare(key, root.getRightChild().getKey()) == -1) //se externo 
				    {
					root = left(root); //rotação esquerda
					}
				else // se interno 
				    {
					root = rightLeft(root); //rotação direita 
					}
				}
			}
		root.setHeight(max(hight(root.getLeftChild()), hight(root.getRightChild())) + 1);
		return root;
		} 
	
	/**
	 * 
	 * @param fKey
	 * @param root
	 * @return
	 */
	public static Object search(String fKey, Node root)
		{
		if(root == null) return null; //se vazia
		if(compare(fKey, root.getKey()) == 0) return root.getData();  //se igual a raiz
		if(compare(fKey, root.getKey()) == 1) return search(fKey, root.getLeftChild()); // se menor que a raiz
		if(compare(fKey, root.getKey()) == -1) return search(fKey, root.getRightChild()); //se mair que a raiz
		return null;
		}
	/**
	 * 
	 */
	public String listAll()
		{
		return this.listAll(this.root);
		}
	
	/**
	 * 
	 * @param root
	 */
	public String listAll(Node root) 
		{
		String s;
		if(root != null)
			{
			
			s = this.listAll(root.getLeftChild());
			s = s + root.getKey() + " - ";
			s = s + this.listAll(root.getRightChild());
			return s;
			}
		return "";
		}
	
	public void updateHeight()
		{
		this.updateHeight(this.root);
		}
	
	public void updateHeight(Node root) 
		{
		if(root != null)
			{
			
			this.updateHeight(root.getLeftChild());
			root.setHeight(max(hight(root.getLeftChild()), hight(root.getRightChild())) + 1);
			this.updateHeight(root.getRightChild());
			root.setHeight(max(hight(root.getLeftChild()), hight(root.getRightChild())) + 1);
			}
		}
	
	
	/**
	 * 
	 * @param rKey
	 * @return
	 */
	public boolean remove(String rKey)
		{
		// root é a raiz da arvore
		// mother é o pai do no removido
		// node é o no reovido
		// p é pai do no removido
		// q é substituto do no removido
		Node mother, node, p, q;
		
		node = (searchForRemove(rKey)).get(1);
		mother = (searchForRemove(rKey)).get(0);
		
		if(node == null) return false;
		
		if(node.getLeftChild() == null || node.getRightChild() == null)
			{
			if(node.getLeftChild() == null)
				{
				q = node.getRightChild();
				}
			else q = node.getLeftChild();
			}
		else
			{
			p = node;
			q = node.getLeftChild();
			while(q.getRightChild() != null)
				{
				p = q;
				q = q.getRightChild();
				}
			if(p != node)
				{
				p.setRightChild(q.getLeftChild());
				q.setLeftChild(node.getLeftChild());
				}
			q.setRightChild(node.getRightChild());
			}
		updateHeight(this.root);
		if(mother == null) // se removendo a raiz
			{
			this.root = balance(q);
			return true;
			}
		if(compare(rKey, mother.getKey()) == 1)
			{
			mother.setLeftChild(balance(q));
			return true;
			}
		else 
			{
			mother.setRightChild(balance(q));
			return true;
			}
		}
	
	
	public Node balance(Node q)
		{
		
		if(q == null) return null;
		
		int z = hight(q.getLeftChild()) - hight(q.getRightChild());
		if(z == 2)
			{
			int m = hight(q.getLeftChild().getLeftChild()) - hight(q.getLeftChild().getRightChild());
			if(m == 1)
				{
				return right(q);
				}
			else if (m == -1)
				{
				return leftRight(q);
				}
			}
		if(z == -2)
			{
			int m = hight(q.getLeftChild().getLeftChild()) - hight(q.getLeftChild().getRightChild());
			if(m == -1)
				{
				return left(q);
				}
			else if (m == 1)
				{
				return rightLeft(q);
				}
			}
		return q;
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
	
	public Node getRoot()
		{
		return this.root;
		}
	
	}
