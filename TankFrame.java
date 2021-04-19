package com.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: jie.d.cheng
 * @Date: 2021/4/7 - 04 - 07 - 23:11
 * @Description: com.tank
 * @version: 1.0
 */
public class TankFrame extends Frame {
//    int x =200, y=200;
//    Dir dir = Dir.DOWN;
//    private  static final int SPEED = 10;
    final static int GAME_WIDTH = 800, GAME_HEIGHT=600;

    Tank t90 = new Tank(20,20, Dir.RIGHT, this);
    List<Bullet> bullets = new ArrayList<Bullet>();
    Bullet b = new Bullet(300,300, Dir.DOWN, this);

    public TankFrame() {
        setTitle("Tank War");
        setSize(GAME_WIDTH,GAME_HEIGHT);
        setResizable(false);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.addKeyListener(new MyKeyListener());
    }

    Image offScreenImage = null;
    @Override
    public void update(Graphics g){
        if(offScreenImage == null){
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.GREEN);
        gOffScreen.fillRect(0,0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);

    }
    @Override
    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.drawString("子弹的数量"+bullets.size(), 10, 60);
        g.setColor(c);
        t90.paint(g);
//        b.paint(g);
        for(int i=0; i<bullets.size();i++){
          bullets.get(i).paint(g);
        }
    }

    class MyKeyListener extends KeyAdapter {
        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;


        @Override
        public void keyPressed(KeyEvent e) {
//            System.out.println("key pressed.");
//            x += 200;
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;

                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;

                case KeyEvent.VK_CONTROL:
                    t90.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if(!bU && !bD && !bR && !bL) t90.setMoving(false);
            else{
                t90.setMoving(true);
                if(bL) t90.setDir(Dir.LEFT);
                if(bR) t90.setDir(Dir.RIGHT);
                if(bU) t90.setDir(Dir.UP);
                if(bD) t90.setDir(Dir.DOWN);

            }


        }

    }

}






