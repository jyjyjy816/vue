package com.woniu.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zyy
 * @since 2021-01-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "用户编号")
        @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

        @ApiModelProperty(value = "用户名")
        private String username;

        @ApiModelProperty(value = "密码")
        private String password;

        @ApiModelProperty(value = "盐")
        private String salt;


}
