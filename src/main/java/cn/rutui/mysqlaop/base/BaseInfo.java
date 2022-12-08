package cn.rutui.mysqlaop.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseInfo implements Serializable {
    private Long creatorId;
    private String creatorName;
    private Date optTime;
}
