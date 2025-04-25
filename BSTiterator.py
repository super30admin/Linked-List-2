# Approach:
# Eager Evaluation - Use in-order traversal to flatten the BST into a list at initialization.
# Lazy Evaluation  - Use a stack to perform in-order traversal on-demand.
#
# Time Complexity:
# Eager: O(n) for constructor, O(1) for next() and hasNext()
# Lazy : O(1) on average for next() and hasNext() amortized over n operations
#
# Space Complexity:
# Eager: O(n) to store in-order traversal
# Lazy : O(h), where h is the height of the tree (stack)

from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class BSTIterator:
    def __init__(self, root: Optional[TreeNode]):
        self.result = []
        self.idx = 0
        self.dfs(root)

    def dfs(self, root: Optional[TreeNode]):
        if not root:
            return
        self.dfs(root.left)
        self.result.append(root.val)
        self.dfs(root.right)

    def next(self) -> int:
        val = self.result[self.idx]
        self.idx += 1
        return val

    def hasNext(self) -> bool:
        return self.idx < len(self.result)


class LazyBSTIterator:
    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.dfs(root)

    def dfs(self, root: Optional[TreeNode]):
        while root:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        temp = self.stack.pop()
        self.dfs(temp.right)
        return temp.val

    def hasNext(self) -> bool:
        return len(self.stack) > 0


root = TreeNode(7)
root.left = TreeNode(3)
root.right = TreeNode(15)
root.right.left = TreeNode(9)
root.right.right = TreeNode(20)

print("Eager Evaluation:")
eager = BSTIterator(root)
while eager.hasNext():
    print(eager.next(), end=" ")
print("\n")

print("Lazy Evaluation:")
lazy = LazyBSTIterator(root)
while lazy.hasNext():
    print(lazy.next(), end=" ")
