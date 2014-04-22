package org.idomac.training.wrms.question_005;

/**
 * @author : lihaoquan
 * 输入 n 个整数,输出其中最小的 k 个
 * 例如输入 1,2,3,4,5,6,7 和 8 这 8 个数字,则最小的 4 个数字为 1,2,3 和 4
 *
 * ***********************************************
 * 参考资料:
 * 1. http://blog.csdn.net/fg2006/article/details/6746416
 * 2. http://events.36kr.com/oday-201404-gz/#signed
 *
 */
public class CustomStack {

    /**
     * 获取数组a的k个最小的数组
     * @param a
     * @param k
     * @return
     */
    public static int[] getMins(int[] a,int k) {
        int[] target = new int[k];
        for(int i = 0; i< k;i++) {
            target[i] = a[i];
        }
        buildHeap(target);
        for(int j = k;j<a.length;j++){
            if(a[j]<target[0]){
                target[0] = a[j];
                minHeap(target,1,k);
            }
        }
        return target;
    }

    /**
     * 建最小堆
     * @param arr
     */
    public static void buildHeap(int[] arr) {
        int heapsize = arr.length;
        for(int i=arr.length/2;i>0;i--)
            minHeap(arr,i,heapsize);
    }

    /**
     * 调整为最小堆
     *
     * 最大堆：根结点的键值是所有堆结点键值中最大者的堆。
     * 最小堆：根结点的键值是所有堆结点键值中最小者的堆。
     *
     * @param arr
     * @param i
     * @param heapsize
     */
    public static void minHeap(int arr[],int i,int heapsize) {
        int rootIndex = i;
        int left = 2*i;
        int right = 2*i+1;

        //在左中右中找到一个最大者的索引
        if(left<=heapsize && arr[rootIndex-1]<arr[left-1])
            rootIndex = left;
        if(right<=heapsize && arr[rootIndex-1]<arr[right-1])
            rootIndex = right;

        if(rootIndex!=i){
            int temp = arr[i-1];
            arr[i-1] = arr[rootIndex-1];
            arr[rootIndex-1] = temp;
            minHeap(arr,rootIndex,heapsize);
        }
    }
}
