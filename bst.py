
# Worse-case time O(h), O(h) space
# amortized time (average case time complexity) O(1):
#  - bottom level of tree - n nodes in a tree - n/2 leaf nodes. 50% of nodes are O(1)
#  - 2nd last row to bottom - 25% of nodes - O(1)
#  - therefore 75% of nodes have O(1) time complexity 
#
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    # [20]
    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        dfs(self, root)

    def dfs(self, root):
        while root != None:
            self.stack.push(root)
            root = root.left
    def next(self) -> int: # O(h)
        result = self.stack.pop()
        dfs(result.right)
        return result.val

    def hasNext(self) -> bool: #O(1)
        return len(self.stack) != 0