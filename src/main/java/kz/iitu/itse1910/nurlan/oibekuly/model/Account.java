package kz.iitu.itse1910.nurlan.oibekuly.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Scope("prototype")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@Entity(name = "account")
@Table
public class Account {

    @Id
    @Column(name = "account_id")
    private int account_id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "accountNumber")
    private long accountNumber;

    @Column(name = "balance")
    private long balance = 20000;
}



