class BSTIterator:
    
    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.dfs(root)

    def dfs(self, root): # First putting all the elements till left root is None
        while root != None:
            self.stack.append(root)
            root = root.left
    def next(self) -> int: # Time Complexity: O(n) because call for dfs func made
        popped = self.stack.pop()
        self.dfs(popped.right) # If element on the right exist then putting it in the stack
        return popped.val

    def hasNext(self) -> bool: # Time Complexity:: O(1). Just need to check len(stack)
        return len(self.stack) != 0

# Space Complexity: O(n) because stack is used to store the elements

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()