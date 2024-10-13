# Time Complexity = O(1) | Space Complexity = O(1)

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class BSTIterator:
    st = []

    def __init__(self, root: TreeNode):
        self.inorder_traversal(root)

    def inorder_traversal(self, root: TreeNode):
        while root is not None:
            self.st.append(root)
            root = root.left

    def next(self) -> int:
        temp = self.st.pop()
        self.inorder_traversal(temp.right)
        return temp.val

    def hasNext(self) -> bool:
        if self.st:
            return True
        else:
            return False

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()