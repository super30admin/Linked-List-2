#Time Complexity: O(H)
#Space Complexity: O(H)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        # Initialize the stack and push all left nodes of the root
        self.stack = []
        self._leftmost_inorder(root)
    
    def _leftmost_inorder(self, node):
        # Push all the leftmost nodes of the tree to the stack
        while node:
            self.stack.append(node)
            node = node.left
        

    def next(self) -> int:
        # Pop the top node from the stack
        topmost_node = self.stack.pop()

        # If there is a right child, we push all of its left children onto the stack
        if topmost_node.right:
            self._leftmost_inorder(topmost_node.right)

        return topmost_node.val
        

    def hasNext(self) -> bool:
        # If stack is not empty, there are still nodes to be visited
        return len(self.stack) > 0
        

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()