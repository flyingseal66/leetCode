package main.java;

import java.math.BigDecimal;

public class CollectionArraylistVsArraylist {

    int getFibo(int n) {
        int result = 0;
        if (n == 0) {
            return 0;
        } else if (n == 1){
            return 1;
        } else {
            result = getFibo(n-1) + getFibo(n-2);
            return result;
        }
    }


    public static void main(String[] args) {
        double d = 2000000000;
        BigDecimal big = new BigDecimal(2000000000);

        System.out.println(big);

    }
}
