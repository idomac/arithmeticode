package org.idomac.training.wrms.question_002;

import org.junit.Test;

/**
 * Author : lihaoquan
 * Description :
 */
public class CustomStackTest {

    @Test
    public void check() {

        CustomStack customStack = new CustomStack();
        customStack.push(13);
        customStack.push(23);
        customStack.push(4);
        customStack.push(6);
        customStack.push(3);
        customStack.push(6);
        customStack.push(65);
        customStack.push(2);

        customStack.pop();

        System.out.println("最小的元素是::"+customStack.getMin());

    }
}
