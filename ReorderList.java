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
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        fast = reverse(slow.next);
        slow.next=null;
        slow=head;
        while(fast!=null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast=fast.next;
            slow.next.next=temp;
            slow=temp;
        }
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur=head;
        while(head!=null){
            head=head.next;
            cur.next=prev;
            prev = cur;
            cur=head;
        }
        return prev;
    }
}

//Time Complexity: O(2n);
//Space Complexity: O(1);
