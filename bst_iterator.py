# Time Complexity:
# next(): O(1) amortized, O(h) in the worst case where h is the height of the tree
# hasNext(): O(1)
# Space Complexity: O(h) where h is the height of the tree

class BSTIterator:
    def __init__(self, root):
        self.stack = []
        self.push_all(root)

    def next(self):
        if self.hasNext():
            node = self.stack.pop()
            if node.right:
                self.push_all(node.right)
            return node.val
        return -1

    def hasNext(self):
        return bool(self.stack)

    def push_all(self, node):
        while node:
            self.stack.append(node)
            node = node.left
