// Time complexity: O(1)
// Space complexity: O(1)

public class Solution3 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    
    public void deleteNode(ListNode node) {
        // copy the next node val
        node.val = node.next.val;
        node.next = node.next.next; 
    }
}
