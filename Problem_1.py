# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    """
    TC - O(1) ammortised
    SC - O(h)
    """

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.dfs(root)

    def next(self) -> int:
        node = self.stack.pop()
        self.dfs(node.right)
        return node.val

    def hasNext(self) -> bool:
        if len(self.stack) == 0:
            return False
        return True

    def dfs(self, toor):
        while toor != None:
            self.stack.append(toor)
            toor = toor.left

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()