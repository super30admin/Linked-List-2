// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public void reorderList(ListNode head) {
        int length = 0;
        ListNode curr=head;
        while(curr!=null){
            length++;
            curr=curr.next;
        }
        ListNode prev = null;
        curr=head;
        int count=0;
        while(count<length/2){
            curr=curr.next;
            count++;
        }
        prev=curr;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
            count++;
        }
        curr=head;
        while(curr!=prev){
            ListNode temp = curr.next;
            ListNode temp1 = prev.next;
            curr.next=prev;
            curr=curr.next;
            curr.next=temp;
            curr=temp;
            prev=temp1;
        }
        prev.next=null;
    }
}
