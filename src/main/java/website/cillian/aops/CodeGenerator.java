package website.cillian.aops;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Collections;

public class CodeGenerator {

        public static void main(String[] args) {
            //1、配置数据源
            FastAutoGenerator.create("jdbc:mysql://localhost:3306/aops?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8", "root", "123456")
                    //2、全局配置
                    .globalConfig(builder -> {
                        builder.author("cillian") // 设置作者名
                                .outputDir(System.getProperty("user.dir") + "/src/main/java")   //设置输出路径：项目的 java 目录下
                                .commentDate("yyyy-MM-dd hh:mm:ss")   //注释日期
                                .dateType(DateType.ONLY_DATE)   //定义生成的实体类中日期的类型 TIME_PACK=LocalDateTime;ONLY_DATE=Date;
                                .enableSwagger()   //开启 swagger 模式
                                .disableOpenDir();   //禁止打开输出目录，默认打开
                    })
                    //3、包配置
                    .packageConfig(builder -> {
                        builder.parent("website.cillian") // 设置父包名
                                .moduleName("aops")   //设置模块包名
                                .entity("entity")   //pojo 实体类包名
                                .service("service") //Service 包名
                                .serviceImpl("serviceImpl") // ***ServiceImpl 包名
                                .mapper("mapper")   //Mapper 包名
                                .xml("mapper")  //Mapper XML 包名
                                .controller("controller") //Controller 包名
//                              .other("utils") //自定义文件包名
                                .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir")+"/src/main/resources/mapper"));    //配置 mapper.xml 路径信息：项目的 resources 目录下
                    })
                    //4、策略配置
                    .strategyConfig(builder -> {
                        builder.addInclude("user") // 设置需要生成的数据表名

                                .addTablePrefix("t_", "c_") // 设置过滤表前缀

                                //4.1、Mapper策略配置
                                .mapperBuilder()

                                .superClass(BaseMapper.class)   //设置父类
                                .formatMapperFileName("%sMapper")   //格式化 mapper 文件名称
//                              .enableMapperAnnotation() //@mapper注解开启
                                .enableFileOverride() //全局覆盖已有文件的配置已失效，已迁移到策略配置中
                                .formatXmlFileName("%sXml")//格式化 Xml 文件名称

                        //4.2、service 策略配置
                                .serviceBuilder()
                                .enableFileOverride()//全局覆盖已有文件的配置已失效，已迁移到策略配置中
                                .formatServiceFileName("%sService") //格式化 service 接口文件名称，%s进行匹配表名，如 UserService
                                .formatServiceImplFileName("%sServiceImpl") //格式化 service 实现类文件名称，%s进行匹配表名，如 UserServiceImpl

                                //4.3、实体类策略配置
                                .entityBuilder()
                                .idType(IdType.ASSIGN_ID)//主键策略  雪花算法自动生成的id
                                .enableLombok() //开启 Lombok
                                .enableFileOverride() //全局覆盖已有文件的配置已失效，已迁移到策略配置中
                                .disableSerialVersionUID()  //不实现 Serializable 接口，不生产 SerialVersionUID
                                .logicDeleteColumnName("deleted")   //逻辑删除字段名
                                .naming(NamingStrategy.underline_to_camel)  //数据库表映射到实体的命名策略：下划线转驼峰命
                                .columnNaming(NamingStrategy.underline_to_camel)    //数据库表字段映射到实体的命名策略：下划线转驼峰命
                                .addTableFills(
                                        new Column("create_time", FieldFill.INSERT),
                                        new Column("modify_time", FieldFill.INSERT_UPDATE)
                                )   //添加表字段填充，"create_time"字段自动填充为插入时间，"modify_time"字段自动填充为插入修改时间
                                .enableTableFieldAnnotation()       // 开启生成实体时生成字段注解

                                //4.4、Controller策略配置
                                .controllerBuilder()
                                .formatFileName("%sController") //格式化 Controller 类文件名称，%s进行匹配表名，如 UserController
                                .enableFileOverride() //全局覆盖已有文件的配置已失效，已迁移到策略配置中
                                .enableRestStyle();  //开启生成 @RestController 控制器
                    })
                    //5、模板
                    .templateEngine(new VelocityTemplateEngine())
                    /*
                            .templateEngine(new FreemarkerTemplateEngine())
                            .templateEngine(new BeetlTemplateEngine())
                            */
                    //6、执行
                    .execute();
        }

    }

