package com.tank;

import java.awt.*;

/**
 * @Auther: jie.d.cheng
 * @Date: 2021/4/8 - 04 - 08 - 23:49
 * @Description: com.tank
 * @version: 1.0
 */
public class Tank {
    private int x, y;
    private Dir dir =Dir.DOWN;
    private boolean moving = false;
    private static final int SPEED = 7;
    private TankFrame tf = null;
    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }



    public Tank() {
    }

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
        move();
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    private void move() {
        if(!moving) return;
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += 10;
                break;
        }
    }

    public void fire() {
        tf.bullets.add(new Bullet(this.x, this.y,this.dir, this.tf));
    }
}
