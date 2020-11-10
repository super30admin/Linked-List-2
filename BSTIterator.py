# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.array = []
        self.inorder(root)
        self.index = -1
    def inorder(self,root):
        if root:
            self.inorder(root.left)
            self.array.append(root.val)
            self.inorder(root.right)
        

    def next(self) -> int:
        """
        @return the next smallest number
        """
        self.index+=1
        return self.array[self.index]

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        if self.index+1<len(self.array):
            return True
        return False
        
# Time: O(n) = Inorder Traversal + Printing
# Space: O(n)

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()