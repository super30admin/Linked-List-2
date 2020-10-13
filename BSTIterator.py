// Time Complexity : O(N)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class BSTIterator:

    def __init__(self, root: TreeNode):
        self.ans=[]
        def helper(root):
            if root is None:
                return
            helper(root.left)
            self.ans.append(root.val)
            helper(root.right)
        helper(root)
        self.i=0
        self.l=len(self.ans)
    def next(self) -> int:
        """
        @return the next smallest number
        """
        self.i+=1
        return self.ans[self.i-1]

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return self.i!=self.l


