# Time Complexity: O(1) Amortized in the average case
# Space Complexity: O(h), where h is the height of the tree, Amortized O(1) ?

# The iterator helps manage iterations in a dynamic fashion as much as possible.

# For BST iterator inorder traversal, we can travers to the left-most leaf node by controlled recursion.
# Once there, we start popping the stack and take the recursion to the right of the popped node


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque

class BSTIterator:

    def dfs(self, root: Optional[TreeNode]) -> None:
        while (root is not None):
            self.st.append(root)
            root = root.left
    
    def __init__(self, root: Optional[TreeNode]):
        self.st = deque()
        self.dfs(root)
        

    def next(self) -> int:
        curr = self.st.pop()
        temp = curr.val
        self.dfs(curr.right)
        return temp

        

    def hasNext(self) -> bool:
        return len(self.st) > 0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
