//package kz.iitu.itse1910.nurlan.oibekuly.controller;
//
//
//import io.swagger.v3.oas.annotations.tags.Tag;
//import kz.iitu.itse1910.nurlan.oibekuly.dto.AuthRequest;
//import kz.iitu.itse1910.nurlan.oibekuly.dto.UserDto;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.oauth2.jwt.JwtClaimsSet;
//import org.springframework.security.oauth2.jwt.JwtEncoder;
//import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//import java.time.Instant;
//
//import static java.lang.String.format;
//import static java.util.stream.Collectors.joining;
//
//@Tag(name = "Authentication")
//@RestController
//@RequestMapping(path = "api/public")
//@RequiredArgsConstructor
//public class AuthApi {
//
//  private final AuthenticationManager authenticationManager;
//  private final JwtEncoder jwtEncoder;
//
//  @PostMapping("login")
//  public ResponseEntity<UserDto> login(@RequestBody @Valid AuthRequest request) {
//    try {
//      Authentication authentication = authenticationManager
//        .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
//
//      User user = (User) authentication.getPrincipal();
//
//      Instant now = Instant.now();
//      long expiry = 36000L;
//
//      String scope = authentication.getAuthorities().stream()
//        .map(GrantedAuthority::getAuthority)
//        .collect(joining(" "));
//
//      JwtClaimsSet claims = JwtClaimsSet.builder()
//        .issuer("example.io")
//        .issuedAt(now)
//        .expiresAt(now.plusSeconds(expiry))
//        .subject(format("%s,%s", user.getUsername(), user.getPassword()))
//        .claim("roles", scope)
//        .build();
//
//      String token = this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
//
//      return ResponseEntity.ok()
//        .header(HttpHeaders.AUTHORIZATION, token)
//        .body(null);
//    } catch (BadCredentialsException ex) {
//      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//    }
//  }
//}
