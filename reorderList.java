//Time Complexity:O(N)
//Space Complexity:O(1)
//In this problem, I'll try to find the middle of the list by using two pointers, fast and slow. My fast will be moving 2 steps at a time whereas my slow will be moving 1 step at a time, so that when my fast pointer reaches null, my slow will be exactly in the middle of the list. Now after finding the middle, I'll start reversing the list from the node next to my slow. After reversing, I'll be adding elements from the end to the begining of the list in the order : 1 N 2 N-1 3 N-2 and so on. I'll be having two temporary variables, that will help me in keeping track of the next node in my head list and the reversed list.
//This code was executed successfully and got accepted in leetcode.

class Solution {
    public void reorderList(ListNode head) {
        if(head==null){
            return;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp= slow.next;
        slow.next=null;
        ListNode cur= temp;
        ListNode prev=null;
        ListNode next;
        while(cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        temp=prev;
        while(temp!=null){
            ListNode tempo=head.next;
            head.next=temp;
            head=tempo;
            ListNode tempo2=temp.next;
            temp.next=head;
            temp=tempo2;
            
        }
    }
}