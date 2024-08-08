package 哈希.LeetCode049字母异位词分组;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = scanner.next();
        }
        List<List<String>> lists = new Solution().groupAnagrams(strs);
        lists.forEach(System.out::println);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        ArrayList<HashMap<Character, Integer>> hashtables = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            //初始化每个数组的哈希表
            HashMap<Character, Integer> hashtable = new HashMap<>();
            for (Character j = 'a'; j <= 'z'; j++) {
                hashtable.put(j, 0);
            }

            //按照每个数组的hash表的字母个数, 为哈希表赋值
            String str = strs[i];
            int m = str.length();
            for (int j = 0; j < m; j++) {
                char c = str.charAt(j);
                hashtable.put(c, hashtable.get(c) + 1);
            }

            //向哈希表的数组中, 添加哈希表
            hashtables.add(hashtable);
        }

        //双重循环遍历hash表, 判断是否相等, 相等则写入同一个列表????
        //
        Map<HashMap<Character, Integer>, List<String>> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = strs[i];
            HashMap<Character, Integer> t = hashtables.get(i);
            List<String> list = hashMap.getOrDefault(t, new ArrayList<>());
            list.add(str);
            hashMap.put(t, list);
        }

        return new ArrayList<List<String>>(hashMap.values());
    }
}
