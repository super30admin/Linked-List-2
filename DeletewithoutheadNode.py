// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution:
    def deleteWithoutHead(self, node: ListNode) -> ListNode:
        temp=node.next.val
        node.val=temp #copying the next node value to current node
        node.next=node.next.next #removing next node

        

            