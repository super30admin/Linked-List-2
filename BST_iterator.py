# TC : O(1)
# SC : O(n); n being no. of nodes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.root = root
        self.left_inorder(self.root)
        
    def left_inorder(self, root):
        while root:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        #no left child or left child is processed
        p = self.stack.pop()
        #processing right children
        if p.right:
            self.left_inorder(p.right)
        return p.val
        

    def hasNext(self) -> bool:
        if len(self.stack)!= 0:
            return True
        else:
            return False
