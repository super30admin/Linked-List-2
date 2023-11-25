#Time Complexity : hasNext() -> O(1), next() -> average O(1) for 75% of the tree.
#Space Complexity : O(1) since we are not using any extra space
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No

#Approach: We implement iterative approach (inhood stack) of inorder travesal of BST using the stack. This preserves the dynamic
# nature of the BST

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    def __init__(self, root: Optional[TreeNode]):
        self.st = []
        self.dfs(root)

    def dfs(self, root):
        while root is not None:
            self.st.append(root)
            root = root.left  

    def next(self) -> int:
        curr = self.st.pop()
        self.dfs(curr.right)
        return curr.val

    def hasNext(self) -> bool:
        return bool(self.st)