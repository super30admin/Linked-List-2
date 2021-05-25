// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(1) 
//Space Complexity: O(1) 
class Solution {
    public void deleteNode(ListNode node) {
        
        ListNode temp = node.next;
        node.val = temp.val;
        node.next = temp.next;
    }
}