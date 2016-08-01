package br.univali.poo2.Turtle2d;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * 
 * @author biankatpas
 */
public class Caneta extends Sprite {

    float objx, objy;

    public Caneta(float x, float y, BufferedImage img, float objy, float objx) {
        super(x, y, img);
        // TODO Auto-generated constructor stub
        this.x = x;
        this.y = y;
        this.img = img;
        this.objx = objx;
        this.objy = objy;
    }

    @Override
    public void simulaSe(long DiffTime) {
        // TODO Auto-generated method stub

    }

    @Override
    public void desenhaSe(Graphics2D dbg) {
        // TODO Auto-generated method stub
        dbg.drawImage(img, (int) x, (int) y, 2, 2, null);
    }

}
