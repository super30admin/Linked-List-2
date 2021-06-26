"""
Time Complexity : for the funcation hasNext() - O(1). 
                : for the funcation next() - Worst case: O(h) and Average case: O(1)
Space Complexity : O(h).
    
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: TreeNode):
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
        return len(self.stack) != 0
        

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()