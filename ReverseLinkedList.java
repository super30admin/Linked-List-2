// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
// use 3 pointers : curr,next and prev, to change the direction of the links
class Solution {
    public ListNode reverseList(ListNode head) {
       ListNode curr= head;
       ListNode prev = null;
       ListNode next = null;
       
       while(curr!=null){
           next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
       }
       
       return prev;
    }
}
   