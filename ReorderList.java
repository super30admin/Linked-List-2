// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : To get the output linked list, we will consider the first half of the list as is, and reverse the second part of the list. Thus, these two lists will be later merged to form the list in the desired way, by repeatedly merging the first elements of the 2 sub-lists.

public class ReorderList {
    public void reorderList(ListNode head) {
        
        if(head != null && head.next != null && head.next.next != null){
            ListNode slow = head;
            ListNode fast = head;

            //find the mid of the list to split the 2 lists at mid
            while(fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            //reset slow and fast pointer to the start of the sub arrays
            fast = slow.next;
            slow.next = null;
            slow = head;
            
            //reverse the linked list pointed by the fast pointer
            ListNode prev = null;
            ListNode curr = fast;
            ListNode temp;

            while(curr != null){
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;                    
            }

            fast = prev;

            //merge the two lists pointed by fast and slow
            while(fast != null){
                temp = slow.next;
                slow.next = fast;
                fast = fast.next;
                slow.next.next = temp;
                slow = temp;
            }
            
        } 
    }
}
