public class bubbleSort {
    public static int[] sortBubble(int[] a){
        for(int i=0;i<a.length-1;i++){
            boolean swap=false;
            for(int j=0;j<a.length-1;j++){
                if(a[j]>a[j+1]){           
                    swap=true;     
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
            if(swap==false){break;}
        }
        for(int k:a){
            System.out.println(k);
        }
        return a;
    }
    public static void main(String[] args) {
        int [] ar={2,3,1,4,5};
        sortBubble(ar);
    }


}
