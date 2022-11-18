import java.util.ArrayList; 
public class PrimeFactors {
    public static ArrayList<Integer> primeFactors(int n){
        ArrayList<Integer> result=new ArrayList<Integer>();
        for(int i=2;i*i<=n;i++){
            while(n%i==0){
                result.add(i);
                n=n/i;
            }
        }
        if(n>1){
            result.add(n);
        }
        return result;
    }
    public static void main(String[] args){
        ArrayList<Integer> arr=new ArrayList<Integer>();
        arr=primeFactors(3450);
        for(int i: arr){
            System.out.println(i);
        }
    }
}
