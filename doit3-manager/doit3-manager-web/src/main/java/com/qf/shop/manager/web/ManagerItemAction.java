package com.qf.shop.manager.web;

import com.qf.shop.common.pojo.dto.ItemResult;
import com.qf.shop.common.pojo.dto.MessageResult;
import com.qf.shop.common.pojo.dto.PageInfo;
import com.qf.shop.manager.pojo.po.TbItem;
import com.qf.shop.manager.service.ItemIndexService;
import com.qf.shop.manager.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * Created by 李杰 on 2018/9/2.
 */
@Controller
public class ManagerItemAction {

    /**
     * 初始化logger
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemIndexService itemIndexService;
    @Autowired
    private JmsTemplate jmsTemplate;
    @Resource
   private Destination topicDestination;

    /**
     * 返回的参数为json类型 根据表格的返回值数据要求定义对应的dto类 用来封装返回值
     *
     * @param page
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public ItemResult<TbItem> ListItemsByPage(PageInfo page) {

        ItemResult<TbItem> result = null;

        try {
            result = itemService.ListItemByPage(page);
        } catch (Exception e) {
            //通过logback输出异常到日志文件道中i
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 导入索引库
     */
    @ResponseBody
    @RequestMapping(value = "/item/indexlib/import", method = RequestMethod.POST)
    //@PostMapping("/item/indexlib/import")
    public MessageResult importIndex() {

        MessageResult messageresult = new MessageResult();
        messageresult.setSuccess(false);
        messageresult.setMsg("failed");
        try {
            itemIndexService.importIndex();
            messageresult.setSuccess(true);
            messageresult.setMsg("success");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);

            e.printStackTrace();
        }

        return messageresult;
    }

    @ResponseBody
    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public void saveItem() {

        //1发布商品
        long itemId =12345678910l;
        //2发送消息

        jmsTemplate.send(topicDestination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                //添加""是为了转为String类型
                TextMessage textMessage = session.createTextMessage(itemId + "");

                return textMessage;
            }
        });

    }
}
