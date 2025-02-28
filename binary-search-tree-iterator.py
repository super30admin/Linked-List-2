# The code implements an iterator for a Binary Search Tree (BST) using inorder traversal (left-root-right) 
# to store values in sorted order, allowing next() to return the next smallest element and hasNext() to check availability.

# Time Complexity:
# O(N) for __init__() (inorder traversal stores all nodes).
# O(1) for next() and hasNext() (simple list operations).
# Space Complexity: O(N) (stores all N nodes in nodes_sorted).
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.nodes_sorted = []
        self.index = -1
        self._inorder(root)

    def _inorder(self, root: TreeNode) -> None:
        if not root:
            return
        self._inorder(root.left)
        self.nodes_sorted.append(root.val)
        self._inorder(root.right)

    def next(self) -> int:
        self.index += 1
        return self.nodes_sorted[self.index]
        

    def hasNext(self) -> bool:
        return self.index +  1 < len(self.nodes_sorted)
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()