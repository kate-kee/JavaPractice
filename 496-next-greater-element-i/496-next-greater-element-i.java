class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
      HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        Stack<Integer> st=new Stack<Integer>();
        for(int j=nums2.length-1;j>=0;j--){
           while(st.isEmpty()==false && st.peek()<nums2[j])
                     st.pop();
                if(st.isEmpty())
                    h.put(nums2[j],-1);
                else
                    h.put(nums2[j],st.peek());
                st.add(nums2[j]);
        }
        int[] result=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            result[i]=h.get(nums1[i]);
        }
        return result;
    }
}