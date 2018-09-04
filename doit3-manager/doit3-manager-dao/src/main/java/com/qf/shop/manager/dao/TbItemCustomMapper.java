package com.qf.shop.manager.dao;

import com.qf.shop.common.pojo.dto.PageInfo;
import com.qf.shop.manager.pojo.po.TbItem;

import java.util.List;

/**
 * Created by 李杰 on 2018/9/2.
 */
public interface TbItemCustomMapper {
    /**
     * 查询符合条件的总数的方法
     * @return
     */
    long countItems();

    /**
     * 分页查询传输参数的方法
     * @param page  起始行 和每页显示数据条数
     * @return
     */

    List<TbItem> listItemByPage(PageInfo page);

}
