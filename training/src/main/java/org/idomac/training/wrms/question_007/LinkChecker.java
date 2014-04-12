package org.idomac.training.wrms.question_007;

/**
 * @author : lihaoquan
 */
public class LinkChecker {

    public static void isJoined(LinkNode head1,LinkNode head2) {
        while(null != head1.next) {
            head1 = head1.next;
        }

        while(null != head2.next) {
            head2 = head2.next;
        }

        if(head1 == head2) {
            System.out.println("joined");
        }else {
            System.out.println("not joined");
        }
    }
}
