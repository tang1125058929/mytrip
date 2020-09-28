package cn.mytrip.controller;

import cn.mytrip.beans.dto.Dto;
import cn.mytrip.beans.pojo.User;
import cn.mytrip.common.DtoUtil;
import cn.mytrip.common.Page;
import cn.mytrip.quartz.MyTask;
import cn.mytrip.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BizController {
    @Resource
    UserService userService;

    @RequestMapping("/display")
    //@ResponseBody
    public Dto display(
            @RequestParam(value = "page",required = true,defaultValue = "1") int pageIndex,
            @RequestParam(value = "userName",required = false)String userName){
        Page<User> page = userService.getPagedUsers(pageIndex,5,userName);
        return DtoUtil.returnDataSuccess(page);
    }

}
