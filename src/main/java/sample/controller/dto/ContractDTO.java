package sample.controller.dto;

import sample.controller.adapters.DateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ContractDTO {
    private Integer id;
    private String num;
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date date;
    @XmlElement
    private ClientDTO client;
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date endingDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    @Override
    public String toString() {
        return "ContractDTO{" +
                "id=" + id +
                ", num='" + num + '\'' +
                ", date=" + date +
                ", client=" + client.getName() +
                ", endingDate=" + endingDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContractDTO)) return false;

        ContractDTO that = (ContractDTO) o;

        if (!id.equals(that.id)) return false;
        if (!num.equals(that.num)) return false;
        if (!date.equals(that.date)) return false;
        if (!client.equals(that.client)) return false;
        return endingDate.equals(that.endingDate);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + num.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + client.hashCode();
        result = 31 * result + endingDate.hashCode();
        return result;
    }
}
