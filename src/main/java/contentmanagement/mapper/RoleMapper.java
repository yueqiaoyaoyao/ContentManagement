package contentmanagement.mapper;

import contentmanagement.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RoleMapper {
    int addRole(String name, String functions);

    Role queryRole(String name);

    List<Role> getAllRole();

    int updateRole(String name, String functions);

    int deleteRole(String name);
}
