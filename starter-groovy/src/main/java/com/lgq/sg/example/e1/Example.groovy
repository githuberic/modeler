package com.lgq.sg.example.e1

class Example {
    static void main(String[] args) {
        // Using a simple println statement to print output to the console
        println('Hello World');

        def x = 5;
        println(x)

        def str = "Hello";
        println(str);

        //Initializing 2 variables
        int x1 = 5;
        int y1 = 6;
        //Printing the value of the variables to the console
        println("The value of X1 is " + x1 + "The value of Y1 is " + y1);

        range();
    }

    private static void range(){
        def range = 5..10;
        println(range)
        println(range.get(2))
    }
}
