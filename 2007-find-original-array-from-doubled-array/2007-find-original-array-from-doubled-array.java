class Solution {
    public int[] findOriginalArray(int[] changed) {

        int i=0;

        if(changed.length%2!=0)
            return new int[0];
        
        Arrays.sort(changed);
        
        int[] result=new int[changed.length/2];
        
        Queue<Integer> q=new LinkedList();
        
        for(int x:changed){
            
            if(!q.isEmpty() && q.peek()==x)
                result[i++]=q.poll()/2;
            
            else
                q.offer(x*2);

        }
        return q.isEmpty() ? result : new int[0];
    }
}