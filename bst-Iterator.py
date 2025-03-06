# DFS Approach
# TC - O(1)
# worst case TC - O(h)
# SC - O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        # call dfs
        self.dfs(root)

    def next(self) -> int:
        popped = self.stack.pop()
        # call dfs on right node of the popped element
        self.dfs(popped.right)
        return popped.val

    def hasNext(self) -> bool:
        return len(self.stack) > 0

    def dfs(self, root):
        if root is None: return
        self.stack.append(root)
        self.dfs(root.left)

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()