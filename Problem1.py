#
# Time Complexity = O(h) for next  O(1) for hasnext
# Space Complexity = O(1)
#

class BSTIterator:

    def __init__(self, root: TreeNode):
        self.root=root

    def next(self) -> int:
        """
        @return the next smallest number
        """
        par=None
        temp=self.root
        while(temp.left):
            if not par:
                par=self.root
            else:
                par=par.left
            temp=temp.left
            
        if par==None:
            self.root = self.root.right
            return temp.val
        if temp.right:
            par.left = temp.right
        else:
            par.left=None
        return temp.val
        

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        if self.root:
            return True
        else:
            return False
        
