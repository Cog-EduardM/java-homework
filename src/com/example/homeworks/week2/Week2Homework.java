package com.example.homeworks.week2;

import com.example.homeworks.Homework;
import com.example.utils.HomeworkUtils;
import java.util.*;

public class Week2Homework extends HomeworkUtils implements Homework {
    private String vowelWords;
    private List<String> consonantWords;
    private List<String> randomWordsList;

    private void checkStringsEquality(String str1, String str2) {
        String message = str1.equals(str2) ?
                String.format("Strings \"%s\" and \"%s\" are equal.", str1, str2) :
                String.format("Strings \"%s\" and \"%s\" are not equal.", str1, str2);
        System.out.println(message);
    }

    private void printConcatenatedString(String str1, String str2) {
        String concatStr = str1.concat(str2);
        System.out.println(concatStr);
    }

    private void isPalindrome(String word) {
        String message = word.concat(" is a palindrome.");

        for (int i=0; i<=word.length()/2; i++) {
            if (word.toLowerCase().charAt(i) != word.toLowerCase().charAt(word.length() - (1 + i))) {
                message = word.concat(" is not a palindrome.");
                break;
            }
        }

        System.out.println(message);
    }

    private void replaceSpecialWordsInList() {
        for (int i = 0; i < randomWordsList.size(); i++) {
            String word = randomWordsList.get(i);

            switch (word.charAt(0)) {
                case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> this.vowelWords += (word.toLowerCase() + " ");
                default -> this.consonantWords.add(word.toUpperCase());
            }

            if (word.toLowerCase().contains("x") || word.length() < 3) {
                System.out.println(String.format("    Word \"%s\" at index %d was replaced with \"special\".", word, i));
                randomWordsList.set(i, "special");
            }
        }
    }

    private void runExercise1() {
        this.printExerciseHeading(1);

        /*
            1. Given two strings, check if the strings are equal.
               After that, concatenate them into one single string
         */
        String str1 = "Some words";
        String str2 = "sOME WORDS";
        String str3 = "Some words";

        this.checkStringsEquality(str1, str2);
        this.checkStringsEquality(str1, str3);
        this.printConcatenatedString(str1, str2);
    }

    private void runExercise2() {
        this.printExerciseHeading(2);

        /*
            2. Given a one word string, return true if the string is a palindrome
               (word that reads the same forwards or backwards - e.g. madam, mom, abba )
         */
        String[] wordsArray = new String[]{"Abba", "abba", "madam", "Madam", "abca"};

        for (String word : wordsArray) {
            this.isPalindrome(word);
        }
    }

    private void runExercise3() {
        this.printExerciseHeading(3);

        /*
            3. Create 3 variables: an empty string, an empty list of strings, and a list of strings
               where each string consists of random upper and lowercase letters
         */
        this.vowelWords = "";
        this.consonantWords = new ArrayList<>();
        this.randomWordsList = this.generateListOfRandomWords(10,20,1,10);

        /*
            Iterate the list.
                i)   If the word starts with a vowel, make it all lowercase and append it to the empty string
                ii)  If the word starts with a consonant, make it all uppercase and add it to the empty array
                iii) If the word contains letter x or X or has less than 3 letters, replace the word with "special"
                     and print into the console the current word and the replaced word
         */
        System.out.println("Before iterating the list:");
        System.out.println("- List of random words: " + this.randomWordsList.toString());
        System.out.println("- String of words that start with vowel: " + this.vowelWords);
        System.out.println("- List of words that start with vowel: " + this.consonantWords.toString());
        System.out.println("\n");
        this.replaceSpecialWordsInList();
        System.out.println("\n");
        System.out.println("After iterating the list:");
        System.out.println("- List of random words: " + this.randomWordsList.toString());
        System.out.println("- String of words that start with vowel: " + this.vowelWords);
        System.out.println("- List of words that start with vowel: " + this.consonantWords.toString());

    }

    private void runExercise4() {
        this.printExerciseHeading(4);

        /*
            4. Create an empty map that will contain Name and Email as key-value pairs
         */
        Map<String, String> nameEmailMap = new HashMap<>();

        // a. Add a couple of K-V entries
        nameEmailMap.put("John Doe", "John.Doe@random-email.com");
        nameEmailMap.put("Richard Roe", "Richard.Roe@random-email.com");
        nameEmailMap.put("John Q", "John.Q@random-email.com");
        nameEmailMap.put("Albert Smith", "Albert.Smith@random-email.com");
        System.out.println("Map entries:");
        this.printMap(nameEmailMap);

        // b. Get the size of the map
        System.out.println("Map size is: " + nameEmailMap.size());

        // c. Check that map contains a specific name
        String name1 = "John";
        String name2 = "John Doe";
        System.out.println("Does map contain name " + name1 + "? " + nameEmailMap.containsKey(name1));
        System.out.println("Does map contain name " + name2 + "? " + nameEmailMap.containsKey(name2));

        // d. Get the email that contains a specific name
        System.out.println(name2 + "'s email is: " + nameEmailMap.get(name2));

        // e. Remove an entry
        System.out.println("\nMap entries before deletion:");
        this.printMap(nameEmailMap);

        System.out.println("Removing " + name2 + "...");
        nameEmailMap.remove(name2);

        System.out.println("Map entries after deletion:");
        this.printMap(nameEmailMap);

        // f. Sort the map by key
        Map<String, String> tm = new TreeMap<>(nameEmailMap);

        System.out.println("Unsorted map:");
        this.printMap(nameEmailMap);
        System.out.println("Sorted map:");
        this.printMap(tm);
    }

    public void runHomework() {
        this.printHomeworkHeading(2);
        this.runExercise1();
        this.runExercise2();
        this.runExercise3();
        this.runExercise4();
    }

}