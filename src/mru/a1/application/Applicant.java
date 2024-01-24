package mru.a1.application;

public class Applicant {
    private String firstName;
    private String lastName;
    private int age;
    private int score;

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
        String [] parameters = line.split("\t");

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
        return "{" +
            getFirstName() + " " + getLastName() + " " +getAge() + " " + getScore() + "}";
    }
}