// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

public class Solution{
    public void deleteNode(ListNode curr){
        if(curr.next == null) curr = null;
        curr.val = curr.next.val;
        curr.next = curr.next.next;
    }
}