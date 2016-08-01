package br.univali.poo2.Turtle2d;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.image.*;
import javax.imageio.ImageIO;

/**
 *
 * @author biankatpas
 */
public class GamePanel extends JPanel implements Runnable {

    public static final int PWIDTH = 640;
    public static final int PHEIGHT = 480;
    private Thread animator;
    private boolean running = false;

    private BufferedImage dbImage;
    private BufferedImage imgFundo;
    public static BufferedImage imgCaneta;
    private BufferedImage imgTartaruga;

    private Graphics2D dbg;

    int FPS, SFPS;
    int fpscount;

    Random rnd = new Random();

    public static boolean LEFT, RIGHT, UP, DOWN, PEN;

    public static int MouseX, MouseY;

    public static ArrayList<Sprite> lista_Sprites = new ArrayList<Sprite>();

    float x = 50, y = 50;
    float x2 = 50, y2 = 250;

    int tempomovimento = 0;
    int tempomovimento2 = 0;

    Tartaruga jogador;

    public GamePanel() {

        imgFundo = carregaImagem("/res/fundo.jpg");
        imgCaneta = carregaImagem("/res/caneta.jpg");
        imgTartaruga = carregaImagem("/res/tartaruga.jpg");
        jogador = new Tartaruga(300, 400, imgTartaruga, 20, 20);
        lista_Sprites.add(jogador);

        setBackground(Color.white);
        setPreferredSize(new Dimension(PWIDTH, PHEIGHT));

        setFocusable(true);
        requestFocus();

        if (dbImage == null) {
            dbImage = new BufferedImage(PWIDTH, PHEIGHT, BufferedImage.TYPE_INT_ARGB);
            if (dbImage == null) {
                System.out.println("dbImage is null");
                return;
            } else {
                dbg = (Graphics2D) dbImage.getGraphics();
            }
        }

        // Adiciona um Key Listner
        addKeyListener(new KeyAdapter() {
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

    public void addNotify() {
        super.addNotify(); // creates the peer
        startGame(); // start the thread
    }

    // initialise and start the thread
    private void startGame() {
        if (animator == null || !running) {
            animator = new Thread(this);
            animator.start();
        }
    } // end of startGame()

    // called by the user to stop execution
    public void stopGame() {
        running = false;
    }

    public void run() /* Repeatedly update, render, sleep */ {
        running = true;

        long DifTime, TempoAnterior;

        int segundo = 0;
        DifTime = 0;
        TempoAnterior = System.currentTimeMillis();

        while (running) {
            gameUpdate(DifTime); // game state is updated
            gameRender(); // render to a buffer
            paintImmediately(0, 0, PWIDTH, PHEIGHT); // paint with the buffer

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

    Color cor = Color.white;
    double contador_de_tempo;

    private void gameUpdate(long DiffTime) {
        jogador.simulaSe(DiffTime);

        for (int i = 0; i < lista_Sprites.size(); i++) {
            Sprite sp = lista_Sprites.get(i);
            sp.simulaSe(DiffTime);
        }

    }

    // draw the current frame to an image buffer
    private void gameRender() {
        // clear the background
        dbg.setColor(cor);
        // fundo
        dbg.fillRect(0, 0, PWIDTH, PHEIGHT);
        dbg.drawImage(imgFundo, 0, 0, PWIDTH, PHEIGHT, null);

        for (int i = 0; i < lista_Sprites.size(); i++) {
            Sprite sp = lista_Sprites.get(i);
            sp.desenhaSe(dbg);
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (dbImage != null) {
            g.drawImage(dbImage, 0, 0, null);
        }
    }

    public static void main(String args[]) {
        GamePanel ttPanel = new GamePanel();

        // create a JFrame to hold the timer test JPanel
        JFrame app = new JFrame("Operação Tartaruga");
        app.getContentPane().add(ttPanel, BorderLayout.CENTER);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        app.pack();
        app.setResizable(false);
        app.setVisible(true);
    } // end of main()

    public BufferedImage carregaImagem(String path) {
        try {
            BufferedImage imgtmp = ImageIO.read(this.getClass().getResourceAsStream(path));
            BufferedImage imagereturn = new BufferedImage(imgtmp.getWidth(), imgtmp.getHeight(),
                    BufferedImage.TYPE_INT_ARGB);
            imagereturn.getGraphics().drawImage(imgtmp, 0, 0, null);
            return imagereturn;

        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return null;
    }

} // end of GamePanel class
