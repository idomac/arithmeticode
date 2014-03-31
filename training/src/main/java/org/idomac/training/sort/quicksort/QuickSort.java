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


    /**
     * 快速排序算法
     * @param a
     * @param left
     * @param right
     */
    public static void sort(int[] a,int left,int right) {

        if(right <= left) return;
        int j = partition(a,left,right); //进行切分
        sort(a,left,j-1);//左半部快速排序
        sort(a,j+1,right);//右半部分快速排序
    }


    /**
     * 切分函数
     * @param a
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] a,int left,int right) {
        int i = left;
        int j = right+1;
        int v = a[i];
        while(true) {
            while(a[++i] < v) if(i == right) break;
            while(v<a[--j]) if(j==left) break;
            if(i>=j) break;
            exchange(a,i,j);
        }
        exchange(a,left,j);
        return j;
    }


    /**
     * 元素交换
     * @param a
     * @param i
     * @param j
     */
    public static void exchange(int[] a,int i,int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
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

        for(int i = 0; i<datas.length;i++) {
            System.out.println("# "+datas[i]);
        }
    }
}
