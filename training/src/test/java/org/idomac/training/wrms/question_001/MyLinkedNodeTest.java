package org.idomac.training.wrms.question_001;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author : lihaoquan
 * Description :
 */
public class MyLinkedNodeTest {

    private static Logger logger = LoggerFactory.getLogger(MyLinkedNodeTest.class);

    @Test
    public void display() {

        MyLinkedNode v10 = new MyLinkedNode(10);
        MyLinkedNode v6 = new MyLinkedNode(6);
        MyLinkedNode v14 = new MyLinkedNode(14);
        MyLinkedNode v4 = new MyLinkedNode(4);
        MyLinkedNode v8 = new MyLinkedNode(8);
        MyLinkedNode v12 = new MyLinkedNode(12);
        MyLinkedNode v16 = new MyLinkedNode(16);

        //构建二叉树关系
        v10.setLeft(v6);
        v10.setRight(v14);

        v6.setLeft(v4);
        v6.setRight(v8);

        v14.setLeft(v12);
        v14.setRight(v16);


        Processor processor = new Processor();
        v10 = processor.processTreeToLinked(v10);

        System.out.print("升序打印：");
        v10.printToRight();

        System.out.println();

        //左向打印v17，会降序打印
        System.out.print("降序打印：");
        v10.printToLeft();
    }
}
