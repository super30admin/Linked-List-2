"""
//Time Complexity : amortized O(1) for next method and 0(1) for hasnext
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.stack = []
        self.dfs(root)

    def next(self):
        """
        :rtype: int
        """
        #T.C = amortized O(1)
        #s.c= O(h)
        node=self.stack.pop()
        self.dfs(node.right)
        return node.val

    def hasNext(self):
        """
        :rtype: bool
        """
        
        return len(self.stack)!=0
    def dfs(self,root):
        
        while(root!=None):
            self.stack.append(root)
            root = root.left
        
            
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()