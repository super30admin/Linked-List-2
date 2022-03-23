// Time Complexity : O(N)
// Space Complexity : O(1)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public void reorderList(ListNode head) {
        //Find middle node
        //Reverse the half of list after mid
        //Merge 2 halfs for resultant ordered list
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){ //Finding middle of the list
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //Slow is at middle node of the list
        
        fast = reverseHalf(slow.next); // FAST will be pointing to the head of reverese list after middle node
        slow.next = null;
        
        slow = head; // Slow pointing to head of list
        
        while(fast != null){ // Till the secood list not reach to null, simply set the next pointer link and merge them one by one
            ListNode temp = slow.next;
            
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
        
        
    }
    public ListNode reverseHalf(ListNode head){ // Reverse the list after middle node
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}