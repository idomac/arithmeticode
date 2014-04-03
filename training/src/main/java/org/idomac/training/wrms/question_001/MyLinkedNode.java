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
}
