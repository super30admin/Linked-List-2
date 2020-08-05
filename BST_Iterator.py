# Leetcode 173. Binary Search Tree Iterator

# Time Complexity :  Ammortized :: O(1)  Worst O(n) is the number of nodes

# Space Complexity : O(h) where h is the height of the tree

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Using DFS we traverse to the left most leaf node and from their we recurrsively traverse
# right child of each node in a controlled manner by popping the stack for a node at every step and applying
# DFS on its right child. In worst case scenario if the tree is skewed we might have to traverse the entire
# depth. hasNext function checks if the stack is empty when its called.

# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: TreeNode):
        # Stack for storing the elemenets in the tree
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
        if len(self.stack) > 0:
            return True
        else:
            False

    # function for traversing the tree Depth wise
    def dfs(self, root):
        while root:
            self.stack.append(root)
            root = root.left


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
