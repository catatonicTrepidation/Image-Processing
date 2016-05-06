package com.eimacs.lab06;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;


//import MyPackage.Pixel;

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 *˙
 * @author Barbara Ericson ericson@cc.gatech.edu
 * @version 2.1 (January 14, 2015) IMACS Curriculum Development Group
 */
public class Picture extends SimplePicture {
	///////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments
	 */
	public Picture() {
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
	public Picture(String fileName) {
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
	public Picture(int width, int height) {
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 *
	 * @param copyPicture
	 *            the picture to copy
	 */
	public Picture(Picture copyPicture) {
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 *
	 * @param image
	 *            the buffered image to use
	 */
	public Picture(BufferedImage image) {
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
		String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
		return output;
	}

	/**
	 * Method to set the blue component to 0
	 */
	public void zeroBlue() {
		Pixel[][] pixels = getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setBlue(0);
			}
		}
	}

	/**
	 * Method that mirrors the left half of a picture onto the right half as
	 * though reflecting in a mirror placed on the vertical center line of the
	 * picture
	 */
	public void mirrorLeftOntoRight() {
		Pixel[][] pixels = getPixels2D();
		Pixel leftPixel, rightPixel;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][(width - 1) - col];
				rightPixel.setColor(leftPixel.getColor());
			}
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

	// __________________________________________________________________

	// public double[] HeatMap(double[][] values)
	//
	// {
	//
	// double x = 0;
	//
	// double valMin = values[0][0], valMax = values[0][0];
	// double xMin = values[0][1], xMax = values [0][1];
	// double yMin = values[0][2], yMax = values [0][2];
	//
	// for(int i = 0; i < values.length; i++)
	//
	// {
	//
	// if(values[i][0] > valMax)
	//
	// valMax = values[i][0];
	//
	// if(values[i][0] < valMin)
	//
	// valMin = values[i][0];
	//
	// }
	// System.out.println(valMin);
	// System.out.println(valMax);
	//
	// //System.out.println(valMin + " | " + valMax);
	//
	// double valRange = valMax - valMin;
	// System.out.println(valRange);
	//
	//
	//
	// Pixel pixels[][] = getPixels2D();
	//
	// for (int row = 0; row < (Math.sqrt(values.length)); row++)
	//
	// {
	// for(int col = 0; col < (Math.sqrt(values.length)); col++)
	// {
	// x = (values[row*10 + col][0] - valMin)/valRange;
	//
	// if(x > 1)
	// {
	// x = 1;
	// }
	// if(x < 0)
	// {
	// x = 0;
	// }
	// //System.out.println(x);
	// pixels[row*10 + col][0].setColor(new Color((int)(122 + 123*x),(int)(255 -
	// x*255),(int)(255 - x*255)));
	// //pixels[i][j].setColor(new
	// Color((int)(255*x),(int)(255*x),(int)(255*x)));
	//
	// }
	//
	//
	//
	//
	//
	// }
	//
	// double[] minAndMax = {valMin, valMax};
	//
	// return minAndMax;
	//
	// }

	public void circleThing(int r1, int r2, int rot) {

		Pixel[][] pixels = getPixels2D();
		int cent_x = pixels[0].length / 2;
		int cent_y = pixels.length / 2;
		for (double theta = 0; theta < 2 * Math.PI; theta += Math.PI / 1000) {
			pixels[(int) ( r1 * Math.cos(rot * theta) + r1 * Math.cos(theta))
					+ cent_x][(int) (r2 * Math.sin(rot * theta) + r2 * Math.sin(theta) + cent_y)].setColor(Color.BLUE);
			repaint();
			sleep(1);
		}

	}
	
	public void circleThing2(int r1, int r2, int rot) {

		Pixel[][] pixels = getPixels2D();
		int cent_x = pixels[0].length / 2;
		int cent_y = pixels.length / 2;
		for (double theta = 0; theta < 2 * Math.PI; theta += Math.PI / 1000) {
			pixels[(int) ( r2 * Math.cos(rot * theta) + r1 * Math.cos(theta))
					+ cent_x][(int) (r2 * Math.sin(rot * theta) + r1 * Math.sin(theta) + cent_y)].setColor(Color.RED);
			repaint();
			sleep(0);
		}

	}
	
	public void Sierpinski()
	{
		Random rand = new Random();

		
		Pixel[][] pixels = getPixels2D();
		
		int randomCol = rand.nextInt((pixels[0].length) );
		int randomRow = rand.nextInt((pixels.length) );
		
		int cent_x = pixels[0].length / 2;
		int cent_y = pixels.length / 2;
		
		int[][] originalPixels = {{0,cent_x},{pixels[0].length-1,0},{pixels[0].length-1,2*cent_x-1}};
		
		
		pixels[0][cent_x].setColor(Color.BLUE);
		pixels[pixels[0].length-1][0].setColor(Color.BLUE);
		pixels[pixels[0].length-1][2*cent_x-1].setColor(Color.BLUE);
		
		pixels[randomRow][randomCol].setColor(Color.RED);
		
		int nextPoint;
		
		int newCol = randomCol;
		int newRow = randomRow;
		
		for(int i = 0; i < 10000; i++)
		{
			nextPoint = rand.nextInt(3);
			newRow = (originalPixels[nextPoint][0]+newRow)/2;
			newCol = (originalPixels[nextPoint][1]+newCol)/2;
			pixels[newRow][newCol].setColor(Color.RED);
			//sleep(1);
			//repaint();
			
		}
		
		
		
		
		
		
	}
	
	public void SierpinskiPentagon()
	{
		Random rand = new Random();

		
		Pixel[][] pixels = getPixels2D();
		
		int randomCol = rand.nextInt((pixels[0].length) );
		int randomRow = rand.nextInt((pixels.length) );
		
		int cent_x = pixels[0].length / 2;
		int cent_y = pixels.length / 2;
		
		int[][] originalPixels = {{0,0},{0,2*cent_x-1},{2*cent_y-1,0},{2*cent_y-1,2*cent_x-1}};
		
		
		pixels[0][cent_x+(int) (cent_y*Math.tan(36))].setColor(Color.BLUE);
		pixels[0][cent_x-(int) (cent_y*Math.tan(36))].setColor(Color.BLUE);
		pixels[cent_y+][].setColor(Color.BLUE);
		pixels[2*cent_y-1][0].setColor(Color.BLUE);
		pixels[2*cent_y-1][2*cent_x-1].setColor(Color.BLUE);
		
		
		pixels[randomRow][randomCol].setColor(Color.RED);
		
		int nextPoint;
		
		int newCol = randomCol;
		int newRow = randomRow;
		
		for(int i = 0; i < 10000; i++)
		{
			nextPoint = rand.nextInt(4);
			newRow = (originalPixels[nextPoint][0]+newRow)/2;
			newCol = (originalPixels[nextPoint][1]+newCol)/2;
			pixels[newRow][newCol].setColor(Color.RED);
			
			
		}
		
		
		
		
		
		
	}
	

	public void sleep(int time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			System.out.println("someone fucked up");
			e.printStackTrace();
		}
	}
	
