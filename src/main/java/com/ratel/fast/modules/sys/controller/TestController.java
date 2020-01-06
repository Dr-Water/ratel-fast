package com.ratel.fast.modules.sys.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @业务描述： 用于测试 @RequestParam @RequestBody @PathVariable 以及不加这三个注解的接收参数的问题
 * @package_name： com.ratel.fast.modules.sys.controller
 * @project_name： ratel-fast
 * @author： ratelfu@qq.com
 * @create_time： 2020-01-06 14:18
 * @copyright (c) ratelfu 版权所有
 */
@RequestMapping("/test")
@RestController
public class TestController extends AbstractController {

    /** 默认只从url中获取参数，并且参数名必须和uid一样，否者接收到不到
     * @param uid
     */
    @RequestMapping("t1")
    @ApiOperation("t1")
    public void t1(String uid){
        logger.info("不加任何注解接收的参数是"+uid);
    }

    /**
     * 可以使用post请求 ，但是前提条件是请求头使用：application/x-www-form-urlencoded 或 form-data
     * 并且参数名必须叫 id
     * @param id
     */
    @RequestMapping("t2")
    @ApiOperation("t2")
    public void t2(@RequestParam String id){
        logger.info("一个@RequestParam接收的参数是"+id);
    }

    /**
     * 可以使用post请求 ，但是前提条件是请求头使用：application/x-www-form-urlencoded 或 form-data
     * 并且参数名必须叫 id
     * @param id
     */
    @RequestMapping("t3")
    @ApiOperation("t3")
    public void t3(@RequestParam("uid") String id){
        logger.info("@RequestParam(\"uid\")接收的参数是"+id);
    }

    /**
     * 通过
     * @param id
     */
    @RequestMapping("/t4/{id}")
    @ApiOperation("t4")
    public void t4(@PathVariable String id){
        logger.info("@PathVariable接收的参数是"+id);
    }

    /**
     * 通过（标准写法）
     * @param id
     */
    @RequestMapping("/t5/{uid}")
    @ApiOperation("t5")
    public void t5(@PathVariable("uid") String id){
        logger.info("@PathVariable(\"uid\")接收的参数是"+id);
    }

    /**
     * 不通过
     * @RequestMapping("/t6/{uid}")中{uid} 必须和@PathVariable("id")中的一致即：
     *  @RequestMapping("/t6/{uid}") ，@PathVariable("uid")   否者会报错
     * @param id
     */
    @RequestMapping("/t6/{uid}")
    @ApiOperation("t6")
    public void t6(@PathVariable("id") String id){
        logger.info("@PathVariable(\"id\")和@RequestMapping中参数名不同的接收情况接收的参数是"+id);
    }

    /**路径名 uid 变量名 id
     * 不通过
     * @param id
     */
    @RequestMapping("/t7/{uid}")
    @ApiOperation("t7")
    public void t7(@PathVariable String id){
        logger.info("@PathVariable接收的参数是"+id);
    }

    /**可以使用但是接收的参数有问题
     * @param id
     */
    @RequestMapping("/t8")
    @ApiOperation("t8")
    public void t8(@RequestBody String id){
        logger.info("@RequestBody接收的参数是"+id);
    }

    /**
     * @requestbody 的含义是在当前对象获取整个http请求的body里面的所有数据，因此spring就不可能将这个数据强制包装成id或者name
     * 解决方案 使用一个参数：
     * 方案1：Map<String,Object> 使用map接收，最后再转化成id 和name两个参数
     * 方案2: 写一个实体类User 属性有id和name
     * @param id
     * @param name
     */
    @RequestMapping("/t9")
    @ApiOperation("t9")
    public void t9( @RequestBody String id , @RequestBody String name){
        logger.info("多个@RequestBody接收的参数是"+id +"姓名"+name);
    }

    /**
     * 可以，id 和name的属性的顺序可以互换
     * @param id
     * @param name
     */
    @RequestMapping("/t10")
    @ApiOperation("t10")
    public void t10( @RequestParam String id , @RequestParam String name){
        logger.info("多个@RequestParam接收的参数是"+id +"姓名"+name);
    }

    /**
     * 可以使用
     * @param id
     * @param name
     */
    @RequestMapping("/t11/{id}/{name}")
    @ApiOperation("t11")
    public void t11( @PathVariable String id , @PathVariable String name){
        logger.info("多个@PathVariable接收的参数是"+id +"姓名"+name);
    }

    /**
     * 在请求头为application/x-www-form-urlencoded 模式下可用
     * @param id
     * @param name
     */
    @RequestMapping("/t12")
    @ApiOperation("t12")
    public void t12( @RequestBody String id , @RequestParam String name){
        logger.info("多个@RequestBody接收的参数是"+id +"姓名"+name);
    }


    /**
     * 在请求头为application/x-www-form-urlencoded 或传 raw json格式数据 下可用
     * @param id
     * @param name
     */
    @RequestMapping("/t13/{name}")
    @ApiOperation("t13")
    public void t13( @RequestBody String id , @PathVariable String name){
        logger.info("多个@RequestBody接收的参数是"+id +"姓名"+name);
    }

    /**
     * 在请求头为application/x-www-form-urlencoded 或传 form-data下可用
     * @param id
     * @param name
     */
    @RequestMapping("/t14/{name}")
    @ApiOperation("t14")
    public void t14( @RequestParam String id , @PathVariable String name){
        logger.info("多个@RequestBody接收的参数是"+id +"姓名"+name);
    }

    /**
     * 在请求头为application/x-www-form-urlencoded 或传 raw json格式数据 下可用
     * @param id
     * @param name
     * @param age
     */
    @RequestMapping("/t15/{age}")
    @ApiOperation("t15")
    public void t15( @RequestBody String id , @RequestBody String name, @PathVariable Integer age){
        logger.info("多个@RequestBody接收的参数是"+id +"姓名"+name+"年龄"+age);
    }

    @RequestMapping("/t16/{sex}")
    @ApiOperation("t16")
    public void t16( @RequestBody String id , @RequestParam String name, @PathVariable String sex){
        logger.info("多个@RequestBody接收的参数是"+id +"姓名"+name+"性别"+sex);
    }

    @RequestMapping("/t18/{sex}")
    @ApiOperation("t18")
    public void t18( @RequestBody(required = false) String id , @RequestParam String name, @PathVariable String sex){
        logger.info("多个@RequestBody接收的参数是"+id +"姓名"+name+"性别"+sex);
    }

    @RequestMapping("/t19/{sex}")
    @ApiOperation("t19")
    public void t19( @RequestBody String id , @RequestParam(required = false) String name, @PathVariable(required = false) String sex){
        logger.info("多个@RequestBody接收的参数是"+id +"姓名"+name+"性别"+sex);
    }

    /**
     * 这样也是可以的
     * @param id
     */
    @RequestMapping("/t4/{id}/456")
    @ApiOperation("t17")
    public void t17( @PathVariable String id ){
        logger.info("多个@PathVariable接收的参数是"+id );
    }
}
