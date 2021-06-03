package leetcode;

import leetcode.data.ListNode;

/**
 * @author drone
 * @date 2021/6/4
 */
public class Q234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        //前半部分链表尾节点 若链表有奇数个节点，则中间的节点应该看作是前半部分。
        ListNode firstHalfEnd = endOffFirstHalf(head);
        //反转后半部分链表
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        //判断是否回文
        ListNode p = head;
        ListNode q = secondHalfStart;
        boolean result = true;
        while (result && q != null) {
            if (p.val != q.val) {
                result = false;
            }
            p = p.next;
            q = q.next;
        }
        //还原链表
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private ListNode endOffFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
