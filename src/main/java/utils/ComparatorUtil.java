package utils;

import comparator.*;
import enums.StudentEnum;
import enums.UniversityEnum;

public class ComparatorUtil {
    private ComparatorUtil() {
    }

    public static StudentComparator getStudentComparator(StudentEnum studentEnum) {
        switch (studentEnum) {
            case ID -> {
                return new SUniversityIdComparator();
            }
            case FULL_NAME -> {
                return new SFullNameComparator();
            }
            case COURSE_NUMBER -> {
                return new SCourseComparator();
            }
            case AVG_EXAM_SCORE -> {
                return new SAvgExamScoreComparator();
            }
            default -> throw new IllegalArgumentException("Некорректное значение" + studentEnum);

        }
    }

    public static UniversityComparator getUniversityComparator(UniversityEnum universityEnum) {
        switch (universityEnum) {
            case ID -> {
                return new UIdComparator();
            }
            case SHORT_NAME -> {
                return new UShortNameComparator();
            }
            case FULL_NAME -> {
                return new UFullNameComparator();
            }
            case YEAR_OF_FOUNDATION -> {
                return new UYearOfFoundationComparator();
            }
            case STUDY_PROFILE -> {
                return new UStudyProfileComparator();
            }
            default -> throw new IllegalArgumentException("Некорректное значение" + universityEnum);
        }
    }
}
