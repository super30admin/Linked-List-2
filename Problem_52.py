class BSTIterator(object):
    def __init__(self, root):
        
        self.stack = []
        self._pushLeft(root)

    def hasNext(self):
        
        return self.stack

    def next(self):
       
        node = self.stack.pop()
        self._pushLeft(node.right)
        return node.val

    def _pushLeft(self, node):
        while node:
            self.stack.append(node)
            node = node.left


%TC : O(1)
%SC : O(h)