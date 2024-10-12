# 173. Binary Search Tree Iterator
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def init(self,root):
        while root != None:
            self.stack.append(root)
            root = root.left

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.init(root)
        
    def next(self) -> int:
        if self.hasNext():
            temp = self.stack.pop()
            self.init(temp.right)
            return temp.val
        return -1
        

    def hasNext(self) -> bool:
        return 0 if len(self.stack)==0 else 1
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()