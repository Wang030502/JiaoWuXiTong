package sys1;

import java.sql.*;
import java.util.*;
import javax.swing.table.AbstractTableModel;

import SqlConnection.SqlConn;

public class ClassColumSelectModel extends AbstractTableModel{

    //定义表格所需要的集合
    Vector rowData, row, column;
    //定义一个记录集，用于接收从数据库返回来的记录集
    ResultSet rs;
    //定义一个用于连接数据库的对象
    SqlConn conn;

    public ClassColumSelectModel (String sql) {
        //默认sql显示的表结构
        if (sql == null) {
            sql = "select * from ClassColumSelect";
        }
        //设置表格的列名
        column = new Vector();
        column.add("教学楼");
        column.add("教室");
        column.add("周次");
        column.add("星期");
        column.add("第1-2节");
        column.add("第3-4节");
        column.add("第5-6节");
        column.add("第7-8节");
        column.add("第9-10节");

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
                row.add(rs.getString(9));
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
