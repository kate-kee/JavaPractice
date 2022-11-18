class Solution {
    private List<String> combinations = new ArrayList<>();
    private Map<Character, String> letters = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    private String phonedigits;
    public List<String> letterCombinations(String digits) {
        this.phonedigits=digits;
        backtrack(0, new StringBuilder());
        return combinations;
    }
    public void backtrack(int index,StringBuilder res){
        if(phonedigits.length()==0){
            return;
        }
        if(res.length()==phonedigits.length())
        {   
            combinations.add(res.toString());
            return;
        }
        String possible=letters.get(phonedigits.charAt(index));
         for (char letter: possible.toCharArray()){
            res.append(letter);
            backtrack(index+1,res);
            res.deleteCharAt(res.length()-1);
        }
    } 
}