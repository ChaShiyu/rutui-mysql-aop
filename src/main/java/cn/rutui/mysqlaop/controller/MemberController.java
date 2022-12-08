package cn.rutui.mysqlaop.controller;

import cn.rutui.mysqlaop.aop.BaseInfoAnnotation;
import cn.rutui.mysqlaop.aop.OperateTypeEnum;
import cn.rutui.mysqlaop.entity.Member;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {
    @PostMapping("")
    @BaseInfoAnnotation(OperateTypeEnum.ADD)
    public String save(@RequestBody Member member) {
        System.out.println(JSON.toJSONString(member));
        return "SUCCESS";
    }
}