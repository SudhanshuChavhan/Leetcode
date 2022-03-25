/*
1029. Two City Scheduling
A company is planning to interview 2n people. Given the array costs where costs[i] = [aCosti, bCosti], the cost of flying the ith person to city a is aCosti, and the cost of flying the ith person to city b is bCosti.
Return the minimum cost to fly every person to a city such that exactly n people arrive in each city.

Example 1:
Input: costs = [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation: 
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.

The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.

Example 2:
Input: costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
Output: 1859

Example 3:
Input: costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
Output: 3086

Constraints:
2 * n == costs.length
2 <= costs.length <= 100
costs.length is even.
1 <= aCosti, bCosti <= 1000
*/
import java.util.*;
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        boolean[] min = new boolean[costs.length];
        
        //Now declare minHeap heap of size n
        PriorityQueue<Integer> pq = new PriorityQueue<>(costs.length);
        
        HashMap<Integer, List<Integer>> map = new HashMap<>(costs.length);
        int total=0, difference, countA = 0, countB = 0;
        
        for(int i=0; i<costs.length; i++){
            difference = Math.abs(costs[i][0] - costs[i][1]);
            
            pq.add(difference);
            
            List<Integer> li = new ArrayList <Integer>();
            li.add(i);
            
            
            if(map.get(difference) == null){
                map.put(difference, li);
            }
            else{
                //Collision
                li = map.get(difference);
                //System.out.println("Already present list: "+li);
                
                li.add(i);
                //System.out.println("List after adding new element: "+li);
                
                map.put(difference, li);
                //System.out.println("Updated map: "+map);
            }
            
            if(costs[i][0] > costs[i][1]){
                min[i] = true;
                countB++;
            }
            else{
                min[i] = false;
                countA++;
            }
        }
        
        if(countA != countB){
            boolean left = false;
            if(countA > countB )
                left = true;
            while(countA != countB){
                int top = pq.poll();
                
                List<Integer> j = map.get(top);
                int index = j.get(0);
                
                j.remove(0);
                map.put(top, j);
                
                //change the minArray...like increment one and decrement the other
                if(min[index] == true){
                    if(left == true)
                        continue;
                    min[index] = false;
                    countB--;
                    countA++;
                }else{
                    if(left == false)
                        continue;
                    min[index] = true;
                    countA--;
                    countB++;
                }
            }
        }
        for(int i=0; i<min.length; i++){
            if(min[i] == true)
                total += costs[i][1];
            else
                total += costs[i][0];
        }
        return total;   
    }
}
