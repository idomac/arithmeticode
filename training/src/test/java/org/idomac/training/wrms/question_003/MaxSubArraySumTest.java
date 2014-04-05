package org.idomac.training.wrms.question_003;

import org.junit.Test;

/**
 * @author : lihaoquan
 */
public class MaxSubArraySumTest {

    @Test
    public void answer() {

        MaxSubArraySum maxSubArraySum = new MaxSubArraySum();

        int[] array = {1, -2, 3, 10, -4, 7, 2, -5};

        System.out.println("最大的子数组和是:"+maxSubArraySum.getMax(array));


    }
}
