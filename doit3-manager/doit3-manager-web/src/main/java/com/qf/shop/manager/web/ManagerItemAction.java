package com.qf.shop.manager.web;

import com.qf.shop.common.pojo.dto.ItemResult;
import com.qf.shop.common.pojo.dto.PageInfo;
import com.qf.shop.manager.pojo.po.TbItem;
import com.qf.shop.manager.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 李杰 on 2018/9/2.
 */
@Controller
public class ManagerItemAction {

    /**
     * 初始化logger
     */
        private Logger logger= LoggerFactory.getLogger(this.getClass());

        @Autowired
        private ItemService itemService;
    /**
     * 返回的参数为json类型 根据表格的返回值数据要求定义对应的dto类 用来封装返回值
     * @param page
     * @return
     */
    @ResponseBody
    @RequestMapping(value ="/items" ,method = RequestMethod.GET)
    public ItemResult<TbItem> ListItemsByPage(PageInfo page){

        ItemResult<TbItem> result=null;

    try {
        result=itemService.ListItemByPage(page);
    }catch (Exception e){
        //通过logback输出异常到日志文件道中i
        logger.error(e.getMessage(),e);
        e.printStackTrace();
    }
        return result;
    }
}
