package com.qf.shop.manager.service.impl;


import com.qf.shop.common.pojo.dto.ItemResult;
import com.qf.shop.common.pojo.dto.PageInfo;
import com.qf.shop.manager.dao.TbItemCustomMapper;
import com.qf.shop.manager.pojo.po.TbItem;
import com.qf.shop.manager.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 李杰 on 2018/9/2.
 */
@Service
public class ItemServiceImpl implements ItemService{
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    /**
     * 依赖注入dao层接口 需要分页查询 和总数
      * @param page
     * @return
     */
    @Autowired
    private TbItemCustomMapper itemCustomDao;
    @Override
    public ItemResult<TbItem> ListItemByPage(PageInfo page) {
        ItemResult<TbItem> result =new  ItemResult<TbItem>();
        result.setCode(0);
        result.setMsg("success");
        try {
            long  count=itemCustomDao.countItems();
            List<TbItem> list=itemCustomDao.listItemByPage(page);
           System.out.println(list+"===================================================================");

            result.setCount(count);
            result.setData(list);

        }catch(Exception e){
        result.setCode(1);
            result.setMsg("field");
            logger.error(e.getMessage(),e);
            e.printStackTrace();

        }
        return result;
    }
}
