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


//        17. Remove Null Values
//        Question: Remove null values from a list using filter.

        List<String> wordsss = Arrays.asList("Java", null, "Stream", null, "API");
        List<String> nonNullWords = wordsss.stream()
                .filter(w -> w!=null)
                .collect(Collectors.toList());
        System.out.println(nonNullWords);


//        18. Calculate Average of Numbers
//        Question: Calculate the average of a list of integers.

        List<Integer> numberssss = Arrays.asList(10, 20, 30, 40, 50);
        double avg = numberssss.stream()
                .mapToInt(i -> (int) i)
                .average().orElse(0.0);
        System.out.println(avg);

//        19. Collect Map from List
//        Question: Convert a list of strings into a map with the string as the key and its length as the value.

        List<String> wordssss = Arrays.asList("Java", "Stream", "API");
        Map<String , Integer> mapOfWordLength = wordssss.stream()
                .collect(Collectors.toMap(
                        wd -> wd,
                       wd -> wd.length()
                ));
        System.out.println(mapOfWordLength);

//        20. Partition Numbers into Even and Odd
//        Question: Partition a list of numbers into even and odd.
          List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
          Map<Boolean , List<Integer>> evenOdd = numbers.stream()
                  .collect(Collectors.partitioningBy(n -> n%2 ==0));
        System.out.println(evenOdd);

//        21. Find Nth Largest Element in a List
//        Question: Find the 3rd largest element in a list.

       int thirdLargestNum = numbers.stream()
               .sorted(Comparator.reverseOrder())
               .skip(2)
               .findFirst()
               .orElse(null);
        System.out.println(thirdLargestNum);


//        22. Find All Palindromic Strings
//        Question: Find all strings that are palindromes in a list.

                List<String> worddssss = Arrays.asList("radar", "level", "world", "java");

                List<String> palindromes = worddssss.stream()
                        .filter(sen-> sen.equals( new StringBuilder(sen).reverse().toString()))
                        .collect(Collectors.toList());
        System.out.println(palindromes);


//        24. Filter and Convert Map to List
//        Question: Given a map, filter entries with values greater than 10 and collect keys into a list.

        Map<String, Integer> map = Map.of("A", 5, "B", 15, "C", 10, "D", 20);
        List<String> numGreaterThan10 = map.entrySet()
                .stream().filter(m -> m.getValue() > 10)
                .map( m -> m.getKey())
                .collect(Collectors.toList());
        System.out.println(numGreaterThan10);
//
//        25. Remove Duplicates Without Collectors
//        Question: Remove duplicates from a list using distinct().

                List<Integer> numberrss = Arrays.asList(1, 2, 3, 2, 4, 3, 5);
                List<Integer> uniqueNumbers = numberrss.stream().distinct().collect(Collectors.toList());
                System.out.println(uniqueNumbers);

//        26. Find the Most Frequent Character in a String
//        Question: Find the most frequent character in a string.

        String input = "success";
        Optional<Character> c = input.chars()
                .mapToObj(ch -> (char) ch)
                .collect(
                        Collectors.groupingBy(
                                ch-> ch,

                                Collectors.counting()

                        )
                )
                .entrySet()
                        .stream()
                                .max(Map.Entry.comparingByValue())
                                        .map(Map.Entry::getKey);
        System.out.println(c);
//
//        27. Find Common Elements Between Two Lists
//        Question: Find common elements between two lists.

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);

        List<Integer> common = list1.stream()
                .filter(n -> list2.contains(n))
                .collect(Collectors.toList());
        System.out.println(common);
//
//        28. Find the Sum of Squares of Even Numbers
//        Question: Calculate the sum of squares of all even numbers in a list.

        List<Integer> numss = Arrays.asList(1, 2, 3, 4, 5, 6);
        int evenSumSqr = numss.stream()
                .filter(n -> n%2 == 0)
                .reduce(0 , (a ,b) -> a + (b*b));
        System.out.println(evenSumSqr);

//        29. Partition Strings by Palindrome
//        Question: Partition strings into palindromes and non-palindromes.

        List<String> wordsPartitioned = Arrays.asList("radar", "level", "java", "stream");

        Map<Boolean , List<String>> mapForPart = wordsPartitioned.stream()
                .collect(Collectors.partitioningBy(word -> word.equals(new StringBuilder(word).reverse().toString())));
        System.out.println(mapForPart);

//        30. Skip and Limit Elements
//        Question: Skip the first 3 elements and limit the result to the next 2.

        List<Integer> numbs = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> lt = numbs.stream()
                .skip(3)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(lt);
//
//        31. Find the Longest Word from a Sentence
//        Question: Find the longest word in a sentence using Streams.

                String sentence = "Java Stream API is very powerful";

                Optional<String> longWord = Arrays.asList(sentence.split(" "))
                        .stream()
                        .max(Comparator.comparing(String::length));
        System.out.println(longWord.get());









    }
}
