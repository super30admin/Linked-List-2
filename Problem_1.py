"""
Problem : 1

Time Complexity : 
hasNext() - O(1)
next() - O(1) //Average

Space Complexity : O(h) //h=height of the tree

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Creating a stack to push the all the left nodes from the root in DFS manner, performing next or hasNext on them,
popping the last node pushed and performing DFS on its right part. 

"""

# Binary search iterator

# Approach - 1
# Dynamic Approach

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
        self.dfs(root)
    def dfs(self,root):
        while root:
            self.stack.append(root)
            root=root.left

    def next(self):
        """
        :rtype: int
        """
        # print(self.res)
        curr=self.stack.pop()
        self.dfs(curr.right)
        return curr.val

    def hasNext(self):
        """
        :rtype: bool
        """
        return True if self.stack else False

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()


# Approach - 2
# Static Apparoch - Using a list

class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.res=[]
        self.inorder(root)
        self.pos=-1
    def inorder(self,root):
        if root==None:
            return
        self.inorder(root.left)
        self.res.append(root.val)
        self.inorder(root.right)
        

    def next(self):
        """
        :rtype: int
        """
        # print(self.res)
        self.pos+=1
        return self.res[self.pos]
        

    def hasNext(self):
        """
        :rtype: bool
        """
        if self.pos>=-1 and self.pos<len(self.res)-1:
            return True
        else:
            return False
        
