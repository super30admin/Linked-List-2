"""
Problem: 173. Binary Search Tree Iterator
Leetcode: https://leetcode.com/problems/binary-search-tree-iterator/
Solution: Iterate the tree in inorder traversal and push all left elements to stack.
    - When 'next' is called, pop the elements and push the right subtree
Time Compelxity: O(N) since we need to traverse all nodes
Space Complexity: O(h), h is height, since we maintain a custom stack for simulating the inorder traversal
"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class BSTIterator:
    def __init__(self, root: TreeNode):
        self.stack = []
        self.dfs(root)

    def next(self) -> int:
        """
        @return the next smallest number
        """
        # If there is not next element
        if not self.hasNext:
            return -1
        node = self.stack.pop()
        if node.right:
            self.dfs(node.right)
        return node.val

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return len(self.stack) > 0

    def dfs(self, root: TreeNode):
        while root is not None:
            self.stack.append(root)
            root = root.left

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()