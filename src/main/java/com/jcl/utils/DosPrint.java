/*
 * Created on Oct 18, 2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.jcl.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author junald
 * 
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
public class DosPrint {
	
	File inputFile; 
	File outputFile;
	FileReader in;
	FileWriter out;


	public DosPrint(String filename){
		inputFile = new File(filename);
		//outputFile = new File("LPT1");
                outputFile = new File("USB001");
		try {
			in = new FileReader(inputFile);
			out = new FileWriter(outputFile);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void startPrinting() throws IOException{
		int c;
		while ((c = in.read()) != -1) {
			out.write((char) c);
		}
		out.flush();
		in.close();
		out.close();	
	}
	
}