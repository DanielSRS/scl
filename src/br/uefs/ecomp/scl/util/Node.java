package br.uefs.ecomp.scl.util;

/**
 * 
 * @author Daniel Santa Rosa
 *
 */
public class Node
	{
	private String key;  // Valor chave que identifica o nó
	private Object data;  //Dado salvo no nó
	private Node leftChild;  //Subárvore da esquerda
	private Node rightChild;  //Subárvore da direita
	private int height; //Altura deste nó/subárvore
	
	/**
	 * 
	 * @param key Identifica o nó. Necessario para sua criação.
	 * @param data Dado que será armazenado no nó.
	 */
	public Node(String key, Object data)
		{
		this.key = key;
		this.data = data;
		height = 0;
		}
	
	/**
	 * 
	 * @return O valor da string que identifica esse nó
	 */
	public String getKey()
		{
		return this.key;
		}
	
	/**
	 * 
	 * @return O dado armazenado no nó
	 */
	public Object getData()
		{
		return this.data;
		}
	
	/**
	 * 
	 * @return A subárvore [um nó] a esquerda do nó raiz.
	 */
	public Node getLeftChild()
		{
		return this.leftChild;
		}
	
	/**
	 * 
	 * @return A subárvore [um nó] a direita do nó raiz.
	 */
	public Node getRightChild()
		{
		return this.rightChild;
		}
	
	/**
	 * 
	 * @return A altura do nó/subárvore em questão.
	 */
	public int getHeight()
		{
		return this.height;
		}
	
	/**
	 * 
	 * @param newLeftChild Adiciona um nó como filho a esquerda do no atual, passando
	 * esta a ser uma subárvore a esquerda do nó em questão.
	 */
	public void setLeftChild(Node newLeftChild)
		{
		this.leftChild = newLeftChild;
		}
	
	/**
	 * 
	 * @param newRightChild Adiciona um nó como filho a direita do no atual, passando
	 * esta a ser uma subárvore a direita do nó em questão.
	 */
	public void setRightChild(Node newRightChild) 
		{
		this.rightChild = newRightChild;
		}
	
	/**
	 * 
	 * @param newHeight Novo o valor da altura do nó/subárvore
	 */
	public void setHeight(int newHeight)
		{
		this.height = newHeight;
		}
	}
