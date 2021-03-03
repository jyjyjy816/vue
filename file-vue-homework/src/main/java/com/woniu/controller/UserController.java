package com.woniu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woniu.domain.User;
import com.woniu.dto.Result;
import com.woniu.dto.StatusCode;
import com.woniu.service.UserService;
import com.woniu.utils.Mysalt;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zyy
 * @since 2021-01-26
 */
@RestController
@RequestMapping("/user")
//@CrossOrigin
public class UserController {
    @Resource
    private UserService userService;

    //查询注册是否存在同名
    @GetMapping("checkName")
    public Result checkName(String username){
        System.out.println("username=====>>>>>"+username);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        User one = userService.getOne(queryWrapper);
        if(ObjectUtils.isEmpty(one)){
            return new Result(true,StatusCode.OK,"注册名字没有重复");
        }
        return new Result(false,StatusCode.MUCHNAME,"注册名字重复");
    }

    @PostMapping("register")
    public Result register(@RequestBody User user){
        System.out.println("register==="+user);
        String salt = Mysalt.getSalt(8);
        Md5Hash md5Hash=new Md5Hash(user.getPassword(),salt,1024);
        user.setPassword(md5Hash.toHex());
        user.setSalt(salt);
        boolean save = userService.save(user);
        if(save){
            return new Result(true,StatusCode.OK,"注册成功");
        }
        return new Result(false, StatusCode.ERRORREGISTER,"注册失败");
    }

    @PostMapping("login")
    public Result login(@RequestBody User user){
        System.out.println("login==="+user);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(user.getUsername(),user.getPassword()));
            if(subject.isAuthenticated()){
                QueryWrapper<User> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("username",user.getUsername());
                User userDB = userService.getOne(queryWrapper);
                return new Result(true, StatusCode.OK,"登录成功",userDB);
            }
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
            return new Result(false, StatusCode.ERRORLOGIN,"登录失败");
        }
        return new Result(false, StatusCode.ERRORLOGIN,"登录失败");
    }



}

