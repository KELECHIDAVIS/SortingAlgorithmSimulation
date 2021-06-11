import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;

import Framework.GamePanel;
import Framework.audio.Audio;

public class SPanel extends GamePanel
{
	protected static int width = 1200, height = 800;
	protected int rectW = 5, numOfRects= width/rectW, i=0, j =0, floor = 30; 
	protected int[] rects = new int[numOfRects]; 
	protected Random random = new Random(); 
	protected boolean done  = false; 
	protected float decibalRange = 86; 
	protected float riseVolume=-0f ;
	protected float it= decibalRange/((float)height -(float)floor); 
	protected Audio ding = new Audio("/ding.wav"), rise; 
	
	SPanel()
	{
		this.setBackground(Color.black);
		for(int i =0 ; i<rects.length; i++) // making rects 
		{
			rects[i] = random.nextInt(height-floor)+floor; 
		}
		
		
		System.out.println(rects.length);
		// bubble sort test 
	/*for(int i = 0; i<rects.length; i++)
		{
			for(int j =0; j<rects.length-i-1; j++)
			{
				
				
			}
		}*/
		
		
		System.out.println(it);
		this.UPS = 60.0; 
		this.start(); 
	}
	
	public void swap(int[] arr, int a , int b )
	{
		
		int dummy  = arr[a]; 
		arr[a] = arr[b]; 
		arr[b] = dummy;
		
		
	}
	@Override
	public void update()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paint(Graphics g)
	{
		super.paintComponent(g);
		if(!done)
		{
			g.setColor(Color.white);
		}else
		{
			g.setColor(Color.green);
		}
		
		
		if(i<rects.length)
		{
			for(int j =0; j<rects.length-i-1; j++)
			{
				int  a =rects[j];
				int b =rects[j+1];
				if(a>b)
				{
					swap(rects, j,j+1); 
				}
			}
			
		}else if(!done)
		{
			System.out.println("done ");
			done =true; 
			finished(g); 
			
			
		}
		i++; 
		
		
		for(int i =0 ; i<rects.length; i++)
		{
			g.fillRect(i*rectW, height - rects[i], rectW, rects[i]);
		}
		
	}
	public void finished(Graphics g)
	{
		ding.setVolume(-20f);
		ding.play(); 
		//since this only happens once i can use this functions to iterate through the whole the playing a sound at the different decibal values 
		for(int y = 0 ; y<rects.length; y++)
		{
			
			g.fillRect(y*rectW, height - rects[y], rectW, rects[y]);
		}
	}

	public void bubble()
	{
		
	}
	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
