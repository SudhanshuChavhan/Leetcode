/*
399. Evaluate Division
You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
Return the answers to all queries. If a single answer cannot be determined, return -1.0.
Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

Example 1:
Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]

Example 2:
Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]

Example 3:
Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]
 
Constraints:
1 <= equations.length <= 20
equations[i].length == 2
1 <= Ai.length, Bi.length <= 5
values.length == equations.length
0.0 < values[i] <= 20.0
1 <= queries.length <= 20
queries[i].length == 2
1 <= Cj.length, Dj.length <= 5
Ai, Bi, Cj, Dj consist of lower case English letters and digits.
*/
class Solution {
  
    public double[] calcEquation(List<List<String>> equations, 
                                 double[] values, List<List<String>> queries) {
        //build the graph
        HashMap<String, HashMap<String, Double>> graph = buildGraph(equations, values);
        
        //we have to return the result in double so we make a double arr
        double[] result = new double[queries.size()];
        
        //Iterate through queries list to get the result
        for(int i = 0;  i < queries.size(); i++){
            String src = queries.get(i).get(0);
            String des = queries.get(i).get(1);
            
            //if any of them is not in the graph
            if (!graph.containsKey(src) || !graph.containsKey(des)){ 
                result[i] = -1.0;
                continue;
            }
            
            result[i] = dfs(src, des, graph, new HashSet());
        }
        return result;       
    }
    //call the dfs to solve the queries
    private double dfs(String src, String des, HashMap<String, 
                       HashMap<String, Double>> graph, Set<String> visited){
        
        //if src and destination is equal
         if (graph.get(src).containsKey(des)) {
            return graph.get(src).get(des);
        }
        
        
        //add to visited set
        visited.add(src);
        
        //go to next node of source
        for(Map.Entry<String , Double>next : graph.get(src).entrySet()){
            //check that is it already visited set contains the key 
            if(!visited.contains(next.getKey())){
                //now get the ans from dfs 
                double ans = dfs(next.getKey(), des, graph, visited);
                if(ans != -1.0){
                    //return the ans * value(weight) of current node
                     return ans * next.getValue();
                }
            }
        }
        return -1.0;
    }
    private HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>> eq, 
                                               double[] values){
        HashMap<String, HashMap<String, Double>> g = new HashMap<>();
        //Iterate through values
        for(int i = 0; i < values.length; i++){
            //get the source from the equations list
            String src = eq.get(i).get(0);
            //get the destination from the equations list
            String des = eq.get(i).get(1);
            //put the src in the graph if it is not present
            g.putIfAbsent(src, new HashMap());
            //put the destination in the graph if it is not present
            g.putIfAbsent(des, new HashMap());
            //add a edge from src to destination with values weight
            g.get(src).put(des, values[i]);
            //add a edge from destination to source with 1/weight
            g.get(des).put(src, 1.0 / values[i]);
        }
        return g;
    }
}
