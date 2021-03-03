package com.woniu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniu.domain.Film;
import com.woniu.mapper.FilmMapper;
import com.woniu.service.FilmService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniu.vo.PageVo;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zyy
 * @since 2021-01-26
 */
@Service
public class FilmServiceImpl extends ServiceImpl<FilmMapper, Film> implements FilmService {

    @Resource
    private FilmMapper filmMapper;

    public IPage<Film> findFilmPage(PageVo pageVo){
        Page<Film> iPage = new Page<>(pageVo.getCurrent(),pageVo.getSize());
        QueryWrapper<Film> wrapper = new QueryWrapper<>();
        if(!ObjectUtils.isEmpty(pageVo.getFilmName())){
            wrapper.like("title",pageVo.getFilmName());
        }
        if(!ObjectUtils.isEmpty(pageVo.getLevel())){
            wrapper.like("rating",pageVo.getLevel());
        }
        if(!ObjectUtils.isEmpty(pageVo.getSmallHour())){
            wrapper.ge("length",pageVo.getSmallHour());
        }
        if(!ObjectUtils.isEmpty(pageVo.getGreatHour())){
            wrapper.le("length",pageVo.getGreatHour());
        }
        if(!ObjectUtils.isEmpty(pageVo.getFilmDescription())){
            wrapper.like("description",pageVo.getFilmDescription());
        }
        return filmMapper.selectPage(iPage, wrapper);

    }

}
