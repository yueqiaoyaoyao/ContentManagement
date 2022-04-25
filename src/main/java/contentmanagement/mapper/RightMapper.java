package contentmanagement.mapper;

import contentmanagement.pojo.Right;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RightMapper {

    int addRight(String userName, String roleName);

    Right queryRight(String userName);

    List<Right> getAllRight();

    int updateRight(String userName, String roleName);

    int deleteRight(String userName);

}
