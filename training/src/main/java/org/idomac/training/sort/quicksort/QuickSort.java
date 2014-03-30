package org.idomac.training.sort.quicksort;

import org.idomac.training.sort.StdRandom;

import java.util.Scanner;

/**
 * @author : lihaoquan
 *
 * 原地切分的方式
 */
public class QuickSort {


    public static void sort(int[] a) {
        StdRandom.shuffle(a); //随机打乱原来的数组
        sort(a,0,a.length-1);//快速排序
    }

    public static void sort(int[] a,int left,int right) {

    }



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输数字,以逗号分隔开;");
        String input = scanner.next();

        String[] inputs = input.split(",");
        int[] datas = new int[inputs.length];

        for(int i = 0; i< inputs.length;i++) {
            String data = inputs[i];
            if("".equals(data) || null==data) {
                data = "0";
            }
            datas[i] = Integer.parseInt(data);
        }

        sort(datas);
    }
}
