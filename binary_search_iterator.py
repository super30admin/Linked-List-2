# TC : O(N)
# SC : O(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.sorted_nodes = []
        self.index = -1
        self._inorder(root)
    
    def _inorder(self, root):
        if not root:
            return
        self._inorder(root.left)
        self.sorted_nodes.append(root.val)
        self._inorder(root.right)

    def next(self) -> int:
        self.index+=1
        return self.sorted_nodes[self.index]

    def hasNext(self) -> bool:
        return self.index + 1 < len(self.sorted_nodes)


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()