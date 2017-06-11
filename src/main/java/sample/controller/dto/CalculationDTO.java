package sample.controller.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CalculationDTO implements Serializable {
    private Integer id;
    @XmlElement
    private ContractDTO contract;
    @XmlElement
    private ServiceTypeDTO serviceType;
    private boolean paid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ContractDTO getContract() {
        return contract;
    }

    public void setContract(ContractDTO contract) {
        this.contract = contract;
    }

    public ServiceTypeDTO getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceTypeDTO serviceType) {
        this.serviceType = serviceType;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "CalculationDTO{" +
                "id=" + id +
                ", contract=" + contract.getNum() +
                ", serviceTypeId=" + serviceType +
                ", paid=" + paid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CalculationDTO)) return false;

        CalculationDTO that = (CalculationDTO) o;

        if (paid != that.paid) return false;
        if (!id.equals(that.id)) return false;
        if (!contract.equals(that.contract)) return false;
        return serviceType.equals(that.serviceType);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + contract.hashCode();
        result = 31 * result + serviceType.hashCode();
        result = 31 * result + (paid ? 1 : 0);
        return result;
    }
}
