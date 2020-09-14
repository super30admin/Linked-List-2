// Time Complexity : O(1) since we can do in constant time
// Space Complexity : O(1) since we can do in constant space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// here we are not given the head of the ll..so we set the value of next one in the current node and point the next of current node to its next to next ptr
// 1 -> 2-> 3 -> 4.. if we are to delete 2 we will set its value as 3 and 2->4
// 1->3->4 and this copied 3 is pointing to the original 3

class Solution {
    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }
}