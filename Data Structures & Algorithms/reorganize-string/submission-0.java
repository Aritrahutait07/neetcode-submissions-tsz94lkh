class Solution {
    public String reorganizeString(String s) {
        // Create MaxHeap
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        // Create HashMap
        HashMap<Character,Integer> map = new HashMap<>();
        // Build HasHashMap
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        // Build MaxHeap
        for(char c:map.keySet()){
            maxHeap.add(new int[]{c,map.get(c)});
        }
        StringBuilder res = new StringBuilder();
        int[] prev = null;
        while(!maxHeap.isEmpty()){
            int[] current = maxHeap.poll();
            res.append((char)current[0]);
            current[1]--;
            if(prev!=null && prev[1]>0){
                maxHeap.add(prev);
            }
            prev = current;
        }
        if(res.length()!=s.length()){
            return "";
        }
        else{
            return res.toString();
        }


    }
}