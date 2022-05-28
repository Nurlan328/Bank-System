package kz.iitu.itse1910.nurlan.oibekuly.model;

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
@Entity(name = "category")
@Table(name = "category")
public class Category {

    @Id
    private int category_id;
}



