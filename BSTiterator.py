# Time Complexity : O(1)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

# traverse the left most branch of rBST and store in a stack. 
# pop the top of stack to get the next elem in BST and whenever we pop we add the right node of that popped val recursively 
# has next returns true only if stack is not empty
class BSTIterator(object):
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.st=list()
        self.dfs(root)
    

    def next(self):
        """
        :rtype: int
        """
        popped = self.st.pop()
        self.dfs(popped.right)
        return popped.val
        

    def hasNext(self):
        """
        :rtype: bool
        """
        return self.st
    
    def dfs(self, root):
        while(root is not None):
            self.st.append(root)
            root=root.left
    
