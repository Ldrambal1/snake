package com.vincentramdhanie.snake;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import javax.swing.JOptionPane;

public class SnakePanel extends JPanel{
	public static final int REPAINT_INTERVAL = 30;
	
	//Snake snake; --moved to SnakeController

	SnakeController controller;

	public SnakePanel(){
		super();
		setBackground(Color.BLACK);
		  
		//snake = new Snake(); --moved to SnakeController

		Thread t = new Thread(new RepaintLoop());
		t.start();

		setFocusable(true);

	}

	public SnakeController getController(){
		return controller;
	}

	public void setController(SnakeController controller){
		this.controller = controller;
	}


	public void startAnimation(){
		//code to start the animation
		//You can write your code here to
		//start up the animation loop
		JOptionPane.showMessageDialog(null, "Starting Game");
	}

	public void stopAnimation(){
		//code to stop the animation
	}


	/**
	 * Override the paintComponent method to 
	 * perform custom drawing
	 */
	@Override
	protected void paintComponent(Graphics g){		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		controller.draw(g2); //the controller knows how to draw the snake

		
	}

	/**
	 * This runs the thread that repaints periodically
	 */
	private class RepaintLoop implements Runnable{
		public void run(){
			while(true){
				repaint();
				try{
					Thread.sleep(REPAINT_INTERVAL);
				}	catch(InterruptedException e){}
			}
		}
	}

}
