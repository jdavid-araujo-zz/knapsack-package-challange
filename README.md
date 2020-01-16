# knapsack-package-challange

Application to solve a specific problem using knapsack. Get the list of index that hava the
total weight is less than or equal to the package limit and the total cost is as large as possible.

# How to run

To build the project you need have the maven installed, then access the project root directory
 
By default, the application is available at `http://localhost:8080/`
 
 # Technologies Used
 
 1. Java as programming language
 2. Libraries:
    - Junit - testing framework for Java
 3. Maven as software project management and comprehension tool.
 
 # Unit tests
 
 The project has unit tests for test the main features. The tests may run using the Junit
 
 # Example
 
 ### Input
 
    81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)
    8 : (1,15.3,€34)
    75 : (1,85.31,€29) (2,14.55,€74) (3,3.98,€16) (4,26.24,€55) (5,63.69,€52) (6,76.25,€75) (7,60.02,€74) (8,93.18,€35) (9,89.95,€78)
    56 : (1,90.72,€13) (2,33.80,€40) (3,43.15,€10) (4,37.97,€16) (5,46.81,€36) (6,48.77,€79) (7,81.80,€45) (8,19.36,€79) (9,6.76,€64)
  
  ### Output

    4
    -
    2,7
    8,9
