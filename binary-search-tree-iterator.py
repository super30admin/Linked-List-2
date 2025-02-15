# Time Complexity : O(1) for hasNext()
#                   O(1) for next() - avg case
#                   o(n) for next() - worst case
# Space Complexity : O(n) - for stack to store the nodes
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
Do controlled recursion
"""


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator(object):
    result = []

    def __init__(self, root):
        """
        :type root: Optional[TreeNode]
        """
        self.dfs(root)

    def dfs(self, root):
        while root is not None:
            self.result.append(root)
            root = root.left

    def next(self):
        """
        :rtype: int
        """

        res = self.result[-1]
        self.result.pop()
        self.dfs(res.right)
        return res.val

    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.result) != 0

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()