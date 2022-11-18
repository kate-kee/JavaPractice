class Solution {
    public String decodeANDcode(String s)
    {
        int l=s.length(),ct=0;
        int[][] count=new int[l][2];
        count[ct][1]=s.charAt(0)-48;
        count[ct][0]=1;
        for(int i=1;i<l;i++)
        {
            if(s.charAt(i)-48==count[ct][1])
                count[ct][0]++;
            else
            {
                ct++;
                count[ct][1]=s.charAt(i)-48;
                count[ct][0]=1;
            }
        }
        StringBuilder str=new StringBuilder();
        for(int i=0;i<=ct;i++)
            str.append(count[i][0]+""+count[i][1]);
        return str.toString();
    }
    public String countAndSay(int n) {
        String s="1";
        if(n>1)
            for(int i=2;i<=n;i++)
                s=decodeANDcode(s);
        return s;
    }
}