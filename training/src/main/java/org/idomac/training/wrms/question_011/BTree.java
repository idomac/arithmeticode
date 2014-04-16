package org.idomac.training.wrms.question_011;

/**
 * @author : lihaoquan
 */
public class BTree {

    public static int maxDistance  = 0;

    public static void getMaxDistance(Node root) {
        if(null == root) {
            return;
        }

        if(null!= root.left) {
            getMaxDistance(root.left);
            root.maxLeft = Math.max(root.left.maxLeft,root.left.maxRight)+1;
        }

        if(null != root.right) {
            getMaxDistance(root.right);
            root.maxRight = Math.max(root.right.maxLeft,root.right.maxRight)+1;
        }

        if(root.maxLeft + root.maxRight > maxDistance) {
            maxDistance = root.maxLeft + root.maxRight;
        }
    }
}
