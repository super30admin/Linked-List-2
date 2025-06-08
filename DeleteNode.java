// Time complexity - O(1)
// Space Complexity - O(1)
// Did you face any issues - No
// Solved on leetcode - yes
// Simply updating the node next value
public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
}
