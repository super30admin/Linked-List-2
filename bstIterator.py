# Time Complexity : O(N) 
# Space Complexity : O(HEIGHT) should be when height of the tree
# Did this code successfully run on Leetcode : Yes 
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    def __init__(self, root: TreeNode):
        self.stack = []
        #need to put to root to stack
        if root:
            self.stack.append(root)
            self.dfs(root)

    def next(self) -> int:
        """
        need to get top element and push the right node and it's left vals
        """
        if not self.hasNext():
            return -1
        
        top = self.stack.pop()
        if top.right:
            self.stack.append(top.right)
            self.dfs(top.right)
            
        return top.val
    
    def hasNext(self) -> bool:
        if not self.stack:
            return False
        return True
    
    def dfs(self, root):
        while root.left:
            self.stack.append(root.left)
            root = root.left
        return
# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()