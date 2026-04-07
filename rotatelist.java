class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // 1. Find length and connect tail to head
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        tail.next = head; // Form cycle

        // 2. Find new tail and head
        k = k % length;
        int stepsToNewTail = length - k;
        for (int i = 0; i < stepsToNewTail; i++) {
            tail = tail.next;
        }

        // 3. Break circle
        ListNode newHead = tail.next;
        tail.next = null;
        return newHead;
    }
}
