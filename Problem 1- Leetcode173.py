#Time Complexity: O(1) for next() and hasNext(), O(h) for the constructor where h is the height of the tree
#Space Complexity: O(h) where h is the height of the tree

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: Optional[TreeNode]
        """
        self.st = []
        self.dfs(root)

    def dfs(self, root):
        while root:
            self.st.append(root)
            root = root.left        

    def next(self):
        """
        :rtype: int
        """
        node = self.st.pop()
        self.dfs(node.right)
        return node.val
        

    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.st) > 0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()