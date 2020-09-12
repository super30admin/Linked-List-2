# Time Complexity : O(n), next() and hasNext() will take O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach class Solution(object):

#Just create a list and store inorder(sorted) of bst and return accordingly

class BSTIterator(object):

    def __init__(self, root):
    
        self.res = []
        self.inorder(root)
        self.nextPtr = -1
        
    
    def inorder(self, root):
        if root:
            self.inorder(root.left)
            self.res.append(root.val)
            self.inorder(root.right)
            
    def next(self):
        
        if self.nextPtr + 1 < len(self.res):
            temp =  self.res[self.nextPtr + 1]
            self.nextPtr += 1
            return temp
        

    def hasNext(self):
      
        if self.nextPtr + 1 < len(self.res):
            return True
        else:
            return False
