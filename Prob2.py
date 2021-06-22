#Time complexity: O(n)
#Space complexity: O(n)
# Did this code successfully run on Leetcode : Yes
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
        #do dfs and move only on the left and add all left elements in the stack
        self.stack = []
        self.dfs(root)

    def next(self):
        """
        :rtype: int
        """
        # in every next call, pop the node, do dfs on the right of the popped element so that is added to stack
        # O(1) average case, O(n) or O(h) worst case
        node = self.stack.pop()
        self.dfs(node.right)
        return node.val
    
    def dfs(self,root):
        while root is not None:
            self.stack.append(root)
            root = root.left

    def hasNext(self):
        """
        :rtype: bool
        """
        #O(1)
        return len(self.stack) != 0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()