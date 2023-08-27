# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.root = root
        self.i = 0
        self.li = []

        self.inorder(self.root)
        
    def inorder(self,root):
        if root == None:
            return 
        self.inorder(root.left)
        self.li.append(root.val)
        self.inorder(root.right)


    def next(self) -> int:
        return self.li.pop(self.i)
        self.i += 1
        

    def hasNext(self) -> bool:
        if self.i != len(self.li):
            return True
        else:
            return False
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()