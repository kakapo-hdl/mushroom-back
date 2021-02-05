package com.mushroom.mgjstreet.controller;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Scanner;

/**
 *
 * 自动生成代码
 *
**/
public class CodeGeneral {
    private static final String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String url = "jdbc:sqlserver://42.192.144.217:1433;databaseName=mouseroomhouse";
    private static final String user = "SA";
    private static final String password = "nM7894561230";
    private static final String packageName = "com.mushroom.mgjstreet";
    private static final String author = "totolo";
    private static final String entitySuperPackageName = "com.mushroom.mgjstreet";

         /**
         * <p>
         * 输入表名之类的信息
         * </p>
         */
        public static String scanner(String tip) {
            Scanner scanner = new Scanner(System.in);
            StringBuilder help = new StringBuilder();
            help.append("请输入" + tip + "：");
            System.out.println(help.toString());
            if (scanner.hasNext()) {
                String ipt = scanner.next();
                if (StringUtils.isNotBlank(ipt)) {
                    return ipt;
                }
            }
            throw new MybatisPlusException("请输入正确的" + tip + "！");
        }
        public static void main(String[] args) {
              String tableName = CodeGeneral.scanner("表名");
//
//            // 全局配置
//            GlobalConfig gc = new GlobalConfig();
//            String projectPath = System.getProperty("user.dir");
//
//            gc.setOutputDir(projectPath + "/src/main/java");
//            gc.setAuthor("totolo");
//            gc.setOpen(false);
//            // gc.setSwagger2(true); 实体属性 Swagger2 注解
//            mpg.setGlobalConfig(gc);
//
//            // 数据源配置
//            DataSourceConfig dsc = new DataSourceConfig();
//            dsc.setUrl("jdbc:sqlserver://42.192.144.217:1433;databaseName=mouseroomhouse");
//            // dsc.setSchemaName("public");
//            dsc.setDriverName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            dsc.setUsername("SA");
//            dsc.setPassword("nM7894561230");
//            mpg.setDataSource(dsc);
//
//            // 包配置
//            PackageConfig pc = new PackageConfig();
//            pc.setModuleName(scanner("模块名"));
//            pc.setParent("com.mushroom.mgjStreet");
//            mpg.setPackageInfo(pc);
//
//            // 自定义配置
//            InjectionConfig cfg = new InjectionConfig() {
//                @Override
//                public void initMap() {
//                    // to do nothing
//                }
//            };
            DataSourceConfig dataSourceConfig = new DataSourceConfig();
            dataSourceConfig
                    .setDbType(DbType.SQL_SERVER)
                    .setUrl(url)
                    .setUsername(user)
                    .setPassword(password)
                    .setDriverName(driverName);
            StrategyConfig strategyConfig = new StrategyConfig();
            strategyConfig
                    .setSuperEntityClass(entitySuperPackageName)
//                    .setSuperEntityColumns(entityColumns)
                    .setCapitalMode(true)
                    .setEntityLombokModel(true)
                    .setNaming(NamingStrategy.underline_to_camel)
                    .setInclude(tableName);//修改替换成你需要的表名，多个表名传数组
            GlobalConfig globalConfig = new GlobalConfig();
            globalConfig
                    .setActiveRecord(false)
                    .setEnableCache(false)//是否开启二级缓存
                    .setIdType(IdType.ID_WORKER_STR)
                    .setAuthor(author)
                    .setOutputDir("c:\\cn")
                    .setFileOverride(true)
                    .setServiceName("I%sService");//user -> IUserService, 设置成true: user -> IUserService
            AutoGenerator autoGenerator = new AutoGenerator();
            autoGenerator
                    .setGlobalConfig(globalConfig)
                    .setDataSource(dataSourceConfig)
                    .setStrategy(strategyConfig)
                    .setPackageInfo(
                            new PackageConfig()
                                    .setParent(packageName)
                                    .setController("controller")
//                                    .setEntity("entity")
                    ).execute();

        }

    }
