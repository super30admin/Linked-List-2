#Time Complexity : O(n)
#Space Complexity : O (logn n)
#Did this code successfully run on Leetcode : yes
class BSTIterator:
    def __init__(self, root):
        self.stack = []
        self.root = root
        
    def next(self):
        while self.root:
            self.stack.append(self.root)
            self.root = self.root.left
        node = self.stack.pop()
        res = node.val
        self.root = node.right
        return res

    def hasNext(self):
        return len(self.stack) > 0 or self.root != None