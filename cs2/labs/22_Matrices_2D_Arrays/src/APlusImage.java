import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.util.Scanner;
import java.io.File;
import java.awt.Canvas;

public class APlusImage extends Canvas
{
	private int[][] image;
	private String fileName;

	public APlusImage()
	{
		try{
		   Scanner file = new Scanner(new File("image.dat"));	
			image = new int[file.nextInt()][file.nextInt()];
			while(file.hasNextInt())
			{
				image[file.nextInt()][file.nextInt()]=file.nextInt();
			}
		}
		catch(Exception e)
		{
			
		}
		
		setSize( 640, 480 );
		setBackground(Color.white);
		setVisible(true);
	}

	public APlusImage(String name)
	{
		try{
		   Scanner file = new Scanner(new File("image.dat"));	
			image = new int[file.nextInt()][file.nextInt()];
			while(file.hasNextInt())
			{
				image[file.nextInt()][file.nextInt()]=file.nextInt();
			}
		}
		catch(Exception e)
		{
			
		}
		
		setSize( 640, 480 );
		setBackground(Color.white);
		setVisible(true);
	}

	public void paint( Graphics window )
	{
		window.setColor(Color.white);
		window.fillRect(0,0,640,480);
		window.setFont(new Font("TAHOMA",Font.BOLD,12));
		window.setColor(Color.blue);
		window.drawString("Lab16e",420,40);
		window.drawString("IMAGES", 420,55);
		
		showImage(window);		
	}
	
	public void showImage(Graphics window)
	{
		//roygbiv
		//2 red
		//4 orange
		//6 yellow
		//8 green
		//10 blue
		//12 indigo
		//14 violet
		
		for(int r=0;r<image.length;r++)
		{
			for(int c=0;c<image[r].length;c++)
			{
				switch(image[r][c])
				{
					case 2 : {
						window.setColor(Color.red);
						window.fillRect(c,r, 10,10);							
						break;
				   }
				   case 4 : {
						window.setColor(Color.orange);
						window.fillRect(c,r, 10,10);							
						break;
					}	
				   case 6 : {
						window.setColor(Color.yellow);
						window.fillRect(c,r, 10,10);							
						break;
					}
					case 8: {
						window.setColor(Color.green);
						window.fillRect(c,r, 10,10);							
						break;
					}
					case 10: {
						window.setColor(Color.blue);
						window.fillRect(c,r, 10,10);							
						break;
					}
 				}
			}
		}
	}
}
