package org.idomac.training.wrms.question_007;

/**
 * @author : lihaoquan
 */
public class MyLinkList {

    private LinkNode head;

    /**
     * 创建链表节点
     * @param a
     * @return
     */
    public LinkNode create(int[] a) {
        LinkNode firstNode = null;
        for(int i = a.length-1;i>=0; i--) {
            LinkNode linkNode = new LinkNode(a[i]);
            linkNode.next = firstNode;
            firstNode = linkNode;
        }
        return firstNode;
    }

    /**
     * 判断是否循环
     * @param head
     * @return
     */
    public LinkNode hasLoop(LinkNode head) {
        LinkNode p1 = head;
        LinkNode p2 = head;
        while (p2!=null && p2.next!=null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2) {
                return p1;
            }
        }
        return null;
    }

    /**
     * 展示链表元素
     */
    public void display() {
        LinkNode p = head;
        while (p!=null) {
            System.out.println(p.data+" ");
            p = p.next;
        }
        System.out.println();
    }

    /**
     * 获取第pos个节点
     * @param pos
     * @return
     */
    public LinkNode getNodeAt(int pos) {
        LinkNode node = head;
        while (--pos>0) {
             node = node.next;
        }
        return node;
    }

    //create a loop. Make tail's nextElement is a[i]
    public void setLoop(int i){
        LinkNode p=head;
        while(p!=null&&p.next!=null){
            p=p.next;
        }
        LinkNode loopPoint=getNodeAt(i);
        p.next=loopPoint;
    }

    //get the last node of LinkList
    public LinkNode getTail(){
        LinkNode p=head;
        while(p.next!=null){
            p=p.next;
        }
        return p;
    }

    public LinkNode getHead() {
        return head;
    }
    public void clear(){
        head=null;
    }

    public LinkNode getFirstNodeInLoop(LinkNode head){
        LinkNode re=null;
        LinkNode p1=head;
        LinkNode p2=hasLoop(head);
        if(p2!=null){
            while(true){
                p2=p2.next;
                p1=p1.next;
                if(p1==p2){
                    re=p1;
                    break;
                }
            }
        }
        return re;
    }
}
