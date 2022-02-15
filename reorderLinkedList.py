#O(n) time and O(1) space
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        #find middle of the linked list
        #reverse the linked list at the middle
        #make slow the head of first part of the linked list
        #make fast the head of the reversed part
        #merge both the lists
        if head == None or head.next == None:
            return
        slow = head
        fast = head
        while(fast.next != None and fast.next.next != None):
            slow = slow.next
            fast = fast.next.next
        #slow is currently in the middle
        #two seperate lists woth fast as head of reversed list
        def reverse(head):
            prev = None
            current = head
            fast = head.next
            while(fast != None):
                current.next = prev
                prev = current
                current = fast
                fast = fast.next
            current.next = prev
            return current
        fast = reverse(slow.next)
        #remove connection from end of first half
        slow.next = None
        slow = head
        temp = None
        while(fast != None):
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
                
