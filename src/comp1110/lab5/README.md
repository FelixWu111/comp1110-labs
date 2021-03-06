# COMP1110 Lab 5

## Before the Lab

* Complete week 6 of your personal journal, commit and push at least 5 minutes prior to your lab.

* The first week back from the lecture break will be [lab test 2](https://cs.anu.edu.au/courses/comp1110/assessments/labtest2/). Don't forget- you will still need to complete your personal journal for week 7, commit and push prior to your lab test.

* There are no scheduled labs for Week 8- Don't forget to complete week 8 of your personal journal, commit and push during week 8.

* Make sure you've covered the modules [**J9**](https://cs.anu.edu.au/courses/comp1110/lectures/java/#J9) (Lambda expressions) and [**X1**](https://cs.anu.edu.au/courses/comp1110/lectures/javafx/#X1) (JavaFX)

## Purpose

In this lab you will write a simple Java FX program and use any spare time to prepare for lab test 2.

**It is essential that you complete this lab and have a tutor mark it off during the lab**.

## A simple JavaFX animation

Your objective here is to familiarize yourself further with JavaFX by creating
a simple window with a moving 'ant'.

In the Java package comp1110.lab5, within your comp1110-labs repository, create a new Java class, `Ant`, that draws the path of an ant that is walking randomly around a JavaFX window. This should look a little like a scribbling on a page. If the ant walks off the edge of the screen re-center the ant and continue the random walk. Use the basic template from the code from lecture X01. In addition to that, you may find the following helpful:

````java
...
primaryStage.setScene(scene);

Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100),
                            ae -> {
                                   /* your code goes here */
                                  }));
timeline.setCycleCount(Animation.INDEFINITE);
timeline.play();
primaryStage.show();
...
````
that little bit of code will be called once every 100 milliseconds (10 times a second).


![alt ant](assets/lab5.png)

## Prepare for lab test 2.

Use any spare time you have to work on preparing for lab test 2 and working on your group assignment.

## Extension

**Use recursion to reverse an ArrayList**

Create a recursive method reverseArray.

The method should take an ArrayList of characters and return the same ArrayList with the characters reversed.
E.g. if you start with `['a','b','c','d','e']` the method should return `['e','d','c','b','a'].

For the method to be recursive, it needs to call itself at some point. 


**Use recursion to print a triangle (harder)**

Create a method `trianglePrinter`.

The method should take an integer as input, and print out a triangle with that many rows.The triangle should look like the triangle from lab 2, except the bottom row should have spaces instead of stars.
For example, if you run trianglePrinter(5):
```
____*
___*_*
__*___*
_*_____*
*_______*

```
To be recursive, the method needs to call itself at some point.
