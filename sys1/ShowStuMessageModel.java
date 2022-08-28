package sys1;

import SqlConnection.SqlConn;

import java.sql.*;
import java.util.*;
import javax.swing.table.AbstractTableModel;

//学生信息
public class ShowStuMessageModel extends AbstractTableModel {
    //定义表格所需要的集合
    Vector rowData, row, column;
    //定义一个记录集，用于接收从数据库返回来的记录集
    ResultSet rs;
    //定义一个用于连接数据库的对象
    SqlConn conn;

    //学生端的显示个人信息
    public ShowStuMessageModel(String sql, String Id) {
        if (sql == null) {
            sql = "select * from StuMessage where Id ='" + Id + "'";
        }
        //设置表格的列名
        column = new Vector();
        column.add("学号");
        column.add("姓名");
        column.add("性别");
        column.add("年龄");
        column.add("地址");
        column.add("专业");
        column.add("班级");
        column.add("总学分");

        //创建表的记录集
        rowData = new Vector();
        //调用数据库连接
        conn = new SqlConn();
        rs = conn.sqlQuery(sql);
        try {
            while (rs.next()) {
                row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getString(4));
                row.add(rs.getString(5));
                row.add(rs.getString(6));
                row.add(rs.getString(7));
                row.add(rs.getString(8));
                rowData.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    public ShowStuMessageModel(String sql) {
        if (sql == null) {
            sql = "select * from StuMessage";
        }
        //设置表格的列名
        column = new Vector();
        column.add("学号");
        column.add("姓名");
        column.add("性别");
        column.add("年龄");
        column.add("地址");
        column.add("专业");
        column.add("班级");
        column.add("总学分");

        //创建表的记录集
        rowData = new Vector();
        //调用数据库连接
        conn = new SqlConn();
        rs = conn.sqlQuery(sql);
        try {
            while (rs.next()) {
                row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getString(4));
                row.add(rs.getString(5));
                row.add(rs.getString(6));
                row.add(rs.getString(7));
                row.add(rs.getString(8));
                rowData.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    @Override
    //设置表的列名
    public String getColumnName(int column) {
        // TODO Auto-generated method stub
        return (String) this.column.get(column);
    }

    @Override
    //得到的列数
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return this.column.size();
    }

    //得到的行数
    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return this.rowData.size();
    }

    @Override
    //得到某行某列的值
    public Object getValueAt(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return ((Vector) this.rowData.get(arg0)).get(arg1);

    }
}
