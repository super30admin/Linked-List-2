# Problem 173.BINARY TREE ITERATOR
# TIME COMPELXITY: 
    #hasNext(): O(1) as it only checks the length of the stack, which is an instantaneous operations
    #next():O(1)is the amortized time complexity as every node in the tree is pushed and popped exactly exactly once across the
    #entire traversal
# SPACE COMPLEXITY: O(H) where H is the height of tree

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
        temp = self.st.pop()
        self.dfs(temp.right)
        return temp.val
        

    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.st) > 0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()