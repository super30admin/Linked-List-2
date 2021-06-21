// 237. Delete Node in a Linked List
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        
        node.val = node.next.val;
        node.next = node.next.next;
        
    }
}

/*
Time complexity: O(N)
Space complexity: O(N)

To delete a node in a linkedlist takes o(n) to traverse the list.
*/