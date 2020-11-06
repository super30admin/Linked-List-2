"""
Time Complexity : O(1) 
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
An iterator computes one value at a time. We cannot precompute all the values, so we called do 
inorder traversal and then keep on returning the values. This is a controlled recursion problem
as we need to pause recursion where we want. This is basically a design problem. So, we maintain a stack
for storing the values with smallest value on the top. In the constructor, we store the values till
the leftmost leaf for first iteration. Afterwards, whenever next() function is called, we pop the topmost
value, and call dfs on the right child if it has one.

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
        @return the next smallest number
        :rtype: int
        """
        value = self.stack.pop()
        self.dfs(value.right)
        return value.val

    def hasNext(self):
        """
        @return whether we have a next smallest number
        :rtype: bool
        """
        if self.stack:
            return True
        return False

    def dfs(self, root):
        if root:
            self.stack.append(root)
            self.dfs(root.left)


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
