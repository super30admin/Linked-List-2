# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

"""
TC: O(n)
SC: O(n)
"""

from collections import deque 
class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        res = deque()
        def inorder(node,res):
            if not node:
                return
            if node.left:
                inorder(node.left,res)
            res.append(node.val)
            if node.right:
                inorder(node.right,res)
        inorder(root,res)
        self.output = res
            
        

    def next(self):
        """
        :rtype: int
        """
        return self.output.popleft()
        

    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.output) > 0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
