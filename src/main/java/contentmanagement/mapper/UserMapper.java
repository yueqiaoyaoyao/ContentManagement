package contentmanagement.mapper;

import contentmanagement.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    int addUser(String name,String password);
    User queryUserByName(String name);
}
