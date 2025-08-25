# Time Complexity : It is O(n) since we are iterating with all nodes.
# Space Complexity : It is O(1) no extra space.
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        preNode = ListNode()
        preNode =None
        currNode=head
        fastNode = head

        while fastNode != None and fastNode.next != None:
            currNode=currNode.next
            fastNode=fastNode.next.next
   
        while currNode!=None:    
            fastNode = currNode.next        
            currNode.next = preNode
            preNode = currNode
            currNode = fastNode                 
  
        currNodeHead = head
        currFastNodeHead = currNodeHead.next
        reverseNodeHead = preNode
        reverseFastNodeHead = preNode.next

        while(reverseFastNodeHead != None):
            currNodeHead.next = reverseNodeHead
            reverseNodeHead.next = currFastNodeHead
            currNodeHead=currFastNodeHead
            currFastNodeHead=currFastNodeHead.next
            reverseNodeHead =reverseFastNodeHead
            reverseFastNodeHead=reverseFastNodeHead.next
        
