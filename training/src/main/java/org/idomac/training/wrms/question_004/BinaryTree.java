package org.idomac.training.wrms.question_004;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : lihaoquan
 * 在二元树中找出和为某一值的所有路径(树)
 * 从树的根结点开始往下访问一直到叶结点所经过的所有结点形成一条路径。
 *
 * *********************************************
 * 参考资料:
 * 1. http://zhuiyi74.iteye.com/blog/838867
 */
public class BinaryTree {

    private BinaryTreeNode root;//根节点

    /**
     * 增加子节点
     * 典型的二叉树添加节点的方法
     */
    public void addNode(BinaryTreeNode node) {

        if(null == this.getRoot()) {
            this.root = node;
            return;
        }

        BinaryTreeNode tempNode = this.getRoot();//临时节点

        /**
         * 循环寻找入树的机会
         */
        while (true) {
            //如果当前节点是大于父节点的情况
            if(node.getValue() > tempNode.getValue()) {

                if(null == tempNode.getRight()) {//如果当前节点的右边有位置
                    tempNode.setRight(node);
                    return;
                }else {//如果当前接的右边没位置,则继续在右边寻找机会
                    tempNode = tempNode.getRight();
                    continue;
                }

            }else if(node.getValue() < tempNode.getValue()) {
                //如果当前节点的左边有位置
                if(null == tempNode.getLeft()) {
                    tempNode.setLeft(node);
                    return;
                }else {
                    //如果当前接的左边没位置,则继续在坐边寻找机会
                    tempNode = tempNode.getLeft();
                    continue;
                }
            } else {//等于父节点的情况
                return;
            }
        }
    }


    /**
     * 输出指定路径和大小的所有路径
     * @param value
     */
    public void getPath(int value) {
        getPath(this.getRoot(),new ArrayList<Integer>(),0,value);
    }


    /**
     *
     * @param node : 节点
     * @param pathList : 路径存储集合
     * @param sumValue : 路径的和
     */
    public void getPath(BinaryTreeNode node,List<Integer> pathList, int tempSumValue, int sumValue) {
        if(null == node) {
            return;
        }

        tempSumValue +=node.getValue();//临时和
        pathList.add(node.getValue());//当前节点入栈

        boolean isLeaf = (null == node.getLeft() && null == node.getRight());//是否为叶子

        //如果找到叶子节点,且当前的临时和与目标的数值一致,则输出
        if(isLeaf && tempSumValue == sumValue) {
            System.out.println("sumPath("+sumValue+") :");
            for(int i: pathList) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        //由于如果上面出现叶子的时候,则其实node.getLeft()和node.getRight的时候,都会为null
        getPath(node.getLeft(),pathList,tempSumValue,sumValue);
        getPath(node.getRight(),pathList,tempSumValue,sumValue);

        // 保证递归完成后返回父节点时路径是根结点到父节点的路径，之后遍历父节点的其他子节点，没有则返回到爷爷节点...
        pathList.remove(pathList.size()-1);//当前节点出栈


    }


    /**
     * 打印函数
     */
    public void print() {
        if(null == this.getRoot()) {
            System.out.print("HashCode: " + this.hashCode() +  "; 空树;");
            return;
        }
        System.out.print("HashCode: " + this.hashCode() +  "; 树: ");
        preOrderPrint(this.getRoot());
        System.out.println();
    }


    /**
     * 前序遍历打印
     */
    public  void preOrderPrint(BinaryTreeNode node) {

        if(null != node) {
            System.out.println(node.getValue()+" ");
            preOrderPrint(node.getLeft());
            preOrderPrint(node.getRight());
        }
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }
}
