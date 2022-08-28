package sys1;

import java.sql.*;
import java.util.*;
import javax.swing.table.AbstractTableModel;
import SqlConnection.SqlConn;

//我的课程表数据模型
public class SelectColumTableModel extends AbstractTableModel{
    //定义表格所需要的集合
    Vector rowData,row,column;
    //定义一个记录集，用于接收从数据库返回来的记录集
    ResultSet rs;
    //定义一个用于连接数据库的对象
    SqlConn conn;
    public SelectColumTableModel(String sql)
    {
        //默认sql的表结构
        if(sql==null)
        {
            sql="select * from SelectColum";
        }
        //设置表格的列名
        column=new Vector();
        column.add("课程名称");
        column.add("授课教师");
        column.add("授课地点");
        column.add("上课周次");
        column.add("课程学分");
        column.add("课程属性");

        //创建表的记录集
        rowData=new Vector();
        //调用数据库连接
        conn=new SqlConn();
        rs=conn.sqlQuery(sql);
        try {
            while(rs.next())
            {
                row=new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getString(4));
                row.add(rs.getString(5));
                row.add(rs.getString(6));
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
        return (String)this.column.get(column);
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
        return ((Vector)this.rowData.get(arg0)).get(arg1);

    }
}

