#TimeComplexity:O(N) 
#SpaceComplexity: O(N)
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.inorder=[] #list to store inorder traversal
        self.index=-1 #index of list
        self._inorder(root) #method to get inorder traversal
        
    def _inorder(self,root):
        #print('hi')
        if root==None:
            return
        self._inorder(root.left)
        self.inorder.append(root.val)
        self._inorder(root.right)
        

    def next(self) -> int:
        self.index+=1
        return self.inorder[self.index]

    def hasNext(self) -> bool:
        return (self.index+1<len(self.inorder))

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()