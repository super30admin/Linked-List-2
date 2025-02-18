# 173. Binary Search Tree Iterator

# Time Complexity: O(1) for next and hasNext
# Space Complexity: O(h) for the stack
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Intuition:
# Use a stack to store the nodes in the BST.
# Use a dfs function to traverse the BST and push the nodes onto the stack.
# Use the next function to return the next smallest element in the BST.
# Use the hasNext function to check if there is a next smallest element in the BST.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.dfs(root)

    def dfs(self, root):
        while root != None:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        node = self.stack.pop()
        self.dfs(node.right)
        return node.val

    def hasNext(self) -> bool:
        return len(self.stack) != 0 

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()