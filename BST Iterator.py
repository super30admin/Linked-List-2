'''
Time Complexity: O(n)
Space Complexity: O(1)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    # stack = []
    def __init__(self, root: TreeNode):
        self.stack = []
        self.dfs(root)

    def dfs(self, root):
        while root is not None:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        if self.hasNext() == False:
            return -1
        root = self.stack.pop()
        self.dfs(root.right)
        return root.val

    def hasNext(self) -> bool:
        if not self.stack:
            return False
        return True

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()