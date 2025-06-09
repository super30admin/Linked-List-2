# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Intuition - We try to do a controlled recursion on the left half of root so that we can pop the next element from the stack. Once we have popped the next element from the stack we do controlled recursion on the left half of the right child.

class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []                 # Space complexity - o(h)
        self.dfs(root)

    def dfs(self,root):                 # Time complexity - o(1)
        if root:
            self.stack.append(root)
            self.dfs(root.left)

    def next(self) -> int:              # Time complexity - o(1)

        nxt = self.stack.pop()
        self.dfs(nxt.right)
        return nxt.val

    def hasNext(self) -> bool:          # Time complexity - o(1)

        return False if len(self.stack)==0 else True
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()