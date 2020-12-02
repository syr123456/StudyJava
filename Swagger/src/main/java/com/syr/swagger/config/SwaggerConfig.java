package com.syr.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * 配置Swagger
 * @author syr
 * // TODO: 2020/12/2
 */
/*开启Swagger2*/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("B");
    }

    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("A");
    }

    /*配置Swagger的Docket的bean实例*/
    @Bean
    public Docket docket(Environment environment) {

        //问题：我只希望我的Swagger在生产环境中启动，在发布的时候不启动？
        //设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev");
        //通过environment.acceptsProfiles判断是否在自己的设定环境中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //配置是否启动Swagger,若为false则表示不启动
                .enable(flag)
                .groupName("宋亚茹")
                .select()
                //RequestHandlerSelectors配置要扫描的接口的方式
                //basePackage:指定要扫描的包，basePackage("com.syr.swagger.controller")
                //any:扫描全部
                //none:不扫描
                //withClassAnnotation：扫描类上的注解，参数是一个注解的反射对象
                //withMethodAnnotation:扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.syr.swagger.controller"))
                //过滤扫描的路径
                //.paths(PathSelectors.ant("/syr/**"))
                //工厂模式
                .build()
                ;
    }

    /*配置Swagger信息*/
    private ApiInfo apiInfo(){
        /*作者信息*/
        Contact contact = new Contact("Songyaru", "", "1764502051@qq.com");
        return  new ApiInfo(
                "YaruSong",
                "晴天女孩",
                "v1.0",
                "http://github//syr123456",
                 contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }



}
