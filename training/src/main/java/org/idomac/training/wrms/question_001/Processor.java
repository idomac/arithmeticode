package org.idomac.training.wrms.question_001;

/**
 * Author : lihaoquan
 * Description :.核心算法处理类
 */
public class Processor {

    /**
     * 把二分查找树转化为双向链表 (从目标node触发)
     * @param node
     * @return
     */
    public MyLinkedNode processTreeToLinked(MyLinkedNode node) {

        try {

            if(node == null) {
                return null;
            }

            MyLinkedNode leftR = getMostRightNode(node.getLeft());//获取左子树最右边的节点
            MyLinkedNode rightL = getMostLeftNode(node.getRight());//获取右子树最左边的节点

            //左子树非空，递归处理左子树
            if(null != node.getLeft()) {
                handleLefts(node.getLeft(),node);
            }

            //右子树非空，递归处理右子树
            if(null != node.getRight()) {
                 handleRights(node.getRight(),node);
            }

            //若左子树最右节点非空，调整与根节点相邻
            if(null !=leftR ) {
                leftR.setRight(node);
                node.setLeft(leftR);
            }

            //若右子树的最左节点非空，调整与根节点相邻
            if(null!= rightL) {
                rightL.setLeft(node);
                node.setRight(rightL);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return node;
    }


    /**
     * 处理左子树
     * @return
     */
    public MyLinkedNode handleLefts(MyLinkedNode left,MyLinkedNode node) {

        if(isLeafNode(left)) {
            System.out.println("left-------------------------"+left.getValue());
            left.setRight(node);
            return left;
        }
        return processTreeToLinked(left);
    }

    /**
     * 处理右子数
     * @return
     */
    public MyLinkedNode handleRights(MyLinkedNode right,MyLinkedNode node) {

        if(isLeafNode(right)) {
            System.out.println("right-------------------------"+right.getValue());
            right.setLeft(node);
            return right;
        }
        return processTreeToLinked(right);
    }


    /**
     * 判断节点是否为叶子节点
     * @param node
     * @return
     */
    private static boolean isLeafNode(MyLinkedNode node) {
        return (null == node.getLeft()) && (null == node.getRight());
    }

    /**
     * 获取右子树最左节点
     * @param right
     * @return
     */
    private MyLinkedNode getMostLeftNode(MyLinkedNode right) {

        if(null == right) {
            return null;
        }

        if(null == right.getLeft()) {
            return right;
        }

        return getMostLeftNode(right.getLeft());
    }

    /**
     * 获取左子树最右节点
     * @param left
     * @return
     */
    private MyLinkedNode getMostRightNode(MyLinkedNode left) {

        if(null == left) {
            return null;
        }

        if(null == left.getRight()) {
            return left;
        }

        return getMostRightNode(left.getRight());
    }
}
