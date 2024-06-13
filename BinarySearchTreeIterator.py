# Time Complexity : O(n)
# Space Complexity : O(n)
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class BSTIterator:
    def __init__(self, root: TreeNode):
        self.list = deque()
        self._inorder(root)

    def _inorder(self, root: TreeNode):
        if root is None:
            return
        self._inorder(root.left)
        self.list.append(root.val)
        self._inorder(root.right)

    def next(self) -> int:
        return self.list.popleft()

    def hasNext(self) -> bool:
        return len(self.list) > 0

# Example 1
root1 = TreeNode(7, TreeNode(3), TreeNode(15, TreeNode(9), TreeNode(20)))
iterator1 = BSTIterator(root1)
print(iterator1.next())    # returns 3
print(iterator1.next())    # returns 7
print(iterator1.hasNext()) # returns True
print(iterator1.next())    # returns 9
print(iterator1.hasNext()) # returns True
print(iterator1.next())    # returns 15
print(iterator1.hasNext()) # returns True
print(iterator1.next())    # returns 20
print(iterator1.hasNext()) # returns False

# Example 2
root2 = TreeNode(5, TreeNode(3, TreeNode(2), TreeNode(4)), TreeNode(6))
iterator2 = BSTIterator(root2)
print(iterator2.next())    # returns 2
print(iterator2.next())    # returns 3
print(iterator2.hasNext()) # returns True
print(iterator2.next())    # returns 4
print(iterator2.hasNext()) # returns True
print(iterator2.next())    # returns 5
print(iterator2.hasNext()) # returns True
print(iterator2.next())    # returns 6
print(iterator2.hasNext()) # returns False

# Example 3
root3 = TreeNode(1)
iterator3 = BSTIterator(root3)
print(iterator3.next())    # returns 1
print(iterator3.hasNext()) # returns False