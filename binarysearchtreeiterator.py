# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Space Complexity: O(h)
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.dfs(root)

    def dfs(self, root):
        while root:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:  # Time Complexity: O(1)
        popped = self.stack.pop()
        self.dfs(popped.right)
        return popped.val

    def hasNext(self) -> bool:  # Time Complexity: O(1)
        return len(self.stack) > 0

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()