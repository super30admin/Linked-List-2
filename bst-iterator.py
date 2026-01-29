# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack =[]
        self.dfs(root)
        self.idx =0

    def dfs(self, root):
        if(root == None):
            return
        self.dfs(root.left)
        self.stack.append(root.val)
        self.dfs(root.right)


    def next(self) -> int:
        val =self.stack[self.idx]
        self.idx+=1
        return val



    def hasNext(self) -> bool:
        return True if self.idx < len(self.stack) else False



# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
