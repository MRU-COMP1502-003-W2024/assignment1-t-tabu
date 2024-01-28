package mru.a1.application;

/**
 *
 * @param firstName               The first name of the applicant.
 * @param lastName                The last name of the applicant.
 * @param age                     The age of the applicant.
 * @param speakingCLB                The applicant's primary language speaking Canadian Language Benchmark (CLB).
 * @param listeningCLB               The applicant's primary language listening CLB.
 * @param readingCLB                 The applicant's primary language reading CLB.
 * @param writingCLB                The applicant's primary language writing CLB.
 * @param allCLB2                 'yes' or 'no' indicating if the applicant has CLB at least 5 in all language skills.
 * @param education               Text representing the education that the applicant has received.
 * @param workExperience          The number of years of relevant work experience.
 * @param arrangedEmployment      'yes' indicating if the applicant has arranged employment; 'no' otherwise.
 * @param spouseLang              'yes' or 'no' value representing whether the applicant's spouse has an acceptable language score.
 * @param spouseEducation         'yes' or 'no' value representing whether the applicant's spouse has relevant educational qualifications.
 * @param spouseWork              'yes' or 'no' value representing whether the applicant's spouse has relevant work experience.
 * @param applicantEducation      'yes' or 'no' value representing whether the applicant has completed at least 2 academic years of study in canada.
 * @param applicantWork           'yes' or 'no' value representing whether the applicant has relevant work experience.
 * @param applicantEmployment     'yes' or 'no' value representing whether the applicant has arranged employment.
 * @param relatives               'yes' or 'no' value representing whether the applicant has family in canada .
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

    /**
     * Calculates the applicant's age score based on age range.
     *
     * @param age The age of the applicant.
     * @return The calculated age score.
     */
    public static int calculateAgeScore (int age) {
        // parse int wil take the age string for the file and make it into a useable integer
        if (age < 18) {
            return 0;
        } else if (age >= 18 && age <= 35) {
            return 12;
        } else if (age >= 36 && age <= 46) {
            return 12 - (age - 35);
        } else {
            return 0;
        }
    }


    /**
     * Calculates the language score based on language proficiency in listening, speaking, reading, writing, and second language.
     *
     * @param speakingCLB     The applicant's speaking Canadian Language Benchmark (CLB).
     * @param listeningCLB    The applicant's listening CLB.
     * @param readingCLB      The applicant's reading CLB.
     * @param writingCLB      The applicant's writing CLB.
     * @param secondLanguageCLB Whether the applicant has CLB at least 5 in all language skills.
     * @return The calculated language score.
     */
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


    /**
     * Calculates the education score based on the level of education attained by the applicant.
     *
     * @param educationLevel Text representing the education level of the applicant.
     * @return The calculated education score.
     */
    public static int calculateEduScore (String educationLevel) {
        if (educationLevel.equals("Secondary school (high school diploma)")) {
            return 5;
        } else if (educationLevel.equals("One-year degree, diploma or certificate")) {
            return 15;
        } else if (educationLevel.equals("Two-year degree, diploma or certificate")) {
            return 19;
        } else if (educationLevel.equals("Bachelor's degree or other programs (three or more years)")) {
            return 21;
        } else if (educationLevel.equals("Two or more certificates, diplomas, or degrees")) {
            return 22;
        } else if (educationLevel.equals("Professional degree needed to practice in a licensed profession")) {
            return 23;
        } else if (educationLevel.equals("University degree at the Master's level")) {
            return 23;
        } else if (educationLevel.equals("University degree at the Doctoral (PhD) level")){
            return 25;
        } else return 0;
    }

    /**
     * Calculates the work experience score based on the number of years of relevant work experience.
     *
     * @param workExp The number of years of relevant work experience.
     * @return The calculated work experience score.
     */
    public static int calculateWorkExpScore (String workExp) {
        int yearsWorked = Integer.parseInt(workExp);

        if (yearsWorked >= 6) {
            return 15;
        } else if (yearsWorked == 4 || yearsWorked == 5) {
            return 13;
        } else if (yearsWorked == 2 || yearsWorked == 3) {
            return 11;
        } else if (yearsWorked == 1) {
            return 9;
        } else return 0;
    }

    /**
     * Calculates the arranged employment score based on whether the applicant has arranged employment.
     *
     * @param workResponse 'yes' indicating if the applicant has arranged employment; 'no' otherwise.
     * @return The calculated arranged employment score.
     */
    public static int calculateArrangedEmployment (String workResponse) {
        if (workResponse.equals("yes")) {
            return 10;
        } else return 0;
    }

        /**
     * Calculates the adaptability score based on various factors such as spouse language, education, work experience,
     * applicant's education, arranged employment, work history, and relatives in Canada.
     *
     * @param spouseLanguage     'yes' or 'no' value representing whether the applicant's spouse has a language scores in above 5 in all categories
     * @param spouseEducation    'yes' or 'no' value representing whether the applicant's spouse has relevant educational
     * @param spouseWork         'yes' or 'no' value representing whether the applicant's spouse has relevant work experience.
     * @param applicantEdu       'yes' or 'no' value representing whether the applicant has completed at least 2 academic years of study in Canada.
     * @param applicantArrangedWork 'yes' or 'no' value representing whether the applicant has arranged employment.
     * @param applicantWorkHis   'yes' or 'no' value representing whether the applicant has relevant work experience.
     * @param applicantRelative  'yes' or 'no' value representing whether the applicant has family in Canada.
     * @return The calculated adaptability score.
     */
    public static int calculateAdaptabilityScore (String spouseLanguage, String spouseEducation, String spouseWork, String applicantEdu, String applicantArrangedWork, String applicantWorkHis, String applicantRelative) {
        int adaptabilityScore = 0;

        {
            if (spouseLanguage.equals("yes"))
                adaptabilityScore += 5;
        }
        
        {
            if (spouseEducation.equals("yes"))
                adaptabilityScore += 5;
        }

        {
            if (spouseWork.equals("yes"))
                adaptabilityScore += 5;
        }

        {
            if (applicantEdu.equals("yes"))
                adaptabilityScore += 5;
        }

        {
            if (applicantRelative.equals("yes"))
                adaptabilityScore += 5;
        }

        {
            if (applicantArrangedWork.equals("yes"))
                adaptabilityScore += 5;
        }

        {
            if (applicantWorkHis.equals("yes"))
                adaptabilityScore += 5;
        }

        {
        if (adaptabilityScore > 10)
            adaptabilityScore = 10;
        }
        
        return adaptabilityScore;

    }

    /**
     * Calculates and returns the total score for the applicant using various scoring functions
     *
     * @return The total score for the applicant.
     */
    public static int calculateTotalScore(int age, String speakingCLB, String listeningCLB, String readingCLB, String writingCLB, String secondLanguageCLB, String educationLevel, String workExp, String workResponse, String spouseLanguage, String spouseEducation, String spouseWork, String applicantEdu, String applicantArrangedWork, String applicantWorkHis, String applicantRelative) {
        int totalScore = 0;
    
        // Calculate individual scores
        int ageScore = calculateAgeScore(age);
        int langScore = calculateLangScore(speakingCLB, listeningCLB, readingCLB, writingCLB, secondLanguageCLB);
        int eduScore = calculateEduScore(educationLevel);
        int workExpScore = calculateWorkExpScore(workExp);
        int arrangedEmploymentScore = calculateArrangedEmployment(workResponse);
        int adaptabilityScore = calculateAdaptabilityScore(spouseLanguage, spouseEducation, spouseWork, applicantEdu, applicantArrangedWork, applicantWorkHis, applicantRelative);
    
        // Sum up the individual scores
        totalScore = ageScore + langScore + eduScore + workExpScore + arrangedEmploymentScore + adaptabilityScore;
    
        return totalScore;
    }

}







