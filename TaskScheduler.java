// Time complexity - O(n)
// Space complexity - O(1)
// Tested in leetcode

class TaskScheduler {
    // Allocate hashmap to store frequency of char
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max_count =0;
        int max_freq = 0;
        // get the frequency of cha which has highest frequency
        for(char c : tasks){
            map.put(c,map.getOrDefault(c,0)+1);
            max_freq = Math.max(max_freq,map.get(c));
        }
        
        // get total number of char having highest frequency
        for(int value : map.values()){
            if(value == max_freq)
                max_count++;
        }
        
        // calculate total number of group of time slots
        int totalPart = max_freq - 1;
        
        // calculate total number of available slots after time allocation of highest frequency character
        int emptySlot = totalPart * ( n - (max_count-1));
        
        // calculate total number of empty slots after allocationg time for all char
        int availableSlot = emptySlot - (tasks.length - (max_freq*max_count));
        
        // store non negative idle slot
        int idleSlot = Math.max(0,availableSlot);
            
        //return total time to schedule the task
        return tasks.length+idleSlot;
    }
}