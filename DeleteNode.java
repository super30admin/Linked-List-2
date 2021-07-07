/**
Time:O(1) Space:O(1)
Algorithm:
==========
1. Copy next node's value into itself
2. Delete next node
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;	//Copy next node's value into itself
        node.next = node.next.next;	//delete next node
    }
}