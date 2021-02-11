#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

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
        self._isleft(root)
    
    def _isleft(self,root):
        while(root):
            self.stack.append(root)
            root=root.left

    def next(self):#o(1)
        """
        :rtype: int
        """
        curr=self.stack.pop()
        if(curr.right):
            self._isleft(curr.right)
        return curr.val
                

    def hasNext(self): #o(1)
        """
        :rtype: bool
        """
        return len(self.stack)>0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()