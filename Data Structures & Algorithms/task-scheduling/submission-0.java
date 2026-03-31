

class Solution {

    public int leastInterval(char[] tasks, int n) {

        // --------------------
        // 1️⃣ Frequency count
        // --------------------
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // --------------------
        // 2️⃣ Max Heap (frequency)
        // --------------------
        PriorityQueue<int[]> maxHeap =
                new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (char c : map.keySet()) {
            maxHeap.add(new int[]{c, map.get(c)});
        }

        // --------------------
        // 3️⃣ Cooldown queue
        // [char, remainingFreq, availableTime]
        // --------------------
        Queue<int[]> waitQueue = new LinkedList<>();

        int time = 0;

        // --------------------
        // 4️⃣ Simulation
        // --------------------
        while (!maxHeap.isEmpty() || !waitQueue.isEmpty()) {

            time++;

            // execute task if available
            if (!maxHeap.isEmpty()) {

                int[] current = maxHeap.poll();
                current[1]--; // reduce frequency

                // if still remaining → send to cooldown
                if (current[1] > 0) {
                    waitQueue.add(
                        new int[]{current[0], current[1], time + n}
                    );
                }
            }

            // check if cooldown finished
            if (!waitQueue.isEmpty()
                    && waitQueue.peek()[2] == time) {

                maxHeap.add(waitQueue.poll());
            }
        }

        return time;
    }
}