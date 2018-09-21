//package com.qf.shop.common.jedis;
//
//import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
//import com.sun.tools.classfile.Opcode;
//import org.junit.Test;
//import redis.clients.jedis.HostAndPort;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisCluster;
//import redis.clients.jedis.JedisPool;
//
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * Created by 李杰 on 2018/9/17.
// */
//public class JedisTest {
//    @Test
//    public void testJedis1(){
//
//        //获取获取jiedis对象
//        Jedis jedis=new Jedis("39.106.165.75",6379);
//        //检验密码
//        jedis.auth("$2015G0805012enzo");
//       String sex=jedis.get("sex");
//        System.out.println(sex);
//        jedis.lpush("javalist1",new String[]{"ab","cb","ed"});
//        jedis.close();
//
//
//    }
//    @Test
//    public void testJedis2(){
//        //获取jedis连接池
//        JedisPool jedisPool=new JedisPool("39.106.165.75",6379);
//        //获取jedis对象
//        Jedis jedis = jedisPool.getResource();
//        //校验密码
//        jedis.auth("$2015G0805012enzo");
//        //设置取值
//
//        System.out.println(jedis.lrange("javalist1",0,-1));
//        jedis.close();
//        jedisPool.close();
//
//    }
//    @Test
//    public void testJedis3(){
//        //获取结合
//       Set<HostAndPort> nodes=new HashSet<HostAndPort>();
//        //集合元素添加
//        nodes.add(new HostAndPort("39.106.165.75",9001));
//        nodes.add(new HostAndPort("39.106.165.75",9002));
//        nodes.add(new HostAndPort("39.106.165.75",9003));
//        nodes.add(new HostAndPort("39.106.165.75",9004));
//        nodes.add(new HostAndPort("39.106.165.75",9005));
//        nodes.add(new HostAndPort("39.106.165.75",9006));
//
//        //获取jedis集群资源
//        JedisCluster jedisCluster=new JedisCluster(nodes);
//
//        System.out.println(jedisCluster.get("key2"));
//    }
//
//}
