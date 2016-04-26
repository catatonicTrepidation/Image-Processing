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
