package models;

import enums.StudyProfile;

public class TestClass {
    public static void main(String[] args) {
        Student student = new Student();
        student.setAvgExamScore((float) 4)
                .setFullName("Ivan Petrov")
                .setUniversityId("001")
                .setCurrentCourseNumber(1);
        System.out.println(student);

        University university = new University();
        university.setId("002")
                .setFullName("Ivan Petrov")
                .setShortName("IP")
                .setYearOfFoundation(2000)
                .setMainProfile(StudyProfile.MEDICINE);
        System.out.println(university);


    }
}
