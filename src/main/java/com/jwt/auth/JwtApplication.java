package com.jwt.auth;

import com.jwt.auth.model.User;
import com.jwt.auth.quotes.AddOns;
import com.jwt.auth.quotes.InsuranceQuotes;
import com.jwt.auth.quotes.RisksCovered;
import com.jwt.auth.repo.AddOnRepo;
import com.jwt.auth.repo.InsuranceProductsRepo;
import com.jwt.auth.repo.RisksCoveredRepo;
import com.jwt.auth.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class JwtApplication {

/*
    private AddOnRepo addOnRepo;

    public JwtApplication(AddOnRepo addOnRepo) {
       this.addOnRepo = addOnRepo;
  }

 */





    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
/*
     @PostConstruct
     public void initUsers(){
        List<AddOns> risksCovereds= Stream.of(
               // new AddOns("Radio & Cassette",BigDecimal.valueOf(300),null),
                new AddOns("AA Membership",BigDecimal.valueOf(250),null),
               // new AddOns("Towing Service",BigDecimal.valueOf(300),null),
               // new AddOns("WindScreen",BigDecimal.valueOf(350),null),
               // new AddOns("Excess Protector",BigDecimal.valueOf(400),null),
                new AddOns("Garage Service",BigDecimal.valueOf(300),null)
               // new AddOns("Fire & Theft",BigDecimal.valueOf(400),null),
               // new AddOns("Courtesy Car",BigDecimal.valueOf(650),null)

                ).collect(Collectors.toList());
         addOnRepo.saveAll(risksCovereds);
    }

 */


    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(JwtApplication.class, args);
    }

}
