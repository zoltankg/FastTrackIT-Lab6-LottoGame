package fasttrackit.lottogame;

import java.util.*;

public class LottoV1 {

    private static final int MAXVALUE = 49;
    private static final int MAX_EXTRACTION_NUMBERS = 6;

    public static void main(String[] args) {

        Random lottoMachine = new Random();
        lottoMachine.setSeed(System.currentTimeMillis());
        int[] sixGeneratedNumbers = generateLottoNumbers(lottoMachine);
        int[] myNumbers = new int[MAX_EXTRACTION_NUMBERS];
        int[] wonNumbers = new int[MAX_EXTRACTION_NUMBERS];

        int tentatives = 0;
        int howManyWons = 0;



        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        do {

            // 1 read

           myNumbers =generateLottoNumbers(lottoMachine);
            // here are my numbers
//            System.out.println("here are my numbers:");
//            for (int i = 0; i < MAX_EXTRACTION_NUMBERS; i++)
//                System.out.print(myNumbers[i] + " |");
//
//            System.out.println("");


            //compare and tell if won
            howManyWons = 0;


            for (int i = 0; i < MAX_EXTRACTION_NUMBERS; i++)
                for (int j = 0; j < MAX_EXTRACTION_NUMBERS; j++) {

                    if (myNumbers[i] == sixGeneratedNumbers[j]) {
                        howManyWons++;
                        wonNumbers[howManyWons - 1] = sixGeneratedNumbers[j];
                    }
                }

            switch (howManyWons) {   // pay attention that the break is from switch not from do while :)

                case 4: // that is 4 numbers
                   System.out.println("congrat, you won 4 numbers after tentatives:"+tentatives);
                    break;
                case 5: // that is 5 numbers
                    System.out.println("congrat, you won 5 numbers after tentatives:"+tentatives);
                    break;
                case 6: // that is 6 numbers
                    System.out.println("WOW, you won 6 numbers after tentatives:"+tentatives);
                    break;
                default:
                  //  System.out.println("you are a looser, but keep trying, you guessed " + howManyWons + " numbers");
                    break;
            }

            tentatives++;
        } while (howManyWons < 4);




            //extraction
            // 3 print the extraction
            System.out.println("here is the extraction today:");
            for (int i = 0; i < MAX_EXTRACTION_NUMBERS; i++)
                System.out.print(sixGeneratedNumbers[i] + " |");

            System.out.println("");

        // our winning ticket
        System.out.println("here is our winning ticket:");
        for (int i = 0; i < MAX_EXTRACTION_NUMBERS; i++)
            System.out.print(myNumbers[i] + " |");

        System.out.println("");


        System.out.println("tentatives:"+tentatives);
            System.out.println("here is what you won: ");
            for (int i = 0; i < MAX_EXTRACTION_NUMBERS; i++)
                if (wonNumbers[i] != 0)
                    System.out.print(wonNumbers[i] + " |");


    }




    // does not have bugs
    private static int[] generateLottoNumbers(Random lottoMachine) {
        // 2 prepare the lotto machine and init it


        // 2 generate the numbers
        int[] sixGeneratedNumbers = new int[MAX_EXTRACTION_NUMBERS];
        for (int i = 0; i < MAX_EXTRACTION_NUMBERS; i++) {

            int nr = lottoMachine.nextInt(MAXVALUE) + 1;

            //check if nr is not already in the array, if it is generate a new one
            boolean nrChanged;
            do {
                nrChanged = false;
                for (int j = 0; j <= i; j++) {
                    if (sixGeneratedNumbers[j] == nr) {
                        nr = lottoMachine.nextInt(MAXVALUE) + 1;
                        nrChanged = true;
                       // System.out.println("*** Duplication correction applied ***");
                    }
                }
            }
            while (nrChanged);

            sixGeneratedNumbers[i] = nr;


        }

//        // 3 print the extraction
//        System.out.println("here is the extraction today:");
//        for (int i = 0; i < MAX_EXTRACTION_NUMBERS; i++)
//            System.out.print(sixGeneratedNumbers[i] + " |");
//
//        System.out.println("");
        return sixGeneratedNumbers;
    }

}
