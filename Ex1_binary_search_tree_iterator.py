# Time Complexity:
#   - next(): Amortized O(1) time — Each node is pushed and popped from the stack only once across the entire traversal,
#     so although individual next() calls may take O(h) time in the worst case (when traversing down to the leftmost node),
#     the total time over all next() calls is O(n), giving O(1) amortized time per call.
#   - hasNext(): O(1) time — Simply checks whether the stack is non-empty.
# Space Complexity: O(h), where h is the height of the tree (stack stores at most h nodes)
# Did this code successfully run on Leetcode: YES
# Any problem you faced while coding this: No

from collections import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class BSTIterator:

    # OPTIMAL APPROACH

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self._leftmost_inorder(root)

    def _leftmost_inorder(self, node):
        while node:
            self.stack.append(node)
            node = node.left

    def next(self) -> int:
        top_node = self.stack.pop()
        if top_node.right:
            self._leftmost_inorder(top_node.right)
        return top_node.val

    def hasNext(self) -> bool:
        return len(self.stack) > 0


# ------------------------------------------------------------------------------------------

    # BRUTE FORCE APPROACH
    # Time Complexity: O(n) for construction, O(1) for each next() and hasNext()
    # Space Complexity: O(n) to store the full inorder traversal

    # def __init__(self, root: Optional[TreeNode]):
    #     self.inorder_arr = []
    #     self.index = 0
    #     self.inorder_traversal(root)

    # def inorder_traversal(self, node):
    #     if not node:
    #         return
    #     self.inorder_traversal(node.left)
    #     self.inorder_arr.append(node.val)
    #     self.inorder_traversal(node.right)

    # def next(self) -> int:
    #     val = self.inorder_arr[self.index]
    #     self.index += 1
    #     return val

    # def hasNext(self) -> bool:
    #     return self.index < len(self.inorder_arr)
