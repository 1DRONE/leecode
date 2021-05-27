package leetcode;

import leetcode.data.ListNode;

/**
 * @author drone
 * @date 2021/5/26
 */
public class Q148 {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (null == head) {
            return null;
        }

        //如果是前后2个节点  先断开连接  底下merge再合并
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        //快慢指针  快走2步  慢走1步  快到尾  慢到中间
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != tail) {
                fast = fast.next;
            }
        }

        //包左不包右
        ListNode left = sortList(head, slow);
        ListNode right = sortList(slow, tail);

        return merge(left, right);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        if (null == node1) {
            return node2;
        }

        if (null == node2) {
            return node1;
        }

        ListNode tmpHead = new ListNode();
        ListNode cur = tmpHead;

        while (null != node1 && null != node2) {
            if (node1.val < node2.val) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
            }

            cur = cur.next;
        }

        cur.next = null == node1 ? node2 : node1;

        return tmpHead.next;
    }
}
