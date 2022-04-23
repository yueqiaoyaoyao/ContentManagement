package contentmanagement.service;

import contentmanagement.pojo.User;

public interface UserService {
    int addUser(String name,String password);
    User queryUserByName(String name);
}
