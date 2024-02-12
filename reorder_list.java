//Time - O(n)
//Space - O(1)
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
        if(head==null || head.next==null){
            return;
        }
        ListNode curr = head;
        ListNode middle = findMiddle(curr);
        ListNode reverse = reverse(middle);
        while(curr!=null && reverse!=null){
            ListNode temp = curr.next;
            ListNode temp1 = reverse.next;
            curr.next = reverse;
            if(temp!=null){
                reverse.next = temp;
            }
            curr = temp;
            reverse=temp1;
        }
        
    }

    public ListNode findMiddle(ListNode head){
        ListNode curr = head;
        int length=0;
        while(curr!=null){
            length++;
            curr = curr.next;
        }
        curr = head;
        ListNode prev = null;
        int count = 0;
        while(count!=length/2){
            prev = curr;
            curr = curr.next;
            count++;
        }
        prev.next = null;
        return curr;

    }

    public ListNode reverse(ListNode curr){
        ListNode prev = null;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr=temp;
        }
        return prev;
    }
}
