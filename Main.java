package com.tank;

/**
 * @Auther: jie.d.cheng
 * @Date: 2021/4/7 - 04 - 07 - 22:46
 * @Description: com.tank
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        TankFrame tf = new TankFrame();

        while(true){
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
