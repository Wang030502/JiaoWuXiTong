package SqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlConn {
    Connection ct = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String driver = "com.mysql.cj.jdbc.Driver";
    String dburl = "jdbc:mysql://localhost:3306/stu";
    String userName = "root";
    String password = "wb030502";

    //实现添加，修改功能的方法
    public void sqlUpdate(String sql) {
        try {
            //加载驱动
            Class.forName(driver);
            ct = DriverManager.getConnection(dburl, userName, password);//获取连接
            ps = ct.prepareStatement(sql);//创建动态对象，参数为sql语句
            //执行添加，更新操作
            int i = ps.executeUpdate();//返回一个值，如果为1则表示添加成功。
            if (i == 1) {
                System.out.println("数据添加成功！");
            } else {
                System.out.println("数据添加失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }

    }

    //查询功能
    public ResultSet sqlQuery(String sql) {

        try {
            //加载驱动
            Class.forName(driver);
            ct = DriverManager.getConnection(dburl, userName, password);//获取连接
            ps = ct.prepareStatement(sql);//创建动态对象，参数为sql语句
            rs = ps.executeQuery();//执行查询功能，返回数据集，保存到变量rs中

        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        return rs;
    }
    //实现删除学生记录的方法
    public void sqlDelete(String sql) {
        try {
            //加载驱动
            System.out.println("ok");
            Class.forName(driver);
            ct = DriverManager.getConnection(dburl, userName, password);
            ps = ct.prepareStatement(sql);
            System.out.println("ok1");
            //执行添加，更新操作
            int i = ps.executeUpdate();//返回一个值，如果为1则表示删除成功。
            if (i == 1) {
                System.out.println("数据删除成功！");
            } else {
                System.out.println("数据删除失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
    //实现关闭数据库连接的功能
    public void closeSqlConn() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (ct != null) ct.close();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
}





