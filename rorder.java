// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
public class rorder {
    public static ListNode middle(ListNode head){
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null){
            ListNode next = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode mid = middle(head);
        ListNode nextHead = mid.next;
        
        mid.next = null;
        
        ListNode right = reverse(nextHead);
        ListNode left = head;
        
        while(right != null){
            //backup
            ListNode leftNext = left.next;
            ListNode rightNext = right.next;
            
            //connection
            left.next = right;
            right.next = leftNext;
            
            //move
            left = leftNext;
            right = rightNext;
        }
    }
}
