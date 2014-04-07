package org.idomac.training.wrms.question_004;

import org.junit.Test;

/**
 * @author : lihaoquan
 */
public class BinaryTreeNodeTest {

    @Test
    public void getPathNode() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.addNode(new BinaryTreeNode(10));
        binaryTree.addNode(new BinaryTreeNode(5));
        binaryTree.addNode(new BinaryTreeNode(12));
        binaryTree.addNode(new BinaryTreeNode(4));
        binaryTree.addNode(new BinaryTreeNode(7));

        binaryTree.print();

        binaryTree.getPath(22);
    }
}
