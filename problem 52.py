#  https://leetcode.com/problems/binary-search-tree-iterator/


# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.result = []
        self.idx = 0
        self.inorder(root)
    
    def inorder(self, root: Optional[TreeNode]):
        if root is None:
            return
        
        self.inorder(root.left)
        self.result.append(root.val)
        self.inorder(root.right)        

    def next(self) -> int:
        re = self.result[self.idx]
        self.idx+=1
        return re
        
    def hasNext(self) -> bool:
        return self.idx != len(self.result)
        




# Using a stack
# TC: O(1)
# SC: O(h) h = height of the tree


class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.dfs(root)
    
    def dfs (self, root: Optional[TreeNode]):
        while(root != None):
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        res = self.stack.pop()
        self.dfs(res.right)
        return res.val        

    def hasNext(self) -> bool:
        return bool(self.stack)
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()