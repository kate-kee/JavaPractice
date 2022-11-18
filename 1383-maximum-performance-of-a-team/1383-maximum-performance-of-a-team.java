class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
int[][] arr= new int[n][2];
        for( int i=0; i<n; i++){
            arr[i]= new int[]{efficiency[i],speed[i]};
        }
        Arrays.sort(arr,(a,b)->b[0]-a[0]);

        PriorityQueue<Integer> q= new PriorityQueue<>((a,b)->a-b);
        long ans=0, speed_sum=0;;
        for( int[] i: arr){

            q.add(i[1]);
            speed_sum+=i[1];

            if( q.size()>k){
                int x= q.poll();
                speed_sum-=x;
            }
             ans= Math.max(ans, speed_sum*i[0]);
        }
        long mod= (long)1e9 + 7;
        return (int) (ans % mod);
}
}