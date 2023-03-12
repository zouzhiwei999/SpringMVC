package com.atguigu.mvc.dao;

import com.atguigu.mvc.bean.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/5/23 19:09
 */
@Repository
public class UserDao {
    private static Map<Integer, User> Users = null;

    static{
        Users = new HashMap<Integer, User>();

        Users.put(1001, new User(1001, "E-AA", "aa@163.com", 1));
        Users.put(1002, new User(1002, "E-BB", "bb@163.com", 1));
        Users.put(1003, new User(1003, "E-CC", "cc@163.com", 0));
        Users.put(1004, new User(1004, "E-DD", "dd@163.com", 0));
        Users.put(1005, new User(1005, "E-EE", "ee@163.com", 1));
    }

    private static Integer initId = 1006;

    public void save(User User){
        if(User.getId() == null){
            User.setId(initId++);
        }
        Users.put(User.getId(), User);
    }

    public Collection<User> getAll(){
        return Users.values();
    }

    public User get(Integer id){
        return Users.get(id);
    }

    public void delete(Integer id){
        Users.remove(id);
    }
}
