package cn.jiyun.wo.jiyunserviceconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class JiyunServiceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiyunServiceConsumerApplication.class, args);
    }
    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
}
