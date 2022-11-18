class Solution {
int max=0;

public int maxLength(List<String> arr) {
  backtrack(arr,"",0);
    return max;
}

public void backtrack(List<String> arr,String resultant,int start){
    if(max<resultant.length())  max=resultant.length();
    for(int i=start;i<arr.size();i++){
         if(!istrue(resultant,arr.get(i))) continue;
        backtrack(arr,resultant+arr.get(i),i+1);
    }
}

private boolean istrue( String arr,String resultant){
  int []qwertyuiop=new int[26];
     for(int i=0;i<resultant.length();i++){
          if(++qwertyuiop[resultant.charAt(i)-'a']==2) return false;
           if(arr.contains(resultant.charAt(i)+"")) return false;
     }
    return true;
}
}