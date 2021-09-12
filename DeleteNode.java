/*
Time: O(1)
Space: O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class DeleteNode {
    public void deleteNode(ListNode node) {

        node.val = node.next.val;

        node.next = node.next.next;

    }

}