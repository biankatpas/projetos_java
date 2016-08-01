package br.univali.poo2.Turtle2d;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * 
 * @author biankatpas
 */
public abstract class Sprite {

    float x, y;
    BufferedImage img;

    public Sprite(float x, float y, BufferedImage img) {
        this.x = x;
        this.y = y;
        this.img = img;
    }

    public abstract void simulaSe(long DiffTime);

    public abstract void desenhaSe(Graphics2D dbg);
}
