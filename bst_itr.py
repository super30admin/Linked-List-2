#time complexity: o(n) for hasnext
#space complexity:o(1)
#passed all cases on LeetCode:yes
#difficulty faced:
# comments:
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: 'Optional[TreeNode]'):
        self.s = []
        self.dfs(root)
        

    def next(self) -> int:
        popped = self.s.pop()
        self.dfs(popped.right)
        return popped.val
        

    def hasNext(self) -> bool:
        return len(self.s)

     #why are we traversing 1st all the left nodes   
    def dfs(self,root):
        while root:
            self.s.append(root)
            root = root.left


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()