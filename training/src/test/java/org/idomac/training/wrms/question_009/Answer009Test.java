package org.idomac.training.wrms.question_009;

import org.junit.Test;

/**
 * @author : lihaoquan
 */
public class Answer009Test {

    @Test
    public void verify() {
        int[] arr = {5, 7, 6, 9, 11, 10, 8}; //Yes

        //int[] arr = {7, 4, 6, 5}; // Not

        boolean flag =  Answer009.verifySquenceOfBST(arr,7);
        System.out.println("是否是后序遍历:"+flag);
    }
}
