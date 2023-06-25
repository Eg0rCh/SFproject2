import comparator.StudentComparator;
import comparator.UniversityComparator;
import enums.StudentEnum;
import enums.UniversityEnum;
import io.XlsReader;
import io.XlsWriter;
import models.Statistics;
import models.Student;
import models.University;
import utils.ComparatorUtil;
import utils.JsonUtil;
import utils.StatisticsUtil;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//        List<University> universities =
//                XlsReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
//        UniversityComparator universityComparator =
//                ComparatorUtil.getUniversityComparator(UniversityEnum.YEAR_OF_FOUNDATION);
//        universities.stream()
//                .sorted(universityComparator)
//                .forEach(System.out::println);
//
//        List<Student> students =
//                XlsReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
//        StudentComparator studentComparator =
//                ComparatorUtil.getStudentComparator(StudentEnum.AVG_EXAM_SCORE);
//        students.stream()
//                .sorted(studentComparator)
//                .forEach(System.out::println);


        List<University> universities =
                XlsReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator =
                ComparatorUtil.getUniversityComparator(UniversityEnum.YEAR_OF_FOUNDATION);
        universities.sort(universityComparator);
        String universitiesJson = JsonUtil.universityListToJson(universities);
        // проверяем, что json создан успешно
        System.out.println(universitiesJson);
        List<University> universitiesFromJson = JsonUtil.jsonToUniversityList(universitiesJson);
        // проверяем, что обратно коллекция воссоздаётся в таком же количестве элементов
        System.out.println(universities.size() == universitiesFromJson.size());
        universities.forEach(university -> {
            String universityJson = JsonUtil.universityToJson(university);
            // проверяем, что json из отдельного элемента создан успешно
            System.out.println(universityJson);
            University universityFromJson = JsonUtil.jsonToUniversity(universityJson);
            // проверяем, что обратно элемент воссоздаётся
            System.out.println(universityFromJson);
        });

        List<Student> students =
                XlsReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator =
                ComparatorUtil.getStudentComparator(StudentEnum.AVG_EXAM_SCORE);
        students.sort(studentComparator);
        String studentsJson = JsonUtil.studentListToJson(students);
        // проверяем, что json создан успешно
        System.out.println(studentsJson);
        List<Student> studentsFromJson = JsonUtil.jsonToStudentList(studentsJson);
        // проверяем, что обратно коллекция воссоздаётся в таком же количестве элементов
        System.out.println(students.size() == studentsFromJson.size());
        students.forEach(student -> {
            String studentJson = JsonUtil.studentToJson(student);
            // проверяем, что json из отдельного элемента создан успешно
            System.out.println(studentJson);
            Student studentFromJson = JsonUtil.jsonToStudent(studentJson);
            // проверяем, что обратно элемент воссоздаётся
            System.out.println(studentFromJson);
        });

        List<Statistics> statisticsList = StatisticsUtil.createStatistics(students, universities);
        XlsWriter.writeXlsStatistics(statisticsList, "statistics.xlsx");


    }
}



