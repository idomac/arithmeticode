package org.idomac.training.wrms.question_010;

import java.util.Stack;

/**
 * Author : lihaoquan
 * Description : 翻转句子中单词的顺序。
 *
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 句子中单词以空格符隔开。为简单起见，标点符号和普通字母一样处理。
 * 例如输入“I am a student.”，则输出“student. a am I”。
 */
public class WordOrder {

    public static void handle(String q) {
        Stack<String> stack = new Stack<String>();
        int l = 0;
        for(int i = 0; i< q.length();i++) {
            switch (q.charAt(i)) {
                case '!':
                case ',':
                case ' ':{
                    System.out.println("----");
                    stack.push(q.substring(l,i));
                    l = i+1;
                    stack.push(q.substring(i, l));
                }
            }
        }

        if (l < q.length()) stack.push(q.substring(l));
        while (!stack.isEmpty())
            System.out.print(stack.pop());
    }

}