	public void HeatMap(double[][] values, double latMin, double latRange, double lonMin, double lonRange,
			double valMin, double valRange) {
		// System.out.println(values.length);

		Pixel[][] pixels = getPixels2D();
		System.out.println("Pixels height" + pixels.length);
		System.out.println("Pixels width" + pixels[0].length);
		double x = 0;
		int w = 0;
		int h = 0;

		for (int i = 0; i < values.length; i++) {
			if (values[i][0] != 0.0 && values[i][1] != 0.0 && values[i][2] != 0.0) {
				// System.out.println((int) ((values[i][1]-latMin)/latRange *
				// getWidth()));
				// System.out.println((int) ((values[i][2]-lonMin)/lonRange *
				// getHeight()));
				if ((int) (((values[i][1] - latMin) / latRange * getWidth())) >= getWidth()) {
					w = getWidth() - 1;
				} else {
					w = (int) ((values[i][1] - latMin) / latRange * getWidth());
				}
				if ((int) (((values[i][2] - lonMin) / lonRange * getHeight())) >= getHeight()) {
					h = getHeight() - 1;
				} else {
					h = (int) (((values[i][2] - lonMin) / lonRange * getHeight()));
				}
				// System.out.println("valMin is " + valMin);
				// System.out.println("values[i][0] is " + values[i][0]);
				// System.out.println("valRange is " + valRange);
				x = (values[i][0] - valMin) / valRange;
				// System.out.println("h is " + h);
				// System.out.println("w is " + w);
				// System.out.println("x is " + x);
				pixels[w][h].setColor(new Color((int) (122 + 123 * x), (int) (255 - x * 255), (int) (255 - x * 255)));
			}

		}

	}

