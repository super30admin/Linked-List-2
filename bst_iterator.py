# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# class BSTIterator:
# BRUTE FORCE-USING INORDER TREE TRAVERSAL METHOD
#     def __init__(self, root: Optional[TreeNode]):
#         self.bst_list=[]
#         self.idx=0
#         self.inorder(root)

#     def inorder(self,root):
#         if root is None:
#             return
#         self.inorder(root.left)
#         self.bst_list.append(root)
#         self.inorder(root.right)

#     def next(self) -> int:
#         node_val=self.bst_list[self.idx].val
#         self.idx+=1
#         return node_val


#     def hasNext(self) -> bool:
#         return self.idx<len(self.bst_list)
class BSTIterator:
    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.init(root)

    def init(self, root):
        # Push all left children onto the stack
        while root:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        if self.hasNext():
            # Pop the top element from the stack
            node = self.stack.pop()
            self.init(node.right)
            return node.val
        return -1

    def hasNext(self) -> bool:
        return len(self.stack) > 0


# time complexity is O(1)
# space complexity is O(1)
