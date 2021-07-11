# Time Complexity: O(1)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes

# Solution:

class Solution:
    def deleteNode(self, node: ListNode) -> None:
        # Copy the val of next node to the curr node and delete the next node
        node.val = node.next.val
        node.next = node.next.next