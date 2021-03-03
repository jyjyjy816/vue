package com.woniu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.woniu.domain.Film;
import com.woniu.dto.Result;
import com.woniu.dto.StatusCode;
import com.woniu.service.FilmService;
import com.woniu.vo.PageVo;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zyy
 * @since 2021-01-26
 */
@RestController
@RequestMapping("/film")
//@CrossOrigin
public class FilmController {
    @Resource
    private FilmService filmService;

    @GetMapping("page")
    public Result pageProducts(PageVo pageVo){
        System.out.println("pageVo===.>>>"+pageVo);
        if(!ObjectUtils.isEmpty(pageVo)){
            IPage<Film> filmPage = filmService.findFilmPage(pageVo);
            return new Result(true, StatusCode.OK,"分页查询成功",filmPage);
        }
        return new Result(false,StatusCode.ERRORPAGE,"分页查询失败",null);
    }

}

