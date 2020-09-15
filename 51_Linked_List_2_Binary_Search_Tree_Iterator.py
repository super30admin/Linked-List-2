#Time Complexity : O(n) where n is the number of elements
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : 
#Your code here along with comments explaining your approach

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
        self.sorted=[]
        self.index=-1
        self.inorder(root)
        
    def inorder(self,root):
        if not root:
            return 
        self.inorder(root.left)
        self.sorted.append(root.val)
        self.inorder(root.right)
        

    def next(self):
        """
        @return the next smallest number
        :rtype: int
        """
        self.index+=1
        return self.sorted[self.index]
        

    def hasNext(self):
        """
        @return whether we have a next smallest number
        :rtype: bool
        """
        return self.index+1<len(self.sorted)
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()