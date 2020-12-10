package ua.lviv.iot.model.entity;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "man",schema = "andriy_moroz")
public class ManEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender")
    private String gender;


    @OneToMany(mappedBy = "manEntity")
    private List<ReviewEntity> reviewEntities;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ManEntity manEntity = (ManEntity) o;
        return id.equals(manEntity.id)
                && firstName.equals(manEntity.firstName)
                && lastName.equals(manEntity.lastName)
                && age.equals(manEntity.age)
                && Objects.equals(gender, manEntity.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age, gender);
    }

    public ManEntity() {
    }

    public ManEntity(Integer id, String firstName, String lastName, Integer age, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public ManEntity(String firstName, String lastName, Integer age, String gender) {
        this(-1, firstName, lastName, age, gender);
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Man{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
