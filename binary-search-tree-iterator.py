#Time Complexity : O(1) : Leaf nodes 50%, One level above leafnodes (25%) --> For both levels you process only one node either null for leaf and leaf for one level above so (75%) nodes processing complexity is O(1) and remaining 25% is O(h) so average is still considered to O(1) for design problems.
#Space Complexity : O(H)
class BSTIterator:
    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.leftNodes(root)
       
    def leftNodes(self, root):
        while(root!=None):
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        if(self.hasNext()==True):
            temp = self.stack.pop()
            if(temp.right!=None):
                self.leftNodes(temp.right)
            return temp.val
            
    def hasNext(self) -> bool:
        return len(self.stack)>0