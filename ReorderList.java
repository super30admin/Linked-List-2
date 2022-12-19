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
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
     

        

        while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverse(slow.next);
        slow.next = null;
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
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        while(fast != null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;

    }
}






//TC : O(n) + O(n) + O(n) = O(n) for all three steps
//SC : O(1), not using any extra space. Even though dividing linked list into two, we are dividing same list.


//Appproach :

// To Reorder list t0 L0 -> Ln -> L1 -> Ln-1, following three steps 1) To find Mid
                                                                  //2) Reversing the Second Half
                                                                  //3) Connecting two list according to the given order
// Using slow and fast pointers to find mid. slow moves by 1 and fast moves by 2 steps. After finding the mid taking slow.next /////as head and reversing the second part of list. In third step slow will be head and slow.next will be temp. slow.next will be my fast. By moving fast to next node we can connect slow.next.next to temp.@interface
