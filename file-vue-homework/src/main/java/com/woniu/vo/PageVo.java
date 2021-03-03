package com.woniu.vo;

import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class PageVo {
    private Integer current;
    private Integer size;
    private String filmName;
    private String level;
    private Integer smallHour;
    private Integer greatHour;
    private String filmDescription;

}
