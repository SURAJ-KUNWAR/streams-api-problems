package final_streams_api_revision;

import java.util.*;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
//        1. Filter Even Numbers from a List
//        Question: Given a list of integers, filter the even numbers.
        List<Integer> list = Arrays.asList(5,4,3,2,1);
        List<Integer> evenNumbers = list.stream().filter(n-> n%2 == 0).collect(Collectors.toList());
        System.out.println(evenNumbers);

//        2. Find Maximum in a List
//        Question: Find the maximum number from a list of integers.
        int max = list.stream().max(Integer::compare).orElseThrow();
        System.out.println(max);
//
//        3. Sort a List
//        Question: Sort a list of integers in descending order.
        List<Integer> sorted = list.stream().sorted(Integer::compare).collect(Collectors.toList()).reversed();
        System.out.println(sorted);
//
//        4. Count Strings with Specific Prefix
//        Question: Count strings starting with a specific prefix, e.g., “A”.
        List<String> names = Arrays.asList("Alice", "Bob", "Annie", "Alex", "Charlie");
        long cntOfNameWithA = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(cntOfNameWithA);

//        5. Find First Non-Repeated Character in a String
//        Question: Find the first non-repeated character in a string.
        String s = "swiss";
        Optional<Character> firstNonRepeating = s.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> s.indexOf(c) == s.lastIndexOf(c))
                .findFirst();

        Optional<Character> result = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        c -> c,
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();

//        6. Convert List of Strings to Uppercase
//        Question: Convert all strings in a list to uppercase.

        List<String> namess = Arrays.asList("java", "stream", "api");
        List<String> capNames = namess.stream().map(n -> n.toUpperCase()).collect(Collectors.toList());
        System.out.println(capNames);

//        7. Sum of Numbers in a List
//        Question: Calculate the sum of all numbers in a list.
        int sum = list.stream()
                        .mapToInt(i -> (int) i)
                                .sum();
        System.out.println(sum);

//        8. Check if Any String Matches a Condition
//        Question: Check if any string in a list contains “API”.

        List<String> strings = Arrays.asList("Java", "Stream API", "Lambda");
        boolean isMatch  = strings.stream()
                .anyMatch(sa -> sa.contains("API"));
        System.out.println(isMatch);

//        9. Find Duplicate Elements in a List
//        Question: Identify duplicate elements in a list.

        List<Integer> numbersss = Arrays.asList(1, 2, 3, 4, 2, 5, 1);
        List<Integer> dups = numbersss.stream()
                .collect(Collectors.groupingBy(
                        n-> n,
                        HashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() >1)
                .map(mp -> mp.getKey())
                .collect(Collectors.toList());

        long dupss = numbersss.stream()
                .collect(Collectors.groupingBy(
                        n-> n,
                        HashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() >1)
                .map(mp -> mp.getKey())
                .count();
        System.out.println(dupss);

//        10. Group Strings by Length
//        Question: Group a list of strings based on their length.

        List<String> words = Arrays.asList("Java", "Stream", "API", "Code", "Fun");
        Map<Integer , List<String>> grpByWord = words.stream()
                .collect(Collectors.groupingBy(
                        st -> st.length()
                ));
        System.out.println(grpByWord);

//        11. Flatten a List of Lists
//        Question: Given a list of lists, flatten it into a single list.

                List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );
                List<Integer> flattenList = listOfLists.stream()
                        .flatMap(List::stream)
                        .collect(Collectors.toList());
        System.out.println(flattenList);
//        12. Concatenate Strings
//        Question: Concatenate all strings in a list into a single string.

        List<String> wordss = Arrays.asList("Stream", "API", "is", "powerful");
        String concatSt = wordss.stream()
                .reduce((a ,b) -> a+b).orElse(null);
        System.out.println(concatSt);

//        13. Find the Longest String
//        Question: Find the longest string in a list.
        String longestString =  wordss.stream()
                .reduce((a ,b) -> a.length() > b.length() ? a: b).orElse(null);
        System.out.println(longestString);

//        14. Count Frequency of Characters in a String
//        Question: Count the frequency of each character in a string.

                String inputt = "success";
                Map<Character , Long> freqOfChar = inputt.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(
                                c -> c,
                                HashMap::new,
                                Collectors.counting()
                        ));
        System.out.println(freqOfChar);



    }
}
