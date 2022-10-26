# Kings_Palindrome
 This is a program that generates a palindrome list from a list of numbers and checks whether it has special sequences. 

INPUT:
The input contains on the first line one of the natural numbers 1, 2 or 3 that
indicates the number of the task that needs to be solved in this program run.
The second line contains the natural number N which represents the number
of elements in the list received from the king’s advisor. The third line contains
the natural numbers from the corrupt list received from the advisor, separated
by a space.

OUTPUT:
The output should be one line that contains the output of the requested task.
If the first task has been solved, the output will contain N natural numbers,
separated by a space, representing the numbers in the correct list in the order
corresponding to the initial list. If task 2 is solved, the size of the largest magic
set should be printed. If task 3 is solved, the output should either contain the
elements of the largest magic set (with the largest X) separated by a space, or
the largest number in the correct list, in case no magic sets exist.

TASKS:
Task 1: The correct list obtained by Peter the Programmer;
Task 2: The number of elements of the largest magic set that can be obtained from
the correct list.
Task 3: The palindromes from which the largest magic set is formed, displayed in
ascending order. If there are several such largest magic sets on the correct
list, the one with the largest X is displayed. If there are no magic sets,
the largest number in the correct list is displayed.

MAGIC LIST:
We consider a subset of palindromes from the correct list and denote as X
the maximum value in this subset. We will say that such a subset is a magic
set if all the palindromes in it can be obtained from X by the method described
above. An example of a magic set is 4, 53435, 7534357, 89753435798, assuming
that all these numbers, among maybe other numbers, are present in the correct
list.