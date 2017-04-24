//package com.eimacs.lab08;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import javax.imageio.ImageIO;

public class Painting extends SimplePicture {

	public Painting() {
		/*
		 * not needed but use it to show students the implicit call to super()
		 * child constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 *
	 * @param fileName
	 *            the name of the file to create the picture from
	 */
	public Painting(String fileName) {
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 *
	 * @param height
	 *            the height of the desired picture
	 * @param width
	 *            the width of the desired picture
	 */
	public Painting(int width, int height) {
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 *
	 * @param copyPicture
	 *            the picture to copy
	 */
	public Painting(Painting copyPicture) {
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 *
	 * @param image
	 *            the buffered image to use
	 */
	public Painting(BufferedImage image) {
		super(image);
	}

	////////////////////// methods ///////////////////////////////////////
	/**
	 * Method to return a string with information about this picture.
	 *
	 * @return a string with information about the picture such as fileName,
	 *         height and width.
	 */
	public String toString() {
		String output = "Painting, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
		return output;
	}
	
	public void saveImage(String filePath)
	{
		BufferedImage bimg = getBufferedImage();
		try {
    		ImageIO.write(bimg,"png", new File(filePath));
    		
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
	}
	
	public void saveImage(String directory, String fileName)
	{
		BufferedImage bimg = getBufferedImage();
		try {
    		ImageIO.write(bimg,"png", new File(directory + fileName));
    		
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
	}
	
	public int[] averageColor()
	{
		Pixel[][] pixels = getPixels2D();
		int[] averageColor = {0,0,0};
		for(int row = 0; row < pixels.length; row++)
		{
			
			for(int col = 0; col < pixels[0].length; col++)
			{
				
				averageColor[0]+=pixels[row][col].getRed();
				averageColor[1]+=pixels[row][col].getGreen();
				averageColor[2]+=pixels[row][col].getBlue();
				
				
			}
			
			
		}
		
		averageColor[0]/=(pixels.length*pixels[0].length);
		averageColor[1]/=(pixels.length*pixels[0].length);
		averageColor[2]/=(pixels.length*pixels[0].length);
		
		return averageColor;
	}
	
	public double stdDevLightness (double avgLightness) {
		Pixel[][] pixels = getPixels2D();
		double total = 0;
		int r, g, b = 0;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				r = pixels[row][col].getRed();
				g = pixels[row][col].getGreen();
				b = pixels[row][col].getBlue();
				total += Math.pow(avgLightness - Math.sqrt(Math.pow(r, 2) + Math.pow(g, 2) + Math.pow(b, 2)), 2);
			}
		}
		
		return Math.sqrt(total/(pixels.length*pixels[0].length - 1));		
	}
	
	public void negBorder(int n) {
		Pixel[][] pixels = getPixels2D();
		int r, g, b = 0;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				r = pixels[row][col].getRed();
				g = pixels[row][col].getGreen();
				b = pixels[row][col].getBlue();
				if (Math.sqrt(Math.pow((0 - r),2) + Math.pow((0 - g),2) + Math.pow((0 - b),2)) < n) { 
					pixels[row][col].setColor(new Color(255 - pixels[row][col].getRed(),255 - pixels[row][col].getGreen(),255 - pixels[row][col].getBlue()));
				}
				else if (Math.sqrt(Math.pow((255 - r),2) + Math.pow((255 - g),2) + Math.pow((255 - b),2)) < n) {
					pixels[row][col].setColor(new Color(255 - pixels[row][col].getRed(),255 - pixels[row][col].getGreen(),255 - pixels[row][col].getBlue()));
				}
			}
		}
	}
	
	
	
	public void relativeNegBorder(double N, double avgLightness, double stdDevLightness) {
		Pixel[][] pixels = getPixels2D();
		int r, g, b = 0;
		double lightness = 0;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				r = pixels[row][col].getRed();
				g = pixels[row][col].getGreen();
				b = pixels[row][col].getBlue();
				lightness = Math.sqrt(Math.pow(r, 2) + Math.pow(g, 2) + Math.pow(b, 2));
				//System.out.println(Math.abs((avgLightness - lightness)/stdDevLightness) > N);
				if (Math.abs((avgLightness - lightness)/stdDevLightness) > N) { 
					pixels[row][col].setColor(new Color(255 - r,255 - g,255 - b));
				}
			}
		}
	}
	
	public void plussle1(Pixel[][] pixels, int row, int col, Color[] colors) {
		
		if (col >= pixels[0].length || col < 0 || row >= pixels.length || row < 0) {
			return;
		}
		//pixels[pos[1]][pos[0]].setColor(colors[(pos[0]*pos[1])%colors.length]);
		System.out.println(pixels[0][0].getColor());
		
		//plussle(pixels, row, col, colors);
		//plussle(pixels, row, col, colors);
		//plussle(pixels, row, col, colors);
		//plussle(pixels, row, col, colors);
	}
	
