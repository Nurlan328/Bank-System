//package kz.iitu.itse1910.nurlan.oibekuly.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private DataSource dataSource;
//
////    private UserPrincipalDetailsService userPrincipalDetailsService;
////
////    public SecurityConfiguration(UserPrincipalDetailsService userPrincipalDetailsService) {
////        this.userPrincipalDetailsService = userPrincipalDetailsService;
////    }
//
//    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select username,password,'true' from users where username = ?")
//                .authoritiesByUsernameQuery("select username,roles "
//                        + "from users "
//                        + "where username = ?")
//                .passwordEncoder(encoder);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/index.html").permitAll()
//                .antMatchers("/**").permitAll()
//                .antMatchers("/static/**").permitAll()
//                .antMatchers("/profile/**").authenticated()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/management/**").hasAnyRole("ADMIN", "MANAGER")
//                .and()
//                .formLogin()
//                .loginProcessingUrl("/signin").successForwardUrl("/index")
//                .loginPage("/login").permitAll()
//                .defaultSuccessUrl("/index")
//                .usernameParameter("txtUsername")
//                .passwordParameter("txtPassword")
//                .and()
//                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
//                .and()
//                .rememberMe().tokenValiditySeconds(2592000).key("mySecret!").rememberMeParameter("checkRememberMe");
//    }
//
////    @Bean
////    DaoAuthenticationProvider authenticationProvider(){
////        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
////        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
////        daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);
////
////        return daoAuthenticationProvider;
////    }
//
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
