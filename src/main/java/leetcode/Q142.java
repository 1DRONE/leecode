package leetcode;

import leetcode.data.ListNode;

/**
 * @author drone
 * @date 2021/6/11
 */
public class Q142 {
    public ListNode detectCycle(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (null != fast) {
            slow = slow.next;
            if (null != fast.next) {
                fast = fast.next.next;
            } else {
                return null;
            }

            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }

        }
        return null;
    }
}
