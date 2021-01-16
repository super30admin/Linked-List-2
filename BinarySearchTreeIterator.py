#// Time Complexity : O(h)
#// Space Complexity : O(1)
#// Did this code successfully run on Leetcode :yes



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    stack=[]
    def __init__(self, root: TreeNode):
        self.stack=[]
        self.inorder(root)
        
    def inorder(self,root):
        while(root!=None):
            self.stack.append(root)
            root=root.left
        
    def next(self) -> int:
        top=self.stack.pop()
        self.inorder(top.right)
        return top.val
        
        

    def hasNext(self) -> bool:
        return (self.stack!=[])
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()

