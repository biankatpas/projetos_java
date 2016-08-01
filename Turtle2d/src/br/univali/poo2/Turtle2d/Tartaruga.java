package br.univali.poo2.Turtle2d;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 * 
 * @author biankatpas
 */

public class Tartaruga extends Sprite{
	
	float sizeX, sizeY;
        Caneta caneta;
	
	
	public Tartaruga(float x, float y, BufferedImage img, float sx, float sy) {
		super(x, y, img);
		// TODO Auto-generated constructor stub
		sizeX=sx;
		sizeY=sy;
	}

	@Override
	public void simulaSe(long DiffTime) {
		// TODO Auto-generated method stub
		
		if(GamePanel.UP)
			if(y>0)
				y--;
		if(GamePanel.DOWN)			
			if(y+sizeY<GamePanel.PHEIGHT)
				y++;
		
		if(GamePanel.LEFT)
			if(x>0)
				x--;
		if(GamePanel.RIGHT)
			if(x+sizeX<GamePanel.PWIDTH)
				x++;
		if(GamePanel.PEN){
			caneta = new Caneta(x,y,GamePanel.imgCaneta, GamePanel.MouseX, GamePanel.MouseY);
			GamePanel.lista_Sprites.add(caneta);
			
		}
		
			
	}

	@Override
	public void desenhaSe(Graphics2D dbg) {
		// TODO Auto-generated method stub
		double dx = (x + sizeX/2) - GamePanel.MouseX;
		double dy = (y +sizeY/2)- GamePanel.MouseY;
		double ang = Math.atan2(dy, dx);
		AffineTransform tf = dbg.getTransform();
		dbg.rotate(300,x+sizeX/2,y+sizeY/2);
		dbg.rotate(ang,x+sizeX/2, y+sizeY/2);
		
		dbg.drawImage(img, (int)x, (int)y ,(int) sizeX, (int) sizeY, null);
		dbg.setTransform(tf);
	
		
	}

}
