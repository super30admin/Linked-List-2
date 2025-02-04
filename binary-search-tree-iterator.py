# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stk = []
        self._dfs(root)
#Time Complexity : O(n)
#Space Complexity : O(1)
    def _dfs(self, root):
        while root != None:
            self.stk.append(root)
            root = root.left
#Time Complexity : O(1)
#Space Complexity : O(1)
    def next(self) -> int:
        popped = self.stk.pop()
        self._dfs(popped.right)
        return popped.val
#Time Complexity : O(1)
#Space Complexity : O(1)
    def hasNext(self) -> bool:
        return len(self.stk) != 0

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()