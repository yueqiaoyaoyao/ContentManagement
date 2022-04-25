package contentmanagement.mapper;

import contentmanagement.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    int addUser(String name,String password);
    User queryUserByName(String name);
    List<User> findAll();
    int modifyUser(String name,String password);
    int deleteUser(String name);
}
