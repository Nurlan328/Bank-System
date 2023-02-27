package kz.iitu.itse1910.nurlan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AuthRequest {

  @NotNull
  private String username;
  @NotNull
  private String password;
}
