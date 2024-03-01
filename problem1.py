# https://leetcode.com/problems/binary-search-tree-iterator/

# Time Complexity : O(N) where N is number of nodes
# Space Complexity : O(H) where H is height of the tree. In worst case it might be equal to N for skewed tree.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, one bug fixed it later.


# Your code here along with comments explaining your approach

# Approach : We first put all the nodes in the stack by traversing till the left. Whenever we remove a node we
# move one step to right and again add all the nodes on the left.

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


from typing import Optional


class BSTIterator:
    stack = []

    def __init__(self, root: Optional[TreeNode]):
        while root is not None:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        cur = self.stack.pop()
        self.updateStack(cur)
        return cur.val

    def hasNext(self) -> bool:
        if len(self.stack) > 0:
            return True
        return False

    def updateStack(self, cur):
        if cur.right is not None:
            self.stack.append(cur.right)
            cur = cur.right

            while cur.left is not None:
                self.stack.append(cur.left)
                cur = cur.left


# Create Tree
l = TreeNode(1, None, None)
r = TreeNode(2, l, None)

# Your BSTIterator object will be instantiated and called as such:
obj = BSTIterator(r)
while obj.hasNext():
    print(obj.next())
