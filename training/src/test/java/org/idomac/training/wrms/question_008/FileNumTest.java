package org.idomac.training.wrms.question_008;

import org.junit.Test;

/**
 * @author : lihaoquan
 */
public class FileNumTest {

    @Test
    public void findNum() {

        int[] a = new int[1001];
        for(int i = 1; i<1001; i++) {
            a[i] = i;
        }
        a[0] = 1;

        System.out.println("重复的元素是:"+FileNum.function2(a));
    }
}
