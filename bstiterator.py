# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    '''
    SC : O(H) 
    
    DFS Next 
    TC : O(H) // traverse the left until there is no left 
    SC : O(1) 
    
    Hasnext 
    TC : O(1)
    SC : O(1)
    
    Approach : 
    dfs() : traverse to the left most and store all the elements
    next() : pop the element from stack and expplore the right tree
    hasnext() : if any element left in stack

    '''
    
    def __init__(self, root: TreeNode):
        self.st = []
        self.dfs(root)

    def next(self) -> int:
        ans = self.st.pop()
        self.dfs(ans.right)
        return ans.val  

    def hasNext(self) -> bool:
        return True if self.st else False
    
    def dfs(self,root):
        while root:
            self.st.append(root)
            root = root.left



# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()