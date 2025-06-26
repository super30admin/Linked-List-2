# Time Complexity : O(1) on average for next() and hasNext()
# Space Complexity : O(h), where h is the height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        # I use a stack to store the path to the next smallest node
        self.stack = []
        self._leftmost_inorder(root)

    def _leftmost_inorder(self, node):
        # Traverse to the leftmost node and store all nodes along the path
        while node:
            self.stack.append(node)
            node = node.left

    def next(self) -> int:
        # The top of the stack is the next smallest element
        node = self.stack.pop()
        # If the node has a right child, process its leftmost subtree
        if node.right:
            self._leftmost_inorder(node.right)
        return node.val

    def hasNext(self) -> bool:
        # There are still nodes to be visited
        return len(self.stack) > 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
