public class Solution {

    public ListNode mergeKLists(List<ListNode> lists) {
        // The key for performance is to find a data structure
        // which has O(n) time complexity for addNode
        // and O(n) time complexity for extract min
        ListNode mergedHead = null;
        ListNode mergedLast = null;

        MinHeap heap = new MinHeap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            heap.add(it.next()); // m logm
        }

        // 2*m*n*log(mn)
        while (! heap.isEmpty()) {
            ListNode listNode = heap.extractMin();
            if (mergedHead == null) {
                mergeHead = listNode;
            } else {
                mergedLast.next = listNode;
            }
            mergedLast = listNode;
            if (listNode.next != null) {
                heap.add(listNode.next);
                listNode.next = null;
            }
        }

        return mergedHead;
    }

    private class MinHeap {

        private ListNode root;

        public MinHeap() {
            root = null;
        }

        public boolean isEmpty() {
            return root == null;
        }

        public void add(ListNode node) {
            // TODO a implementation
        }

        public ListNode extractMin() {
            // TODO a implementation
        }

    }

}
