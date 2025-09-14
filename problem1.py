# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
"""
Space Complexity: Amortized O(1)

Time Complexity: O(N)
"""


class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = collections.deque()
        self.dfs(root)
    
    def dfs(self, curr):
        while curr != None:
            self.stack.append(curr)
            curr = curr.left

    def next(self) -> int:
        popped = self.stack.pop()
        self.dfs(popped.right)
        return popped.val

    def hasNext(self) -> bool:
        return len(self.stack) > 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
