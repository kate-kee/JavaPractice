class Solution {
    public boolean checkIfPangram(String sentence) {
         boolean[] seen = new boolean[26];
         for (char currChar : sentence.toCharArray())
            seen[currChar - 'a'] = true;      
        for (boolean status : seen)
            if (!status)
                return false;
        return true;
    }
}