package org.idomac.training.wrms.question_003;

/**
 * Author : lihaoquan
 * Description :
 *  输入一个整形数组，数组里有正数也有负数。数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。
 *  求所有子数组的和的最大值。要求时间复杂度为O(n)。
 *
 * ********************************************************
 * 参考 :
 * 1. http://www.dotlife.info/articles/2012/05/21/1337580564291.html
 * 2. http://blog.csdn.net/yuucyf/article/details/6342421
 */
public class MaxSubArraySum {

    public  long getMax(long a,long b) {
        return a>b? a: b;
    }


    /**
     * 获得连续子数组的最大和
     * @param array
     * @return 最大和，此处用了Long型是为了表示当参数为null或空时，可以返回null，返回其它任何数字都可能引起歧义。
     */
    public Long getMax(int[] array) {
        if(array == null || array.length<=0) {
            return null;
        }
        long maxSum = array[0];//所有子数组中最大的和
        long rightEdge = array[0];//右侧子数组的最大和
        try {

            for(int i = 1; i<array.length;i++) {
                //当右侧子数组的最大和为负数时，对于新数组，右侧子数组的最大和为新增加的数。
                if(rightEdge<0) {
                    rightEdge = array[i];
                }else {
                    //为正数时，对于新数组，右侧子数组的最大和为新增加的数 + 原来的最大和。
                    rightEdge += array[i];
                }
                //所有子数组中最大的和
                maxSum = getMax(rightEdge,maxSum);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return maxSum;
    }

}
