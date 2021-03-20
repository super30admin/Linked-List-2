// The length of the lists after the point of intersection is the same. If we maintain two pointers one starting from the head of the first node, and the other from the 
// head of the second list, if we traverse the list twice it is bound that the two points will meet at the point of their intersection. 

// Time Complexity : O(N + M), where N and M are the length of two LinkedList
// Space Complexity: O(1) 

public class IntersectionOfLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode list1 = headA, list2 = headB;
        if (list1 == null || list2 == null)
            return null;

        while (list1 != null && list2 != null && list1 != list2) {
            list1 = list1.next;
            list2 = list2.next;
            if (list1 == list2)
                return list1;
            if (list1 == null)
                list1 = headB;
            if (list2 == null)
                list2 = headA;
        }

        return list1;
    }
}
