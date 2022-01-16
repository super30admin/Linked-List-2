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
        HashMap<Integer, ListNode> map = new HashMap<>();
        
        ListNode slow= head;
        ListNode fast= head;
        int i=0;
        while(fast!= null && fast!= null){
            slow= slow.next;
            fast= fast.next.next;
        }
           ListNode curr= slow, prev= null;
        while(curr!= null){
            ListNode next= curr.next;
            curr.next= prev;
            prev= curr;
            curr= next;
        }
        ListNode first = head, second = prev, tmp;
        while (second.next != null) {
        tmp = first.next;
        first.next = second;
        first = tmp;

        tmp = second.next;
        second.next = first;
        second = tmp;
    }
        return ;
    }
}

//time complexity - O(n)
//space complexity - O(1)