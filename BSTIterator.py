#TC: O(1) since we will be accessing the next element and hasNext value in constant time. 
#SC: O(H) since we are storing the stack.

class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []    
        self.dfs(root)
        
    def dfs(self, root):
        while root:
            self.stack.append(root)
            root = root.left
            
    def next(self) -> int:
        node = self.stack.pop()
        self.dfs(node.right)
        return node.val
    

    def hasNext(self) -> bool:
        if self.stack:
            return True
        return False
