"""
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Time : For next function = O(1) , For hasNext function = O(1)
space : O(1)
Successfully excecuted on leetcode


Approach --
1. Traverse the BST in inorder, for each node processed add it to result array.
2. After we have all the nodes in the array, for next function we pop the element at ondex 0 
3. For hasnext function we return True is resuly array is not empty, else False
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class BSTIterator:
    def __init__(self,root):
        self.res = []
        self.inorder(root)
        
    def inorder(self,root):
        if not root:
            return
        self.inorder(root.left)
        self.res.append(root.val)
        self.inorder(root.right)
        
    def next(self):
        if self.res:
            return self.res.pop(0)
    
    def hasNext(self):
        if self.res:
            return True
        return False
        