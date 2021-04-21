package com.xxdr.juc.my_lable;

/**
 * @ClassName Test_Lable
 * @Description TODO
 * @Author John Yuan
 * @Date 4/21/21 1:51 PM
 * @Version 1.0
 */
public class Test_Lable {
    public static void main(String[] args) throws InterruptedException {
        //标签
        exit:
        while (true) {
            for (int i = 0; i < 10; i++) {
                if (i == 5)
//                    break ;   //直接退出内层for循环继续下一次for循环
//                    continue ; //开始内层for循环的下一次
                    break exit; //直接退出exit标签所执行标签的循环
//                    continue exit; //调到exit，从新执行while
                    System.out.print(i + " ");
                Thread.sleep(10);
            }
            System.out.println();
        }
    }
}

