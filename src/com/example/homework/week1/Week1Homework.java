package com.example.homework.week1;

import com.example.utils.HomeworkUtils;
import com.example.homework.Homework;

public class Week1Homework extends HomeworkUtils implements Homework {

    private void runExercise5() {
        this.printExerciseHeading(5);

        // 5. Define and print on separate lines following data types:
        // Primitive - boolean
        boolean myPrimitiveBoolean = true;
        System.out.println("myPrimitiveBoolean: " + myPrimitiveBoolean);

        // Primitive - char
        char myPrimitiveChar = '%';
        System.out.println("myPrimitiveChar: " + myPrimitiveChar);

        // Primitive - int
        int myPrimitiveInt = 17;
        System.out.println("myPrimitiveInt: " + myPrimitiveInt);

        // Primitive - long
        long myPrimitiveLong = 5L;
        System.out.println("myPrimitiveLong: " + myPrimitiveLong);

        // Primitive - double
        double myPrimitiveDouble = 3.0d;
        System.out.println("myPrimitiveDouble: " + myPrimitiveDouble);

        // Non primitive - String
        String myNonPrimitiveString = "Hello World";
        System.out.println("myNonPrimitiveString: " + myNonPrimitiveString);

        // Non primitive - Integer
        Integer myNonPrimitiveInteger = 15;
        System.out.println("myNonPrimitiveInteger: " + myNonPrimitiveInteger);
    }

    private void runExercise6() {
        this.printExerciseHeading(6);

        // 6. Define some integer variables. Perform the operations below and print the result
        int a = 17;
        int b = 3;

        // Increment it using the unary operator
        System.out.println("a++: " + a++);
        System.out.println("++b: " + ++b);

        // Perform some random arithmetic operations using the arithmetic operators
        System.out.println("Addition: " + (a+b));
        System.out.println("Subtraction: " + (a-b));
        System.out.println("Multiplication: " + (a*b));
        System.out.println("Division: " + (a/b));

        // Compare two variables using the comparison operator
        System.out.println("b is greater than a - " + (b>a));
    }

    private void runExercise7() {
        this.printExerciseHeading(7);

        /*
            7. Define two integer variables, a and b.
               Using an if-else statement, compare the values, and:
                - if a is larger, print "<value of a> is larger than <value of b>"
                - if b is larger, print "<value of b> is larger than <value of a>"
                - if numbers are equal, print "<value of a> is equal to <value of b>"
         */
        int a = 5;
        int b = 7;
        String message;

        if(a>b) {
            message = a + " is larger than " + b;
        } else if (b>a) {
            message = b + " is larger than " + a;
        } else {
            message = a + " is equal to " + b;
        }

        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println(message);
    }

    private void runExercise8() {
        this.printExerciseHeading(8);

        /*
            8. Define a number array of 10 elements, using random values from range 1 to 100.
               Using a for loop, print only the even numbers
        */
        byte[] number = new byte[10];

        for (int i=0; i<number.length; i++) {
            number[i] = (byte)(this.generateRandomNumberInRange(1,100));
            if (number[i] % 2 == 0)
                System.out.println("Index: " + i + ", Value: " + number[i]);
        }
    }

    public void runHomework() {
        this.printHomeworkHeading(1);
        this.runExercise5();
        this.runExercise6();
        this.runExercise7();
        this.runExercise8();
    }
}