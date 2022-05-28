package kz.iitu.itse1910.nurlan.oibekuly.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FeedBack {

    private String customerName;

    @Email
    private String email;

    private String description;

}










