
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class RemoveNthNodeFromEnd {

    private boolean isLastNode(ListNode node){
        return  node.next == null;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode originalHead = new ListNode(head.val, head.next);
        ListNode nexthead = head;

        if ( isLastNode(head) ){
            return head.next;
        }

        while ( n != 0 && nexthead.next != null) {
            nexthead = nexthead.next;
            n--;
        }
        if( n != 0) {
            return head.next;
        }

        if (isLastNode(nexthead)) {
            head.next = head.next.next;
            return head;
        }

        while (!isLastNode(nexthead)) {
            head = head.next;
            nexthead = nexthead.next;
        }
        head.next = head.next.next;

        return originalHead;
    }
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<ListNode>();

        while ( head != null ){
            stack.push(head);
            head = head.next;
        }

        ListNode temp = null;

        while ( n != 0) {
            temp = stack.peek();
            stack.pop();
            n--;
        }
        if ( stack.empty() ){
            return temp.next;
        }

        temp = stack.peek();
        temp.next = temp.next.next;

        if (!stack.empty()) {
            temp = stack.firstElement();
            //temp = stack.peek();
            //stack.pop();
        }
        return temp;
    }
}