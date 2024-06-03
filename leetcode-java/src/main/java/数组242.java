class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        /*
        c/c++直接s[i]表示字符串第i个，而java要s.charAt(i)
        */
        int[] nb=new int[26];
        for(int i=0;i<s.length();i++)
            nb[s.charAt(i)-'a']++;
        for(int i=0;i<t.length();i++)
            nb[t.charAt(i)-'a']--;
        for(int i=0;i<26;i++)
            if(nb[i]!=0)
                return false;

        return true;
    }
}