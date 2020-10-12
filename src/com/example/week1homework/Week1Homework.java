package com.example.week1homework;

public class Week1Homework {
    public static void main(String[] args) {
        // 5. Define and print on separate lines following data types:
        System.out.println("------------------");
        System.out.println("-   EXERCISE 5   -");
        System.out.println("------------------");

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

        // 6. Define some integer variables. Perform the operations below and print the result
        System.out.println("------------------");
        System.out.println("-   EXERCISE 6   -");
        System.out.println("------------------");

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

        // 7. Using an if-else statement, compare the values, and
        /*
         * if a is larger, print "<value of a> is larger than <value of b>"
         * if b is larger, print "<value of b> is larger than <value of a>"
         * if numbers are equal, print "<value of a> is equal to <value of b>"
         */
        System.out.println("------------------");
        System.out.println("-   EXERCISE 7   -");
        System.out.println("------------------");

        String message;
        if(a>b) {
            message = a + " is larger than " + b;
        } else if (b>a) {
            message = b + " is larger than " + a;
        } else {
            message = a + " is equal to " + b;
        }
        System.out.println(message);

        // 8. Define a number array of 10 elements, using random values from range 1 to 100.
        // Using a for loop, print only the even numbers
        System.out.println("------------------");
        System.out.println("-   EXERCISE 8   -");
        System.out.println("------------------");

        byte[] number = new byte[10];
        for (int i=0; i<number.length; i++) {
            number[i] = (byte)(Math.floor(Math.random()*100 + 1));
            if (number[i] % 2 == 0)
                System.out.println("Index: " + i + ", Value: " + number[i]);
        }
    }
}
