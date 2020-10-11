class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack =[]
        self.dfs(root)
        

    def next(self) -> int:
        """
        @return the next smallest number
        """
        if self.hasNext() is None:
            return -1
        if self.stack:
            node = self.stack.pop()
            if node.right is not None:
                self.dfs(node.right)
            return node.val
                
        

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return len(self.stack)>0
        
    def dfs(self,root):
        while(root!=None):
            self.stack.append(root)
            root = root.left
            
            
            #tc of hasnext is constant and next is o(n) and space complexity is height of tree
