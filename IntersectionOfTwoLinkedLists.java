import java.util.HashSet;

public class IntersectionOfTwoLinkedLists {
    public static ListNode getIntersectionNodeHashSet(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>(); //O(n) S.C

        while(headA != null) { //O(n) T.C
            set.add(headA); //Adding nodes from headA linked-list to the hashset
            headA = headA.next;
        }

        while(headB != null) {
            if(set.contains(headB)) { //O(1) T.C
                return headB; //If node from headB linked-list is already in hashset, return that as connecting node
            }
            headB = headB.next;
        }

        return null; //if no connecting node, return null
    }

    public static ListNode getIntersectionNodePointers(ListNode headA, ListNode headB) {
        ListNode slow = headA; //starting pointer from headA linked-list
        ListNode fast = headB; //starting pointer from headB linked-list

        int lenA = 0;
        while(slow != null) { //O(n) T.C
            lenA++; //calculate length of headA linked-list
            slow = slow.next;
        }

        int lenB = 0;
        while(fast != null) { //O(n) T.C
            lenB++; //calculate length of headB linked-list
            fast = fast.next;
        }

        slow = headA; //re-assign slow and fast back to original starting pointers
        fast = headB;

        int diff = Math.abs(lenA - lenB); //Find the difference between both lengths
        int count = 0;

        while(count != diff) { //Until the counter meets difference
            if(lenA > lenB) { //depending on which length is higher
                slow = slow.next; //increment the head of either the first linked-list
            }
            else {
                fast = fast.next; //or the second one
            }
            count++; //increment the counter to move difference places up in the list
        }

        while(slow != fast) { //now incrementing both pointers at 1x speed
            slow = slow.next; //we can find the coinciding node
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        // Creating first linked list
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        // Creating second linked list
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next;  // Pointing to node 8 in the first list

        // Running the intersection function
        ListNode intersectionHashSet = getIntersectionNodeHashSet(headA, headB);
        ListNode intersectionPointer = getIntersectionNodePointers(headA, headB);

        if (intersectionHashSet != null) {
            System.out.println("Intersection at node with value using hashSet is: " + intersectionHashSet.val +
                    " for the lists: " );
        } else {
            System.out.println("No intersection");
        }

        if (intersectionPointer != null) {
            System.out.println("Intersection at node with value using pointers is: " + intersectionPointer.val);
        } else {
            System.out.println("No intersection");
        }
    }
}