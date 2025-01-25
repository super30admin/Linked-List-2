// ## Problem2 (https://leetcode.com/problems/reorder-list/)
// You are given the head of a singly linked-list. The list can be represented as:
// L0 → L1 → … → Ln - 1 → Ln
// Reorder the list to be on the following form:
// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// You may not modify the values in the list's nodes. Only nodes themselves may be changed.

// Input: head = [1,2,3,4]
// Output: [1,4,2,3]

Approach :
step 1 : we will divide a list in 2 lists using a fast and slow pointer
step 2 : as we have 2 lists now we will reverse the second list so that we can iterate over both the lists 
step 3: we will iterate and alternatively merge first and second list nodes and form one list

Time Complexity : O(N)
Space Complexity : O(1)

class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        //dividing a listbinto two lists
        ListNode slow=head;
        ListNode fast=head;

        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        fast=slow.next;
        slow.next=null;
        //Reversing fast
        ListNode prev=null;
        ListNode curr=fast;
        ListNode nextt=fast.next;
        while(nextt!=null){
            curr.next=prev;
            prev=curr;
            curr=nextt;
            nextt=nextt.next;
        }
        curr.next=prev;

        //Iterating over both the lists and adding them in one
        fast=curr;
        slow=head;
        while(fast!=null){
            ListNode temp=slow.next;
            slow.next=fast;
            fast=fast.next;
            slow.next.next=temp;
            slow=temp;
        }
    }
}