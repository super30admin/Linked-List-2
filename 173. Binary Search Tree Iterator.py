#Time Complexity:O(n)
#Space Complexity:O(n)

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
        self.stack=[]
        while root:
            self.stack.append(root)
            root=root.left
        

    def next(self):
        """
        :rtype: int
        """
        leftchild=self.stack.pop()
        curr=leftchild.right
        while curr:
            self.stack.append(curr)
            curr=curr.left
        return leftchild.val
        

    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.stack)


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()