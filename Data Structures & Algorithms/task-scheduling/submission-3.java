class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] counts = new int[26];
        PriorityQueue<Character> heap = new PriorityQueue<Character>((a,b)-> Integer.compare(counts[(int)b-65],counts[(int)a-65]));

        Queue<Pair<Character,Integer>> pc = new LinkedList<Pair<Character,Integer>>();

        for(char task:tasks){
            int index = (int)task - 65;
            counts[index]++;
        }
        for(char task:tasks){
            if(!heap.contains(task)){
                heap.offer(task);
            }
        }

        int cycles = 0;

        while((!heap.isEmpty() || !pc.isEmpty())){
            cycles++;
            if(!heap.isEmpty()){
                char ch = heap.poll();
                counts[ch-'A']--;
                if(counts[ch-'A']>0) {
                    Pair<Character,Integer> pro= new Pair<>(ch,cycles+n);
                    pc.add(pro);
                }
            }else{
                cycles = pc.peek().getValue();
            }

            if(!pc.isEmpty()){
                Pair process = pc.peek();
                int next_time = (int)process.getValue();
                char next_process = (char)process.getKey();
                if(cycles == next_time){
                    pc.poll();
                    heap.offer(next_process);
                }

                
            }
        }

        return cycles;
    }
}
