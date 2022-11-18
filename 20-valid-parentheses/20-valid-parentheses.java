class Solution {
    public boolean isValid(String s) {
        HashMap<Character,Character> openclose=new HashMap<Character,Character>();
        Stack<Character> openstack=new Stack<Character>();
        openclose.put('(',')');
        openclose.put('[',']');
        openclose.put('{','}');
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(openclose.containsValue(c)){
                if(openstack.isEmpty())
                    return false;
                Character o=openstack.pop();
                if(openclose.get(o)!=c)
                    return false;
            }
            else
                openstack.push(c);
        }
        return openstack.isEmpty();
    }
}