//Time Complexity:O(N)
//Space Complexity: O(1)
class Solution {
    public void reorderList(ListNode head) {
        if( head.next == null){
            return;
        }
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l2 =  l2= reverseLinkedList(slow.next);
        slow.next= null;
        merge(head,l2);
        return;

    }
    public ListNode reverseLinkedList(ListNode head){
        if(head == null){
            return head;
        }
        ListNode previous=null;
        ListNode current = head;
        ListNode fast = current.next;


        while(fast!=null){
            current.next= previous;
            previous= current;
            current = fast;
            fast= fast.next;
        }
        current.next=previous;
        return current;
    }
    public void merge(ListNode l1,ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        while(l1!=null && l2!=null){
            n1= l1.next;
            n2= l2.next;
            l1.next=l2;
            l2.next=n1;
            l2=n2;
            l1=n1;
        }
    }
}