public class catalan {
    public static void Catalan(int n){
        int[] a = new int[n]; 
        a[0]=1;
        a[1]=1;
        for(int i=2;i<n;i++){
           a[i]=0;
            for(int j=0;j<i;j++){
                a[i]+=a[j]*a[i-j-1];
            }
        }
        for(int k:a){
            System.out.println(k);
        }
        return;
    }
    public static void main(String[] args) {
       Catalan(10);
       
    }
    
}
