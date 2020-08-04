package cn.jiyun.wo.jiyunserviceconsumer.service;

import cn.jiyun.wo.jiyunserviceconsumer.dao.UserDAO;
import cn.jiyun.wo.jiyunserviceconsumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    public List<User> queryUserById(List<Long> ids){
        List<User> users =new ArrayList<>();
        ids.forEach(id->{
            users.add(this.userDAO.queryUserById(id));
        });
        return users;
    }
}
