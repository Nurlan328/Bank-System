package kz.iitu.itse1910.nurlan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "staff")
@Table
public class Staff {

    @Id
    private int staff_id;

}
