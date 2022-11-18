class Solution {
    public int numPrimeArrangements(int n) {
        if(n<3)
            return 1;
        n=n+1;
        boolean[] sieve=new boolean[n];
        for(int i=2;i<n;i++){
            sieve[i]=false;
        }
        for(int i=2;i<Math.sqrt(n);i++){
            if(sieve[i]==false){
                for(int j=2;i*j<n;j++){
                    sieve[i*j]=true;
                }
            }
        }
        int result=0;
        for(int i=2;i<sieve.length;i++){
            if(sieve[i]==false){
                 result++;
            }
        }
        System.out.print(result);
        return (int) (fact(result)* fact(n-1-result)% 1000000007); 
    }
        public long fact(int num){
        if(num <= 1) return 1;
        return (num * fact(num - 1)) % 1000000007;
    }
}