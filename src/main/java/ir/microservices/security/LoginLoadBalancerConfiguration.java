package ir.microservices.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

public class LoginLoadBalancerConfiguration {

	@Autowired
	public IClientConfig ribbonClientConfig;
	
	@Bean
	public IPing ping(IClientConfig clientConfig){
		return new PingUrl();
	}
	
	@Bean
	public IRule rule(IClientConfig config){
		return new AvailabilityFilteringRule();
	}
		
}