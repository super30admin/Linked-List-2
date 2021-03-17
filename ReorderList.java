/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //Middle - > Reverse -> combine
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        //find mid point of the list
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //reverse 2nd half of the linked list
        fast = reverse(slow.next);
        slow = null;
        
        slow = head;
        //start adding the elements of 2nd half into the first half in desired format
        while(fast!= null && slow!=null){
            ListNode nextS = slow.next;
            ListNode nextF = fast.next;
            
            slow.next = fast;
            fast.next = nextS;
            
            slow= nextS;
            fast = nextF;
        }

        //retur the head node
        return head;
    }
}

//Time Complexity : O(n)
//Space Complexity: O(1)