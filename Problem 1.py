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
        
    # O(n) # BST can be skewed
    def next(self):
        """
        :rtype: int
        """
        top = self.stack.pop()
        self.dfs(top.right)
        return top.val
        
    # O(1)
    def hasNext(self):
        """
        :rtype: bool
        """
        if len(self.stack) != 0:
            return True
        else:
            return False
    def dfs(self, node):
        if node == None:
            return
        self.stack.append(node)
        self.dfs(node.left)
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
