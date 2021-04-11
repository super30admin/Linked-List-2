# Time Complexity: O(n)
# Space Complexity: O(h) where h is height of the tree
# Ran on Leetcode: Yes

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
        

    def next(self) -> int:
        popped = self.stack.pop()
        self.dfs(popped.right)
        return popped.val
        

    def hasNext(self) -> bool:
        return len(self.stack) != 0 
        
    def dfs(self, node):
        while node:
            self.stack.append(node)
            node = node.left
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()