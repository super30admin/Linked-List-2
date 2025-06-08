# Time Complexity: O(1)
# Space Complexity: O(h) due to stack where h is height of the tree
# Iterators have a to be dynamic in nature
# It has unique feature lazy loading
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self._dfs(root)
    def _dfs(self, node: Optional[TreeNode]):
        while node:
            self.stack.append(node)
            node = node.left

    def next(self) -> int:
        node = self.stack.pop()
        self._dfs(node.right)
        return node.val

    def hasNext(self) -> bool:
        return len(self.stack)>0