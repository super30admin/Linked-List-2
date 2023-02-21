#Time Complexity : O(H), H being height of tree.
#Space Complexity : O(H), H being height of tree.
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Got stuck on a lot of corner cases. 
#Your code here along with comments explaining your approach in three sentences only
'''While placing all left nodes in an array initially. Append right node and place
all left nodes in array and pop the last node in array, for next function. If there is no
right node and array is empty, then the iterator at the end.  
'''
class BSTIterator:
    # place all left nodes in array initally.
    def __init__(self, root: Optional[TreeNode]):
        self.node_array = []
        self.node = root
        while(self.node!=None):
            self.node_array.append(self.node)
            self.node = self.node.left

        
    def next(self) -> int:
        #handle initial case. 
        if self.node==None:
            self.node = self.node_array.pop(len(self.node_array)-1)
        #handle general case. 
        elif self.node.right!=None:
            self.node = self.node.right
            while(self.node!=None):
                self.node_array.append(self.node)
                self.node = self.node.left
            self.node = self.node_array.pop(len(self.node_array)-1)
        #handle right case. 
        else:
            if len(self.node_array)>0:
                self.node = self.node_array.pop(len(self.node_array)-1)

        return self.node.val

    def hasNext(self) -> bool:
        #handle initial case. 
        if self.node==None:
            if len(self.node_array)>0:
                return True
            else:
                return False
        #handle remaining cases. 
        if self.node.right==None and len(self.node_array)==0:
            return False
        else:
            return True
