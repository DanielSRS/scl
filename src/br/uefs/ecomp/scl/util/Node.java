package br.uefs.ecomp.scl.util;

/**
 * 
 * @author danie
 *
 */
public class Node
	{
	private String key;
	private Object data;
	private Node leftChild;
	private Node rightChild;
	private int height;
	
	public Node()
		{
		height = 0;
		}
	
	public String getKey()
		{
		return this.key;
		}
	
	public Object getData()
		{
		return this.data;
		}
	
	public Node getLeftChild()
		{
		return this.leftChild;
		}
	
	public Node getRightChild()
		{
		return this.rightChild;
		}
	
	public int getHeight()
		{
		return this.height;
		}
	
	/**
	 * 
	 * @param newLeftChild
	 */
	public void setLeftChild(Node newLeftChild)
		{
		this.leftChild = newLeftChild;
		}
	
	/**
	 * 
	 * @param newRightChild
	 */
	public void setRightChild(Node newRightChild) 
		{
		this.rightChild = newRightChild;
		}
	
	/**
	 * 
	 * @param newHeight
	 */
	public void setHeight(int newHeight)
		{
		this.height = newHeight;
		}
	}
