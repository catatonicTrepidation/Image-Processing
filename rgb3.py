from PIL import Image
import math
import sys

#img = Image.new( 'RGB', (255,255), "black") # create a new black image

file = sys.argv[1] #"CatGirl.png"
img = Image.open(file)
pixels = img.load() # create the pixel map
avg = 0
w = 5
h = 5

for i in range(img.size[0]):    # for every pixel:
    for j in range(img.size[1]):
       #avg = int(math.sqrt(pixels[i,j][0]*pixels[i,j][1])+pixels[i,j][2])
       #avg = (avg // 2)%255
       r = pixels[i,j][0]*(1.2 if (i//w+j//h)%3 == 0 else 0.8) + (50 if (i//w+j//h)%5 == 0 else 0)
       r = 255 if r > 255 else int(r)
       g = pixels[i,j][1]*(1.2 if (i//w+j//h)%3 == 1 else 0.8) + (50 if (i//w+j//h)%5 == 2 else 0)
       g = 255 if g > 255 else int(g)
       b = pixels[i,j][2]*(1.2 if (i//w+j//h)%3 == 2 else 0.8) + (50 if (i//w+j//h)%5 == 4 else 0)       
       b = 255 if b > 255 else int(b)
       pixels[i,j] = (r,g,b)  # set the colour accordingly

img.show()
img.save('output.png')
