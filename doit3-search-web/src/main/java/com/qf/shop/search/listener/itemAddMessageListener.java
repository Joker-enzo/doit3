package com.qf.shop.search.listener;

import com.qf.shop.search.dao.TbItemIndexMapper;
import com.qf.shop.search.pojo.vo.TbItemIndex;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**发布商品消息监听器
 * Created by 李杰 on 2018/9/18.
 */


public class itemAddMessageListener implements MessageListener{

    @Autowired
    private TbItemIndexMapper itemIndexDao;
    @Autowired
    private SolrServer solrServer;
    @Override
    public void onMessage(Message message) {
        try {
            //1 获取消息 强转
            TextMessage textMessage = (TextMessage) message;
            //将String类型的 变量转化为long类型
            long itemId = Long.parseLong(textMessage.getText());
            System.out.println(itemId+"====================================");
            //2 通过ID查询对象
            TbItemIndex itemIndex = itemIndexDao.listItemById(itemId);
            System.out.println(itemIndex+"============================================");
            //3 将这个对象添加到索引库
            SolrInputDocument document = new SolrInputDocument();
            document.addField("id", itemIndex.getId());
            document.addField("item_title", itemIndex.getTitle());
            document.addField("item_sell_point", itemIndex.getSellPoint());
            document.addField("item_price", itemIndex.getPrice());
            document.addField("item_image", itemIndex.getImage());
            document.addField("item_category_name", itemIndex.getCatName());
            //添加到索引库
            solrServer.add(document);
            //提交，注入solrServer
            solrServer.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
