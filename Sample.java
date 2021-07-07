// ======================================Intersection of 2 LinkedList=====================
// Time Complexity : O(n) + O(n) = O(2n) == O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null)
            return null;
        
        ListNode pntrA = headA;
        ListNode pntrB = headB;
        int lenA=0;
        int lenB=0;
        // Get the length of LinkedList A
        while(pntrA != null){
            lenA++;
            pntrA = pntrA.next;
        }
        
        // Get the length of LinkedList B
        while(pntrB != null){
            lenB++;
            pntrB = pntrB.next;
        }
        
        // If A = 8 and B = 6 reduce the length of A untill both are equal
        while(lenA > lenB){
            
            headA = headA.next;
            lenA--;
        }
        
        // If A = 6 and B = 8 reduce the length of B untill both are equal
        while(lenA < lenB){
           
            headB = headB.next;
            lenB--;
        }
        
//         Traverse untill both A and B meets. That will be our intersecting Node.
        while(headA != headB){
            
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}


// ===================RE-ORDER LinkedList===============================
// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next== null)
            return;
        
        // FInd the middle of the list
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // ListNode middle = slow;   -- No need to have extra nodes. Use it in the same linkedLIst
        // ListNode secondHalf = slow.next;
        // Reverse second half of the list
        fast = reverse(slow.next);
        slow.next = null; // Next of middle will be marked null making first half as a individual linkedLIst.
        slow = head;
        ListNode curr;
        while(fast != null){  // Merge first half with second half. Go until reverse not null as it can have less number or elements(in odd numbr of nodes) and equal number when even number of nodes.
            curr = slow.next;
            slow.next  = fast;
            fast = fast.next;
            slow.next.next  = curr;
            slow = curr;
            // curr = curr.next;
        }
        
        
    }
    
    private ListNode reverse(ListNode node){
        
        ListNode fast = node.next;
        ListNode prev = null;
        ListNode curr = node;
        while(fast != null){
            curr.next  = prev;
            prev = curr;
            curr = curr.next;
            curr = fast;
            fast = fast.next;
        }
        
        curr.next  = prev;
        return curr;
        
    }
}

// ===================Delete Node without head===================
// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach


/*
class Node
{
	int data ;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}
*/

// This function should delete node from linked list. The function
// may assume that node exists in linked list and is not last node
// node: reference to the node which is to be deleted
class GfG
{
    void deleteNode(Node node)
    {
        if(node.next == null || node == null)
            return;
         // Your code here
         while(node.next != null){
             node.data = node.next.data;
            if(node.next.next == null)
                node.next = null;
            else
                node = node.next;
         }
        node.next = null;
    }
}
