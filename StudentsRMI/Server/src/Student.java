import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "STUDENT")
@NamedQueries({
        @NamedQuery(name = "Student.findAll", query = "SELECT student FROM Student student"),
        @NamedQuery(name = "Student.findByName", query = "SELECT student FROM Student student WHERE student.name = :name"),
        @NamedQuery(name = "Student.findByEmail", query = "SELECT student FROM Student student WHERE student.email = :email"),
        @NamedQuery(name = "Student.findByStartDate", query = "SELECT student FROM Student student WHERE student.startDate = :startDate")
})

public class Student implements IStudent, Serializable {
    @Id
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "BIRTHDAY")
    private String birthday;
    @Column(name = "STARTDATE")
    private String startDate;

    public Student() {}

    public Student(String name, String email, String birthday, String startDate) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getStartDate() {
        return startDate;
    }

    @Override
    public String toString(){
        return name + " - " + email + " - " + birthday + " - " + startDate;
    }
}
