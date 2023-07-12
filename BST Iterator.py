# Time complexity : O(1), for next and hasnext functions. For 75% of the nodes, the time complexity is O(1)
# Space complexity : O(1)

# The code ran on Leetcode

# Maintain a stack to control the recursion from processing all elements at once.

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
        # Add current node and all its left children to the stack
        while root:
            self.stack.append(root)
            root = root.left
        

    def next(self) -> int:
        # Pop the top element from stack. Move to right and add all its left children to the stack

        cur = self.stack.pop(-1)
        self.dfs(cur.right)

        return cur.val

    def hasNext(self) -> bool:
        return len(self.stack) > 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()