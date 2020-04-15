/**
 * Time Complexity - O(1)
 * Space Complexity - O(1)
 */
class Solution{


    public void deleteNodeWithoutHead(ListNode delNode)
    {
        if (delNode == NULL) // If linked list is empty
            return;
        else {

            if (delNode.next == NULL) {
                return;
            }

            ListNode temp = delNode.next;

            // Copy data of the next node to current node
            delNode.val = delNode.next.val;

            // Perform conventional deletion
            delNode.next = delNode.next.next;
        }
    }
}