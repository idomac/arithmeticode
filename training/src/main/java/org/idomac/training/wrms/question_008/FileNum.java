package org.idomac.training.wrms.question_008;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : lihaoquan
 * 假设你有一个用 1001 个整数组成的数组,这些整数是任意排列的,但是你知道所有的整 数都在 1 到 1000(包括 1000)之间。
 * 此外,除一个数字出现两次外,其他所有数字只出现一 次。假设你只能对这个数组做一次处理,用一种算法找出重复的那个数字。
 * 如果你在运算中 使用了辅助的存储方式,那么你能找到不用这种方式的算法吗?
 *
 * *****************************************
 * 参考资料:
 * 1.http://blog.csdn.net/zhanxinhang/article/details/6710285
 */
public class FileNum {

    public static int function1(int[] a) {
        List list = new ArrayList();
        int x = 0;
        for(int i = 0; i<a.length;i++) {
            if(!list.contains(a[i])) {
                list.add(a[i]);
            }else{
                x = a[i];
                break;
            }
        }
        return x;
    }

    /**
     * 方法二、若不使用辅助的存储方式呢？已知1001个整数组成的数组只有一个数字出现了两次，且整数都在1到1000之间，
     * 所以可推得数组里面包含了1到1000之间的所有数字为[1,2,3……1000]和一个出现两次的x为1到1000中的任一个数字。
     * 这样就可以计算原数组里的所有数字之和S1和等差数列[1,2,3……1000]的和S2，
     * 再计算S1与S2之差，该差就是原数组中出现两次的数字x。时间复杂度是固定的O(n)。
     * 优缺点：内存空间消耗几乎没有，但是效率要输于使用hash表的存储方式。代码如下：
     * @param a
     */
    public static int function2(int[] a) {

        int s1 = 0;
        int s2 = 1001*1000/2;
        for(int i = 0;i<1001;i++) {
            s1+=a[i];
        }
        return s1-s2;
    }
}
