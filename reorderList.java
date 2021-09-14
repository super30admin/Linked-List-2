// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class reorderList {
    public void reorderList(ListNode head) {
        //null case
        if (head == null) return;
        
        ListNode slow = head;
        ListNode fast = head;
        
        //find middle
        while(fast != null && fast.next != null){
            slow = slow.next;       //1x speed
            fast = fast.next.next;  //2x speed
        }
        
        //reverse; using the 3 pointer approach
        ListNode prev, curr, temp;
        prev = null;
        curr = slow;
        
        while(curr != null) {
            temp = curr.next;
            curr.next = prev; //point the arrow in the opposite direction
            prev = curr;
            curr = temp;
        }
        
        
        //merge 2 lists
        ListNode firstList  = head;
        ListNode secondList = prev;
        
        while(secondList.next != null) {
            temp = firstList.next;
            firstList.next = secondList;
            firstList = temp;
            temp = secondList.next;
            secondList.next = firstList;
            secondList = temp;
            
        }
        
    }
}
