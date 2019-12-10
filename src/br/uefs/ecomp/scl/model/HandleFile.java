package br.uefs.ecomp.scl.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HandleFile
	{
	FileReader file;
    BufferedReader readFile;
    
    /**
     * 
     * @param path
     * @return
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
	
	        line = readFile.readLine();
	
	        while (line != null) 
	        	{
	        	Matrix1x6 = line.split(";");
	        	MatrixNx6.add(Matrix1x6);
	            line = readFile.readLine();
	        	}
	        file.close();
	        readFile.close();
	    	} 
	    catch (final IOException e)
	        {
	        return null;
	        }
	    return MatrixNx6;
	    }
	}
