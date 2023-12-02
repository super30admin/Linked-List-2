# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    stack=[]

    def init(self,root):
        if not root:
            return
        self.stack.append(root)
        self.init(root.left)

    def __init__(self, root: Optional[TreeNode]):
        self.init(root)
        

    def next(self) -> int:
        top = self.stack.pop()
        val = top.val
        self.init(top.right)
        return val
        

    def hasNext(self) -> bool:
        if len(self.stack) >0:
            return True

        return False
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()