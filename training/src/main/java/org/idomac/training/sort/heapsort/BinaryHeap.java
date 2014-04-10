package org.idomac.training.sort.heapsort;

import java.util.Arrays;

/**
 * @author : lihaoquan
 *
 * 二叉堆就结构性质上来说就是一个完全填满的二叉树，满足结构性和堆序性。结构性不必多说，
 * 就是完全二叉树应该满足的树结构。堆序性指的是：父节点的键值总是大于或等于（小于或等于）任何
 * 一个子节点的键值，且每个节点的左子树和右子树都是一个二叉堆（都是最大堆或最小堆）。
 *
 * ************************************************
 * 参考资料 :
 * 1.http://blog.csdn.net/lcore/article/details/9100073
 * 2.http://blog.csdn.net/a352193394/article/details/7210435
 * 3.http://courses.cs.washington.edu/courses/cse373/11wi/homework/5/BinaryHeap.java
 * 4.http://users.cis.fiu.edu/~weiss/dsaajava/code/DataStructures/BinaryHeap.java
 */
public class BinaryHeap {

    private static final int DEAFAULT_CAPACITY = 100;
    private int currentSize;//堆中的元素个数
    private Comparable[] array;//存储堆中的元素使用数组存储方式

    /**
     * 二叉堆的构造方法
     * @param capacity
     */
    public BinaryHeap(int capacity) {
        currentSize = 0;
        array = new Comparable[capacity+1];
    }

    /**
     * 判断二叉堆是否为空
     * @return
     */
    public boolean isEmpty() {
        return currentSize==0;
    }

    public boolean isFull(){
        return currentSize == array.length-1;
    }


    /**
     * 插入函数(上浮式)
     */
    public void insert(Comparable x) {
        if(isFull()) {
            throw new RuntimeException("溢出");
        }

        int hole = ++currentSize;
        for(;hole>1 && x.compareTo(array[hole/2]) <0 ; hole/=2 ) {
            array[hole] = array[hole/2];
        }
        array[hole] = x;
    }


    /**
     * 删除函数(下沉式)
     * @return
     */
    public Comparable deleteMin() {
        if(isEmpty()) {
            return null;
        }

        Comparable minItem = array[1];
        array[1] = array[currentSize--];
        percolateDown(1);
        return minItem;
    }

    /**
     * 同样的这个操作在最坏的情况下为O(logN),平均而言也为O(logN).
     * @param hole
     */
    public void percolateDown(int hole) {
        int child = 0;
        Comparable tmp = array[hole];
        for(;hole*2<=currentSize;hole = child) {
            child = hole * 2;
            if(child!=currentSize && array[child+1].compareTo(array[child])<0) {
                child++;
            }
            if( array[ child ].compareTo( tmp ) < 0 ) {
                array[ hole ] = array[ child ];
            }else {
                break;
            }
        }
        array[hole] = tmp;
    }



    public static void main(String[] args) {
        int numItems = 50;
        BinaryHeap h = new BinaryHeap(numItems);
        int i = 37;

        try{
            for( i = 37; i != 0; i = ( i + 37 ) % numItems )
                h.insert( new Integer( i ) );
            System.out.println(Arrays.toString(h.array));
            h.deleteMin();
            System.out.println(Arrays.toString(h.array));
        }
        catch( Exception e )
        { System.out.println( "Overflow (expected)! " + i  ); }
    }
}
