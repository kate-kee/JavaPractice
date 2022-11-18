public class selectionsort {
    public static int[] sortSelect(int[] a){
        for(int i=0;i<a.length-1;i++){
            int min=i;
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[min]){min=j;}
            }
            int temp=a[i];
            a[i]=a[min];
            a[min]=temp;
        }
        for(int k:a){
            System.out.println(k);
        }
        return a;
    }

    public static void main(String[] args) {
        int [] ar={2,3,1,4,5};
        sortSelect(ar);
    }
}
