// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on GFG : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * Since we are not given the head of the linked list, we cannot traverse the
 * list to store the previous. So we can just swap the values of the node to
 * be deleted with the next node
 *
 */

public class Problem3 {
    void deleteNode(ListNode del_node)
    {
        // Your code here
        ListNode temp = del_node.next;
        del_node.val = temp.val;
        del_node.next = temp.next;
        temp = null;
    }
}
