package sample.controller.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class TaskDTO {
    private Integer id;
    private Date date;
    @XmlElement
    private ContractDTO contract;
    @XmlElement
    private ServiceTypeDTO serviceType;
    private Date serviceDate;
    @XmlElement
    private PersonDTO person;
    @XmlElement
    private StatusDTO status;
    private Date endingDate;
    private String priority;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public PersonDTO getPerson() {
        return person;
    }

    public void setPerson(PersonDTO person) {
        this.person = person;
    }

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(StatusDTO status) {
        this.status = status;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", date=" + date +
                ", contract=" + contract +
                ", serviceType=" + serviceType +
                ", serviceDate=" + serviceDate +
                ", person=" + person +
                ", status=" + status +
                ", endingDate=" + endingDate +
                ", priority='" + priority + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskDTO)) return false;

        TaskDTO taskDTO = (TaskDTO) o;

        if (!id.equals(taskDTO.id)) return false;
        if (!date.equals(taskDTO.date)) return false;
        if (!contract.equals(taskDTO.contract)) return false;
        if (!serviceType.equals(taskDTO.serviceType)) return false;
        if (!serviceDate.equals(taskDTO.serviceDate)) return false;
        if (person != null ? !person.equals(taskDTO.person) : taskDTO.person != null) return false;
        if (!status.equals(taskDTO.status)) return false;
        if (!endingDate.equals(taskDTO.endingDate)) return false;
        return priority.equals(taskDTO.priority);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + contract.hashCode();
        result = 31 * result + serviceType.hashCode();
        result = 31 * result + serviceDate.hashCode();
        result = 31 * result + (person != null ? person.hashCode() : 0);
        result = 31 * result + status.hashCode();
        result = 31 * result + endingDate.hashCode();
        result = 31 * result + priority.hashCode();
        return result;
    }
}
