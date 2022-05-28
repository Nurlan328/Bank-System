package kz.iitu.itse1910.nurlan.oibekuly.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

//@Scope("prototype")
//@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "bill")
@Table(name = "bill")
public class Bill  {

    @Id
    @Column(name = "bill_id")
    private int bill_id;

    @Column(name = "bill_customer_id")
    private int bill_customer_id;

    @Column(name = "bill_number")
    private int bill_number;

    @Column(name = "amount")
    private long amount;

    @OneToOne
    @JoinColumn(name = "account")
    private Account account = new Account();

    @Column(name = "description")
    private String description;
}




