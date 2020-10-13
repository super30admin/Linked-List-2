# O(N) TIME AND O(D) space where N IS NO.OF NODES AND D IS DEPTH 

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []
        self.dfs(root)
        
    def next(self) -> int:
        node = self.stack.pop()
        if node.right is not None:
            self.dfs(node.right)
        return node.val 

    def hasNext(self) -> bool:
        return len(self.stack) != 0
    
    def dfs(self,node):
        while node is not None:
            self.stack.append(node)
            node = node.left