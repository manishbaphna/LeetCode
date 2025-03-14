import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * Definition for singly-linked list.
 */
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


public class MergedTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode newHead = null;
        ListNode head = new ListNode();

        newHead = head;

        while ( list1 != null && list2 != null ){

            if ( list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }

        head.next = list1 == null ? list2 : list1;

        return newHead.next;
    }

    public ListNode mergeTwoLists_Recursively(ListNode list1, ListNode list2) {

        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        if ( list1.val <= list2.val )
        {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

    }


}
