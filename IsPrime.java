// import java.util.Scanner;

// import java.util.*;
// import java.lang.*;
public class IsPrime {
    public static boolean isPrime(int n){
        for(int i=2;i*i<=n;i++){
            if(n%i==0)
            return false;
        }
        return true;
    }
    public static void main(String args[]){
        //Scanner in=new Scanner(System.in);
        //int n=in.nextInt();
        System.out.print(isPrime(11));
    }
}
