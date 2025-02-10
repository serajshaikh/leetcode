class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb=new StringBuilder();
        int i=0;
        int j=0;
        while(i<word1.lenght()||j<word2.lenght()){
            if(i<word1.lenght()){
                sb.append(word1.charAt(i));
                i++;
            }
            if(j<word2.lenght()){
                sb.append(word2.charAt(j));
                j++;
            }
        }

        return sb.toString();
    }
}