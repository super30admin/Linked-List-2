# // Time Complexity :O(n)
# // Space Complexity :O(h) for stack /O(n) for list
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :No
# In list appraoch don't try to return in one line with index increment

# // Your code here along with comments explaining your approach

# Actual approach: using stack(h) and pop
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.st = []
        self.traveller(root)

    def traveller(self,root):                                # Lazy: we left
        while root != None:
            self.st.append(root)
            root = root.left                                 #  recursion left only  

    def next(self) -> int:
        if self.st != None: 
            temp = self.st.pop()                             # popped? check right(deleted if condition)
            self.traveller(temp.right)                       # recursion right
            return temp.val

    def hasNext(self) -> bool:                              
        return self.st != []




# commoner approach: using inorder traversal and index pointer(n)
class BSTIterator:
    def __init__(self, root: Optional[TreeNode]):
        self.idx = 0                    # current pointer for moving next
        self.li = []                    # list to append values of nodes
        self.inorder(root)          
    
    def inorder(self, root):            # basic inorder recursion
        # base
        if not root : return
        #logic
        self.inorder(root.left)
        self.li.append(root.val)        # add values to list
        self.inorder(root.right)

    def next(self) -> int:  
        val = self.li[self.idx]         # value = list[idx]
        self.idx +=1                    # move pointer to next        
        return val

    def hasNext(self) -> bool:
        return self.idx < len(self.li)  # current pointer index inbounds of total length

