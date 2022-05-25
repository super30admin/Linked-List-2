# Time Complexity : O(N) where N is number of nodes in the Binary Tree
# Space Complexity : O(H) where H is height of the Binary Tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stk = []
        self.dfs(root)

    def next(self) -> int:
        node = self.stk.pop()
        self.dfs(node.right)
        return node.val

    def hasNext(self) -> bool:
        return False if len(self.stk) == 0 else True
        
    def dfs(self, root):
        while root is not None:
            self.stk.append(root)
            root = root.left


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()