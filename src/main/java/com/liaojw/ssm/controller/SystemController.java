package com.liaojw.ssm.controller;

import com.liaojw.ssm.common.Result;
import com.liaojw.ssm.model.User;
import com.liaojw.ssm.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by LJW on 2017/3/29.
 */
@Controller
@RequestMapping("/system")
public class SystemController {

    Logger logger = Logger.getLogger(SystemController.class);

    @Autowired
    private IUserService iUserService;

    @ResponseBody
    @RequestMapping("/getUser")
    public Result getUser(){
        Result result = new Result();
        try {
            User user = new User();
            user.setId("737907737358368769");
            result.setCode(200).setMsg("Success").setData(iUserService.selectUser(user));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e, e.fillInStackTrace());
        }
        return result;
    }
}
