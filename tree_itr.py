# The BSTIterator class provides an iterator for a binary search tree (BST) that returns elements in sorted order using in-order traversal.

# Initialization (__init__):
#   - Sets up an in-order traversal generator (`self.iter`) for the BST.
#   - Initializes `self.nxt` to the first value from the generator or None if the BST is empty.

# Helper Function (_inorder):
#   - Performs an in-order traversal of the BST:
#       - Traverses the left subtree, yields the current node's value, and then traverses the right subtree.
#   - Yields values lazily using a generator.

# next():
#   - Returns the next smallest element in the BST.
#   - Updates `self.nxt` to the next value from the generator or None if traversal is complete.

# hasNext():
#   - Checks if there are more elements in the traversal by verifying if `self.nxt` is not None.

# TC:
#   - next(): O(1) amortized, as each node is processed once over the traversal.
#   - hasNext(): O(1), simple check for remaining elements.
#   - Initialization: O(n), processes all nodes during traversal.

# SC: O(h), where h is the height of the tree, due to the recursion stack during in-order traversal.


from typing import Optional


class BSTIterator:
    def __init__(self, root: Optional[TreeNode]):
        self.iter = self._inorder(root)
        self.nxt = next(self.iter, None)
    
    def _inorder(self, node: Optional[TreeNode]) -> Generator[int, None, None]:
        if node:
            yield from self._inorder(node.left)
            yield node.val
            yield from self._inorder(node.right)

    def next(self) -> int:
        res, self.nxt = self.nxt, next(self.iter, None)
        return res

    def hasNext(self) -> bool:
        return self.nxt is not None