// Time complexity:O(1)
//Space complexity:O(1)

//Cope value of next node into node to be deleted and then change next pointer of node to the node next to the successor node.

class Solution {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}