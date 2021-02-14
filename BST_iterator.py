# O(1) AMORTIZED TIME AND O(D) SPACE WHERE D IS DEPTH OF TREE
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []
        self.addToStack(root)
    
    def addToStack(self,node):
        while node is not None:
            self.stack.append(node)
            node = node.left
        
    def next(self) -> int:
        current = self.stack.pop()
        self.addToStack(current.right)
        return current.val
        

    def hasNext(self) -> bool:
        return len(self.stack) != 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()