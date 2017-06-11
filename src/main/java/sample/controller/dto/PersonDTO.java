package sample.controller.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonDTO {
    private Integer id;
    private String surname;
    private String name;
    private String patronymic;
    private Date birthdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonDTO)) return false;

        PersonDTO personDTO = (PersonDTO) o;

        if (!id.equals(personDTO.id)) return false;
        if (!surname.equals(personDTO.surname)) return false;
        if (!name.equals(personDTO.name)) return false;
        if (patronymic != null ? !patronymic.equals(personDTO.patronymic) : personDTO.patronymic != null) return false;
        return birthdate.equals(personDTO.birthdate);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + birthdate.hashCode();
        return result;
    }
}
