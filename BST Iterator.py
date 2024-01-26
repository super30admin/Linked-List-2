# Iterators do lazy loading and maintains the dynamic nature of the data structure

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

    def dfs(self, root: Optional[TreeNode]) -> None:
        while (root) :
            self.stack.append (root)
            root = root.left

    # TC - Amortized - O(1), 50% children have O(1), above 25% parents have O(1)
    def next(self) -> int:
        next = self.stack.pop()
        self.dfs(next.right)
        return next.val
        
    # TC - O(1) - Just checking if we have anything at the top of stack    
    def hasNext(self) -> bool:
        return len(self.stack) != 0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()