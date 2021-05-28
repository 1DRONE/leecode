package leetcode;

import leetcode.data.ListNode;

/**
 * @author drone
 * @date 2021/5/27
 */
public class Q141 {
    public boolean hasCycle(ListNode head) {
        ListNode tmp = new ListNode();
        tmp.next = head;

        ListNode slow = tmp;
        ListNode fast = head;

        while (slow != fast) {
            if (slow == null || fast == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return true;
    }
}
