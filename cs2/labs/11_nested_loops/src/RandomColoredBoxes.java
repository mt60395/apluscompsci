import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import javax.swing.JPanel;

public class RandomColoredBoxes extends JPanel
{
	private Timer timer;
	private final static int SLEEP = 110;
	
	public RandomColoredBoxes()
	{		
		setBackground(Color.BLACK);
		setVisible(true);

		ActionListener paintCaller = new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				repaint();  
			}
		};
		timer = new Timer(SLEEP, paintCaller);
		timer.start();
	}	

	public void paintComponent( Graphics window )
	{
		super.paintComponent(window);
		
		window.setColor(Color.RED);
		window.setFont(new Font("TAHOMA",Font.BOLD,12));
	  	window.drawString("Graphics Lab Lab11k ", 20, 40);
	  	window.drawString("Drawing boxes with nested loops ", 20, 80);

	  	drawBoxes(window);
	}

	public void drawBoxes(Graphics window)
	{
		for (int y = 120; y < 9 * 25 + 120; y += 25) {
			for (int x = 50; x < 9 * 25 + 50; x += 25) {
				Random rand = new Random();
				window.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
				window.fillRect(x, y, 20, 20);
			}
		}
	}
}
