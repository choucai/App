package com.dream.java.think.think04;

/**
 * java中的标签使用,相当于其它语言中的goto关键字.
 *
 * @author 李君波
 * @version v1.0.0
 * @date 2015-11-16
 */
public class Label {

    public static void main(String[] args){
        int i = 0;
        outer:
        while(true){
            System.out.println("Outer while loop");
            while (true){
                i++;
                System.out.println("i = " + i);

                if(i == 1){
                    System.out.println("continue");
                    continue ;
                }

                if(i == 3){
                    System.out.println("continue outer");
                    continue outer;
                }

                if(i == 5){
                    System.out.println("break");
                    break  ;
                }

                if(i == 7){
                    System.out.println("break outer");
                    break  outer;
                }

            }
        }
    }

}
