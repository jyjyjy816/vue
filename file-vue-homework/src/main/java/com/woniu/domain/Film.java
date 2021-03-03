package com.woniu.domain;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@TableName("t_film")
@ApiModel(value="Film对象", description="")
public class Film implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "film_id", type = IdType.AUTO)
    private Integer filmId;

    private String title;

    private String description;

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date releaseYear;

    private Integer languageId;

    private Integer originalLanguageId;

    private Integer rentalDuration;

    private BigDecimal rentalRate;

    private Integer length;

    private BigDecimal replacementCost;

    private String rating;

    private String specialFeatures;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date lastUpdate;


}
