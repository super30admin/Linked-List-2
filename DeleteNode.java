/**
## Problem3: (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)
 
Time Complexity :   O (N) 
Space Complexity :  O (1) 
Did this code successfully run on Leetcode :    Yes (237. Delete Node in a Linked List)
Any problem you faced while coding this :       No
 */

// Input: head = [4,5,1,9], node = 5
// Output: [4,1,9]

class DeleteNode {
    // copy node.next data to given node and delete node.next 
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}