"""
Time Complexity : O(1) amortized
Space Complexity : O(n) using the stack space
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        # We traverse through the list of nodes
        self.dfs(root)
    def next(self) -> int:
        # The top most is the next smallest so get that element
        node = self.stack.pop()
        # Call the dfs on the remaining right nodes
        self.dfs(node.right)
        return node.val
    def hasNext(self) -> bool:
        return len(self.stack) > 0
    def dfs(self, root):
        # Add all the elements in the leftmost node and below in the stack
        while root:
            self.stack.append(root)
            root = root.left

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()