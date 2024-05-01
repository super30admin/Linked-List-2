# Linked-List-2

## Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)

# Approach
# We will use controlled recursion. Create stack. When helper function is called, while root: append root to stack. root = root.left
# Node at the top of the stack is the next smallest element. Pop topmost element. If the node has a right child, call the helper function for the right child. return topmostode.val 
# In hasnext function return True if stack has elements else return False

# Time Complexity: O(1)
# Space Complexity: O(n)
# Did this code successfully run on Geeks for Geeks : Yes
# Any problem you faced while coding this : No


class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []

        self._leftmost_inorder(root)

    def _leftmost_inorder(self, root: TreeNode) -> None:

        while root:
            self.stack.append(root)
            root = root.left


    def next(self) -> int:
        topmost_node = self.stack.pop()

        if topmost_node.right:
            self._leftmost_inorder(topmost_node.right)
        return topmost_node.val
        

    def hasNext(self) -> bool:
        return len(self.stack) > 0