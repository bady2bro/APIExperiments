package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.TreeSet;

public class TestExercitiu {
    //Write a Java program to reverse the order of the words of a phrase.
    // (Hint: Use a loop).Expected behaviour: "Anna has apples" -> "apples has Anna"
    @Test
    public void exercitiu(){
        boolean itSums=canGetSum(10,new int[]{1, 2, 3, 4, 5});
        Assert.assertTrue(itSums);
//        String phrase = "Anna has apples";
//        List<String> words = new ArrayList<>(List.of(phrase.split(" ")));
//        List<String> reverseWords = new ArrayList<>();
//        Collections.reverse(words);
//        System.out.println(words);
//        int size = words.size();
//        for (int i = 0; i<size; i++) {
//            reverseWords.add(words.get(size-1-i));
//        }
//        System.out.println(String.join(" ", reverseWords));

    }

    public boolean canGetSum( int sum, int[] integers){
        TreeSet<Integer> diffs = new java.util.TreeSet<>(Collections.emptySet());
        for (int n: integers){
            boolean d = diffs.add(sum-n);
            if (d && sum-n==n){
                continue;
            }
            boolean x = diffs.add(n);
            if (!d || !x){
                return true;
            }
        }
        return false;
    }
}
