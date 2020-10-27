package com.example.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HomeworkUtils {

    public void printHomeworkHeading(int weekNo)
    {
        System.out.println("\n-----------------------------------------");
        System.out.println(String.format("             HOMEWORK WEEK %d", weekNo));
        System.out.println("-----------------------------------------");
    }

    public void printExerciseHeading(int exerciseNo) {
        System.out.println(String.format("\n    EXERCISE %d", exerciseNo));
        System.out.println("__________________");
    }

    public void printExerciseHeading(String exerciseName) {
        System.out.println(String.format("\n    EXERCISE: %s", exerciseName));
        System.out.println(new String(new char[exerciseName.length() + 18]).replace('\0', '-'));
    }

    protected int generateRandomNumberInRange(int min, int max) {
        return (int)Math.floor(Math.random()*(max-min + 1) + min);
    }

    private char generateRandomChar(String alphabet) {
        int index = generateRandomNumberInRange(0, alphabet.length() - 1);

        return alphabet.charAt(index);
    }

    private String generateRandomWord(int minLength, int maxLength) {
        String word = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int wordLength = this.generateRandomNumberInRange(minLength, maxLength);

        for (int i=0; i<wordLength; i++) {
            char randomLetter = this.generateRandomChar(alphabet);
            word += randomLetter;
        }

        return word;
    }

    public List<String> generateListOfRandomWords(int listMinLength, int listMaxLength, int wordsMinLength, int wordsMaxLength) {
        List<String> wordsList = new ArrayList<>();
        int listLength = this.generateRandomNumberInRange(listMinLength, listMaxLength);
        String word;

        for (int i = 0; i < listLength; i++) {
            word = this.generateRandomWord(wordsMinLength, wordsMaxLength);
            wordsList.add(word);
        }

        return wordsList;
    }

    public void printMap(Map<?,?> map) {
        Iterator<?> i = map.keySet().iterator();

        while (i.hasNext()) {
            String key = i.next().toString();
            System.out.println("Key:  " + key + ", Value:   " + map.get(key));
        }

        System.out.println("\n");
    }

}