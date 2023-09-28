package com.example.managerproject.common.util;

import com.alibaba.excel.EasyExcel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ExportDataUtil
 * @Description TODO
 * @Author kevin
 * @Date 2023/9/22 上午9:18
 * @Version 1.0
 */
public class ExportDataUtil {
    private static String filePath = "src/main/resources/sql/database";
    private static List<String> tables = new ArrayList();
    private static List<String> createTableSQL = new ArrayList();
    private static List<String> insertSql = new ArrayList();
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;
    private static Statement statement = null;
    private static String username = "debian-sys-maint";
    private static String password = "16xQp0x66siNl9KU";
    private static String url = "jdbc:mysql://127.0.0.1:3306/kevin?userUnicode=true&characterEncoding=utf8";
    private static String tablePath = "src/main/resources/sql/tables";

    public static void main(String[] args) throws Exception {
        /**
         * 1.连接数据库
         * 2.遍历查询数据表，数据语句
         * 3.生成文件
         */
        //1.数据库连接
        DBConnect();
        //2.获取数据表名
        getDBData();
        //3.生成创建表文件
        //生成文件名
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String fileName = simpleDateFormat.format(date);
        //写入文件
        writeListToFile(filePath+"/"+fileName+".sql", createTableSQL);

        exportToExcel(tablePath);

    }

    /**
     * @Description 连接数据库
     * @Author kevin
     * @Date 2023/9/22 上午9:26
     * @Version 1.0
     */
    public static Connection DBConnect() {

        username = "debian-sys-maint";
        password = "16xQp0x66siNl9KU";
        url = "jdbc:mysql://127.0.0.1:3306/kevin?userUnicode=true&characterEncoding=utf8";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
        }
        return connection;
    }

    /***
     * @Description 遍历查询数据表
     * @Author kevin
     * @Date 2023/9/22 上午9:57
     * @Version 1.0
     */
    public static List<String> getDBData() throws SQLException {
        /*获取表名*/
        preparedStatement = connection.prepareStatement("select * from information_schema.TABLES where TABLE_SCHEMA=?");
        preparedStatement.setString(1, "kevin");
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            tables.add(resultSet.getString("table_name"));
        }
        /*获取创建表语句*/
        for (String table : tables) {
            preparedStatement = connection.prepareStatement("show create table " + table);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                createTableSQL.add(resultSet.getString(2));
            }
        }
        return createTableSQL;
    }

    /**
     * @Description 生成创建表文件
     * @Author kevin
     * @Date 2023/9/22 上午10:43
     * @Version 1.0
     */
    public static void writeListToFile(String filePath, List<String> createTableSQLs) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        for (String createTableSQL : createTableSQLs) {
            bufferedWriter.write(createTableSQL+"\r\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        System.out.println("创建生成表语句文件成功");
    }
    public static void exportToExcel(String filePath) throws Exception{
        for(String table : tables){
            List list = new ArrayList();
            preparedStatement = connection.prepareStatement("select * from "+table);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getMetaData());
                EasyExcel.write(filePath+"/"+table,table.getClass()).sheet(table).doWrite(Collections.singleton(resultSet));

            }
        }
    }
}

