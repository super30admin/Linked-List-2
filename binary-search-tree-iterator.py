# Using controlled recursion
# Time Complexity: O(1)
# Space Complexity: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    # We use a stack to keep track of all the left element first
    def __init__(self, root: TreeNode):
        self.st = []
        self.dfs(root)
    
    # dfs function creates a stack with all the left elements
    # This is constant time as it is taking place in the constructor
    def dfs(self, root):
        while root:
            self.st.append(root)
            root = root.left
    
    # Whenever next is called, topmost node is popped and saved in node and return the value 
    # Check if the node that is popped has a right child
    # If yes, then call dfs on the right child again
    def next(self) -> int:
        node = self.st.pop()
        if node.right:
            self.dfs(node.right)
        return node.val

    # If the stack is empty, return false or else return true
    def hasNext(self) -> bool:
        if self.st:
            return True
        return False
        
    
            
        
# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()