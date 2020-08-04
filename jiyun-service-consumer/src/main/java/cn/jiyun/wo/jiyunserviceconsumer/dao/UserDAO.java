package cn.jiyun.wo.jiyunserviceconsumer.dao;

import cn.jiyun.wo.jiyunserviceconsumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class UserDAO {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;
    public User queryUserById(Long id){
       /* String url="http://localhost:8081/user/"+id;

        return this.restTemplate.getForObject(url,User.class);
*/

        List<ServiceInstance> li=discoveryClient.getInstances("service-provider");
        ServiceInstance instance = li.get(0);

        //获取ser-p的信息
        String url="http://"+instance.getHost()+":"+instance.getPort()+"/user/"+id;

        return this.restTemplate.getForObject(url,User.class);

    }
}
