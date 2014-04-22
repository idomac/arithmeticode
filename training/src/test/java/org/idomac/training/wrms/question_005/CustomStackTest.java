package org.idomac.training.wrms.question_005;

import org.junit.Test;

/**
 * @author : lihaoquan
 */
public class CustomStackTest {

    @Test
    public void getMin() {
        int a[] = {1,3,4,2,7,8,9,10,14,16,0,2};
        int[] krr = CustomStack.getMins(a,4);

        for(int i =0;i<krr.length;i++)
            System.out.println(krr[i]);
    }
}
