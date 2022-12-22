//TC : o(n)
//Sc :o(h) recursive stack space 
//https://leetcode.com/problems/reorder-list/
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.print(slow.next.val);
        fast = reverse(slow.next);
        slow.next = null;
        System.out.print(fast.val);
        
        slow = head;
        while(fast != null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    private ListNode reverse(ListNode head){
        if(head.next == null) return head;
        ListNode reversed = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }
}
