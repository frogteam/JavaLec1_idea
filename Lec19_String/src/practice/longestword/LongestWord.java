package practice.longestword;

/*******************************
 * 가장 긴 단어 찾기
 */

public class LongestWord {

    public static String[] input = {
            "I am a Student",     // ->  Student
            "That elephant is big",  // -> elephant
    };

    public static void main(String[] args) {
        for(var x : input){
            System.out.println(longestWord(x));
        }
    }

    public static String longestWord(String str) {
        String result = "";

        String[] words = str.trim().split("\\s+");
        for(String word : words){
            if(word.length() > result.length()){
                result = word;
            }
        }
        return result;
    }
} // end class
















