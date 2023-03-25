# Time Complexity: O(n) n are all nodes in tree
# Space Complexity: O(H) where H is the height of the tree, which could also be n in the worst case

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        # node = root
        while root:
            self.stack.append(root)
            root = root.left
        # print(self.stack)

    def next(self) -> int:
        node = self.stack.pop()
        print(node.val)
        node_r = node.right
        while node_r:
            self.stack.append(node_r)
            node_r = node_r.left
        return node.val

    def hasNext(self) -> bool:
        return True if self.stack else False

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()