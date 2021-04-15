# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Amortized Time complexities for next and hasnext is O(1).
# Time Complexity is O(h)
# Perform Iterative Inorder Traversal in a controlled manner to achieve O(1) amortized time Complexity
class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.stack = []
        while(root):
            self.stack.append(root)
            #self.stack2.append(root.val)
            root = root.left
            

    def next(self):
        """
        :rtype: int
        """
        popped = self.stack.pop()
        right = popped.right
        while(right):
            self.stack.append(right)
            right = right.left
        return popped.val

    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.stack) != 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()