package com.example.springbootdemo.common.util;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GeneratorUtils {
    public static void main(String[] args) {
        autoGenerator();
    }


    public static void autoGenerator() {

        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setDataSource(getDataSourceConfig());
        autoGenerator.setGlobalConfig(getGlobalConfig());
        autoGenerator.setPackageInfo(getPackageInfo());
        autoGenerator.setStrategy(getStrategyConfig());
        autoGenerator.execute();
    }

    /**
     * 设置数据源
     *
     * @return
     */
    public static DataSourceConfig getDataSourceConfig() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/kevin?userUnicode=true&characterEncoding=utf8");
        dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("kevin");
        dsc.setPassword("960713");

        return dsc;
    }

    /**
     * 设置全局配置
     *
     * @return
     */
    public static GlobalConfig getGlobalConfig() {
        GlobalConfig gc = new GlobalConfig();
        String path = System.getProperty("user.dir");
        gc.setOutputDir(path + "/src/main/java");//参数是一个目录，所以需要获取当前系统目录
        gc.setAuthor("kevin");
        gc.setOpen(true);//是否打开资源管理器
        gc.setFileOverride(true);//是否覆盖已经生成的
        gc.setServiceName("%sService");//去service的I前缀
        gc.setIdType(IdType.INPUT);// id生成策略
        gc.setDateType(DateType.ONLY_DATE);
        return gc;
    }

    /**
     * 包配置
     *
     * @return
     */
    public static PackageConfig getPackageInfo() {
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("common");
        pc.setParent("com.example.springbootdemo");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        return pc;
    }

    /**
     * 策略配置
     *
     * @return
     */
    public static StrategyConfig getStrategyConfig() {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);// 下划线转驼峰命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);

        //获取多张表
        // 设置映射的表名，多张表
        List<String> tables = new ArrayList();
        String url = "jdbc:mysql://127.0.0.1:3306/kevin?userUnicode=true&characterEncoding=utf8";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,"debian-sys-maint","16xQp0x66siNl9KU");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from information_schema.TABLES where TABLE_SCHEMA=?");
            preparedStatement.setString(1,"kevin");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                    tables.add(resultSet.getString("table_name"));
            }
            String[] result = tables.toArray(new String[tables.size()]);
            //填写表名
            strategy.setInclude(result);
        } catch (Exception e) {
            e.printStackTrace();
        }


        strategy.setEntityLombokModel(true);// 是否启用lombok开启注解
        strategy.setLogicDeleteFieldName("isAction");//设置逻辑删除字段

        // 时间自动填充配置
        TableFill startDate = new TableFill("startDate", FieldFill.INSERT);
        TableFill updateDate = new TableFill("updateDate", FieldFill.UPDATE);

        ArrayList<TableFill> list = new ArrayList<>();
        list.add(startDate);
        list.add(updateDate);
        strategy.setTableFillList(list);


        // 乐观锁配置
        strategy.setVersionFieldName("version");
        // rustful 格式

        strategy.setRestControllerStyle(true);

        return strategy;
    }

}
