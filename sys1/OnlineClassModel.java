package sys1;
//����ѡ�α�ģ��
import SqlConnection.SqlConn;

import java.util.Vector;
import java.sql.*;
import javax.swing.table.AbstractTableModel;

public class OnlineClassModel extends AbstractTableModel{

    //����������Ҫ�ļ���
    Vector rowData, row, column;
    //����һ����¼�������ڽ��մ����ݿⷵ�����ļ�¼��
    ResultSet rs;
    //����һ�������������ݿ�Ķ���
    SqlConn conn;

    public OnlineClassModel(String sql) {
        if (sql == null) {
            sql = "select * from OnlineClass";
        }
        //���ñ�������
        column = new Vector();
        column.add("�γ�����");
        column.add("�ڿν�ʦ");
        column.add("�ڿεص�");
        column.add("�Ͽ��ܴ�");
        column.add("�γ�ѧ��");
        column.add("ʣ���ѡ");
        column.add("һ����ѡ");

        //������ļ�¼��
        rowData = new Vector();
        //�������ݿ�����
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
                rowData.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    @Override
    //���ñ������
    public String getColumnName(int column) {
        // TODO Auto-generated method stub
        return (String) this.column.get(column);
    }

    @Override
    //�õ�������
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return this.column.size();
    }

    //�õ�������
    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return this.rowData.size();
    }

    @Override
    //�õ�ĳ��ĳ�е�ֵ
    public Object getValueAt(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return ((Vector) this.rowData.get(arg0)).get(arg1);

    }
}

