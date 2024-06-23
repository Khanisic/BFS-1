// Time Complexity : O(v + e)
// Space Complexity : O(v+e)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0){
            return true; // base case
        }
        int[] indegree = new int[numCourses]; // indegree array with length - num of courses
        HashMap<Integer, List<Integer>> map = new HashMap<>(); // hash map -> mapping course number to its dependancies
        Queue<Integer> q = new LinkedList<>(); 
        int count = 0; // count to perform check at the end
        for( int[] prerequisite : prerequisites){
            int from = prerequisite[1]; // prereq 
            int to = prerequisite[0]; // course
            indegree[to]++; // modifying the indegree array
            if(!map.containsKey(from)){
                map.put(from, new ArrayList<>());  // modifying the hashmap
            }
            map.get(from).add(to);
        }
        for(int i = 0; i < numCourses; i++){ // getting the course with no dependancies
            if(indegree[i] == 0){
                count++;
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int course = q.poll();
            if(!map.containsKey(course)){
                continue;
            }
            List<Integer> edges = map.get(course);
            if(edges == null){
                continue;
            }
            for(int edge : edges){
                indegree[edge]--; // reducing number of dependancies
                if(indegree[edge] == 0){
                    q.add(edge);
                    count++;
                }
            }
        }
        return count == numCourses;
    }
}