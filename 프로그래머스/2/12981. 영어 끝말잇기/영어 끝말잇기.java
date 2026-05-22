import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {

        Set<String> set = new HashSet<>();
        
        set.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String curr = words[i];
            
            if (prev.charAt(prev.length() - 1) != curr.charAt(0) || set.contains(curr)) {
                int player = (i % n) + 1;
                int turn = (i / n) + 1;
                
                return new int[]{player, turn};
            }
            
            set.add(curr);
        }
        return new int[]{0, 0};
    }
}