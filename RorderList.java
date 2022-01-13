// Time Complexity : O(n) where n is length of input linked list
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, i had issue while adjusting linked list pointer, i fixed those by drawing the list and simulating the algorithm

public class RorderList {
    public static void main(String[] args) {
        
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        
        // split linked list into half
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // reverse second half
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        
        ListNode next = slow;
        
        // rearrange/ merge
        while(fast != null){
            next = next.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = next;
            slow = next;
        }
    }
    
    private ListNode reverse(ListNode head){
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        
        while(next != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        return curr;
    }

    class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
}
