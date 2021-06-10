package leetcode;

import leetcode.data.ListNode;

/**
 * @author drone
 * @date 2021/6/10
 */
public class Q19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = tmp;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (null != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        //删除节点  此时slow为删除节点的前一个节点
        slow.next = slow.next.next;
        //有可能只有一个节点并且删除  所以不能直接返回head
        return tmp.next;
    }
}
