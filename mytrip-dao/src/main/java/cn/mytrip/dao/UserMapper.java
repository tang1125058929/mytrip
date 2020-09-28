package cn.mytrip.dao;



import cn.mytrip.beans.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 根据参数查询
     * @param params
     * @return
     */
    List<User> getUsersByWord(Map<String, Object> params);

    /**
     * 根据参数查询个数
     * @param params
     * @return
     */
    int getUserCountByWord(Map<String, Object> params);

    User getUserByUserCode(@Param("userCode") String userCode);

}
