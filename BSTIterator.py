# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    
    stack = list()
    def __init__(self, root: TreeNode):
        self.dfs(root)

    def next(self) -> int:
        result = self.stack.pop()
        self.dfs(result.right)
        return result.val

    def hasNext(self) -> bool:
        
        if self.stack:
            return True
        
        return False
    
    
    def dfs(self, root: TreeNode):
        while root is not None:
            self.stack.append(root)
            root = root.left

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()


#  Approach is to use dfs iteration. create a manual stack in the recursion for better control.
#  Time complexity is O(n) and space complexity is O(h)
