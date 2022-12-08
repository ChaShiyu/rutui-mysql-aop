package cn.rutui.mysqlaop.entity;

import cn.rutui.mysqlaop.base.BaseInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Member extends BaseInfo {
    private String name;
}