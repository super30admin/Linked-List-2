#TC: O(1)
#SC: O(h)
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class BSTIterator(object):

    def __init__(self, root):
        self.stack = []
        if (root != None):
            self.stack.append(root)
            self.__dfs(root)

    def __dfs(self, node):
        while (node.left != None):
            self.stack.append(node.left)
            node = node.left
        return

    def next(self):
        
        if not (self.hasNext()):
            return -1

        #   pop the top element
        topNode = self.stack.pop()

        if (topNode.right != None):
            self.stack.append(topNode.right)
            self.__dfs(topNode.right)

        return topNode.val

    def hasNext(self):
        return (len(self.stack) > 0)
