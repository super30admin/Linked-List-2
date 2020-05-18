# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Time COmplexity: O(1) on average
#Sapce Complexiy : O(H) where H is the height of tree
class BSTIterator(object):
    st = []
    def dfs(self,root) :
        while(root!=None):
            self.st.append(root)
            root =root.left

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.dfs(root)

    def next(self):
        """
        @return the next smallest number
        :rtype: int
        """
        node =self.st.pop()
        self.dfs(node.right)
        return node.val

    def hasNext(self):
        """
        @return whether we have a next smallest number
        :rtype: bool
        """
        if len(self.st)!= 0:
            return True
        
    
    


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()