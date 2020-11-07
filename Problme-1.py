class BSTIterator:

    def __init__(self, root: TreeNode):

        self.stack = []
        self.dfs(root)


    def next(self) -> int:
        """
        @return the next smallest number
        """
        node = self.stack.pop()
        if node.right is not None:
            self.dfs(node.right)

        return node.val

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return not len(self.stack)==0

    def dfs(self,root):
        while root:
            self.stack.append(root)
            root=root.left
