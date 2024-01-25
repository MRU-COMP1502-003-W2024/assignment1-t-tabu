package mru.a1.application;

/**
 *
 */
public class Applicant {
    private String firstName;
    private String lastName;
    private int age;
    private int score;

    private static int applicantCounter = 0;

    public static void increaseCounter() {
        applicantCounter++;
    }

    public static void decreaseCounter() {
        applicantCounter--;
    }

    public static int getApplicantCounter() {
        return applicantCounter;
    }

    public Applicant(String paramFirstName, String paramLastName, int paramAge, int paramScore) {
        firstName = paramFirstName;
        lastName = paramLastName;
        age = paramAge;
        score = paramScore;
    }
    
    public Applicant(String paramFirstName, String paramLastName, String paramAge, String paramScore) {
        firstName = paramFirstName;
        lastName = paramLastName;
        //
        // code to be developed together in Tuesday lab
        //
        age = Integer.valueOf(paramAge);
        score = Integer.valueOf(paramScore);
    }

    public Applicant(String line) {
        String [] parameters = line.split(" ");
        //
        // code to be developed together in Tuesday lab
        //
        firstName = parameters[0];
        lastName = parameters[1];
        age = Integer.valueOf(parameters[2]);
        score = Integer.valueOf(parameters[3]);
    }

    //
    // getters and setters for firstname
    //
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //
    // getters and setters for lastname
    //
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //
    // getters and setters for age
    //
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    //
    // getters & setters for score
    //
    public int getScore() {
        return this.score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " " + getAge() + " " + getScore();
    }

    public static int calculateAgeScore (String age) {
        int ageInt = Integer.parseInt(age);
        // parse int wil take the age string for the file and make it into a useable integer
        if (ageInt < 18) {
            return 0;
        } else if (ageInt >= 18 && ageInt <= 35) {
            return 12;
        } else if (ageInt >= 36 && ageInt <= 46) {
            return 12 - (ageInt - 35);
        } else {
            return 0;
        }
    }

    public static int calculateLangScore (String speakingCLB, String listeningCLB, String readingCLB, String writingCLB, String secondLanguageCLB){
    int speakingPoints = 0;
    int listeningPoints = 0;
    int writingPoints = 0;
    int readingPoints = 0;
    int secondLanguagePoints = 0;
    if (speakingCLB.equals("9") || speakingCLB.equals("10")) {
        speakingPoints = 6;
    } else if (speakingCLB.equals("8")) {
        speakingPoints = 5;
    } else if (speakingCLB.equals("7")) {
        speakingPoints = 4;
    } else {
        speakingPoints = 0;
    }
    
    if (listeningCLB.equals("9") || listeningCLB.equals("10")) {
        listeningPoints = 6;
    } else if (listeningCLB.equals("8")) {
        listeningPoints = 5;
    } else if (listeningCLB.equals("7")) {
        listeningPoints = 4;
    } else {
        listeningPoints = 0;
    }
    
    if (readingCLB.equals("9") || readingCLB.equals("10")) {
        readingPoints = 6;
    } else if (readingCLB.equals("8")) {
        readingPoints = 5;
    } else if (readingCLB.equals("7")) {
        readingPoints = 4;
    } else {
        readingPoints = 0;
    }
    
    if (writingCLB.equals("9") || writingCLB.equals("10")) {
        writingPoints = 6;
    } else if (writingCLB.equals("8")) {
        writingPoints = 5;
    } else if (writingCLB.equals("7")) {
        writingPoints = 4;
    } else {
        writingPoints = 0;
    }
    
    if (secondLanguageCLB.equals("yes")) {
        secondLanguagePoints = 4;
    } else {
        secondLanguagePoints = 0;
    }
    
    int totalPoints = speakingPoints + listeningPoints + readingPoints + writingPoints + secondLanguagePoints;
    if (totalPoints > 28) {
        totalPoints = 28;
    }
    return totalPoints;

    
    }

    public static int calculateEduScore (String educationLevel){
        if (educationLevel.equals("Secondary school (high school diploma)"));
            return 5;
        else if (educationLevel.equals(''))
    }
}
