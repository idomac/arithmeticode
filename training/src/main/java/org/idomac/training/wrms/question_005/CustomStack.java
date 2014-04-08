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
                maxHeap(target,1,k);
            }
        }
        return target;
    }

    /**
     * 建最大堆
     * @param arr
     */
    public static void buildHeap(int[] arr) {
        int heapsize = arr.length;
        for(int i=arr.length/2;i>0;i--)
            maxHeap(arr,i,heapsize);
    }

    /**
     * 调整为最大堆
     * @param arr
     * @param i
     * @param heapsize
     */
    public static void maxHeap(int arr[],int i,int heapsize) {
        int largest = i;
        int left = 2*i;
        int right = 2*i+1;
        if(left<=heapsize && arr[i-1]<arr[left-1])
            largest = left;
        if(right<=heapsize && arr[largest-1]<arr[right-1])
            largest = right;
        if(largest!=i){
            int temp = arr[i-1];
            arr[i-1] = arr[largest-1];
            arr[largest-1] = temp;
            maxHeap(arr,largest,heapsize);
        }
    }
}
