# Time Complexity : amortized O(1)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Initialize a stack and perform dfs on root node in init()
# In dfs add the root to stack and perform dfs on left nodes
# In the next function, pop the first element from the stack  and we need to perform dfs on right of that node which is popped then return the popped value
# In the hasNext function, check if the stack is not empty return True else return False


class Solution:
    def __init__(self, root: TreeNode | None):
        self.stack = []
        self.dfs(root)

    def dfs(self, root):
        while root:
            self.stack.append(root)
            root = root.left


    def next(self) -> int:
        node = self.stack.pop()
        self.dfs(node.right)
        return node.val


    def hasNext(self) -> bool:
        return len(stack) > 0

