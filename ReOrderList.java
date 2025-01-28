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
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public void reorderList(ListNode head) {
     // approach -> Split the list, reverse the latter half and weave it into the first list

     ListNode slow = head;
     ListNode fast = head;

     while (fast!=null && fast.next !=null )   {
       slow = slow.next;
       fast = fast.next.next; 
     }
        ListNode secondListHead = slow.next;
        slow.next = null;
       ListNode reversedSecondList = reverseLL (secondListHead);

       ListNode firstList = head; 
       int i= 0;
        while (firstList != null && reversedSecondList != null){
            if (i%2 == 0){
            ListNode temp = firstList.next; 
                firstList.next = reversedSecondList;
                firstList = temp;
                                i++;
            } else {
            ListNode temp = reversedSecondList.next; 
                reversedSecondList.next = firstList;
                reversedSecondList= temp;
                i++;
            }
        }

    }
    
    public ListNode reverseLL (ListNode node){
       if (node == null || node.next == null) {
        return node;
       }
       ListNode prev = null;
       while (node != null){
        ListNode temp = node.next;
        node.next = prev;
        prev = node;
        node = temp;
       }
       return prev;
    }
}