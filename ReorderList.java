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

// Time Complexity : O(n) -> iterating through the list 
// Space Complexity : O(1) -> no additional space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
*The intuition is to divide the list into half -> half: because when you reverse the entire list, you are not really using all the elements from both the lists 
* Reverse the second half of the list and set the slow.next to null to let go of the second half of the list
* Merge both the lists together: 1. Using two temp pointers one for tracking slow.next and another for tracking fast.next
2. From dry running the first approach, its evident that you dont need to track fast.next in a temp variable as we will always have access to that using slow.next.next
*/
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }        
       
        //reverse the list
        // curr will start from next of the slow node
        ListNode curr = slow.next;
        ListNode reversedList = null;
        while(curr != null){
            //going to lose the node so save it in temp
            ListNode temp = curr.next;
            curr.next = reversedList;
            reversedList = curr;
            curr = temp;
        }

        // we only need first half of the list
        slow.next = null;
        
        //merge the lists
        
        slow = head;

        fast = reversedList;

        while(fast != null){
            //save the next address to slow in temp as we are going to lose access
            ListNode temp = slow.next;

            // update the next of slow to fast
            slow.next = fast;
            // move fast to fast.next as we have access to fast
            fast = fast.next;

            //map fast.next i.e. slow.next.next to the actual slow.next stored in temp
            slow.next.next = temp;

            // move slow to slow.next i.e. temp
            slow = temp;
        }
    }
}
