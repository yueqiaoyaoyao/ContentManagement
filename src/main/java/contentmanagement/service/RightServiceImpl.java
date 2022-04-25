package contentmanagement.service;

import contentmanagement.mapper.RightMapper;
import contentmanagement.pojo.Right;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RightService")
public class RightServiceImpl implements RightService{

    @Autowired
    RightMapper rightMapper;

    @Override
    public int addRight(String userName, String roleName) {
        try {
            rightMapper.addRight(userName, roleName);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public Right queryRight(String userName) {
        return rightMapper.queryRight(userName);
    }

    @Override
    public List<Right> getAllRight() {
        return rightMapper.getAllRight();
    }

    @Override
    public int updateRight(String userName, String roleName) {
        try {
            rightMapper.updateRight(userName, roleName);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public int deleteRight(String userName) {
        try {
            rightMapper.deleteRight(userName);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }
}
