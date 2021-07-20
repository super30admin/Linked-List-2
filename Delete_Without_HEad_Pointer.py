# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# from collections import deque
#Space:O(1)
#time:O(1)
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []
        if root:
            self.left_traverse(root)
        else:
            return None
    
    def left_traverse(self,root):
        while(root):
            self.stack.append(root)
            root = root.left
        
        

    def next(self) -> int:
        add = self.stack.pop()
        if add.right:
            self.left_traverse(add.right)
        return add.val
            
        

    def hasNext(self) -> bool:
        return True if self.stack else False
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()