#I used a stack-based approach to simulate an in-order traversal of the BST. In the constructor, I initialize an empty stack and call a helper method _left_tree_traverse to push all left nodes of the root onto the stack. This method traverses down the left side of any given node, pushing each node onto the stack. The next method pops the top node from the stack (which is the next smallest element), checks if this node has a right child, and if so, calls _left_tree_traverse on that right child to push its left subtree onto the stack. This ensures that the stack always contains the next elements in the correct order. The hasNext method simply checks if the stack is non-empty. This implementation achieves O(1) average time complexity for next and hasNext operations, and O(h) space complexity where h is the height of the tree.

class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self._left_tree_traverse(root)

    def next(self) -> int:
        node = self.stack.pop()
        if node.right:
            self._left_tree_traverse(node.right)
        return node.val

    def hasNext(self) -> bool:
        return bool(self.stack)
    
    def _left_tree_traverse(self, node: TreeNode) -> None:
        curr = node
        while curr:
            self.stack.append(curr)
            curr = curr.left