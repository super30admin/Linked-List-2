'''
Time Complexity : O(1) : amortized 
Space Complexity : O(h) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :  No
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root):
        self.li = []
        self.idx = 0
        self.inorder(root)
    
    def inorder(self, root):
        # base
        if root is None:
            return

        # logic
        self.inorder(root.left)
        self.li.append(root.val)
        self.inorder(root.right)
        

    def next(self) -> int:
        re = self.li[self.idx]
        self.idx += 1
        return re

    def hasNext(self) -> bool:
        return len(self.li) > self.idx
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()