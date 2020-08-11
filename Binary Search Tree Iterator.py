# Time Complexity : average - next - O(1)  and has next - 0 (1)
# Space Complexity : O(h) - height of the tree
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# we do controlled recursion, when initialized we traverse as dfs from root to the last left node and add to stack
# when next is called we pop the node from the stack and dfs the popped node.right
# dfs iterates till the leaf node and and push nodes to the stack


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: TreeNode):

        self.stack = []
        self.dfs(root)

    def next(self) -> int:
        """
        @return the next smallest number
        """
        node = self.stack.pop()

        self.dfs(node.right)

        return node.val

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        if len(self.stack) == 0:
            return False

        return True

    def dfs(self, node):

        while node is not None:
            self.stack.append(node)
            node = node.left

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()