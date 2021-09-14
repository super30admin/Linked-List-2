# // Time Complexity : O(1) avergae - O(h) worst case where n stand for length of the two lists 
# // Space Complexity : O(h) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 

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
        
    def next(self) -> int:
        top = self.stack.pop()
        self.dfs(top.right)
        return top.val
    
    def hasNext(self) -> bool:
        return len(self.stack)
        
    def dfs(self,root):
        while root:
            self.stack.append(root)
            root = root.left
        

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()