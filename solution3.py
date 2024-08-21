# time: O(n)
# space: O(n)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator(object):
    arr = []
    leng = 0
    ptr = 0
    def inorder(self, node):
        if not node:
            return
        self.inorder(node.left)
        self.arr.append(node.val)
        self.inorder(node.right)

    def __init__(self, root):
        self.arr = []
        self.leng = 0
        self.ptr = 0
        self.inorder(root)
        self.leng = len(self.arr)
        self.ptr = 0

    def next(self):
        if not self.hasNext():
            return
        element = self.arr[self.ptr]
        self.ptr += 1
        return element

    def hasNext(self):
        return self.ptr < self.leng
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()