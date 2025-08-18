# Time Complexity:
#   - Constructor: O(n)
#   - next(): O(1)
#   - hasNext(): O(1).
# Space Complexity: O(n)

class BSTIterator:
    def __init__(self, root: Optional[TreeNode]):
        self.arr = []      # Store inorder traversal
        self.idx = 0       # Pointer to current index
        self.helper(root)  # Fill the array with inorder nodes

    def helper(self, root: Optional[TreeNode]) -> None:
        # Standard inorder traversal: Left -> Root -> Right
        if root is None: 
            return
        self.helper(root.left)
        self.arr.append(root.val)
        self.helper(root.right)

    def next(self) -> int:
        # Return current element and advance pointer
        val = self.arr[self.idx]
        self.idx += 1
        return val

    def hasNext(self) -> bool:
        # True if there are still elements left in the array
        return self.idx < len(self.arr)
