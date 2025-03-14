import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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

class ListNodeComparator implements Comparator<ListNode> {
    @Override
    public int compare(ListNode o1, ListNode o2) {
        return Integer.compare(o1.val, o2.val);
    }
}
class MergeKSortedLinkedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if ( lists == null || lists.length == 0)
            return null;

        MergedTwoSortedLists mergeTwoLists = new MergedTwoSortedLists();

        ListNode mergedSoFar = lists[0];

        for (int i=1; i <lists.length; ++i){
            mergedSoFar = mergeTwoLists.mergeTwoLists(mergedSoFar, lists[i]);
        }

        return mergedSoFar;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new ListNodeComparator());

        ListNode head = new ListNode();
        ListNode oldhead = head;
        for ( int i=0; i < lists.length; ++i){
            if ( lists[i] != null)
                pq.add(lists[i]);
        }

        while ( !pq.isEmpty() ){
            ListNode top = pq.poll();
            if (top.next != null)
                pq.add(top.next);
            head.next = top;
            head = head.next;
        }

        return oldhead.next;

    }


    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(null);

    }
}