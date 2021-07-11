# Time Complexity: O(1), amortized
# Space Complexity: O(h), where h is the height of the tree
# Did this code successfully run on Leetcode : Yes

# Solution:

class BSTIterator:
    # Initialize the stack and push the root node with its left children
    def __init__(self, root: TreeNode):
        self.stack = []
        self.dfs(root)

    # Return the top value from the stack and push all the left children for its right child
    def next(self) -> int:
        if not self.hasNext():
            return -1
        popped = self.stack.pop()
        self.dfs(popped.right)
        return popped.val

    # When the stack is not empty, the node has a next value
    def hasNext(self) -> bool:
        return len(self.stack) > 0

    # Function to push the node and all its left children into the stack
    def dfs(self, root: TreeNode) -> None:
        while root:
            self.stack.append(root)
            root = root.left

