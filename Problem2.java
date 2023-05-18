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

//  Time: O(n)
// Space: O(1)
class Solution {
    public void reorderList(ListNode head) { 
        ListNode slow  =  head;
        ListNode fast  =  slow.next;
        // find middle
        while(fast != null && fast.next != null){
            slow  = slow.next;
            fast = fast.next.next;
        }
        


        // reverse second half
        System.out.println("slow: " + slow.val);

        ListNode secondHead = reverse(slow.next);
        slow.next = null;

        // merge two linked list

        ListNode firstHead = head;

        while(secondHead != null){
            ListNode temp = firstHead.next;
            ListNode temp2 = secondHead.next;
            firstHead.next = secondHead;
            secondHead.next = temp;
            secondHead = temp2;
            firstHead = temp;
        }


    }

    public ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode nextPointer = null;

        while(node!=null){
            nextPointer = node.next;
            node.next = prev;
            prev =  node;
            node = nextPointer;
        }
        return prev;
    }
}