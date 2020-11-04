package com.example.homework.week3;

import com.example.homework.Runnable;
import com.example.utils.HomeworkUtils;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Week3Homework extends HomeworkUtils implements Runnable {

    private boolean runExercise2(String str1, String str2) {
        /*
            2. Create a method that takes two strings as input,
               and returns true if the strings are equal in length
         */

        return (str1 != null) && (str2 != null) && str1.length() == str2.length();
    }

    private String runExercise3(String str) {
        /*
            3. Create a method that takes a string as input,
               formats the string so that the vowels are uppercase
               and consonants are lowercase and returns the formatted string
         */

        return str.toUpperCase()
                .replace('A', 'a')
                .replace('E', 'e')
                .replace('I', 'i')
                .replace('O', 'o')
                .replace('U', 'u');
    }

    private Map<String, Integer> runExercise4(int[] intArr) {
        /*
            4. Create a method that takes an array of integers as input,
               and returns a map containing the number of even integers
               and odd integers as two separate keys with corresponding values.
                   a. Example: [1,2,6,13,1,20,56,17,12] -> {even:5 ,odd: 4}
         */

        Map<String, Integer> m = new HashMap<>();

        m.put("even", (int)Arrays.stream(intArr).filter(i -> (i % 2 == 0)).count());
        m.put("odd", (int)Arrays.stream(intArr).filter(i -> (i % 2 == 1)).count());

        return m;

        /* Alternative solution:
        Map<String, Integer> m = new HashMap<>();
        int oddNumbers=0, evenNumbers = 0;

        for(int num : intArr) {
            if (num%2==0)
                evenNumbers++;
            else
                oddNumbers++;
        }

        m.put ("Even Numbers", evenNumbers);
        m.put ("Odd Numbers", oddNumbers);

        return m;
        */
    }

    private int[] runExercise5(int[] intArr) {
        /*
            5. Create a method that takes as input an array of integers
               that can contain multiple occurrences of the same value,
               return an array containing only the unique values
                   a. Example: [1,4,5,4,2,5] -> [1,4,5,2]
         */

        return Arrays.stream(intArr).distinct().toArray();

        /* Alternative solution:
        List<Integer> l = new ArrayList<>();

        for(int num : intArr) {
            if (!l.contains(num))
                l.add(num);
        }

        return l.stream().mapToInt(Integer::intValue).toArray();
         */
    }

    private Map<String, Map<String, Integer>> runExercise6(List<List<String>> listList) {
        /*
            6. Create a method that takes as input an array of strings array
               (List<List<String>>). Find the string with the largest number of vowels,
               and the string with the largest number of consonants respectively.
               If there are multiple strings with the same max number,
               save them both as an array. Return the result as a map:
                   a. Result example:
                      {largestVowelsNo : {[aaaastring,eeaastring]: 5} ,
                      largestConsonantsNo: {bbbbstring: 9}}
         */

        Map<String, Map<String, Integer>> result = new HashMap();
        Map<String, Integer> vMap = new HashMap<>();
        Map<String, Integer> cMap = new HashMap<>();
        List<String> vWords = new ArrayList<>();
        List<String> cWords = new ArrayList<>();
        int maxVowels = 0;
        int maxConsonants = 0;
        Pattern v = Pattern.compile("[aeiouAEIOU]");
        Pattern c = Pattern.compile("[^aeiouAEIOU]");
        Matcher vm = v.matcher("");
        Matcher cm = c.matcher("");

        for (List<String> strList : listList) {
            for (String str : strList) {
                if (str == null) {
                    continue;
                }

                vm.reset(str);
                cm.reset(str);
                int vCount = vm.results().toArray().length;
                int cCount = cm.results().toArray().length;
                
                if (vCount > maxVowels) {
                    vWords.clear();
                    vWords.add(str);
                    maxVowels = vCount;
                } else if (vCount == maxVowels) {
                    vWords.add(str);
                }

                if (cCount > maxConsonants) {
                    cWords.clear();
                    cWords.add(str);
                    maxConsonants = cCount;
                } else if (cCount == maxConsonants) {
                    cWords.add(str);
                }
            }
        }

        vMap.put(Arrays.toString(vWords.toArray()), maxVowels);
        cMap.put(Arrays.toString(cWords.toArray()), maxConsonants);
        result.put("largestVowelsNo", vMap);
        result.put("largestConsonantsNo", cMap);
        return result;
    }

    private Object runExercise7(String str) {
        /*
            7. Create a method that takes a string as input.
               If it contains multiple occurrences of the same
               character consecutively, return that occurrence sequence:
                   a. Example: thisstringisweird -> ss
                   b. Optional: if there are multiple occurrences
                      (sss, aaa etc), return them as an array
         */

        Pattern p = Pattern.compile("([A-Za-z])\\1+");
        Matcher m = p.matcher(str);
        List<String> groupsList = new ArrayList<>();

        while (m.find()) {
            groupsList.add(m.group());
        }

        int count = groupsList.size();

        if (count == 0)
            return "No occurrences found";
        else if (count == 1)
            return groupsList.get(0);
        else
            return Arrays.toString(groupsList.toArray());
    }

    public void runHomework() {
        this.printHomeworkHeading(3);

        // 2
        this.printExerciseHeading(2);

        System.out.println(this.runExercise2("anna", null));
        System.out.println(this.runExercise2("", null));
        System.out.println(this.runExercise2(null, null));
        System.out.println(this.runExercise2("Anna", "john"));
        System.out.println(this.runExercise2("a", ""));

        // 3
        this.printExerciseHeading(3);

        List<String> words = this.generateListOfRandomWords(10, 10, 5, 10);
        for (String word : words) {
            System.out.println((words.indexOf(word) + 1) + ". Initial word: " + word + "; transformed word: " + this.runExercise3(word));
        }

        // 4
        this.printExerciseHeading(4);

        this.printMap(this.runExercise4(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        this.printMap(this.runExercise4(new int[]{1, 1, 1, 1, 1, 1, 3, 5, 7, 9}));

        // 5
        this.printExerciseHeading(5);

        System.out.println(Arrays.toString(this.runExercise5(new int[]{1, 1, 2, 3, 4, 1, 5, 6, 5, 7, 8, 9, 10})));
        System.out.println(Arrays.toString(this.runExercise5(new int[]{1, 1, 1, 1})));

        // 6
        this.printExerciseHeading(6);

        List<List<String>> testList = new ArrayList<>();
        testList.add(new ArrayList<String>(Arrays.asList("aaaaaaaadsdsaaarfweeei", null)));
        testList.add(new ArrayList<String>(Arrays.asList("l", "bbbbbbbbbbbbba")));
        testList.add(new ArrayList<String>(Arrays.asList("e", "m")));
        testList.add(new ArrayList<String>(Arrays.asList("aaaaaaaadsdsaaarfweeeo", null)));
        System.out.println(testList);
        System.out.println(this.runExercise6(testList));

        // 7
        this.printExerciseHeading(7);

        System.out.println(this.runExercise7("this string is weird"));
        System.out.println(this.runExercise7("thisstringisweird"));
        System.out.println(this.runExercise7("thissstringgisweirdddd"));

    }
}
