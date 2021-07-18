#Time Complexity: O(N).
#Auxiliary Space: O(N)
#Did this code successfully run on Leetcode :Yes

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
        self.leftmost_inorder(root)
        
    def leftmost_inorder(self,root):
        while root:
            self.stack.append(root)
            root = root.left

    def next(self):
        """
        :rtype: int
        """
        top = self.stack.pop()
        if top.right:
            self.leftmost_inorder(top.right)
        return top.val

    def hasNext(self):
        """
        :rtype: bool
        """
        return  len(self.stack) >0
            


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()