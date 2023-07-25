# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    # Time Complexity:O(n)
    # Space Complexity:O(n)
    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.left_inorder(root)

    def left_inorder(self, node):
        while node:
            self.stack.append(node)
            node = node.left

    def next(self) -> int:
        curr_node = self.stack.pop()
        if curr_node.right:
            self.left_inorder(curr_node.right)
        return curr_node.val

    def hasNext(self) -> bool:
        return len(self.stack) > 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
