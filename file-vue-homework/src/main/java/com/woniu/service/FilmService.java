package com.woniu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.woniu.domain.Film;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniu.vo.PageVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zyy
 * @since 2021-01-26
 */
public interface FilmService extends IService<Film> {

    public IPage<Film> findFilmPage(PageVo pageVo);

}
