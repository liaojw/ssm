package com.liaojw.ssm.controller;

import com.liaojw.ssm.common.Result;
import com.liaojw.ssm.model.User;
import com.liaojw.ssm.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by LJW on 2017/3/29.
 */
@Controller
@RequestMapping("system")
public class SystemController {

    Logger logger = Logger.getLogger(SystemController.class);

    @Autowired
    private IUserService iUserService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody User user){
        Result result = new Result();
        try {
            User u = iUserService.selectUser(new User().setAccount(user.getAccount()).setPassword(user.getPassword()));
            if(u != null){
                result.setCode(200).setMsg("Success").setData(u);
            }else{
                result.setCode(300).setMsg("Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e, e.fillInStackTrace());
        }
        return result;
    }

}
