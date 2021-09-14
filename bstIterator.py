# Time Complexity : O(1) for next and hasNext
# Space Complexity : O(h) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.sort_nodes = []
        self.ind = -1
        self._inorder(root)
    
    def _inorder(self,root):
        if not root:
            return
        self._inorder(root.left)
        self.sort_nodes.append(root.val)
        self._inorder(root.right)

    def next(self) -> int:
        self.ind+=1
        return self.sort_nodes[self.ind]

    def hasNext(self) -> bool:
        return self.ind+1 < len(self.sort_nodes)
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
