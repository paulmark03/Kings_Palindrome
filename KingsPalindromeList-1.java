import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


/**
 * Reads a list of numbers, and can reconstruct the corresponding list of Palindromes,
 * produce the size of the largest magic set, and the content of that magic set.
 * 
 * TODO: Documentation
 *        We use this program in order to corect the king's corupted list and fulfil
 *        one of his tasks. For the first task the program returns the corected list.
 *        For the second task the program sorts the list in a descendin order and then
 *        checks if there is any magic set. In ordder to do this the program cuts the 
 *        ends of each number and checks the pressence of the now cut number in the list.
 *        It also stores the largest list in a different array (maxList) for the purpose
 *        of solving the third task which is to return the largest magic list. The program
 *        uses several methods in order to solve these tasks.
 * 
 * END TODO
 * 
 * @author Paul Marcu
 * @ID 1844989
 */
class KingsPalindromeList {

    /**
    * Takes a number and returns its square root.
    * @param number The value to be checked if palindrome.
    * @return True if number is palindrome, false otherwise.
    */
    public boolean palindromeCheck(long number) {
        long copy = number;
        long inverse = 0;
        while (copy != 0) {
            inverse = inverse * 10 + (copy % 10);
            copy = copy / 10;
        }
        return inverse == number;
    }

    /**
    * Takes a number and returns it without its ends(e.g. 134 => 3).
    * @param number The value to be cut.
    * @return result or 0 if the number is less than 100.
    */
    public long cutMargins(long number) {
        long copy = number;
        long result = 0;
        while (copy != 0) { 
            if (!(copy == number || copy / 10 == 0)) {
                result = result * 10 + (copy % 10);
            }
            copy = copy / 10;
        }
        return result;
    }

    /**
    * Takes a number and returns the next palindrome.
    * @param number The value to be added 1 to .
    * @return the next palindrome.
    */  
    public long findNextPalindrome(long number) {
        while (!this.palindromeCheck(number)) {
            number++;
        }
        return number;
    }

    /**
    * takes an array and sorts it in descending order.
    * @param array The array that is given , arrayLength The length of the array.
    * @return the array sorted.
    */
    public void sortDesc(long[] array, int arrayLength) {
        long temp;
        for (int i = 0; i < (arrayLength - 1); i++) {
            for (int j = 0; j < arrayLength - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int taskNumber;
        int arrayLength;
        long[] corruptedList = new long[50000];
        long[] goodList = new long[50000];

        KingsPalindromeList kpl = new KingsPalindromeList();
        
        //read inputs
        taskNumber = scanner.nextInt();
        arrayLength = scanner.nextInt();
        for (int i = 0; i < arrayLength; i++) {
            corruptedList[i] = scanner.nextLong();
        }
        scanner.close();

        //get correct palindromes
        for (int i = 0; i < arrayLength; i++) {
            goodList[i] = kpl.findNextPalindrome(corruptedList[i]);
        }

        //task1
        if (taskNumber == 1) {
            for (int i = 0; i < arrayLength; i++) {
                System.out.print(goodList[i] + " ");
            }

        //task2
        } else if (taskNumber == 2 || taskNumber == 3) {

            //input the neccessary variables for task 2 and 3
            int maxim = 1;
            long[] magicList = new long[10];
            long[] maxList = new long[10];
            int counter;
            long trimmed;
            
            //sort the new list of palindromes in descendent order
            kpl.sortDesc(goodList, arrayLength);

            //compare the palindromes in the list in order to get the magic sets
            for (int i = 0; i < arrayLength - 1; i++) {
                counter = 1;
                magicList[counter - 1] = goodList[i]; 
                trimmed = kpl.cutMargins(goodList[i]);
                //we also store each magic set in order to get the largest one for task 3
                while (trimmed != 0) {
                    for (int j = i + 1; j < arrayLength; j++) {
                        if (goodList[j] == trimmed) {
                            counter++;
                            magicList[counter - 1] = goodList[j]; 
                            break; //we break bcause there are only distinct palindromes
                        }
                    }
                    trimmed = kpl.cutMargins(trimmed);
                }
                //store the longest magic set in maxList and its length in maxim
                if (counter > maxim) {
                    maxim = counter;
                    for (int idx = 0; idx < counter; idx++) {
                        maxList[idx] = magicList[counter - 1 - idx];
                    }
                }
            }
            if (taskNumber == 2){
                System.out.println(maxim);
            } else if (maxim > 1) {
                //we check to see if we have any magic sets and if not we
                //display
                //the largest palindrome in the list  
                for (int i = 0; i < maxim; i++) {
                    System.out.print(maxList[i] + " ");
                }
            } else {
                System.out.println(goodList[0]);
            }
        }
    }
}