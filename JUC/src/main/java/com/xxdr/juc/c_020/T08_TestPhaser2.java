package com.xxdr.juc.c_020;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName T08_TestPhaser
 * @Description TODO
 * @Author John Yuan
 * @Date 4/15/21 5:58 PM
 * @Version 1.0
 */
public class T08_TestPhaser2 {
    static Random r = new Random();
    static MarriagePhaser phaser = new MarriagePhaser();

    static void millisleep(int milli) {
        try {
            TimeUnit.MILLISECONDS.sleep(milli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        phaser.bulkRegister(7);

        for (int i = 0; i < 5; i++) {
            new Thread(new Person("p" + i)).start();
        }

        new Thread(new Person("bridegroom")).start();
        new Thread(new Person("bride")).start();
    }

    static class MarriagePhaser extends Phaser {
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase) {
                case 0:
                    System.out.println("Everyone is here!");
                    System.out.println();
                    return false;
                case 1:
                    System.out.println("Everyone has finished eating!");
                    System.out.println();
                    return false;
                case 2:
                    System.out.println("Everyone left!");
                    System.out.println();
                    return false;
                case 3:
                    System.out.println("The wedding is over!");
                    return true;
                default:
                    return true;
            }
        }
    }
    static class Person implements Runnable {
        String name;

        public Person(String name) {
            this.name = name;
        }

        public void arrive() {
            millisleep(r.nextInt(1000));
            System.out.printf("%s is here!\n", name);
            phaser.arriveAndAwaitAdvance();
        }

        public void eat() {
            millisleep(r.nextInt(1000));
            System.out.printf("%s has finished eating!\n", name);
            phaser.arriveAndAwaitAdvance();
        }

        public void leave() {
            millisleep(r.nextInt(1000));
            System.out.printf("%s left!\n", name);
            phaser.arriveAndAwaitAdvance();
        }

        public void hup() {
            if (name.equals("bridegroom") || name.equals("bride")) {
                millisleep(r.nextInt(1000));
                System.out.printf("%s Bridal chamber\n", name);
                phaser.arriveAndAwaitAdvance();
            } else {
                phaser.arriveAndDeregister();
            }
        }

        @Override
        public void run() {
            arrive();
            eat();
            leave();
            hup();
        }
    }
}
