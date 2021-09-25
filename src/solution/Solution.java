package solution;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static Map<String, Integer> buildSortedArrayByString(String word) {
        Map<String, Integer> lettersSorted = new TreeMap<>();
        var wordSplit = word.split("");

        // Insert the letter into the collection and count the repetitions
        Stream.of(wordSplit).forEach(letter -> {
            if (lettersSorted.containsKey(letter)) {
                lettersSorted.put(letter, lettersSorted.get(letter) + 1);
            } else {
                lettersSorted.put(letter, 1);
            }
        });

        // Sort the collection by value, following the DESC order
        return lettersSorted.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1, LinkedHashMap::new
            ));
    }

    public static void main(String[] args) {
        var test1 = buildSortedArrayByString("aoNHQATeMNLuWC4vMdGgQpqMge7bit");
        var test2 = buildSortedArrayByString("IhavebeenworkingwithDevOpstoolslikeKubernetesJenkinsTravisRancherDocker");
        var test3 = buildSortedArrayByString("IwouldliketoworkatAthenaWorks");

        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);
    }

}
