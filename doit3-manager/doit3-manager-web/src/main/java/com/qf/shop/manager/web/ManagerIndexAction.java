package com.qf.shop.manager.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by 李杰 on 2018/8/29.
 */
@Controller
public class ManagerIndexAction {

@RequestMapping(value = "/{page}",method = RequestMethod.GET)
    public String index(@PathVariable String page){


    return page;
    }

   @RequestMapping(value="/pages/{pageName}" ,method = RequestMethod.GET)
    public String index1(@PathVariable String pageName){

    return "pages/"+pageName;

    }
    @RequestMapping(value = "/pages/{pageName1}/{pageName2}",method =RequestMethod.GET)
    public String index2(@PathVariable String pageName1,@PathVariable String pageName2){
        return "pages/"+pageName1+"/"+pageName2;
    }
}
