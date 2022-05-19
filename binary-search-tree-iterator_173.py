#Approach 2: 
#Time Complexity O(1) for two methods there will be pushes and sometimes there wont be, 
#also if we assume total N elements are pushed then N next calls must be there so on an average (N/N) ~ O(1)
#Space Complexity O(H) height of tree, Because max we are appending all the left nodes of root at any point not all N elements
#It successfully runs on the leetcode
class BSTIterator:
    s = []
    def __init__(self, root: Optional[TreeNode]):
        self.inorder(root)
        
    def inorder(self, root):
        while root!=None:
            self.s.append(root)
            root= root.left
        
        
    def next(self) -> int:
        if self.s: 
            node = self.s.pop()
            if node.right:
                self.inorder(node.right)
            return node.val        
        

    def hasNext(self) -> bool:
        return len(self.s)!=0




#Approach 1: storing traversal values in list and calling methods in recursive inorder traversal
#Time Complexity O(1) for two methods
#Space Complexity O(N) List
#It successfully runs on the leetcode
class BSTIterator:
    l=[]

    def __init__(self, root: Optional[TreeNode]):
        self.inorder(root)
        
    
    def inorder(self, root):
        if root == None:
            return 
        self.inorder(root.left)
        self.l.append(root.val)
        self.inorder(root.right)
        return self.l

    def next(self) -> int:
        if self.l:
            val = self.l.pop(0)
            return val
        else:
            return None
        

    def hasNext(self) -> bool:
        return len(self.l) > 0