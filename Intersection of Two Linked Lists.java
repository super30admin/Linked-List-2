
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


//Brute force TC-O(m+n) SC-O(m+n)

//find the length of the both list n,m
//move pointer of bigger list from n-m times
//iterate over both whenever they meet that would be the intersection.
//TC-O(m+n) find length then intersection node SC-O(1)



public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        int lenA=0;
        int lenB = 0;

        while(nodeA!=null){
            nodeA = nodeA.next;
            lenA++;
        }
         while(nodeB!=null){
            nodeB = nodeB.next;
            lenB++;
        }
        nodeA = headA;
        nodeB = headB;


            while(lenA > lenB){
             nodeA = nodeA.next;
             lenA--;

            }
         while(lenB > lenA){
             nodeB = nodeB.next;
             lenB--;

            }


        while(nodeA!= nodeB){
      
            nodeA=nodeA.next;
            nodeB=nodeB.next;
        }

        return nodeA;
     
    }
}


// You are given a node del_node of a Singly Linked List where you have to delete a value of the given node from the linked list but you are not given the head of the list.

// By deleting the node value, we do not mean removing it from memory. We mean:

// The value of the given node should not exist in the linked list.
// The number of nodes in the linked list should decrease by one.
// All the values before & after the del_node node should be in the same order.
// Note:

// Multiple nodes can have the same values as the del_node, but you must only remove the node whose pointer del_node is given to you.
// It is guaranteed that there exists a node with a value equal to the del_node value and it will not be the last node of the linked list.


// a common trick is used: instead of "deleting" the node directly, 
// you overwrite its value with the value of the next node and adjust 
// the pointers to skip over the next node.

// Time Complexity:
// O(1): This solution only involves constant-time operations of copying a value and adjusting a pointer.
// Space Complexity:
// O(1): No additional space is used, just updating the node in place.






// class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) { val = x; }
// }

// public class Solution {
//     public void deleteNode(ListNode del_node) {
//         // Copy the value of the next node into the current node
//         del_node.val = del_node.next.val;
        
//         // Update the current node's next pointer to skip the next node
//         del_node.next = del_node.next.next;
//     }
// }


