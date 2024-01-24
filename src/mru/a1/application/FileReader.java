package mru.a1.application;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    final static String INPUT_FOLDER = "/data/input/";
    final static String OUTPUT_FOLDER = "/data/output/";

    public static void main(String[] args) throws Exception {
        //
        // pattern of getting the input filename from the user
        //

        System.out.print("Input file: ");
        Scanner keyboard = new Scanner(System.in);
        String strFilename = keyboard.nextLine();

        //
        // because I expect that the user is only providing a filename, I need to build the
        // folder to the absolute location where the file is located, using the constants above
        //

        System.out.println(System.getProperty("user.dir"));
        String strWorkingFolder = System.getProperty("user.dir");

        //
        // build the absolute file path
        //

        File inputFile = new File(strWorkingFolder + INPUT_FOLDER + strFilename);
        // File inputFile = new File(strFilename);
        

        // sometimes getPath() and getAbsolutePath() will return the same information, but the more reliable way
        // to get the absolute file path is getAbsolutePath()

        System.out.println(inputFile.getAbsolutePath());

        // create a separate, independent Scanner object that is connected to the file

        Scanner scnInputFile = new Scanner(inputFile);

        // create arraylist of applicants

        ArrayList <Applicant> applicant_list = new ArrayList<Applicant>();

        while(scnInputFile.hasNext()) {

            // column 1 = first-name
            String firstName = scnInputFile.next();
            // column 2 = last-name
            String lastName = scnInputFile.next();
            // column 3 = age
            int age = scnInputFile.nextInt();
            // column 4 = score
            int score = scnInputFile.nextInt();

            //
            // print the values that were just read from the file
            //

            System.out.println(firstName + " " + lastName + " " + age + " " + score);

            //
            // create a new object of type Applicant using the information read above
            //

            Applicant applicant = new Applicant(firstName, lastName, age, score);
            System.out.println(applicant);

            //
            // add the applicant that was just created to our list of applicants
            //

            applicant_list.add(applicant);
        }

        // close the open file
        scnInputFile.close();
        // close the connection to the keyboard
        keyboard.close();

    }
}