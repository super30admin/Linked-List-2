#TC:O(h)in worst case
#TC:O(1) SC:O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.s=[]
        self.dfs(root)   

    def next(self) -> int:
        popped=self.s.pop()
        self.dfs(popped.right)
        return popped.val

    def hasNext(self) -> bool:
        return self.s!=[]

    def dfs(self, root):
        while root!=None:
            self.s.append(root)
            root=root.left

        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
