# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.lis=[]
        
        while root:
            self.lis.append(root)
            root=root.left
        
    def next(self) -> int:
        temp=self.lis.pop()
       
        if temp.right:
            root1=temp.right
            while root1:
                self.lis.append(root1)
                root1=root1.left
                
        return temp.val

    def hasNext(self) -> bool:
        if len(self.lis)>0:
            return True
        else:
            return False
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()