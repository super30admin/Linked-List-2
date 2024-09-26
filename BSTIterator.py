# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#time complexity:O(n)
#Space complexity::O(n)


    def __init__(self, root: TreeNode):
        self.q=[]
        self.dfs(root)

    def next(self) -> int:
        """
        @return the next smallest number
        """
        curr=self.q.pop()
        self.dfs(curr.right)
        return curr.val
        

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        if not self.q:
            return False
        else:
            return True
        
    def dfs(self,root):
        while root:
            self.q.append(root)
            root=root.left


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
