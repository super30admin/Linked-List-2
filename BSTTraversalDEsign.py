
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class BSTIterator:
    def __init__(self, root):
        self.lst=[]
        self.dfs(root)
#Space complexity:  O(1)     
#Time complexity: O(1)
    def next(self) -> int:
        node=self.lst.pop()
        self.dfs(node.right)
        return node.val
#Space complexity: O(1)     
#Time complexity: O(1)
    def hasNext(self) -> bool:
        if self.lst:
            return True
        return False
       
    def dfs(self,root):
        while root!=None:
            self.lst.append(root)
            root=root.left
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()