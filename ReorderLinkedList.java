/*
 * #143. Reorder List
 * 
 * Reorder the given Linked List

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.

Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

 */


/*
 * Time Complexity: O (N/2) -> O (N) -> Traverse through the half list for merging
 * 
 * Space Complexity: O (1) -> No extra space used
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.linkedlist2;

//Definition for singly-linked list.
class ListNode3 {
	int val; // data
	ListNode3 next;
	ListNode3() {}
	ListNode3(int val) { this.val = val; }
	ListNode3(int val, ListNode3 next)
	{
		this.val = val; 
		this.next = next; 
	}
}

public class ReorderLinkedList {
	public void reorderList(ListNode3 head) {
        
        // Base condition 
        if(head == null){
            return;
        }
        
        // 1. Find the mid of LL by Floyd's algorithm
        /*
        * Two pointers - slow and fast
        * slow pointer will increment by 1
        * fast pointer will increment by 2
        * We will keep incrementing until fast cannot traverse more
        * In case of odd numbers list -> we will stop once fast reaches at last element
        * In case of even numbers list -> we will stop once fast reaches at null
        */ 
        ListNode3 slow = head;
        ListNode3 fast = head;
        
        // We have to first check for fast != null and then for fast.next != null
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // 2. Reverse the LL after slow pointer
        
        // e.g: ip = 1->2->3->4->5, op = 1->5->2->4->3
        // Looking at the output, the order 1->2->3 is same as input
        // 4->5 changed to 5->4
        // So, we reverse the list after slow pointer(3) in this case
        ListNode3 h2 = reverseList(slow.next);
        
        // we set the next of slow pointer to null
        slow.next = null;
        
        
        // 3. Merge the two lists
        
        // After reverse step, we get two lists 
        // 1. 1->2->3
        // 2. 5->4
        // op= 1->5->2->4->3
        ListNode3 h1 = head;
        ListNode3 temp1;
        ListNode3 temp2;
        
        // 1. 1->2->3 ----  h1 = 1
        // 2. 5->4    ----  h2 = 5
        while(h2 != null){
            temp1 = h1.next;
            h1.next = h2;
            temp2 = h2.next;
            h2.next = temp1;
            h1 = temp1;
            h2 = temp2;
        }
    
    }
    
    // Separate function to reverse the list after slow pointer
    public ListNode3 reverseList(ListNode3 curr){
            ListNode3 prev = null;
            ListNode3 tempNode = null;
            
            while(curr != null){
                tempNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tempNode;
            }
            return prev; // return the head of reversed list to calling function
        }
    
}
