//347. 前 K 个高频元素
class Solution_347 {
    public int[] topKFrequent(int[] nums, int k) {
        //key,count Map
        Map<Integer,Integer> map = new HashMap();
        for(int data : nums) {
            map.put(data, map.getOrDefault(data, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for(Integer key : map.keySet()) {
            queue.add(key);
            if(queue.size() > k) {
                queue.poll();
            }
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }

        return result;
    }
}