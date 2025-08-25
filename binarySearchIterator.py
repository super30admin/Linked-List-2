# Time Complexity : It is O(1) since we are checking the next element or navigating the next right element
# Space Complexity : It is O(1) amortized.
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

class BSTIterator:
    globalRoot = []
    def recursiveTillHeight(self,root: Optional[TreeNode]) -> int:
        
        if root == None:
            return

        while(root!=None):
            BSTIterator.globalRoot.append(root)
            root=root.left
            
    def __init__(self, root: Optional[TreeNode]):
        self.recursiveTillHeight(root)        

    def next(self) -> int:        
        currNode = BSTIterator.globalRoot.pop()
        currVal =currNode.val
        self.recursiveTillHeight(currNode.right)
        return currVal

    def hasNext(self) -> bool:
        if len(BSTIterator.globalRoot) > 0:
            return True
        return False
        
