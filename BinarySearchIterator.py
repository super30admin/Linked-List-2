#173. Binary Search Tree Iterator
"""
Time Complexity : O(1)
Space Conplexity : O(n)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.result = []
        self.helper(root)
        #print(self.result)
        self.idx = 0
        
    def helper(self, root):
        if root == None:
            return
        
        self.helper(root.left)
        self.result.append(root.val)
        self.helper(root.right)
        

    def next(self) -> int:
        
        self.idx = self.idx + 1
        return self.result[self.idx - 1 ]
        

    def hasNext(self) -> bool:
        if self.idx+1 <= len(self.result) :
            return True
        else:
            return False
            
        
        

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
