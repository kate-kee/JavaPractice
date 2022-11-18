class Solution {
    public static class node{
        String id;
        double value;
        public node(){       
        }
    }
        public static String find(HashMap<String ,String> dsuf, String name){
        return dsuf.get(name)==name?name: find(dsuf,dsuf.get(name));
    }
    
    public static double calculate( HashMap<String, ArrayList<node>> adj,String start,String end,HashMap<String, Boolean> visited){
         double res;
         visited.put(start, true);
         for(node t: adj.get(start)){
            String adjNode=t.id;
            if(visited.containsKey(adjNode) && visited.get(adjNode)) continue;
            if(adjNode.equals(end)) {
                return (t.value);
            }
            res=calculate(adj,adjNode,end,visited);
            if(res==(double)-1)
                continue;
            return (t.value)*(res);
            }
        visited.put(start,false);
        return (double)-1;
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans= new double[queries.size()];
        int n=equations.size();
        HashMap<String, ArrayList<node>> adj=new HashMap<String , ArrayList<node>>();
        for(int i=0;i<n;i++){
            adj.put(equations.get(i).get(0),new ArrayList<node>());
            adj.put(equations.get(i).get(1),new ArrayList<node>());
        }
        HashMap <String ,String> dsuf= new HashMap<String,String>();
        for(List<String> it: equations){
            dsuf.put(it.get(0),it.get(0));
            dsuf.put(it.get(1),it.get(1));
        }
        for(int i=0;i<n;i++)  //make adjacency list
        { 
            node newNode=new node();
            newNode.id=equations.get(i).get(1);
            newNode.value=values[i];
            adj.get(equations.get(i).get(0)).add(newNode);
            String parentFrom =find(dsuf, equations.get(i).get(0));
            String parentTo=find(dsuf, equations.get(i).get(1));
            dsuf.put(parentFrom,parentTo);
            
            node temp=new node();
            temp.id=equations.get(i).get(0);
            temp.value=(double)1/values[i];
            adj.get(equations.get(i).get(1)).add(temp);
        }
        int j=0;
        for(List<String> it: queries){
            String a=it.get(0);
            String b=it.get(1);
            String findA=find(dsuf,a);
            String findB=find(dsuf,b);
            if(a.equals(b) && dsuf.containsKey(a)){ ans[j]=(double)1; j++;continue;}
            if(!dsuf.containsKey(a)|| !dsuf.containsKey(b) || !(findA.equals(findB)) ){ans[j]=(double)-1;j++;continue;}
            HashMap<String, Boolean> visited= new HashMap<String ,Boolean>();
            double ret=calculate(adj,it.get(0),it.get(1),visited);
            ans[j++]=ret;
        }
        return ans;   
    }
}