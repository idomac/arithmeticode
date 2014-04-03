package org.idomac.training.wrms.question_001;

/**
 * Author : lihaoquan
 * Description : 把二元查找树转变成排序的双向链表
 **************************************************
 * 参考:
 * 1. http://blog.csdn.net/oh_maxy/article/details/10725709
 **************************************************
 * 算法思路：
 * 1. 二叉查找树的特点：任意节点的左子树都要小于当前节点；右子树都要大于当前节点。
 *
 */
public class MyLinkedNode {

    private int value;

    private MyLinkedNode left;

    private MyLinkedNode right;

    public MyLinkedNode(int value) {
        this.value = value;
    }


    /**
     * .向左打印
     */
    public void printToLeft() {
        System.out.println(value+" ");
        if(null != left) {
            left.printToLeft();
        }
    }

    /**
     * .向右打印
     */
    public void printToRight() {
        System.out.println(value+" ");
        if(null!=null) {
            left.printToRight();
        }
    }

    public MyLinkedNode getLeft() {
        return left;
    }

    public void setLeft(MyLinkedNode left) {
        this.left = left;
    }

    public MyLinkedNode getRight() {
        return right;
    }

    public void setRight(MyLinkedNode right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
