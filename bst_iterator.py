# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator(object):
    queue = []
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        def recur(root):
            if root is None:
                return self.queue
            else:
                recur(root.left)
                self.queue.append(root.val)
                recur(root.right)
        recur(root)        

    def next(self):
        """
        @return the next smallest number
        :rtype: int
        """
        return self.queue.pop(0)
        

    def hasNext(self):
        """
        @return whether we have a next smallest number
        :rtype: bool
        """
        if len(self.queue)!=0:
            return True
        return False