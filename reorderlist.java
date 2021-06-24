//Time complexity: O(n)
//Space Complexity: O(1)
//Ran on leetcode
// We first find the middle of the list and then seperate the two lists. Then we reverse the second list and merge the two lists.


class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode l2=reverse(slow.next);
        slow.next=null;
        ListNode l1=head;
        merge(l1,l2);
        
    }
    private ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    
    private void merge(ListNode l1,ListNode l2){
        while(l2!=null){
            ListNode next=l1.next;
            l1.next=l2;
            l2=l2.next;
            l1.next.next=next;
            l1=next;
        }
    }
}