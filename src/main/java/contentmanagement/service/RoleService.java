package contentmanagement.service;

import contentmanagement.pojo.Role;

import java.util.List;

public interface RoleService {
    int addRole(String name, String functions);

    Role queryRole(String name);

    List<Role> getAllRole();

    int updateRole(String name, String functions);

    int deleteRole(String name);
}
