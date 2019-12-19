package com.algorithm;

/**
 * @author admin
 * @Description: 4的幂
 * @date 2019/12/19 20:29

 判断给定的数是否是4的幂

 */
public class FourPower {

    public static boolean isPowerOfFour(int num) {
        if(num == 0){
            return false;
        }
        String numStr = Integer.toBinaryString(num);
        if(numStr.lastIndexOf("1") == numStr.indexOf("1")){
            return (((numStr.length() - 1) % 2) == 0)?true:false;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println("args = [" + isPowerOfFour(64) + "]");
    }

}
