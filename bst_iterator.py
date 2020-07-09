# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class BSTIterator:
    
    def __init__(self, root: TreeNode):
        self.stack = []
        self.dfs(root)
        
    def next(self) -> int:
        """
        @return the next smallest number
        """
        node = self.stack.pop()
        self.dfs(node.right)
        return node.val
        

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        if self.stack:
            return True
        return False
    
    def dfs(self, node):
        while node:
            self.stack.append(node)
            node = node.left
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()


#time complexity - O(h) as worst, O(1) as best, O(1) as avg

#space complexity - O(h), max elements possible in recursive stack. h is the height of BST