	public void plussle(Pixel[][] pixels, int row, int col, Color[] colors) {
		
		if (col >= pixels[0].length || col < 0 || row >= pixels.length || row < 0) {
			return;
		}
		pixels[row][col].setColor(colors[(row*col)%colors.length]);
		//System.out.println(pixels[0][0].getColor());
		boolean running = true;
		int[] p0 = new int[] {row+1, col};
		int[] p1 = new int[] {row, col+1};
		int[] p2 = new int[] {row-1, col};
		int[] p3 = new int[] {row, col-1};
		int x = 1;
		double i = 0;
		while (x > 0 && i < 50000) {
			x = plussleHelper(pixels, p0[0]+1, p0[1], colors, 0) +
			plussleHelper(pixels, p1[0], p1[1]+1, colors, 1) +
			plussleHelper(pixels, p2[0]-1, p2[1], colors, 2) +
			plussleHelper(pixels, p3[0], p3[1]-1, colors, 3);
			p0[0]=(int) (row + 50*Math.sin(i));
			p0[1]=(int) (col + 50*Math.cos(i));
			p1[0]+=p0[0]%2;
			p1[1]+=p0[1]%2;
			p2[0]+=7*Math.sin((p0[1]-p0[0]));
			p2[1]+=Math.cos((p0[0]-p0[1]));
			p3[0]=(int) (row + (int) 30*Math.sin(i + i*Math.sin(i)));
			p3[1]=(int) (col + (int) 30*Math.cos(i + i*Math.cos(i)));
			i++;
		}
	}
	
	public int plussleHelper(Pixel[][] pixels, int row, int col, Color[] colors, int n) {
		//System.out.println("row - " + row + " | col - " + col);
		if (col >= pixels[0].length || col < 0 || row >= pixels.length || row < 0) {
			return 0;
		}
		
		pixels[row][col].setColor(colors[(row*col + (col+row)%(colors.length-1))%colors.length]);
		return 1;
	}
	
	public void modulo1(Color[] colors, int n) {
		Pixel[][] pixels = getPixels2D();
		int max = ((int)Math.sqrt(Math.pow(pixels.length, 2)+Math.pow(pixels[0].length, 2)));
		double height = getHeight();
		double width = getWidth();
		int[] vals = new int[n];
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				pixels[row][col].setColor(new Color((vals[vals.length-2*(n/4)] + vals[vals.length-1])%255,(vals[vals.length-3*(n/4)] + vals[vals.length-1])%255,(vals[vals.length-4*(n/4)] + vals[vals.length-1])%255));
				
				for (int i = 1; i < vals.length; i++) {
					vals[i-1]+=max%((int)Math.sqrt(Math.pow(col + col*Math.sin(2*Math.PI*row/height), 2)+Math.pow(row + row*Math.sin(2*Math.PI*col/width), 2)) + 1);
					//System.out.println(vals[i-1]);
					vals[i]+=vals[i-1]%n;
				}
			}
		}
	}
	
	public void modulo2() {
		
	}
	
	public void swirlifier(double initial, double scalar) {
		Pixel[][] pixels = getPixels2D();
		Color[][] saveColors = new Color[pixels.length][pixels[0].length];
		
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				saveColors[row][col] = pixels[row][col].getColor();
			}
			
		}
		
		double height = getHeight();
		double width = getWidth();
		double dist = 0;
		double maxDist = Math.sqrt(Math.pow(width/2, 2) + Math.pow(height/2,2));
		//double maxDistX = Math.sqrt(Math.pow(width/2, 2) + Math.pow(height/2,2));
		//double maxDistY = Math.sqrt(Math.pow(width/2, 2) + Math.pow(height/2,2));
		
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				dist = Math.sqrt(Math.pow(col-width/2, 2) + Math.pow(row-height/2,2));
				
				//System.out.println(scalar*dist/maxDistX);
				if ((int) (((height + row + scalar*Math.sin(10*Math.PI*col/width)*dist/maxDist))) >= height ||
						(int) (((height + row + scalar*Math.sin(10*Math.PI*col/width)*dist/maxDist))) < 0 ||
						(int) ((width + col + scalar*Math.cos(10*Math.PI*row/height)*dist/maxDist)) >= width ||
						(int) ((width + col + scalar*Math.cos(10*Math.PI*row/height)*dist/maxDist)) < 0) {
							pixels[(int) (((height + row + scalar*Math.sin(10*Math.PI*col/width)*dist/maxDist))%(height))][(int) ((width + col + scalar*Math.cos(10*Math.PI*row/height)*dist/maxDist)%width)].setColor(pixels[row][col].getColor()); 
						}
				else {
					pixels[(int) (((height + row + scalar*Math.sin(10*Math.PI*col/width)*dist/maxDist)))][(int) ((width + col + scalar*Math.cos(10*Math.PI*row/height)*dist/maxDist))].setColor(saveColors[row][col]);
				}
				//pixels[(int) (((height + row + scalar*Math.sin(10*Math.PI*col/width)*dist/maxDist))%height)][(int) ((width + col + scalar*Math.cos(10*Math.PI*row/height)*dist/maxDist)%width)].setColor(saveColors[row][col]);
				
			}
			
		}
		
		
	}
	
}
