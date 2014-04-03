package org.idomac.training.classics;

import java.util.Scanner;

/**
 * Author : lihaoquan
 * Description :
 */
public class JosephusProblem {

    private static class Node{
        public int no;
        public Node next;
        public Node(int no) {
            this.no = no;
        }
    }

    /**
     * 约瑟夫函数处理
     */
    public static void josephus(int totalNum, int countNum) {

        /**
         * 初始化一个闭环
         */
        Node header = new Node(1);
        Node currentPointer = header;
        for(int i = 2; i<= totalNum;i++) {
            currentPointer.next = new Node(i);
            currentPointer = currentPointer.next;
        }
        currentPointer.next = header; //这一步形成环状

        System.out.println("以下是出列的顺序节点编号 : ");
        while(currentPointer!=currentPointer.next) {//环还存在的情况:
            for(int i = 1; i< countNum;i++) {
                currentPointer = currentPointer.next;
            }
            //枪毙不幸的节点
            System.out.println(currentPointer.next.no);
            currentPointer.next = currentPointer.next.next;
        }
        System.out.println("----------"+currentPointer.next.no);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入总人数:");
        int totalNum = scanner.nextInt();
        System.out.println("请输入报数的大小:");
        int cycleNum = scanner.nextInt();

        josephus(totalNum,cycleNum);
    }
}
