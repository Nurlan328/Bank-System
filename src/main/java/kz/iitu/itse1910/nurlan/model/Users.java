package kz.iitu.itse1910.nurlan.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Scope("prototype")
@Entity
@Table(name = "Users", schema = "public")
@ApiModel
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @NotEmpty(message = "Name cannot be null")
    @NotNull(message = "Name cannot be null")
    @Size(min = 1, max = 16, message = "There must be at least 1 symbol, " +
            "and no more than 16")
    @Column(name = "FIRST")
    private String first;

    @NotEmpty(message = "Name cannot be null")
    @NotNull(message = "Name cannot be null")
    @Size(min = 1, max = 16, message = "There must be at least 1 symbol, " +
            "and no more than 16")
    @Column(name = "LAST")
    private String last;

    @Positive
    @Column(name = "AGE")
    @ApiModelProperty(name = "age", required = true, example = "20", notes = "user's age")
    private int age;

    @Column(name = "PASSWORD")
    @ApiModelProperty(name = "password", required = true, example = "admin", notes = "user's password")
    private String password;

    @Column(name = "username")
    @ApiModelProperty(name = "login", required = true, example = "admin", notes = "user's login")
    @NaturalId
    private String username;

    @Lob
    @Column(name = "photo")
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] photo;

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", age=" + age +
                '}';
    }
}
