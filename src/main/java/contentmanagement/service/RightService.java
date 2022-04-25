package contentmanagement.service;



import contentmanagement.pojo.Right;

import java.util.List;

public interface RightService {

    int addRight(String userName, String roleName);

    Right queryRight(String userName);

    List<Right> getAllRight();

    int updateRight(String userName, String roleName);

    int deleteRight(String userName);

}
