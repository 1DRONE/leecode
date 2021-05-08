package so;

import leetcode.data.ListNode;

/**
 * @author zhangyizhang01
 * @date 2021-05-01
 */
public class Q24 {
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode next=null;
        while(head != null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
}
