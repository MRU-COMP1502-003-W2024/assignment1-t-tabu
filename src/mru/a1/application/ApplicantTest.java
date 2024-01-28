package mru.a1.application;

// Assert equals as seen from here https://www.guru99.com/junit-assert.html

class ApplicantTest {
    private void assertEquals(int i, int j) {
        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
    }

    @Test
    void testCalculateAgeScore() {
        // Test for calculateAgeScore method
        assertEquals(0, Applicant.calculateAgeScore(17));
        assertEquals(12, Applicant.calculateAgeScore(18));
        assertEquals(11, Applicant.calculateAgeScore(36));
        assertEquals(0, Applicant.calculateAgeScore(47));
    }

    @Test
    void testCalculateLangScore() {
        // Test for calculateLangScore method
        assertEquals(0, Applicant.calculateLangScore("0", "0", "0", "0", "no"));
        assertEquals(28, Applicant.calculateLangScore("10", "10", "10", "10", "yes"));
    }

    @Test
    void testCalculateEduScore() {
        // Test for calculateEduScore method
        assertEquals(5, Applicant.calculateEduScore("Secondary school (high school diploma)"));
        assertEquals(15, Applicant.calculateEduScore("One-year degree, diploma or certificate"));
        assertEquals(23, Applicant.calculateEduScore("University degree at the Doctoral (PhD) level"));
    }

    @Test
    void testCalculateWorkExpScore() {
        // Test for calculateWorkExpScore method
        assertEquals(0, Applicant.calculateWorkExpScore("0"));
        assertEquals(15, Applicant.calculateWorkExpScore("6"));
        assertEquals(11, Applicant.calculateWorkExpScore("3"));
    }

    @Test
    void testCalculateArrangedEmployment() {
        // Test for calculateArrangedEmployment method
        assertEquals(10, Applicant.calculateArrangedEmployment("yes"));
        assertEquals(0, Applicant.calculateArrangedEmployment("no"));
    }

    @Test
    void testCalculateAdaptabilityScore() {
        // Test for calculateAdaptabilityScore method
        assertEquals(5, Applicant.calculateAdaptabilityScore("yes", "yes", "yes", "yes", "yes", "yes", "yes"));
        assertEquals(0, Applicant.calculateAdaptabilityScore("no", "no", "no", "no", "no", "no", "no"));
    }

    @Test
    void testCalculateTotalScore() {
        // Test for calculateTotalScore method
        int totalScore = Applicant.calculateTotalScore(30, "8", "9", "10", "8", "no", "Bachelor's degree or other programs (three or more years)", "4", "yes", "yes", "yes", "yes", "yes", "yes", "yes", "yes");
        assertEquals(80, totalScore);
    }
}
