# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity: O(1)
# Space Complexity: O(1)
class BSTIterator:
    stack=[]
    def __init__(self, root: Optional[TreeNode]):
        while root!=None:
            self.stack.append(root)
            root=root.left
    def next(self) -> int:
        v=self.stack.pop()
        root=v.right
        while root!=None:
            self.stack.append(root)
            root=root.left
        return v.val
        

    def hasNext(self) -> bool:
        return len(self.stack)!=0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()