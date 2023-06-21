# Time and space complexity : O(n) and O(h)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    def __init__(self, root: Optional[TreeNode]):
        self.li = []
        self.i =0
        self.inorder(root)
    def inorder(self, root:[TreeNode]):
        if root is None:
            return
        #logic
        self.inorder(root.left)
        self.li.append(root.val)
        self.inorder(root.right)
        

    def next(self) -> int:
        result = self.li[self.i]
        self.i+=1
        return result

    def hasNext(self) -> bool:
        return self.i!=len(self.li)
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()