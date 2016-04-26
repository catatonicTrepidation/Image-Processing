package com.eimacs.lab06;

import java.awt.Color;
import java.util.Random;

import com.eimacs.digest.UserInfoDialog;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


/**
 *
 * @author IMACS Curriculum Development Group
 * @version 2.0 March 05, 2015
 */
public class Lab06Runner
{
    public static int checkIndex = 3;
    
    public static double[][] valuesMap = new double[1000][1000];
    
    public static double[] minAndMax;
    
    public static void main( String[] args )
    {
 
    	
///////////////////////////////////////////VJava FunV/////////////////////////////////////////////
    	
    	//Picture p = new Picture(1000,1000);
    	
    	//p.RGB6();
    	
    	
    	
    	
///////////////////////////////////////////^Java Fun^/////////////////////////////////////////////
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
///////////////////////////////////////////VRECIEVING VALUES V/////////////////////////////////////////////
    	
    	
    	
    	
    	
    		BigDecimal bd = new BigDecimal(1.0);


    	
    	
    	

	

    	    	String s = "";
    	    	
    	    	double[][] valuesArray = new double[500][3];
    	        // The name of the file to open.
    	        String fileName = "temp.txt";

    	        // This will reference one line at a time
    	        String line = null;

    	        try {
    	            // FileReader reads text files in the default encoding.
    	            FileReader fileReader = 
    	                new FileReader(fileName);

    	            // Always wrap FileReader in BufferedReader.
    	            BufferedReader bufferedReader = 
    	                new BufferedReader(fileReader);

    	            while((line = bufferedReader.readLine()) != null) {
    	            	s += line;
    	                //System.out.println(line);
    	            	
    	            }   

    	            // Always close files.
    	            bufferedReader.close();         
    	        }
    	        catch(FileNotFoundException ex) {
    	            System.out.println(
    	                "Unable to open file '" + 
    	                fileName + "'");                
    	        }
    	        catch(IOException ex) {
    	            System.out.println(
    	                "Error reading file '" 
    	                + fileName + "'");                  
    	            // Or we could just do this: 
    	            // ex.printStackTrace();
    	        }
    	        //System.out.println(s);
    	        
    	        int counter = 0;
    	        while(s.indexOf("Ammonia") >= 0)
    	        {
    	        	
    	        	if(s.indexOf("Ammonia") >= 0)
    	        	{
    	        		//System.out.println(s.substring(s.indexOf(":") + 1,s.indexOf("PPM") - 1));
    	        		valuesArray[counter][0] = Double.parseDouble(s.substring(s.indexOf(":") + 1,s.indexOf("PPM")));
    	        		//System.out.println(valuesArray[counter][0]);
    	        		s = s.substring(s.indexOf("PPM ") + 4);
    	        		//System.out.println(s.substring(s.indexOf("lad") + 4, s.indexOf("long") - 1));
    	        		valuesArray[counter][1] = Double.parseDouble(s.substring(s.indexOf("lad") + 4, s.indexOf("long")));
    	        		
    	        		s = s.substring(s.indexOf("long"));
    	        		
    	        		if(s.indexOf("*") >= 0)
    	        		{
    	        			valuesArray[counter][2] = Double.parseDouble(s.substring(s.indexOf("long") + 6, s.indexOf("*")));
    	        			
    	        			s = s.substring(s.indexOf("Ammonia"));
    	        			//System.out.println("IT IS: " + s.substring(s.indexOf("long") + 6, s.indexOf("*") - 1));
    	        			
    	        		}
    	        		else
    	        		{
    	        			valuesArray[counter][2] = Double.parseDouble(s.substring(s.indexOf("long") + 6));
    	        		}
    	    			//System.out.println(valuesArray[i][0]);
    	    			//System.out.println(valuesArray[i][1]);
    	    			//System.out.println(valuesArray[i][2]);
    	        		counter++;
    	        		//System.out.println(counter);
    	        		//break;
    	        	}
    	        	
    	        }
    	///////////////////////////////////////////^RECIEVING VALUS ^/////////////////////////////////////////////
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	

    	        
		double valMin = valuesArray[0][0], valMax = valuesArray[0][0];
	   	 double latMin = valuesArray[0][1]; double latMax = valuesArray[0][1];
	   	double lonMin = valuesArray[0][2]; double lonMax = valuesArray[0][2];
	   	double[][] valueMap = new double[valuesArray.length][valuesArray.length];
	
	   	 for(int i = 0; i < valuesArray.length; i++)
	
	   	 {
	   		 //System.out.println("long: " + valuesArray[i][2]);
	   		 
	
	   		 	if(valuesArray[i][0] > valMax && valuesArray[i][0] != 0.0)
	
	   		 		valMax = valuesArray[i][0];
	
	   		 	if(valuesArray[i][0] < valMin && valuesArray[i][0] != 0.0)
	
	   		 		valMin = valuesArray[i][0];
	   		 	if(valuesArray[i][1] > latMax && valuesArray[i][1] != 0.0)
	   		 		latMax = valuesArray[0][1];
	
	   		 	if(valuesArray[i][1] < latMin && valuesArray[i][1] != 0.0)
	
	   		 		latMin = valuesArray[i][1];
	   		 	if(valuesArray[i][2] > lonMax && valuesArray[i][2] != 0.0)
	
	   		 		lonMax = valuesArray[i][2];
	
	   		 	if(valuesArray[i][2] < lonMin && valuesArray[i][2] != 0.0)
	
	   		 		lonMin = valuesArray[i][2];
	   		 	
	
	    	 }
	   	 
	   	double latRange = latMax - latMin;
	   	double lonRange = lonMax - lonMin;
	   	double valRange = valMax - valMin;

//	   	System.out.println("valMax is: " + valMax);
//	   	System.out.println("valMin is: " + valMin);
//	   	System.out.println("valRange is: " + valRange);
//	   	System.out.println("latMax is: " + latMax);
//	   	System.out.println("latMin is: " + latMin);
//	   	System.out.println("latRange is: " + latRange);
//	   	System.out.println("lonMax is: " + lonMax);
//	   	System.out.println("lonMin is: " + lonMin);
//	   	System.out.println("lonRange is: " + lonRange);
//	   	System.out.println(lonRange/(0.00001));
//	   	
	   	
	//Picture p = new Picture((int)(valuesArray.length + 1),(int)(valuesArray.length+1));
//      	p.HeatMap(valuesArray, latMin, latRange, lonMin, lonRange, valMin, valRange);
	   	//p.HeatMap(valuesArray, latMin, latRange, lonMin, lonRange, valMin, valRange);
	   	Picture p = new Picture(500,500);
	   	
      	
      	//p.filler(latRange, lonRange);
      	
      	
      	
      	//p = p.stretch(2, 2);
      	
      	//p.RGB7();
      	
      	//p.addLidOutline();
      	
    	//Picture p2 = new Picture(p.getWidth()+30,p.getHeight()+30);
      	
      	//p.addScale(p2, latRange, lonRange);
      	//p = p.addProperScale(p2,latRange,lonRange);
      	
      //p.circleThing(100, 100,3);
      //p.circleThing2(100, 50, 9);
      //p.circleThing(100, 100, 4);
      //p.Sierpinski();
	  p.SierpinskiSquare();
      p.explore();
      
      //p.explore();
    }    
    
    
    public void combineMaps(double[][] a1, double[][] a2)
    {
    	
    	for(int i = 0; i < a1.length && i < a2.length; i++)
    	{
    		//if(a1[(int)(a2[i][1]-minAndMax[0])/(minAndMax[1] - minAndMax[0])][2] == a2[i][2])
    	}
    		
    }
    
    public static String format(Number n) {
        NumberFormat format = DecimalFormat.getInstance();
        format.setRoundingMode(RoundingMode.FLOOR);
        //format.setMinimumFractionDigits(0);
        format.setMaximumFractionDigits(5);
        return format.format(n);
    }
}
