package contentmanagement.service;

import contentmanagement.mapper.RoleMapper;
import contentmanagement.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("RoleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public int addRole(String name, String functions) {
        try {
            roleMapper.addRole(name, functions);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public Role queryRole(String name) {
        return roleMapper.queryRole(name);
    }

    @Override
    public List<Role> getAllRole() {
        return roleMapper.getAllRole();
    }

    @Override
    public int updateRole(String name, String functions) {
        try {
            roleMapper.updateRole(name, functions);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public int deleteRole(String name) {
        try {
            roleMapper.deleteRole(name);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

}
