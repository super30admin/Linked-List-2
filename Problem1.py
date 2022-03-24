# Time Complexity : O(N)
# Space Complexity : O(N)
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
        self.nodes_values = []
        self.start_index = -1
        self._inorder(root)
        
    def _inorder(self,root):
        if not root:
            return
        self._inorder(root.left)
        self.nodes_values.append(root.val)
        self._inorder(root.right)
        
    def next(self):
        """
        :rtype: int
        """
        self.start_index += 1
        return self.nodes_values[self.start_index]
        
        

    def hasNext(self):
        """
        :rtype: bool
        """
        if len(self.nodes_values) > self.start_index+1:
            return True
        else:
            return False
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()