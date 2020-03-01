/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        //edge case, null or single node
        if(head == null || head.next==null)
            return; 
        //find middle pointer of linked list
        ListNode secondHalf = getMiddle(head);
        //reverse 2nd part of the list
        secondHalf= reverseSecondHalf(secondHalf);
        //merge 1st and 2nd half
        reorder(head,secondHalf);
    }
    private ListNode getMiddle (ListNode head){
        ListNode slow= head ,fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        //divide the list into two parts
        prev.next = null;
        return slow;
    }
    //reverse second half
    private ListNode reverseSecondHalf(ListNode node){
        ListNode cur = node;
        ListNode next= null, prev= null;
        while(cur !=null){
            next = cur.next;
            cur.next = prev;
            prev =cur;
            cur = next;
        }
        return prev;
    }
    //merge 2 lists
    private ListNode reorder(ListNode first, ListNode second){
        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;
        while(first != null && second!= null){
            ptr.next = first;
            first= first.next;
            ptr = ptr.next;
            ptr.next = second;
            ptr = ptr.next;
            second = second.next;   
        }
        if(first !=null)
            ptr.next = first;
        if(second!= null)
            ptr.next = second;
        return dummy.next;
    }
}
