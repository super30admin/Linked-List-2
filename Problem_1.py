# Time Complexity: O(n) for __init__, O(1) for next, O(1) for hasNext
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

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
        self.pushUntilNone(root)

    def next(self):
        """
        :rtype: int
        """
        root = self.stack.pop()
        self.pushUntilNone(root.right)
        return root.val

    def hasNext(self):
        """
        :rtype: bool
        """
        return self.stack

    def pushUntilNone(self, root):
        while root:
            self.stack.append(root)
            root = root.left

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()