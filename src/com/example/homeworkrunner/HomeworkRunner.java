package com.example.homeworkrunner;

import com.example.homeworks.week1.Week1Homework;
import com.example.homeworks.week2.Week2Homework;
import com.example.homeworks.week3.Week3Homework;

public class HomeworkRunner {

    public static void main(String[] args) {
        Week1Homework h1 = new Week1Homework();
        h1.runHomework();

        Week2Homework h2 = new Week2Homework();
        h2.runHomework();

        Week3Homework h3 = new Week3Homework();
        h3.runHomework();
    }
}