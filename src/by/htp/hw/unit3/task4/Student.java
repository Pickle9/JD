import java.util.Date;

public class Student {

    private long id;
    private String lastName;
    private String name;
    private String patronymic;
    private Date birthday;
    private String address;
    private String mobileNumber;
    private String faculty;
    private int course;


    public Student(long id, String lastName, String name, String patronymic, Date birthday, String address, String mobileNumber, String faculty, int course) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.faculty = faculty;
        this.course = course;
    }


    public long getId() {return id;}

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getCourse() {
        return course;
    }



    public void setId(long id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setCourse(int course) {
        this.course = course;
    }



    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", faculty='" + faculty + '\'' +
                ", course=" + course +
                '}';
    }

    public void deduct(long id, String lastName, String name, String patronymic, Date birthday, String address, String mobileNumber, String faculty, int course) {

    }

    public static void main(String[] args) {

    }
}
