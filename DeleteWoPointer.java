// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Copying the next element to the current and point to the next.next
// if there is the last element, auto assign as null
public class Solution {
    public void deleteNode(ListNode pos) {
        if(pos.next != null){
            pos.val = pos.next.val;
            pos.next = pos.next.next;
        }else{
            pos = null;
        }
    }
}