package sys1;

import java.sql.*;
import java.util.*;
import javax.swing.table.AbstractTableModel;

import SqlConnection.SqlConn;

public class MyColumTableModel extends AbstractTableModel {
    //����������Ҫ�ļ���
    Vector rowData, row, column;
    //����һ����¼�������ڽ��մ����ݿⷵ�����ļ�¼��
    ResultSet rs;
    //����һ�������������ݿ�Ķ���
    SqlConn conn;

    public MyColumTableModel(String sql,int i,int m) {
        if (i==1) {
            sql = "select * from MyColum";
        }
        else if(i==2){
            sql = "select * from MyColum2";
        }
        //���ñ�������
        column = new Vector();
        column.add("��"+m+"��");
        column.add("����");
        column.add("��һ");
        column.add("�ܶ�");
        column.add("����");
        column.add("����");
        column.add("����");
        column.add("����");

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
                row.add(rs.getString(8));
                rowData.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }

    }public MyColumTableModel(String sql,String Week,int i) {
        if (i==1) {
            sql = "select * from MyColum";
        }
        else if(i==2){
            sql = "select * from MyColum2";
        }
        //���ñ�������
        column = new Vector();
        column.add(""+Week);
        column.add("����");
        column.add("��һ");
        column.add("�ܶ�");
        column.add("����");
        column.add("����");
        column.add("����");
        column.add("����");

        //������ļ�¼��
        rowData = new Vector();
        //�������ݿ�����
        conn = new SqlConn();
        rs = conn.sqlQuery(sql);
        try {
            while (rs.next()) {//����
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
