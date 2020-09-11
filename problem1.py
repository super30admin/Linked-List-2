class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class BSTIterator:

    def __init__(self, root):
        self.stack = []
        while root:
            self.stack.append(root)
            root = root.left

    def next(self):
        """
        @return the next smallest number
        """
        if self.hasNext():
            current = self.stack.pop()
            head = current
            head = head.right
            while head:
                self.stack.append(head)
                head = head.left
            return current.val

    def hasNext(self):
        """
        @return whether we have a next smallest number
        """
        return len(self.stack) > 0

