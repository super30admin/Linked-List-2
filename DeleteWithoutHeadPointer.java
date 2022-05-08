// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : I didnt understand the problem, I feel like this isnt the right solution


public class DeleteWithoutHeadPointer {
    public void deleteWithoutHeadPointer(ListNode node){
        node.val=node.next.val;          // copy the next node's value into the current node
        node.next=node.next.next;       // connect the current node to the next of next node
    }
}
