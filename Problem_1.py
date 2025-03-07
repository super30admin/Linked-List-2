"""
## Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#Approach - 1 using controlled recursion
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        #TC: O(1) sc: O(h)
        self.stack = []
        self.dfs(root)

    def next(self) -> int:
        #TC: O(1) SC : O(1)
        root = self.stack.pop()
        self.dfs(root.right)
        return root.val
        
        

    def hasNext(self) -> bool:
        #TC: O(1) SC : O(1)
        return True if self.stack else False

    def dfs(self, root):
        #TC: O(1) sc: O(h)
        while(root):
            self.stack.append(root)
            root = root.left

        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()