'''
Time complexity: O(N)
Space complexity: O(max_depth)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []
        self.dfs(root)
    
    def dfs(self, root):
        while root:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        if self.hasNext() is False:
            return -1
        root = self.stack.pop()
        self.dfs(root.right)
        return root.val

    def hasNext(self) -> bool:
        return len(self.stack) != 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()