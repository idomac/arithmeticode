package org.idomac.training.wrms.question_009;

import com.sun.accessibility.internal.resources.accessibility;

/**
 * @author : lihaoquan
 * 判断整数序列是不是二元查找树的后序遍历结果
 * 题目:输入一个整数数组,判断该数组是不是某二元查找树的后序遍历的结果。 如果是返回 true,否则返回 false。
 *
 * ***********************************************
 * 思路一： http://blog.csdn.net/wangwangfish/article/details/8017231
*     根据二叉查找树和后序遍历的定义，我们知道后序遍历的结果必然是分为：小于根的部分|大于根的部分|根
*     假设后序遍历的结果为A[1],A[2],...,A[n],则根root = A[n]
*      1.对于A[1],A[2],...,A[n], 从A[n-1]往前查找第一个比根A[n]小的元素为A[pos]
*      2.在A[1],A[2],...,A[pos]中查找是否有比root大的元素
*      3.若有,则说明该结果不是后序遍历的结果
*      4.若没有,则对A[1]...A[pos]和A[pos+1]...A[n-1]分别进行上述重复1-3的步骤
 *
 *      http://zhuyanfeng.com/archives/3221
 *      http://www.coder4.com/archives/3271
*/
public class Answer009 {

    public static boolean verifySquenceOfBST(int[] sequence,int length) {

        if(null == sequence || length<=0) {
            return false;
        }

        int root = sequence[length-1];

        int i = 0;
        for(;i<length-1;++i) {
            if(sequence[i]>root) {
                break;
            }
        }

        int j = i;
        for(;j<length-1;++j) {
            if(sequence[j] < root) {
                return false;
            }
        }

        boolean left = true;
        if(i > 0)
            left = verifySquenceOfBST(sequence, i);

        boolean  right = true;


        int sublen = length - i;
        int[] subSequence = new int[sublen];
        for(int index = 0; index<length-1;index++) {
             if(index>=i) {
                 subSequence[index-i] = sequence[i];
             }
        }

        if(i < length - 1)
            right = verifySquenceOfBST(subSequence, length - i - 1);

        return (left && right);
    }

}
