**
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
       
        ListNode fast = head;
        ListNode slow = head;
        ListNode curr = null;        
       
        while( fast.next != null && fast.next.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverse(slow.next);
        slow.next = null; //3 node connection lost
        slow = head;
       
        //merge
        while(fast!= null){
            curr = slow.next; //initialize curr
            slow.next = fast; //pointer equal to fast
            fast = fast.next; //fast move forward
            slow.next.next = curr; // merged  node 5 with node 2
            slow = curr; // reset slow to curr
           
        }
    }
   
    private ListNode reverse(ListNode root){
        ListNode curr = root;
        ListNode prev = null;
        ListNode temp = null;
       
        while (curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
   
}

/*
Time complexity : O(n)
Space complexity : O(1)
*/