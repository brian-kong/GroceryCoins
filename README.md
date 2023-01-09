# Grocery Coins/ Help your Mom Count Coins

As a kid, I saw a random lady paying the cashier with coins, accidentally dumping a bunch of coins on the table.
The cashier struggled to count the coins, taking over 3 minutes, while holding the line back. As you could guess,
I was that little bratty kid that thought "what's the hold up".

I thought what if she had an application that could count the coins in a snap. Then I would be out of that line...

Nowadays, my mother is starting to have difficulty seeing objects close-by. After having a similar incident at a
grocery store, I thought about developing this tiny-application to help count coins in a split second (or 10 seconds).

# What it does/built with (KEY FEATURE):

Using the OpenCV library, it takes an image (pre-process through greyscale, Canny Edge algorithm, and Gaussian blur) and
returns a list of circles in the image via their radius through HoughCircles algorithm. Then, the circle radiuses is used
to determine the coin and value through their given size.

# Challenges ran into:

1. Figuring out a robust pre-processing algorithm 
2. Dependency issues with javafx/maven
3. 

# What I learned

1. Understanding OpenCV library for Java
2. Further experience with Maven
3. Getting a working prototype up
4. Re-learning java syntax/general design patterns

# What's next:

1. Add in machine learning neural networks to identify coin (increase reliability/reduce variance)- tradeoff of bias/variance


