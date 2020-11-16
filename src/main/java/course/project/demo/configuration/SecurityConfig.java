package course.project.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
////                .csrf().disable()
////                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS) // сессию для каждого юзера не создаем
////                .and()
//                .authorizeRequests()
//                .antMatchers("/all").permitAll()
//                .antMatchers("/user").hasRole("USER")
//                .antMatchers("/admin").hasRole("ADMIN")
//                .and()
//                .formLogin().permitAll()
//                .loginPage("/login")
//                .failureUrl("/index");
        http.
                csrf().disable()
                .authorizeRequests()
                .antMatchers("/all").permitAll()
                .antMatchers("/user").hasAnyRole("ADMIN,USER")
                .antMatchers("/admin").hasRole("ADMIN")
                .and()
                .formLogin();

//        http.formLogin()
//                // указываем страницу с формой логина
//                .loginPage("/login")
//                // указываем action с формы логина
//                .loginProcessingUrl("/j_spring_security_check")
//                // указываем URL при неудачном логине
//                .failureUrl("/login?error")
//                // Указываем параметры логина и пароля с формы логина
//                .usernameParameter("j_username")
//                .passwordParameter("j_password")
//                // даем доступ к форме логина всем
//                .permitAll();


//        http.logout()
//                // разрешаем делать логаут всем
//                .permitAll()
//                // указываем URL логаута
//                .logoutUrl("/logout")
//                // указываем URL при удачном логауте
//                .logoutSuccessUrl("/test")
//                // делаем не валидной текущую сессию
//                .invalidateHttpSession(true);

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
