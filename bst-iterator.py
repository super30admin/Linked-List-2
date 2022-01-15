# Time Complexity : O(1) average
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes

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
        self.stack = []  # a stack to perform recursion
        self.leftmost_inorder(root)

    def leftmost_inorder(self, root):

        # add all the elements in the leftmost branch of the tree under it to the stack.
        while root:
            self.stack.append(root)
            root = root.left

    def next(self):
        """
        :rtype: int
        """
        # top of the stack is the next smallest element
        top_node = self.stack.pop()

        # if the node has a right child, call the helper function for the right child
        if top_node.right:
            self.leftmost_inorder(top_node.right)
        return top_node.val

    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.stack) > 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
