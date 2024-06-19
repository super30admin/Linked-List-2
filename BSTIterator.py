# Time Complexity :
# O(N)

# Space Complexity :  
# O(N)  





# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.list = []
        self.inorder(root)

    def inorder(self, root):
        if not root:
            return
        self.inorder(root.left)
        self.list.append(root.val)
        self.inorder(root.right)
        

    def next(self):
        """
        :rtype: int
        """
        popped = self.list.pop(0)
        return popped


    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.list)>0