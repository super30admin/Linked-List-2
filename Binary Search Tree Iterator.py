# Time Complexity :
# TC: O(H)

# Space Complexity :
# SC: O(1)

# Did this code successfully run on Leetcode :
# Yes

# Any problem you faced while coding this :
# No

# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    
    # TC: O(h)
    # SC: O(1)

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        
        # Fill the stack till 3
        self.dfs(root)
        
    def dfs(self, root):
        while (root != None):
            self.stack.append(root)
            root = root.left
        
    def next(self) -> int:
        
        # TC: O(h)
        # SC: O(1)
        
        cuurNode = self.stack.pop()
        self.dfs(cuurNode.right)
        return cuurNode.val

    def hasNext(self) -> bool:
        
        # TC: O(1)
        # SC: O(1)
        
        return len(self.stack) > 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()