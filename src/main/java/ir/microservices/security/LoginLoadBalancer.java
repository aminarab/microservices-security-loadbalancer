package ir.microservices.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RibbonClient(name = "login-service-config", configuration = LoginLoadBalancerConfiguration.class)
public class LoginLoadBalancer {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	public RestTemplate restTemplate;

	@RequestMapping("/login")
	public String login() {
//		return restTemplate.getForObject("http://localhost:7777/login", String.class);
		return restTemplate.getForObject("http://login-service/login", String.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(LoginLoadBalancer.class, args);
	}

}
