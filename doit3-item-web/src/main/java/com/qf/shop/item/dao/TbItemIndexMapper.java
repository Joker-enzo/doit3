package com.qf.shop.item.dao;


import com.qf.shop.item.pojo.vo.TbItemIndex;

/**
 * User: DHC
 * Date: 2018/8/29
 * Time: 15:14
 * Version:V1.0
 */
public interface TbItemIndexMapper {
    TbItemIndex listItemsById(long itemId);
}
