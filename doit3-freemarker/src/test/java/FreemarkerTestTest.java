//import freemarker.template.Configuration;
//import freemarker.template.Template;
//import org.junit.Test;
//
//import java.io.FileWriter;
//import java.io.Writer;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by 李杰 on 2018/9/19.
// */
//public class FreemarkerTestTest {
//    @Test
//    public void test1() throws  Exception{
//        //创建配置对象
//        Configuration configuration = new Configuration(Configuration.getVersion());
//        //设置模板文件所在的路径
//        configuration.setClassForTemplateLoading(this.getClass(),"/ftl");
//        //设置字符集
//        configuration.setDefaultEncoding("UTF-8");
//        //创建模板对象
//        Template template = configuration.getTemplate("01.ftl");
//        //创建数据集
//        Map<String,Object> dataModel = new HashMap<String,Object>();
//        dataModel.put("name", "joker");
//        //创建Writer对象
//        Writer out = new FileWriter("d:/web/01.html");
//        //使用模板对象输出文件
//        template.process(dataModel, out);
//        //关闭流
//        out.close();
//    }
//}
