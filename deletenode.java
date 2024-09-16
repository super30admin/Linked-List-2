// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :No (Not a Leetcode problem)
// Any problem you faced while coding this :No




public class Solution {
    public void deletenNode(ListNode head, int target) {
        if(head == null || head.next == null)return;
        ListNode curr = head;
        while(curr != null){
            if(curr.val == target){
                curr.val = curr.next.val;
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        
    }
}