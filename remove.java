/* Time complexity: O(n)
space complexity: O(1)  */


class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;        
    }
}