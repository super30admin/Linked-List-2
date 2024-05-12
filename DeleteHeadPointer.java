// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Had to learn the trick

/*
 * Tricky problem: since we dont have access to previous node. 
 * 
 * To think about it, ListNode is val & pointer to the next node. 
 * So, get the next node of deletenode; set the value of the delete node to the prev value and
 * assign the deletenode.next to delete.next.next.
 * 
 * so the value of deletenode address is updated to the next node value and the next node is pointed to the next of next.
 */
public class DeleteHeadPointer {

    public void deleteNode(ListNode del_node) {
        ListNode temp = del_node.next;
        del_node.val = temp.val;
        del_node.next = temp.next;
    }

}