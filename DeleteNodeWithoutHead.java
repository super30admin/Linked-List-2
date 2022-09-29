// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public void deleteNode(ListNode node) {
        ListNode iterate = node;

        //we have to only check the next as not null.
        //Because, we are given that the 'node' is not the last node.

        ListNode prevNode = node;

        while(iterate.next != null){
            int nextVal = iterate.next.val;
            iterate.val = nextVal;
            prevNode = iterate;
            iterate = iterate.next;
        }

        prevNode.next = null;
    }
}