#tc: O(h) , h is height
#sc: O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        # self.li = []
        # self.idx = 0
        self.stack = []
        self.helper(root)
        
    def helper(self,root):
        while root != None:
            self.stack.append(root)
            root = root.left
        # if root is None: return
        # self.inorder(root.left)
        # self.li.append(root.val)
        # self.inorder(root.right)
    
    def next(self) -> int:
        Node = self.stack.pop()
        self.helper(Node.right)
        return Node.val
        # ele = self.li[self.idx]
        # self.idx += 1
        # return ele

    def hasNext(self) -> bool:
        return len(self.stack) > 0
        # return self.idx != len(self.li)


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()