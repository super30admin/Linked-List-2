# Time Complexity: O(1) -> amortized cost, O(h) -> worse case
# Space Complexity: O(h) -> where h is height of tree
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No


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
        if self.stack:
            node = self.stack.pop()
            self.dfs(node.right)
        return node.val
    
    def hasNext(self):
        """
        :rtype: bool
        """
        return True if len(self.stack)>0 else False
    
    def dfs(self, root):
        while root:
            self.stack.append(root)
            root = root.left

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()