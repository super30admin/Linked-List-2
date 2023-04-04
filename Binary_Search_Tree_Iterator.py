# Time Complexity : O(h) for __init__
#                   O(h) for next
#                   O(1) for hasNext
# Space Complexity : O(h)

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class BSTIterator:
    def __init__(self, root: TreeNode):
        self.stack = []
        self.push_left_nodes(root)

    def next(self) -> int:
        node = self.stack.pop()
        self.push_left_nodes(node.right)
        return node.val

    def hasNext(self) -> bool:
        return len(self.stack) > 0
    
    def push_left_nodes(self, node):
        while node:
            self.stack.append(node)
            node = node.left