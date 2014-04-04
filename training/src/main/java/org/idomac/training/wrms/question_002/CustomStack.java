package org.idomac.training.wrms.question_002;


import java.util.ArrayList;
import java.util.List;

/**
 * Author : lihaoquan
 * Description : 定义栈的数据结构，要求添加一个 min 函数，能够得到栈的最小元素,
 *  # 要求函数 min、push 以及 pop 的时间复杂度都是 O(1)。
 */
public class CustomStack {

    public List<Integer> mainStacks = new ArrayList<Integer>();//主栈
    public List<Integer> assistStacks = new ArrayList<Integer>();//辅助栈:记录最小元素的索引位置

    /**
     * 元素入栈
     * @param element
     */
    public void push(int element) {

        int currentMainStackSize = mainStacks.size();
        if(currentMainStackSize == 0) {
            assistStacks.add(0);
        }else {
            int currentMinElementIndex = assistStacks.get(currentMainStackSize-1);
            int currentMinElement = mainStacks.get(currentMinElementIndex);
            if(element<currentMinElement) {
                assistStacks.add(mainStacks.size());
            }else {
                assistStacks.add(currentMinElementIndex);
            }
        }

        mainStacks.add(element);
    }

    public int pop() {
        int size = mainStacks.size();
        assistStacks.remove(size - 1);
        return mainStacks.remove(size - 1);
    }

    /**
     * 获取最小的元素
     * @return
     */
    public int getMin() {
        return mainStacks.get(assistStacks.get(assistStacks.size()-1));
    }

}
