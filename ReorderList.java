// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : no
// Any problem you faced while coding this : after reverding the second half of the list, i am facing
//problems in merging the 2 lists one by one


// Your code here along with comments explaining your approach



//  Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution {
    public void reorderList(ListNode head) {

        //splitting the list into using slow fast technique where for every iteration of p1, p2 is
        // moved twice, so that when p2 reaches end, p1 is at the center

        ListNode p1=  head;
        ListNode p2 = head;

//        checking if the fast.next and fast.next.next conditions
        while(p1 != null && p2 != null && p2.next != null && p2.next.next ){
            p1 = p1.next;
            p2 = p2.next.next;
        }


        //reversing the second half of the list
        Listnode prev = p1;
        ListNode curr = p1.next;
        ListNode next = p1.next.next;

        while(next != null) {
            curr.next = prev;
            prev =curr;
            curr = next;
            next = next.next;
        }

        //Here problem: trying to merge the 2 lists one by one but I am messign the pointers
        p1=head;
        p2=prev.next;
        while(p1!=prev){
            prev.next=p2.next;
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
            p2=prev.next;


    }
}