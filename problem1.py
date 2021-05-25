# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []
        self.root = root
        self.bfs(root)


    def next(self) -> int:
        result = self.stack.pop()
        self.bfs(result.right)
        return result.val


    def bfs(self,root):
        while(root!=None):
            self.stack.append(root)
            root = root.left



    def hasNext(self) -> bool:
        if len(self.stack)==0:
            return False
        return True



# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
