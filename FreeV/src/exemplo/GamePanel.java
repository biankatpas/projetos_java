package exemplo;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/**
 *
 * @author biankatpas
 */
public class GamePanel extends JPanel implements Runnable {

    public static boolean LEFT, RIGHT, UP, DOWN, PEN;
    public static int MouseX, MouseY;
    private Thread animator;
    private boolean running = false;
    int FPS, SFPS;
    int fpscount;

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
        g2d.fillRect(10, 10, 30, 30);

    }

    public GamePanel() {

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                if (keyCode == KeyEvent.VK_LEFT) {
                    LEFT = true;
                }
                if (keyCode == KeyEvent.VK_RIGHT) {
                    RIGHT = true;
                }
                if (keyCode == KeyEvent.VK_UP) {
                    UP = true;
                }
                if (keyCode == KeyEvent.VK_DOWN) {
                    DOWN = true;
                }

                if (keyCode == KeyEvent.VK_C) {
                    if (PEN) {
                        PEN = false;
                    } else {
                        PEN = true;
                    }
                    System.out.println("C");
                }

                if (keyCode == KeyEvent.VK_ESCAPE) {
                    stopGame();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();

                if (keyCode == KeyEvent.VK_LEFT) {
                    LEFT = false;
                }
                if (keyCode == KeyEvent.VK_RIGHT) {
                    RIGHT = false;
                }
                if (keyCode == KeyEvent.VK_UP) {
                    UP = false;
                }
                if (keyCode == KeyEvent.VK_DOWN) {
                    DOWN = false;
                }
            }
        });

        addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseMoved(MouseEvent e) {
                // TODO Auto-generated method stub
                MouseX = e.getX();
                MouseY = e.getY();

                System.out.println("Mouse - X: " + MouseX + " | Y: " + MouseY);

            }

            @Override
            public void mouseDragged(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });
    }

    @Override
    public void run() {
        running = true;

        long DifTime, TempoAnterior;

        int segundo = 0;
        DifTime = 0;
        TempoAnterior = System.currentTimeMillis();

        while (running) {
            //gameUpdate(DifTime); // game state is updated
            //gameRender(); // render to a buffer
            // paintImmediately(0, 0, PWIDTH, PHEIGHT); // paint with the buffer

            try {
                Thread.sleep(0); // sleep a bit
            } catch (InterruptedException ex) {
            }

            DifTime = System.currentTimeMillis() - TempoAnterior;
            TempoAnterior = System.currentTimeMillis();

            if (segundo != ((int) (TempoAnterior / 1000))) {
                FPS = SFPS;
                SFPS = 1;
                segundo = ((int) (TempoAnterior / 1000));
            } else {
                SFPS++;
            }

        }
        System.exit(0);
    }

//    private void gameUpdate(long DiffTime) {
//        jogador.simulaSe(DiffTime);
//
//        for (int i = 0; i < lista_Sprites.size(); i++) {
//            Sprite sp = lista_Sprites.get(i);
//            sp.simulaSe(DiffTime);
//        }
//
//    }
//    private void gameRender() {
//        // clear the background
//        dbg.setColor(cor);
//        // fundo
//        dbg.fillRect(0, 0, PWIDTH, PHEIGHT);
//        dbg.drawImage(imgFundo, 0, 0, PWIDTH, PHEIGHT, null);
//
//        for (int i = 0; i < lista_Sprites.size(); i++) {
//            Sprite sp = lista_Sprites.get(i);
//            sp.desenhaSe(dbg);
//        }
//
//    }
    public void stopGame() {
        running = false;
    }

}
