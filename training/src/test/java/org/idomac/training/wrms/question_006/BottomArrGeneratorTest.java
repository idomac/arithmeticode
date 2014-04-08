package org.idomac.training.wrms.question_006;

import org.junit.Test;

/**
 * Author : lihaoquan
 * Description :
 */
public class BottomArrGeneratorTest {

    @Test
    public void generate() {

        int[] a = BottomArrGenerator.generate(10);
        if (a != null) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(i + "\t");
            }
            System.out.println();
            for (int i : a) {
                System.out.print(i + "\t");
            }
        }
    }
}
