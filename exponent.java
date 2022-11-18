public class exponent {
    public static int getExponent(int base,int power) { //2 //10
        int res = 1;  
        while(power>0){ //1
            if((power & 1) != 0){ //1
                res*=base; //4*256=1024 
             }
            power=power/2; //0
            base=base*base;//256*256
        }
        return res; //1024
    }
    public static void main(String[] args) {
        System.out.print(getExponent(2,10));
    }
}
