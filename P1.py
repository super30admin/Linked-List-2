# -*- coding: utf-8 -*-
"""
Created on Fri Apr 30 23:08:43 2021

@author: jgdch
"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator(object):
#Space complexity:O(H)
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.stack=[]
        self.dfs(root)
        
    def dfs(self,root):
        while root:
            self.stack.append(root)
            root=root.left
    #O(N), worst case, O(1)-Average case       
    def next(self):
        """
        :rtype: int
        """
        top=self.stack.pop()
        if top.right:
            self.dfs(top.right)
        return top.val
        
    #O(1)
    def hasNext(self):
        """
        :rtype: bool
        """
        if len(self.stack):
            return True
        return False
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()