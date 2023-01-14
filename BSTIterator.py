# Time Complexity :O(1)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No


class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.root=root
        self.stack=[]
        while(self.root!=None):
            self.stack.append(self.root)
            self.root=self.root.left
        
    def next(self):
        """
        :rtype: int
        """
        if(self.stack==[]):
            return -1
        k=self.stack[-1].val
        n=self.stack[-1].right
        self.stack=self.stack[:-1]
        if(n is None):
            return k
        self.stack.append(n)
        while(n.left!=None):
            self.stack.append(n.left)
            n=n.left
        
        return k
        
    def hasNext(self):
        return(self.stack!=[])
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()