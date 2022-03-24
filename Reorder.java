//Time Complexity O(n)
//Space Complexity O(1)
//Leetcode tested

public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode l1 = head;
        ListNode prev=null;
        ListNode slow=head;
        ListNode fast=head;

        while (fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        prev.next=null;
        ListNode l2 = reverse(slow);
        merge(l1,l2);
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode current=head;
        while (current!=null){
            ListNode next = current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }

    public void merge(ListNode l1, ListNode l2){
        while (l1!=null){
            ListNode l1Next= l1.next;
            ListNode l2Next= l2.next;

            l1.next=l2;

            if(l1Next== null) break;

            l2.next=l1Next;
            l1=l1Next;
            l2=l2Next;
        }
    }
}
