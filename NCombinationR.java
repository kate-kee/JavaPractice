public class NCombinationR {
    public static int getCombination(int n,int r){
        if(n<r)
        return 0;
        int[][] pascal=new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            pascal[i][0]=1;
            pascal[i][i]=1;
            for(int j=1;j<i;j++){
                pascal[i][j]=pascal[i-1][j]+pascal[i-1][j-1];
            }
        }
        return pascal[n][r];
    }
    public static void main(String[] args) {
        System.out.print(getCombination(5,3));
    }
}
