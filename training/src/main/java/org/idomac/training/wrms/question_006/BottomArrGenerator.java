package org.idomac.training.wrms.question_006;

/**
 * Author : lihaoquan
 * Description :
 *
 * 给你 10 分钟时间，根据上排给出十个数，在其下排填出对应的十个数
 * 要求下排每个数都是先前上排那十个数在下排出现的次数。
 * 上排的十个数如下：
 * 【0，1，2，3，4，5，6，7，8，9】
 *
 * 举一个例子，
 * 数值: 0,1,2,3,4,5,6,7,8,9
 * 分配: 6,2,1,0,0,0,1,0,0,0
 * 0 在下排出现了 6 次，1 在下排出现了 2 次,2 在下排出现了 1 次，3 在下排出现了 0 次...
 *
 * *******************************************************8888
 * 参考:
 * 1.http://zhuiyi74.iteye.com/blog/839742
 * 2.http://blog.csdn.net/heaven13483/article/details/7925621
 * 3.http://blog.csdn.net/wcyoot/article/details/6428305
 *
 */
public class BottomArrGenerator {

    /**
     * 结构结果生成
     * @param n
     * @return
     */
    public static int[] generate(int n) {

        if(n<4) {
            System.out.println("请输入不小于4的整数");
            return null;
        }

        int[] top = new int[n];
        int[] bottom = new int[n];

        //把相关的数字设置进去
        for (int i = 0 ; i < top.length; i++) {
            top[i] = i;
            //System.out.println(top[i]);
        }

        for (int m = 0; m < n + 2; m++) {
            boolean flag = true;    // 找到结果标志

            for (int i = 0; i < n; i++) {// 逐位对应
                int count = getCount(i, bottom);
                if (bottom[i] != count) {// 和上一次算出来的次数不符
                    bottom[i] = count;
                    flag = false;
                }
            }

            // 连续2次得到的次数一样，则为正确结果
            if (flag)
                break;

            if (n + 1 == m && !flag) {
               // 算法有缺陷，n=5时是有结果2,1,2,0,0的，底下结果如果有2个数字等于上面的数字就算不出来
                System.out.println("找不到结果");
                return null;
            }
        }

        return bottom;
    }

    /**
     * 统计数字n在数组arr中出现的次数
     * @param num
     * @param arr
     * @return
     */
    public static int getCount(int num,int [] arr) {
        int count = 0;
        for(int i : arr) {
            if(num == i) {
                count++;
            }
        }
        return count;
    }
}