	public void filler(double latRange, double lonRange) {
		Pixel[][] pixels = getPixels2D();
		Color[][] newColors = new Color[pixels.length][pixels[0].length];
		Color saveColor = Color.BLACK;
		// Color avgVal = pixels[0][0].getColor();
		// System.out.println("It's " + getHeight()/(200000*lonRange));
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				if (!pixels[row][col].getColor().equals(Color.WHITE)) {
					saveColor = pixels[row][col].getColor();
					// System.out.println(row);
					// System.out.println(saveColor);
					for (double row2 = row - getWidth() / (200000 * latRange); row2 < row
							+ getWidth() / (200000 * latRange); row2++) {
						for (double col2 = col - getHeight() / (200000 * lonRange); col2 < col
								+ getHeight() / (200000 * lonRange); col2++) {
							if (col2 >= 0 && row2 >= 0 && col2 < getWidth() && row2 < getHeight()) {

								newColors[(int) row2][(int) col2] = saveColor;
							}
						}
					}
				} else {
					if (newColors[row][col] == null)
						newColors[row][col] = Color.BLACK;
				}
			}
		}

		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				pixels[row][col].setColor(newColors[row][col]);
			}
		}
	}

	public void average() {
		Pixel[][] pixels = getPixels2D();

		Color avgVal = pixels[0][0].getColor();
		for (int row = 0; row < pixels.length - 1; row++) {
			for (int col = 0; col < pixels[0].length - 1; col++) {
				avgVal = new Color(
						(int) ((pixels[row][col].getRed() + pixels[row + 1][col].getRed()
								+ pixels[row][col + 1].getRed() + pixels[row + 1][col + 1].getRed()) / 4.0),
						(int) ((pixels[row][col].getGreen() + pixels[row + 1][col].getGreen()
								+ pixels[row][col + 1].getGreen() + pixels[row + 1][col + 1].getGreen()) / 4.0),
						(int) ((pixels[row][col].getBlue() + pixels[row + 1][col].getBlue()
								+ pixels[row][col + 1].getBlue() + pixels[row + 1][col + 1].getBlue()) / 4.0));
				pixels[row][col].setColor(avgVal);
			}
		}

	}

	public void average2() {
		Pixel[][] pixels = getPixels2D();

		Color avgVal = pixels[0][0].getColor();
		for (int row = 0; row < pixels.length - 1; row++) {
			for (int col = 0; col < pixels[0].length - 1; col++) {

				avgVal = new Color(
						(int) ((pixels[row][col].getRed() + pixels[row + 1][col].getRed()
								+ pixels[row][col + 1].getRed() + pixels[row + 1][col + 1].getRed()) / 4.0),
						(int) ((pixels[row][col].getGreen() + pixels[row + 1][col].getGreen()
								+ pixels[row][col + 1].getGreen() + pixels[row + 1][col + 1].getGreen()) / 4.0),
						(int) ((pixels[row][col].getBlue() + pixels[row + 1][col].getBlue()
								+ pixels[row][col + 1].getBlue() + pixels[row + 1][col + 1].getBlue()) / 4.0));
				pixels[row][col].setColor(avgVal);
			}
		}

	}

	public void addLid() {
		Pixel[][] pixels = getPixels2D();
		System.out.println(pixels.length);
		Color saveColor = Color.WHITE;
		for (int row = pixels.length / 2 - 55; row < pixels.length / 2 + 55; row++) {
			for (int col = pixels[0].length / 2 - 30; col < pixels[0].length / 2 + 30; col++) {
				saveColor = pixels[row][col].getColor();
				pixels[row][col].setColor(Color.WHITE);
				// pixels[row][col].setColor(new
				// Color((saveColor.getRed()+100<=255) ? saveColor.getRed()+100
				// : 255,(saveColor.getGreen()+100<=255) ?
				// saveColor.getGreen()+100 : 255,
				// (saveColor.getBlue()+100<=255) ? saveColor.getBlue()+100 :
				// 255));

			}
		}

	}

	public void addLidOutline() {
		Pixel[][] pixels = getPixels2D();
		System.out.println(pixels.length);
		Color saveColor = Color.WHITE;
		for (int row = pixels.length / 2 - 55; row < pixels.length / 2 + 55; row++) {
			for (int col = pixels[0].length / 2 - 30; col < pixels[0].length / 2 + 30; col++) {
				saveColor = pixels[row][col].getColor();
				if (row <= pixels.length / 2 - 50 || row >= pixels.length / 2 + 50 || col <= pixels[0].length / 2 - 25
						|| col >= pixels[0].length / 2 + 25) {
					pixels[row][col].setColor(Color.WHITE);
				}

				// pixels[row][col].setColor(new
				// Color((saveColor.getRed()+100<=255) ? saveColor.getRed()+100
				// : 255,(saveColor.getGreen()+100<=255) ?
				// saveColor.getGreen()+100 : 255,
				// (saveColor.getBlue()+100<=255) ? saveColor.getBlue()+100 :
				// 255));

			}
		}

	}

	public void addScale(Picture p2, double latRange, double lonRange) {
		Pixel[][] pixels = getPixels2D();
		Pixel[][] pixels2 = p2.getPixels2D();
		Color saveColor = Color.WHITE;
		for (int row = 0; row < pixels.length; row += (getHeight() / (131239 * latRange))) {
			for (int col = 0; col < 30; col++) {
				saveColor = pixels[row][col].getColor();
				pixels[row][col].setColor(Color.WHITE);
				// pixels[row][col].setColor(new
				// Color((saveColor.getRed()+100<=255) ? saveColor.getRed()+100
				// : 255,(saveColor.getGreen()+100<=255) ?
				// saveColor.getGreen()+100 : 255,
				// (saveColor.getBlue()+100<=255) ? saveColor.getBlue()+100 :
				// 255));

			}
		}
		for (int row = pixels.length - 1; row >= pixels.length - 30; row--) {
			for (int col = 0; col < pixels[0].length; col += (getWidth() / (131239 * lonRange))) {
				saveColor = pixels[row][col].getColor();
				pixels[row][col].setColor(Color.WHITE);
				// pixels[row][col].setColor(new
				// Color((saveColor.getRed()+100<=255) ? saveColor.getRed()+100
				// : 255,(saveColor.getGreen()+100<=255) ?
				// saveColor.getGreen()+100 : 255,
				// (saveColor.getBlue()+100<=255) ? saveColor.getBlue()+100 :
				// 255));

			}
		}

	}

	public Picture addProperScale(Picture p2, double latRange, double lonRange) {
		Pixel[][] pixels = getPixels2D();
		Pixel[][] pixels2 = p2.getPixels2D();
		Color saveColor = Color.WHITE;
		for (int row = 0; row < pixels2.length; row += (getHeight() / (131239 * latRange))) {
			for (int col = 0; col < 30; col++) {
				// saveColor = pixels[row][col].getColor();
				pixels2[row][col].setColor(Color.BLACK);
				// pixels[row][col].setColor(new
				// Color((saveColor.getRed()+100<=255) ? saveColor.getRed()+100
				// : 255,(saveColor.getGreen()+100<=255) ?
				// saveColor.getGreen()+100 : 255,
				// (saveColor.getBlue()+100<=255) ? saveColor.getBlue()+100 :
				// 255));

			}
		}
		for (int row = pixels2.length - 1; row >= pixels2.length - 30; row--) {
			for (int col = 0; col < pixels2[0].length; col += (getWidth() / (131239 * lonRange))) {
				// saveColor = pixels[row][col].getColor();
				pixels2[row][col].setColor(Color.BLACK);
				// pixels[row][col].setColor(new
				// Color((saveColor.getRed()+100<=255) ? saveColor.getRed()+100
				// : 255,(saveColor.getGreen()+100<=255) ?
				// saveColor.getGreen()+100 : 255,
				// (saveColor.getBlue()+100<=255) ? saveColor.getBlue()+100 :
				// 255));

			}
		}
		// System.out.println("pixels2.length = " + pixels2.length);
		// System.out.println("pixels2[0].length = " + pixels2[0].length);
		// System.out.println("pixels.length = " + pixels.length);
		// System.out.println("pixels[0].length = " + pixels[0].length);
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				pixels2[row][col + 30].setColor(pixels[row][col].getColor());
			}
		}
		return p2;
	}

	public Picture stretch(int scaleH, int scaleW) {
		Picture p2 = new Picture(getWidth() * scaleW, getHeight() * scaleH);
		Pixel[][] pixels = getPixels2D();
		Color[][] colors2 = new Color[p2.getHeight()][p2.getWidth()];

		// System.out.println(p2.getHeight());
		// System.out.println(p2.getWidth());
		// System.out.println(colors2[0].length);
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				for (int i = 0; i <= scaleW - 1; i++) {
					for (int j = 0; j <= scaleH - 1; j++) {
						// System.out.println(col*i);
						colors2[row * scaleH + j][col * scaleW + i] = pixels[row][col].getColor();
					}
				}
			}
		}

		Pixel[][] pixels2 = p2.getPixels2D();

		for (int row = 0; row < pixels2.length; row++) {
			for (int col = 0; col < pixels2[0].length; col++) {
				pixels2[row][col].setColor(colors2[row][col]);
			}
		}

		return p2;
	}

	// __________________________________________________________________________________

	// public void edgeDetect(int minColorDistance)
	// {
	// Pixel[][] pixels = getPixels2D();
	// for(int row = 0; row < pixels.length-1; row++)
	// {
	// for(int col = 0; col < pixels[0].length-1; col++)
	// {
	// int b0 = pixels[row][col].getBlue();
	// int r0 = pixels[row][col].getRed();
	// int g0 = pixels[row][col].getGreen();
	// int b1 = pixels[row][col+1].getBlue();
	// int r1 = pixels[row][col+1].getRed();
	// int g1 = pixels[row][col+1].getGreen();
	// int b2 = pixels[row+1][col].getBlue();
	// int r2 = pixels[row+1][col].getRed();
	// int g2 = pixels[row+1][col].getGreen();
	// int d1 = (int)(Math.pow((b1 - b0), 2)
	// + Math.pow((r1 - r0), 2)
	// + Math.pow((g1 - g0), 2));
	// int d2 = (int)(Math.pow((b2 - b0), 2)
	// + Math.pow((r2 - r0), 2)
	// + Math.pow((g2 - g0), 2));
	// if(d1 >= minColorDistance || d2 >= minColorDistance)
	// {
	// pixels[row][col].setColor(Color.BLACK);
	// }
	// else
	// {
	// pixels[row][col].setColor(Color.WHITE);
	// }
	// }
	// }
	// }
	//
	// public void mix(Picture otherPic)
	// {
	// Pixel[][] otherPixels = otherPic.getPixels2D();
	// Pixel[][] pixels = getPixels2D();
	// boolean b = false;
	//
	// for(int row = 0; row < pixels.length && row < otherPixels.length; row++)
	// {
	// if(b)
	// {
	// for(int col = 0; col < pixels[0].length && col < otherPixels[0].length;
	// col++)
	// {
	// pixels[row][col].setColor(otherPixels[row][col].getColor());
	// }
	// b = false;
	// }
	// else
	// {
	// b = true;
	// }
	// }
	// }
	//
	// public void mix2(Picture secondPic, Picture thirdPic)
	// {
	// Pixel[][] secondPixels = secondPic.getPixels2D();
	// Pixel[][] thirdPixels = thirdPic.getPixels2D();
	// Pixel[][] pixels = getPixels2D();
	// int flip = 0;
	//
	// for(int row = 0; row < pixels.length && row < secondPixels.length && row
	// < thirdPixels.length; row++)
	// {
	// if(flip == 0)
	// {
	// for(int col = 0; col < pixels[0].length && col < secondPixels[0].length;
	// col++)
	// {
	// pixels[row][col].setColor(secondPixels[row][col].getColor());
	// }
	// flip++;
	// }
	// else if(flip == 1)
	// {
	// for(int col = 0; col < pixels[0].length && col < thirdPixels[0].length;
	// col++)
	// {
	// pixels[row][col].setColor(thirdPixels[row][col].getColor());
	// }
	// flip++;
	// }
	// else
	// {
	// flip = 0;
	// }
	// }
	// }
	//
	public void swirlifier(double degrees, double d, int relative) {
		Pixel[][] pixels = getPixels2D();
		Color[][] newColors = new Color[pixels.length][pixels[0].length];
		double width = 0;
		double height = 0;
		if (pixels[0].length % 2 == 0) {
			width = pixels[0].length / 2 - 0.5;
		}
		if (pixels.length % 2 == 0) {
			height = pixels.length / 2 - 0.5;
		}
		double v1 = 0;
		double v2 = 0;
		int newRow = 0;
		int newCol = 0;
		double cornerDist = 0;
		double maxDist = Math.sqrt(Math.pow(height, 2) + Math.pow(width, 2));
		double sDegrees = degrees;
		System.out.println(v1 + " | " + v2);
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				v1 = (Math.abs(Math.cos(degrees)) < 0.0001 ? 0 : Math.cos(degrees));
				v2 = (Math.abs(Math.sin(degrees)) < 0.0001 ? 0 : Math.sin(degrees));

				newRow = (int) (v1 * (row - height) + height - v2 * (col - width));
				newCol = (int) (v2 * (row - height) + v1 * (col - width) + width);

				if (newRow >= 0 && newRow < height * 2 && newCol >= 0 && newCol < width * 2) {
					newColors[row][col] = pixels[(int) (v1 * (row - height) + height
							- v2 * (col - width))][(int) (v2 * (row - height) + v1 * (col - width) + width)].getColor();
				} else {
					newColors[row][col] = pixels[row][col].getColor();
				}

				// cornerDist = Math.sqrt(Math.pow(Math.abs(row - height) -
				// height,2) + Math.pow(Math.abs(col - width) - width, 2));
				// degrees = sDegrees*(cornerDist/maxDist);

				cornerDist = Math.sqrt(
						Math.pow(Math.abs(row - height) - height, 2) + Math.pow(Math.abs(col - width) - width, 2));
				degrees = sDegrees * (cornerDist / maxDist);

			}
		}

		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				pixels[row][col].setColor(newColors[row][col]);
			}
		}
	}

	public void RGB() {
		Pixel[][] pixels = getPixels2D();
		Color[] colors = { Color.RED, Color.GREEN, Color.BLUE };
		Color[] colors2 = { Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE };
		double hScale = 255 / ((double) getHeight());
		double wScale = 255 / ((double) getWidth());
		// double currentBlue = 0;
		// double currentGreen = 0;
		// double currentRed = 0;
		for (int row = 0; row < pixels.length / 2; row++) {
			for (int col = 0; col < pixels[0].length / 2; col++) {
				pixels[row][col]
						.setColor(colors2[(int) ((row / (getHeight() / (20 * (0.5 + (row / (double) getHeight()))))) % 4
								+ (col / (getWidth() / (20 * (0.5 + (col / (double) getWidth()))))) % 4) % 4]);
			}
		}
		for (int row = pixels.length / 2; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length / 2; col++) {
				pixels[row][col]
						.setColor(colors2[(int) ((row / (getHeight() / (20 * (0.5 + (row / (double) getHeight()))))) % 4
								+ (col / (getWidth() / (20 * (0.5 + (col / (double) getWidth()))))) % 4) % 4]);
			}
		}
		for (int row = 0; row < pixels.length / 2; row++) {
			for (int col = pixels[0].length / 2; col < pixels[0].length; col++) {
				pixels[row][col]
						.setColor(colors2[(int) ((row / (getHeight() / (20 * (0.5 + (row / (double) getHeight()))))) % 4
								+ (col / (getWidth() / (20 * (0.5 + (col / (double) getWidth()))))) % 4) % 4]);
			}
		}
		for (int row = pixels.length / 2; row < pixels.length; row++) {
			for (int col = pixels[0].length / 2; col < pixels[0].length; col++) {
				pixels[row][col]
						.setColor(colors2[(int) ((row / (getHeight() / (20 * (0.5 + (row / (double) getHeight()))))) % 4
								+ (col / (getWidth() / (20 * (0.5 + (col / (double) getWidth()))))) % 4) % 4]);
			}
		}
	}

	public void RGB2() {
		Pixel[][] pixels = getPixels2D();
		Color[] colors = { Color.RED, Color.GREEN, Color.BLUE };
		double hScale = 255 / ((double) getHeight());
		double wScale = 255 / ((double) getWidth());
		// double currentBlue = 0;
		// double currentGreen = 0;
		// double currentRed = 0;
		for (int row = 0; row < pixels.length / 2; row++) {
			for (int col = 0; col < pixels[0].length / 2; col++) {
				pixels[row][col].setColor(colors[(col / (getWidth() / (10 * (col / (getWidth() / 2))))) % 3]);
			}
		}
	}

	public void RGB3() {
		Pixel[][] pixels = getPixels2D();
		Color[] colors = { Color.RED, Color.GREEN, Color.BLUE };
		Color[] colors2 = { Color.CYAN, Color.BLACK, Color.PINK };
		Color[] colors3 = { Color.ORANGE, Color.WHITE, new Color(255, 0, 255) };

		Color[] fourColors = { Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE };
		double hScale = 255 / ((double) getHeight());
		double wScale = 255 / ((double) getWidth());
		// double currentBlue = 0;
		// double currentGreen = 0;
		// double currentRed = 0;
		for (int row = 0; row < pixels.length / 2; row++) {
			for (int col = 0; col < pixels[0].length / 2; col++) {
				pixels[row][col].setColor(
						fourColors[(int) (((row / (getHeight() / (20 * (0.5 + (row / (double) getHeight()))))) % 3
								+ (col / (getWidth() / (20 * (0.5 + (col / (double) getWidth())))))) % 3) % 4]);
			}
		}
		for (int row = pixels.length / 2; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length / 2; col++) {
				pixels[row][col].setColor(
						fourColors[(int) (3 - ((row / (getHeight() / (20 * (0.5 + (row / (double) getHeight()))))) % 3
								+ (col / (getWidth() / (20 * (0.5 + (col / (double) getWidth())))))) % 3) % 4]);
			}
		}
		for (int row = 0; row < pixels.length / 2; row++) {
			for (int col = pixels[0].length / 2; col < pixels[0].length; col++) {
				pixels[row][col].setColor(
						fourColors[(int) (3 - ((row / (getHeight() / (20 * (0.5 + (row / (double) getHeight()))))) % 3
								+ (col / (getWidth() / (20 * (0.5 + (col / (double) getWidth())))))) % 3) % 4]);
			}
		}
		for (int row = pixels.length / 2; row < pixels.length; row++) {
			for (int col = pixels[0].length / 2; col < pixels[0].length; col++) {
				pixels[row][col].setColor(
						fourColors[(int) (((row / (getHeight() / (20 * (0.5 + (row / (double) getHeight()))))) % 3
								+ (col / (getWidth() / (20 * (0.5 + (col / (double) getWidth())))))) % 3) % 4]);
			}
		}
	}

	public void RGB4() {
		Pixel[][] pixels = getPixels2D();
		Color[] colors = { Color.RED, Color.GREEN, Color.BLUE };
		Color[] colors2 = { Color.CYAN, Color.BLACK, Color.PINK };
		Color[] colors3 = { Color.ORANGE, Color.WHITE, new Color(255, 0, 255) };
		Color[][] colorSets = { colors, colors2, colors3 };
		Color[] fourColors = { Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE };
		double hScale = 255 / ((double) getHeight());
		double wScale = 255 / ((double) getWidth());
		// double currentBlue = 0;
		// double currentGreen = 0;
		// double currentRed = 0;
		for (int row = 0; row < pixels.length / 2; row++) {
			for (int col = 0; col < pixels[0].length / 2; col++) {
				pixels[row][col].setColor((colorSets[(int) ((col / (getWidth() / 20))
						% 3)])[(int) ((row / (getHeight() / (20 * (0.5 + (row / (double) getHeight()))))) % 3
								+ (col / (getWidth() / (20 * (0.5 + (col / (double) getWidth()))))) % 3) % 3]);
			}
		}
		for (int row = pixels.length / 2; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length / 2; col++) {
				pixels[row][col].setColor((colorSets[(int) ((col / (getWidth() / 20))
						% 3)])[(int) ((row / (getHeight() / (20 * (0.5 + (row / (double) getHeight()))))) % 3
								+ (col / (getWidth() / (20 * (0.5 + (col / (double) getWidth()))))) % 3) % 3]);
			}
		}
		for (int row = 0; row < pixels.length / 2; row++) {
			for (int col = pixels[0].length / 2; col < pixels[0].length; col++) {
				pixels[row][col].setColor((colorSets[(int) ((col / (getWidth() / 20))
						% 3)])[(int) ((row / (getHeight() / (20 * (0.5 + (row / (double) getHeight()))))) % 3
								+ (col / (getWidth() / (20 * (0.5 + (col / (double) getWidth()))))) % 3) % 3]);
			}
		}
		for (int row = pixels.length / 2; row < pixels.length; row++) {
			for (int col = pixels[0].length / 2; col < pixels[0].length; col++) {
				pixels[row][col].setColor((colorSets[(int) ((col / (getWidth() / 20))
						% 3)])[(int) ((row / (getHeight() / (20 * (0.5 + (row / (double) getHeight()))))) % 3
								+ (col / (getWidth() / (20 * (0.5 + (col / (double) getWidth()))))) % 3) % 3]);
			}
		}
	}

	public void RGB5() {
		Pixel[][] pixels = getPixels2D();
		Color[] colors = { Color.RED, Color.GREEN, Color.BLUE };
		Color[] colors2 = { Color.CYAN, Color.BLACK, Color.PINK };
		Color[] colors3 = { Color.ORANGE, Color.WHITE, new Color(255, 0, 255) };
		Color[][] colorSets = { colors, colors2, colors3 };
		Color[] fourColors = { Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE };
		double hScale = 255 / ((double) getHeight());
		double wScale = 255 / ((double) getWidth());
		// double currentBlue = 0;
		// double currentGreen = 0;
		// double currentRed = 0;
		for (int row = 0; row < pixels.length / 2; row++) {
			for (int col = 0; col < pixels[0].length / 2; col++) {
				pixels[row][col].setColor((colorSets[(int) ((col / (getWidth() / 20))
						% 3)])[(int) ((row / (getHeight() / (20 * (0.5 + (row / (double) getHeight()))))) % 3
								+ (col / (getWidth() / (20 * (0.5 + (col / (double) getWidth()))))) % 3) % 3]);
			}
		}
		for (int row = pixels.length / 2; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length / 2; col++) {
				pixels[row][col].setColor((colorSets[(int) ((col / (getWidth() / 20))
						% 3)])[(int) ((row / (getHeight() / (20 * (0.5 + (row / (double) getHeight()))))) % 3
								+ (col / (getWidth() / (20 * (0.5 + (col / (double) getWidth()))))) % 3) % 3]);
			}
		}
		for (int row = 0; row < pixels.length / 2; row++) {
			for (int col = pixels[0].length / 2; col < pixels[0].length; col++) {
				pixels[row][col].setColor((colorSets[(int) ((col / (getWidth() / 20))
						% 3)])[(int) ((row / (getHeight() / (20 * (0.5 + (row / (double) getHeight()))))) % 3
								+ (col / (getWidth() / (20 * (0.5 + (col / (double) getWidth()))))) % 3) % 3]);
			}
		}
		for (int row = pixels.length / 2; row < pixels.length; row++) {
			for (int col = pixels[0].length / 2; col < pixels[0].length; col++) {
				pixels[row][col].setColor((colorSets[(int) ((col / (getWidth() / 20))
						% 3)])[(int) ((row / (getHeight() / (20 * (0.5 + (row / (double) getHeight()))))) % 3
								+ (col / (getWidth() / (20 * (0.5 + (col / (double) getWidth()))))) % 3) % 3]);
			}
		}
	}

	public void RGB7() {
		Pixel[][] pixels = getPixels2D();
		Color[] colors = { Color.RED, Color.GREEN, Color.BLUE };
		Color[] colors2 = { Color.CYAN, Color.BLACK, Color.PINK };
		Color[] colors3 = { Color.ORANGE, Color.WHITE, new Color(255, 0, 255) };
		Color[][] colorSets = { colors, colors2, colors3 };
		Color[] fourColors = { Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE };
		double partitions = 16;
		double hScale = ((double) getHeight()) / partitions;
		double wScale = ((double) getWidth()) / partitions;

		// double currentBlue = 0;
		// double currentGreen = 0;
		// double currentRed = 0;

		int[] mods = { 1, 2, 3 };

		System.out.println("HI");
		// for(double i = 0; i < partitions; i++)
		// {
		//
		//
		// if(i%3==0)
		// {
		// System.out.println("i%3==0 == " + (i%3==0));
		// for(int row = (int)(i/partitions)*pixels.length; row <
		// (int)((i+1)/partitions)*pixels.length; row++)
		// {
		// for(int col = (int)(i/partitions)*pixels[0].length; col <
		// (int)((i+1)/partitions)*pixels[0].length; col++)
		// {
		// //pixels[row][col].setColor(fourColors[(int)((col/wScale)%3)]);
		// pixels[row][col].setColor(Color.BLUE);
		// }
		// }
		// }
		// else if(i%3==1)
		// {
		// System.out.println("i%3==1 == " + (i%3==1));
		// for(int row = (int)(i/partitions)*pixels.length; row <
		// (int)((i+1)/partitions)*pixels.length; row++)
		// {
		// for(int col = (int)(i/partitions)*pixels[0].length; col <
		// (int)((i+1)/partitions)*pixels[0].length; col++)
		// {
		// //pixels[row][col].setColor(fourColors[(int)((col/wScale)%4)]);
		// pixels[row][col].setColor(Color.BLACK);
		// }
		// }
		// }
		// }
		int i = 0;
		int j = 0;
		/// THIS IS REALLY COOL
		// for(int row = 0; row < pixels.length; row++)
		// {
		// for(int col = 0; col < pixels[0].length; col++)
		// {
		// pixels[row][col].setColor(fourColors[i%(mods[(int)
		// (((col/wScale))%2)])]);
		// i++;
		// }
		// }
		// for(int row = 0; row < pixels.length; row++)
		// {
		// for(int col = 0; col < pixels[0].length; col++)
		// {
		// pixels[row][col].setColor((colorSets[(int)
		// (((row/hScale))%3)])[i%(mods[(int) (((col/wScale))%2)])]);
		// i+=(row%2+col%2);
		// }
		// }
		int size = 150;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				pixels[row][col].setColor((colorSets[(i % (1 + (int) (((col / hScale) % size)))) % 2])[(1
						* (i % (1 + (int) (((col / wScale) % size))))) % 3]);
				i++;
				// System.out.println(i);
				// System.out.println((1+(int) (((col/wScale))%2)));
			}
		}

		// for(int row = 0; row < pixels.length; row++)
		// {
		// for(int col = 0; col < pixels[0].length; col++)
		// {
		// pixels[row][col].setColor(colors3[i%(mods[(int)
		// (((col/wScale))%2)])]);
		//
		// }
		// i++;
		// }

		// for(int row = 0; row <pixels.length/2; row++)
		// {
		// for(int col = 0; col < pixels[0].length/2; col++)
		// {
		// pixels[row][col].setColor((colorSets[(int) (
		// (col/(getWidth()/20))%3)])[(int)
		// ((row/(getHeight()/(20*(0.5+(row/(double)getHeight())))))%3 +
		// (col/(getWidth()/(20*(0.5+(col/(double)getWidth())))))%3)%3]);
		// }
		// }
		// for(int row = pixels.length/2; row <pixels.length; row++)
		// {
		// for(int col = 0; col < pixels[0].length/2; col++)
		// {
		// pixels[row][col].setColor((colorSets[(int) (
		// (col/(getWidth()/20))%3)])[(int)
		// ((row/(getHeight()/(20*(0.5+(row/(double)getHeight())))))%3 +
		// (col/(getWidth()/(20*(0.5+(col/(double)getWidth())))))%3)%3]);
		// }
		// }
		// for(int row = 0; row < pixels.length/2; row++)
		// {
		// for(int col = pixels[0].length/2; col < pixels[0].length; col++)
		// {
		// pixels[row][col].setColor((colorSets[(int) (
		// (col/(getWidth()/20))%3)])[(int)
		// ((row/(getHeight()/(20*(0.5+(row/(double)getHeight())))))%3 +
		// (col/(getWidth()/(20*(0.5+(col/(double)getWidth())))))%3)%3]);
		// }
		// }
		// for(int row = pixels.length/2; row < pixels.length; row++)
		// {
		// for(int col = pixels[0].length/2; col < pixels[0].length; col++)
		// {
		// pixels[row][col].setColor((colorSets[(int) (
		// (col/(getWidth()/20))%3)])[(int)
		// ((row/(getHeight()/(20*(0.5+(row/(double)getHeight())))))%3 +
		// (col/(getWidth()/(20*(0.5+(col/(double)getWidth())))))%3)%3]);
		// }
		// }
	}

	public void polka(double e, double f, int xPeriod, int yPeriod, int[] color) {
		Pixel[][] pixels = getPixels2D();
		int[][] colors = { { 10, 0, 0 }, { 0, 10, 0 }, { 0, 0, 10 } };
		double xDistance = 0;
		double yDistance = 0;
		double d = 0;
		/*
		 * if(color == 0) { for (int row = 0; row < pixels.length; row++) {
		 * for(int col = 0; col < pixels[0].length; col++) { //Use modulo to see
		 * distance of pixel to nearest period/checkpoint xDistance =
		 * row%((yRadius+yPeriod)/2); yDistance = col%((xRadius+xPeriod)/2); d =
		 * Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2)); if(d <=
		 * xRadius) pixels[row][col].setColor(Color.RED); } } }
		 */

		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				// Use modulo to see distance of pixel to nearest
				// period/checkpoint
				// xDistance = (yRadius) - (row%((yRadius)))/2;
				// yDistance = (xRadius) - (col%((xRadius)))/2;
				yDistance = f - row % (yPeriod + f * 2);
				xDistance = e - col % (xPeriod + e * 2);
				d = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
				// System.out.println((row%((yRadius+yPeriod))));
				// if(d <= xRadius)
				// pixels[row][col].setColor(Color.RED);
				/*
				 * if(xDistance == 0) { pixels[row][col].setColor(Color.PINK); }
				 * if(yDistance == 0) { pixels[row][col].setColor(Color.GREEN);
				 * }
				 */
				/*
				 * if(d <= 30) { pixels[row][col].setColor(Color.ORANGE); }
				 */

				// if(d <= yRadius)
				// {
				// pixels[row][col].setRed(pixels[row][col].getRed() +
				// color[0]);
				// pixels[row][col].setGreen(pixels[row][col].getGreen() +
				// color[1]);
				// pixels[row][col].setBlue(pixels[row][col].getBlue() +
				// color[2]);
				// }

				if (d <= f) {
					pixels[row][col].setColor(new Color(color[0], color[1], color[2]));
				}

			}
		}
	}

	public void RGB6() {
		Pixel[][] pixels = getPixels2D();
		Color[] colors = { Color.RED, Color.GREEN, Color.BLUE };
		Color[] colors2 = { Color.CYAN, Color.BLACK, Color.PINK };
		Color[] colors3 = { Color.ORANGE, Color.WHITE, new Color(255, 0, 255) };
		Color[][] colorSets = { colors, colors2, colors3 };
		Color[] fourColors = { Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE };

		int[][] colorValues = { { 255, 0, 0 }, { 0, 255, 0 }, { 0, 0, 255 } };
		int[] aColor = new int[3];
		int colorIndex = 0;
		double gradient = getWidth();
		double hScale = 255 / ((double) getHeight());
		double wScale = 255 / ((double) getWidth());
		// double currentBlue = 0;
		// double currentGreen = 0;
		// double currentRed = 0;
		// for(int row = 0; row <pixels.length; row++)
		// {
		// for(int col = 0; col < pixels[0].length; col++)
		// {
		//
		// colorIndex = (int)
		// ((row/(getHeight()/(20*(0.5+(row/(double)getHeight())))))%3 +
		// (col/(getWidth()/(20*(0.5+(col/(double)getWidth())))))%3)%3;
		// aColor = colorValues[colorIndex];
		// //pixels[row][col].setColor((colorSets[(int) (
		// (col/(getWidth()/20))%3)])[(int)
		// ((row/(getHeight()/(20*(0.5+(row/(double)getHeight())))))%3 +
		// (col/(getWidth()/(20*(0.5+(col/(double)getWidth())))))%3)%3]);
		// if(colorIndex == 0)
		// {
		// pixels[row][col].setColor(new Color(aColor[0],(int)( aColor[1] +
		// (col/(double)getWidth())*255),(int)( aColor[2] +
		// (col/(double)getWidth())*255)));
		// }
		// if(colorIndex == 2)
		// {
		// pixels[row][col].setColor(new Color((int)(aColor[0] +
		// (col/(double)getWidth())*255),(int)( aColor[1] +
		// (col/(double)getWidth())*255), aColor[2]));
		// }
		// if(colorIndex == 1)
		// {
		// pixels[row][col].setColor(new Color((int)(aColor[0] +
		// (col/(double)getWidth())*255), aColor[1], (int)(aColor[2] +
		// (col/(double)getWidth())*255)));
		// }
		// }
		// }

		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length; col++) {

				colorIndex = (int) ((row / (getHeight() / (20 * (0.5 + (row / (double) getHeight()))))) % 3
						+ (col / (getWidth() / (20 * (0.5 + (col / (double) getWidth()))))) % 3) % 3;
				aColor = colorValues[colorIndex];
				// pixels[row][col].setColor((colorSets[(int) (
				// (col/(getWidth()/20))%3)])[(int)
				// ((row/(getHeight()/(20*(0.5+(row/(double)getHeight())))))%3 +
				// (col/(getWidth()/(20*(0.5+(col/(double)getWidth())))))%3)%3]);
				if (colorIndex == 0) {
					pixels[row][col]
							.setColor(new Color(aColor[0], (int) (aColor[1] + (col / (double) getWidth()) * 255),
									(int) (aColor[2] + (col / (double) getWidth()) * 255)));
				}
				if (colorIndex == 2) {
					pixels[row][col].setColor(
							new Color(aColor[0], aColor[1], aColor[2] - (int) ((col / (double) getWidth()) * 255)));
				}
				if (colorIndex == 1) {
					pixels[row][col].setColor(new Color(aColor[0], aColor[1], aColor[2]));
				}
			}
		}
	}

} // this } is the end of class Picture, put all new methods before this
