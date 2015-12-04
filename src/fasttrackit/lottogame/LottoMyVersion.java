package fasttrackit.lottogame;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Agu on 12/3/2015.
 */

public class LottoMyVersion {

    private static final int INPUT_SIZE = 6;

    private static final int MIN_NUMBER_POSSIBLE = 1;

    private static final int MAX_NUMBER_POSSIBLE = 49;

    private Set<Integer> userNumbers = new HashSet<Integer>();

    private Set<Integer> randomNumbers = new HashSet<Integer>();

    public static void main(String[] args) {
        LottoMyVersion c = new LottoMyVersion();
        c.generateRandomNumbers();
        System.out.println("Pick " + INPUT_SIZE + " numbers from " +  MIN_NUMBER_POSSIBLE +  " to " + MAX_NUMBER_POSSIBLE + ".");
        c.readUserNumbers();
        if (c.doUserNumbersMatchRandomNumbers()) {
            System.out.println("You win :) !");
        } else {
            System.out.println("Sorry you failed :( !");
            c.showRandomNumbersToUser();
        }
    }

    private void generateRandomNumbers() {
        Random random = new Random();
        for (int i = 1; i <= INPUT_SIZE; i++) {
            randomNumbers.add(random.nextInt(MAX_NUMBER_POSSIBLE));
        }
    }

    private void showRandomNumbersToUser() {
        System.out.println("Random numbers where : ");
        for (Integer randomNumber : randomNumbers) {
            System.out.print(randomNumber + " ");
        }
    }

    private void readUserNumbers() {
        Scanner input = new Scanner(System.in);
        int inputSize = 1;
        while (input.hasNextInt() && inputSize < INPUT_SIZE) {
            int numberChoosen = input.nextInt();
            if (numberChoosen < MIN_NUMBER_POSSIBLE || numberChoosen > MAX_NUMBER_POSSIBLE) {
                System.out.println("Your number must be in " + MIN_NUMBER_POSSIBLE + " - " + MAX_NUMBER_POSSIBLE + " range.");
            } else {
                userNumbers.add(numberChoosen);
                inputSize++;
            }
        }
    }

    private boolean doUserNumbersMatchRandomNumbers() {
        for (Integer userNumber : userNumbers) {
            if (!randomNumbers.contains(userNumber)) {
                return false;
            }
            printMatchingNumber(userNumber);
        }
        return true;
    }

    private void printMatchingNumber(int num) {
        System.out.println("Your number, " + num + ", has been called.");
    }
}