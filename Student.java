import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {
    private static int indexCounter = 1;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;
    private Date birthDate;
    private String indexNumber;
    private String status;
    private int currentSemester;
    private StudyProgramme studyProgramme;
    private List<Grade> grades;

    public Student(String firstName, String lastName, String email, String address, String phoneNumber, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.indexNumber = "s" + indexCounter++;
        this.status = "candidate";
        this.currentSemester = 1;
        this.grades = new ArrayList<>();
    }

    public void enrollStudent(StudyProgramme programme) {
        this.studyProgramme = programme;
        this.status = "student";
    }

    public void addGrade(int grade, String subject) {
        this.grades.add(new Grade(grade, subject));
    }

    public void promoteToNextSemester() {
        if (currentSemester >= studyProgramme.getNumberOfSemesters()) {
            this.status = "graduate";
        } else if (countITNs() <= studyProgramme.getAllowedITNs()) {
            this.currentSemester++;
        }
    }

    private int countITNs() {
        int itns = 0;
        for (Grade grade : grades) {
            if (grade.getGrade() < 3) {
                itns++;
            }
        }
        return itns;
    }


   public String getInfo() {
        return firstName + " " + lastName + ", Index: " + indexNumber + ",Semester: " +
                currentSemester + ",Status: " + status;
   }
}
