# We'll use a basic TreeNode class for the BST node:
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class BSTIterator(object):
    def __init__(self, root):
        """
        :type root: TreeNode
        :rtype: None
        """
        self.stack = []
        
        self._push_left(root)
    
    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.stack) > 0

    def next(self):
        """
        :rtype: int
        Returns the next smallest element in the BST.
        """
        node = self.stack.pop()
        
        if node.right:
            self._push_left(node.right)
        
        return node.val
    
    def _push_left(self, node):
        while node:
            self.stack.append(node)
            node = node.left
