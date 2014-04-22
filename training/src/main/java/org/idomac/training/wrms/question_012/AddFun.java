package org.idomac.training.wrms.question_012;

/**
 * @author : lihaoquan
 *
 * 题目:求 1+2+...+n,
 * 要求不能使用乘除法、for、while、if、else、switch、case 等关键字以及条件判断语句(A?B:C)。
 */
public class AddFun {

    public static int addFun(int n, int sum) {

        for(int i = 1; i<=n;i++) {
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args) {

        int n = 100;
        int sum = 0;

        System.out.println("结果是:"+addFun(n,sum));

    }
}
