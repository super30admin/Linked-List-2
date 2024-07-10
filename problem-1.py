# Time Complexity :
# worst case :O(n), avg case : O(1)
# space complexity : O(h)

# Approach :

#  create a stack
#  call a dfs traversal and keep traversing left in the constructor and keep appending to the stack
#  next function, pops a value from the stack and checks if right child is present, if so do a dfs on it
#  hastNext function returns self.stack is empty or not

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.dfs(root)

    def dfs(self, root):

        while root is not None:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:

        poppedVal = self.stack.pop()
        self.dfs(poppedVal.right)
        return poppedVal.val

    def hasNext(self) -> bool:

        return self.stack
