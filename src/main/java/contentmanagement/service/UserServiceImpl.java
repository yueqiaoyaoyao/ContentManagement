package contentmanagement.service;

import contentmanagement.mapper.UserMapper;
import contentmanagement.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public int addUser(String name, String password) {
        try {
            userMapper.addUser(name,password);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }


}
