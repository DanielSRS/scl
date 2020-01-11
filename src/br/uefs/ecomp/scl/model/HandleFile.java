package br.uefs.ecomp.scl.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author Daniel Santa Rosa
 *
 */
public class HandleFile
	{
	FileReader file;
    BufferedReader readFile;
    
    /**
     * 
     * @param path Caminho para o arquivo no diret�rio do sistema
     * @return Uma matriz (uma lista de listas) com as informa��es do arquivo CSV
     */
    public ArrayList<Object> readCSV(final String path)
		{
	    String line;
	    String[] Matrix1x6;
	    final ArrayList<Object> MatrixNx6 = new ArrayList<>();
	
	    try 
	    	{
	        file = new FileReader(path);
	        readFile = new BufferedReader(file);
	
	        line = readFile.readLine();  // L� a primeira linha do arquivo
	
	        while (line != null)  // Enquanto o n�o chegar no fim do arquivo
	        	{
	        	Matrix1x6 = line.split(";");  // Separa as informa��es em seis colunas
	        	MatrixNx6.add(Matrix1x6);  // Adiciona essas colunas � matriz com as outras informa��es do arquivo CSV
	            line = readFile.readLine();  // L� a pr�xima linha
	        	}
	        
	        // Terminado a leitura, fecha o arquivo
	        file.close();
	        readFile.close();
	    	} 
	    catch (final IOException e)  // Caso de erro na leitura do arquivo
	        {
	        return null;
	        }
	    return MatrixNx6;
	    }
	}
