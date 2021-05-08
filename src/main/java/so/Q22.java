package so;

import leetcode.data.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhangyizhang01
 * @date 2021-05-02
 */
public class Q22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode before=head;
        ListNode after=head;
        int i=0;
        while(i<k){
            before=before.next;
            i++;
        }
        while(before !=null){
            before=before.next;
            after=after.next;
        }

        return after;
    }
}
