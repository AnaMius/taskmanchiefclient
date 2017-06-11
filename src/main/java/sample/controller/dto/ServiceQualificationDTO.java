package sample.controller.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceQualificationDTO {
    @XmlElement
    private ServiceTypeDTO serviceType;
    @XmlElement
    private SpecialtyDTO specialty;

    public ServiceTypeDTO getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceTypeDTO serviceType) {
        this.serviceType = serviceType;
    }

    public SpecialtyDTO getSpecialty() {
        return specialty;
    }

    public void setSpecialty(SpecialtyDTO specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "ServiceQualificationDTO{" +
                "serviceType=" + serviceType +
                ", specialty=" + specialty +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceQualificationDTO)) return false;

        ServiceQualificationDTO that = (ServiceQualificationDTO) o;

        if (!serviceType.equals(that.serviceType)) return false;
        return specialty.equals(that.specialty);
    }

    @Override
    public int hashCode() {
        int result = serviceType.hashCode();
        result = 31 * result + specialty.hashCode();
        return result;
    }
}
