// Time Complexity :O(n) traverse the whole list
// Space Complexity :O(1) no extra space needed
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Solution4 {

    // Definition for singly-linked list.
      public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
        public class Solution {
            public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
                if(headA==null ||headB==null)
                    return null;
                ListNode curr=headA;
                int lenA=0;
                int lenB=0;
                // length of list A
                while(curr!=null){
                    lenA++;
                    curr=curr.next;
                }
                // reusing same node to calculate the length
                curr=headB;
                // length of list B
                while(curr!=null){
                    lenB++;
                    curr=curr.next;
                }
                while(lenA>lenB){
                    headA=headA.next;
                    lenA--;
                }
                // move the pointer to lenA-lenB so that they are at same distance from the end.
                while(lenB>lenA){
                    headB=headB.next;
                    lenB--;
                }
    
                //when both heads are at same point , move them to find a intersection point
                while(headA!=headB){
                    headA=headA.next;
                    headB=headB.next;
                }
                // Can return either of the head pointers
                return headB;
            }
        }
    }
    