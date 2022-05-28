package kz.iitu.itse1910.nurlan.oibekuly.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Scope("prototype")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "premise")
@Table
public class Premise {
    @Id
    private int premise_id;

}






