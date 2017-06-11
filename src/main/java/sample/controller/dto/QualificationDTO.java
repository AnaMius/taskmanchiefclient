package sample.controller.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class QualificationDTO {
    @XmlElement
    private PersonDTO person;
    @XmlElement
    private SpecialtyDTO specialty;
    private boolean available;

    public PersonDTO getPerson() {
        return person;
    }

    public void setPerson(PersonDTO person) {
        this.person = person;
    }

    public SpecialtyDTO getSpecialty() {
        return specialty;
    }

    public void setSpecialty(SpecialtyDTO specialty) {
        this.specialty = specialty;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "QualificationDTO{" +
                "person=" + person +
                ", specialty=" + specialty +
                ", salary=" + available +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QualificationDTO)) return false;

        QualificationDTO that = (QualificationDTO) o;

        if (available != that.available) return false;
        if (!person.equals(that.person)) return false;
        return specialty.equals(that.specialty);
    }

    @Override
    public int hashCode() {
        int result = person.hashCode();
        result = 31 * result + specialty.hashCode();
        result = 31 * result + (available ? 1 : 0);
        return result;
    }
}
