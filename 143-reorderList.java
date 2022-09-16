//Approach-1: 3-step approach, finding the mid, reversing the second half and then merging the two halves
//Overall Time Complexity: O(N)
//Overall Space Complexity: O(1)
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        
        //Traversing till the middle
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = reverse(slow.next);
        slow.next = null; //Removing the connection in the middle 
        slow = head;
        
        ListNode temp;
        
        while(fast != null){
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode node = head;
        ListNode next = null;
        
        while(node != null){
            next = node.next;    
            node.next = prev;
            prev = node;
            node = next;
        }
        
        return prev;
    }
}