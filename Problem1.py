#Time Complexity - O(1)
#Space Complexity - O(1)
#Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.root = root
        self.stack = []
        self.iter(root)

    def iter(self, root):
        while root is not None:
            self.stack.append(root)
            root = root.left
    
    def next(self) -> int:
        n = self.stack.pop()
        self.iter(n.right)
        return n.val

    def hasNext(self) -> bool: 
        return len(self.stack) != 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()