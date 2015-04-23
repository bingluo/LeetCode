package cn.edu.seu.leetcode;

import cn.edu.seu.leetcode.AddTwoNumbers.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = head;
        ListNode newHead = null;
        ListNode parent = null;
        while(cur!=null){
            if(cur.val!=val){
                newHead=newHead==null?cur:newHead;
                if(parent!=null)
                    parent.next = cur;
                parent = cur;
            }
            cur = cur.next;
        }
        if(parent!=null)
            parent.next = cur;
        return newHead;
    }
}
