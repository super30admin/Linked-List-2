// Time Complexity : O(V+E)
// Space Complexity : O(max depth)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack=[]
        self.dfs(root) #perform dfs

    def next(self) -> int:
        """
        @return the next smallest number
        """
        retVal=self.stack.pop() #pop from stack for the lease element
        if retVal.right:
            self.dfs(retVal.right) #perform dfs for right subtree
        return retVal.val
        
        

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return len(self.stack)>0 #returns if stack is empty or not
    def dfs(self,root):
        top=root
        while top: #find left most since its BST and it would be the smallest element
                self.stack.append(top)
                top=top.left
            


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()

            