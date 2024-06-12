// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
In a binary search tree we use in order traversal to access all the elements.In the below we use dfs on the left side first and then we go to the right side.next() gives the next element in the inorder traversal.hasnext() function checks that there is an element in the order.

# Time complexity -->o(n) where n is the number of elements.
# space complexity -->o(h) where h is the height of the tree
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.stack=[]
        self.dfs(root)
        
    def dfs(self,node):
        while node!=None:
            self.stack.append(node)
            node=node.left
        return

    def next(self):
        """
        @return the next smallest number
        :rtype: int
        """
        if len(self.stack)!=0:
            node=self.stack.pop()
            self.dfs(node.right)
            return node.val
            

    def hasNext(self):
        """
        @return whether we have a next smallest number
        :rtype: bool
        """
        if len(self.stack)==0:
            return False
        return True
    
    
# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()