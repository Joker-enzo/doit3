package com.qf.shop.manager.service;

import com.qf.shop.common.pojo.dto.ItemResult;
import com.qf.shop.common.pojo.dto.PageInfo;
import com.qf.shop.manager.pojo.po.TbItem;

/**
 * 处理商品服务层的相关接口
 * Created by 李杰 on 2018/9/2.
 */
public interface ItemService {

    /**
     * 分页擦寻商品
     * @param page  参数
     * @return  返回json格式的对象
     */
    ItemResult<TbItem> ListItemByPage(PageInfo page);
}
