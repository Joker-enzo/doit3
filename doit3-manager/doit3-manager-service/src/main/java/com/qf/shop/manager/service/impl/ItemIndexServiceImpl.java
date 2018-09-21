package com.qf.shop.manager.service.impl;

import com.qf.shop.manager.dao.TbItemIndexMapper;
import com.qf.shop.manager.service.ItemIndexService;
import com.qf.shop.manager.pojo.vo.TbItemIndex;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 李杰 on 2018/9/15.
 */
@Service
public class ItemIndexServiceImpl implements ItemIndexService {
  private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TbItemIndexMapper itemIndexdao;
    @Autowired
    private SolrServer solrServer;
    @Override
    public void importIndex() {

        try {
            //采集数据 注入dao层接口
            // List<TbItemIndex>
            List<TbItemIndex> list=itemIndexdao.listItemByCondation();
            //遍历数据集产生documentlist 注入solrServer
            for(TbItemIndex itemIndex:list){
                //创建一个文档 每循环一次创建一个文档对象
                SolrInputDocument document=new SolrInputDocument();
                //逐个添加字段到document对象当中   前面是在索引库中的字段,后面是数据库查询到封装到实体类中的字段
                document.setField("id",itemIndex.getId());
                document.setField("item_title",itemIndex.getTitle());
                document.setField("item_sell_point",itemIndex.getSellPoint());
                document.setField("item_price",itemIndex.getPrice());
                document.setField("item_image",itemIndex.getImage());
                document.setField("item_category_name",itemIndex.getCatName());
                //添加到索引库  通过solrserver添加到索引库
                solrServer.add(document);
            }
            //提交 注入solrServer
            solrServer.commit();
        } catch (Exception e) {
            logger.error(e.getMessage(),e);

            e.printStackTrace();
        }

    }
}
