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
class ReorderList {
    public void reorderList(ListNode head) {
        
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode cur = slow.next;
        slow.next=null;
        while(cur != null)
        {
            ListNode temp = cur.next;
            cur.next=prev;
            prev=cur;
            cur = temp;
        }
        ListNode startCur = head;
        ListNode endCur = prev;
        while(endCur!=null)
        {
            ListNode temp = startCur.next;
            ListNode temp2 = endCur.next;
            
            startCur.next = endCur;
            endCur.next = temp; 
            startCur=temp;
            endCur=temp2;
        }
        
    }
}

//tc: O(n)
//sc: O(1)