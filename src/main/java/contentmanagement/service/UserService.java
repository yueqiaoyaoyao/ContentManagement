package contentmanagement.service;

import contentmanagement.pojo.User;

import java.util.List;

public interface UserService {
    int addUser(String name,String password);
    User queryUserByName(String name);
    List<User> findAll();
    int modifyUser(String name,String password);
    int deleteUser(String name);
}
