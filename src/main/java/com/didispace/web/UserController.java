package com.didispace.web;

import com.didispace.beans.User;
import com.didispace.database.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value="/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    // 创建线程安全的Map
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User> ());
    static {
        User user = new User ();
        user.setId (10000L);
        user.setName ("benylwang");
        user.setAge (30);

        users.put (user.getId (), user);
    }

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value="/", method=RequestMethod.GET)
    public List<User> getUserList() {
        // 处理"/users/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        System.out.println ("===getUserList===");
        List<User> r = new ArrayList<User> (users.values());
        return r;
    }

    @ApiOperation(value="获取用户", notes="")
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        System.out.println ("===getUser===" + id);
        User user = users.get (id);
        return user;
    }

    @ApiOperation(value="增加用户", notes="")
    @RequestMapping(value="/", method = RequestMethod.POST)
    public Integer addUser(@RequestBody User user) {
        System.out.println ("===addUser===" + user);
        Long id =  user.getId ();
        User u = users.get (id);
        if (u != null) {
            return -1;
        } else {
            users.put (id, user);
            return 0;
        }
    }

    @ApiOperation(value="更新用户信息", notes="")
    @RequestMapping(value="/update/{id}", method = RequestMethod.PUT)
    public Integer updateUser(@PathVariable Long id, @RequestBody User user) {
        System.out.println ("===updateUser==id=" + id + " :" + user);
        User u = users.get (id);
        if (u == null) {
            return -1;
        } else {
            u.update (user);
            return 0;
        }
    }

    @ApiOperation(value="更新用户名称", notes="给出指定用户的名称")
    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public Integer updateUserName(@PathVariable Long id, @RequestParam String name) {
        System.out.println ("===updateUserName==id=" + id + " :" + name);
        User u = users.get (id);
        if (u == null) {
            return -1;
        } else {
            u.setName (name);
            return 0;
        }
    }

    @ApiOperation(value="删除用户", notes="")
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public Integer deleteUser(@PathVariable Long id) {
        System.out.println ("===deleteUser==id=" + id);
        User u = users.remove (id);
        if (u == null) {
            return -1;
        } else {
            return 0;
        }
    }
}
