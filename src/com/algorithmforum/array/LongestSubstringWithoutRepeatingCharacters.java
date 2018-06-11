package com.algorithmforum.array;


/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * Example: Input  "ABDEFGABEF"
 * Output: "BDEFGA" and "DEFGAB", with length 6.
 * 
 * Input: "BBBB"
 * Output: "B", with length 1.
 * 
 * Input: "GEEKSFORGEEKS"
 * Output: "EKSFORG" and "KSFORGE", with length 7.
 * 
 *  https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 * 
 * @author rajesh.dixit
 * @since May 29, 2018 3:09:24 PM
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
       String str = "ABCDEFGHIJKLGEEKSFORGEEKSABCDEFGHIJK";
       
       printLongestStringWithoutRepeatingCharacter(str);

    }

    private static void printLongestStringWithoutRepeatingCharacter(String str) {
        int[] visited = new int[26];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = -1;
        }

        int maxLength = -1;
        int count = 0;
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            int ch = str.charAt(i) - 'A';
            if (visited[ch] == -1 || visited[ch] < i - count) {
                visited[ch] = i;
                count++;
            } else {
                if(maxLength<count) {
                    maxLength = count;
                    index = i;
                }
                count = i - visited[ch];
                visited[ch] = i;
            }
        }
        
        System.out.println(str.substring(index- maxLength,index));
    }
}