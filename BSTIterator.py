"""
TC: O(1) for next() and hasNext(), O(N) for creating iteratpr
SP: O(N) for storing inorder traversal

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.sorted = []
        self.pointer = -1
        self._inorder(root)
    def _inorder(self, root):
        if not root:
            return
        self._inorder(root.left)
        self.sorted.append(root.val)
        self._inorder(root.right)


    def next(self) -> int:
        self.pointer+=1
        return self.sorted[self.pointer]
        

    def hasNext(self) -> bool:
        return self.pointer+1 <len(self.sorted)
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()