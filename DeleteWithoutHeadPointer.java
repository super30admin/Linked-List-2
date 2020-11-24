package S30.LinkedList2;

/*
Time Complexity : O(1)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

public class DeleteWithoutHeadPointer {

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;

    }
}
