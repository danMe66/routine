package com.freedougall.demo.mybatis;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * mybatis-plus代码生成器
 * mybatis-plus官网：https://mp.baomidou.com
 */
public class MybatisPlusGenerator {

    // 表名（多表用逗号隔开）
    private static final String TABLE_NAME = "city";
    // 包路径（以表前缀为文件夹名）
    private static final String PACKAGE_PATH = "com.freedougall.demo";
    // 文件夹名
    private static final String MODULE_NAME = "world";
    // 作者注释
    private static final String AUTHOR = "liudandan";

    //注意，会覆盖MODULE_NAME下的所有代码
    public static void main(String[] args) {
        String[] tables = TABLE_NAME.split(",");
        for (String table : tables) {
            build(table);
        }
    }

    private static void build(String table) {
        // 表前缀
        String tablePrefix = "";
        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        //项目目录
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath + "/src/main/java");
        //生成后打开文件目录
        globalConfig.setOpen(false);
        //覆盖文件
        globalConfig.setFileOverride(true);
        //生成BaseResultMap
        globalConfig.setBaseResultMap(true);
        //生成BaseColumnList
        globalConfig.setBaseColumnList(true);
        //加上swagger注解
        globalConfig.setSwagger2(false);
        //自定义service接口名
        globalConfig.setServiceName("%sService");
        //使用java.util.Date
        globalConfig.setDateType(DateType.ONLY_DATE);
        globalConfig.setAuthor(AUTHOR);
        autoGenerator.setGlobalConfig(globalConfig);

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/world?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        autoGenerator.setDataSource(dsc);

        //包配置
        PackageConfig pc = new PackageConfig();
        //生成的目录
        pc.setParent(PACKAGE_PATH);
        pc.setModuleName(MODULE_NAME);
        pc.setEntity("model");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");
        pc.setXml("mapper");
        autoGenerator.setPackageInfo(pc);

        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        //设置继承实体类
        //strategy.setSuperEntityClass("");
        strategy.setSuperEntityColumns();
        //数据库表映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //是否为lombok模型
        strategy.setEntityLombokModel(true);
        //生成 @RestController 控制器
        strategy.setRestControllerStyle(true);
        //表前缀
        strategy.setTablePrefix(tablePrefix);
        //需要包含的表名，允许正则表达式（与exclude二选一配置）
        strategy.setInclude(table);
        autoGenerator.setStrategy(strategy);
        autoGenerator.execute();
    }
}
