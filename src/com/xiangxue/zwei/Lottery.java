package com.xiangxue.zwei;

import java.util.Random;

/**
 * @author wang wei
 * 2019/10/29 11:29
 */
public class Lottery {



    public static int getNum(){
        Random random = new Random(System.currentTimeMillis());
        return random.nextInt(10);
    }

    public static void main(String[] s) throws InterruptedException {
        for(int i=0;i<7;i++){
            Thread.sleep(1000);
            int t = 0;
            while (t==0){
                t = getNum();
            }
            System.out.println(t);
        }
    }
}
