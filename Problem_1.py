# // Time Complexity : O(n)
# // Space Complexity : O(h)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        
        self.stack = []
        self.stackLeft(root)

  
    def stackLeft(self,root):
        while(root is not None):
            self.stack.append(root)
            root = root.left
      
    def next(self) -> int:
        
        root = self.stack.pop()
        result = root

        if(root.right):
            
            root = root.right
            self.stackLeft(root)

        return result.val  

    def hasNext(self) -> bool:
        if(len(self.stack)>0):
            return True
        return False
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()