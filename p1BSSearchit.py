"""
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
"""
class Solution(object):
        def __init__(self, root):
            self.stack = []
            while root:
                self.stack.append(root)
                root = root.left

        # @return a boolean, whether we have a next smallest number
        def hasNext(self):
            return len(self.stack) > 0

        # @return an integer, the next smallest number
        def next(self):
            node = self.stack.pop()
            x = node.right
            while x:
                self.stack.append(x)
                x = x.left
            return node.val