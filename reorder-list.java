// Time Complexity :
n= no of elements in Linked list
O(n) + o(n/2) + o(n/2) ==> O(n)
// Space Complexity :
O(1) as we are using just pointers
// Did this code successfully run on Leetcode :
Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
[1,2,3,4,5]
*/
class Solution {
    public void reorderList(ListNode head) {
        
    if(head == null) return;  
        
        
    //Step 1: Find middle element ---> returns mid =3
    ListNode slow = head;
    ListNode fast = head;
        
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }
     
        
    //Step 2: Reverse second half of the linked list --> return 5->4
    ListNode previous = null;
    ListNode current = slow;
    ListNode forward = null;
    
    while(current != null){
        forward = current.next;//back up of next element
        current.next = previous; //break the link and update the pointer
        previous = current ; //back up of current
        current = forward ;
        
    }
        
    //Step 3: Merge two sorted lists ---> 1->2->3  and 5->4
        
    //currently my previous points to 5
    ListNode first = head;
    ListNode second = previous;
    
    //Will iterate until my second list is empty    
    while(second.next != null){
        forward = first.next; //backing up next element of first list first element
        first.next = second ; //change the pointer
        first = forward;
        
        forward = second.next; // backing up next element of second list first element
        second.next = first; //change the pointer
        second = forward;
    }
        
    
    
        
    }
    

}