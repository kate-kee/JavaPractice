class Solution {
    public int numberOfWeakCharacters(int[][] props) {
        Arrays.sort(props, (a, b) -> a[0]-b[0] == 0 ? b[1]-a[1] : a[0]-b[0]);
        
        Stack<Integer> stack = new Stack<>(); 
        int ans = 0; 
        
        for (int i=0; i<props.length; i++) { 
            
            while(!stack.isEmpty() && 
                  props[stack.peek()][0] < props[i][0]) {
                
                if (props[stack.peek()][1] >= props[i][1]) break; 
                
                ans += 1; 
                stack.pop(); 
            }
            
            stack.push(i);
        }
        
        return ans; 
    }
}