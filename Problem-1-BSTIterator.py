# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class BSTIterator:
    stack = []

    def __init__(self, root):

        while root != None:
            self.stack.append(root)
            root = root.left

    def next(self) :
        curr = self.stack.pop()
        if curr.right != None:
            root = curr.right
            while root != None:
                self.stack.append(root)
                root = root.left
        return curr.val

    def hasNext(self) :
        return (len(self.stack) > 0)

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()





