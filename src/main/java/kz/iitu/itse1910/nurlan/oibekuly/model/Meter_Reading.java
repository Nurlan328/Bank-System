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
@Entity
@Table(name = "meter_reading")
public class Meter_Reading {

    @Id
    private int meter_reading_id;

    private int dayOfMonth;

    private String month;

    private int year;

    private long amount;
}







