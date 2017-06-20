package nl.first8.hu.ticketsale.sales;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class AuditTrial implements Serializable {

    @Id
    @GeneratedValue
    public Long id;

    public Long saleID;
    public Long accID;
}
