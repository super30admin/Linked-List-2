// Time Complexity O(n)
// Space Complexity O(1)

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow  = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //Reverse List second half
        ListNode prev = null;
        ListNode curr = slow;
        ListNode forw = slow.next;
        while(curr!=null){
            fast = curr.next;
            curr.next = prev;
            prev = curr; 
            curr =  fast;
        }
        fast = prev;
        
        //Rearrange
        System.out.print(" "+slow.val);
        System.out.print(" "+fast.val);
        ListNode temp = head;
        slow = head;
        while(fast.next!=null){
            temp = slow.next;
            slow.next = fast;
            slow = temp;
            
            temp = fast.next;
            fast.next = slow;
            fast = temp;
            
        }
    }
}