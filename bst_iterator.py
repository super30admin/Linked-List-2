# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity: O(n)
# Space Complexity: O(n)

class BSTIterator(object):
    #     Mainatian global stack
    stack = []

    def __init__(self, root):
        #       In constructor we will move the root to the left most side as we are doing inorder
        while root:
            self.stack.append(root)
            root = root.left

        #         root = stack.pop()

        #             root = root.right

        """
        :type root: TreeNode
        """

    def next(self):
        #         While Iterator ask for next element in stack we will pop the node and chekc if it has righ tchild if so then we will go to that rightchild left subtree and upadte the root accordingly
        # and will return node value
        node = self.stack.pop()

        if node.right:
            root = node.right
            while root:
                self.stack.append(root)
                root = root.left

        return node.val

        """
        :rtype: int
        """

    def hasNext(self):
        #         In this function we willl just check if there are more elements left in stack

        return len(self.stack) > 0
        """
        :rtype: bool
        """

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()