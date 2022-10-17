# Time complexity: O(n)
# Space complexity: O(n)

# Code sucessfully ran on Leetcode

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.s = list()
        self.root = root
        self.dfs(self.root)

    def next(self) -> int:
        popped = self.s.pop()
        self.dfs(popped.right)
        return popped.val

    def hasNext(self) -> bool:
        if self.s:   return True
        return False
    
    def dfs(self, root):
        while root:
            self.s.append(root)
            root = root.left

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()