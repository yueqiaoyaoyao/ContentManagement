package contentmanagement.service;

import org.apache.ibatis.annotations.Param;

public interface UserService {
    int addUser(String name,String password);
}
