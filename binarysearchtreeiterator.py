##Time Complexity : O(1)
##Space Complexity : O(1)
##Did this code successfully run on Leetcode : Yes
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
        self.push_left(root)
        

    def next(self):
        """
        :rtype: int
        """
        node = self.stack.pop()
        self.push_left(node.right)
        return node.val

        

    def hasNext(self):
        """
        :rtype: bool
        """
        return self.stack
    
    def push_left(self, root):
        while root:
            self.stack.append(root)
            root = root.left
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()