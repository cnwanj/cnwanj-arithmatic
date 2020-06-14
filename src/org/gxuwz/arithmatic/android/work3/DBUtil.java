package org.gxuwz.arithmatic.android.work3;

import java.sql.*;

/**
 * 数据库访问操作
 */
public class DBUtil {
    private static final String driverClass = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql:///wei_yong_heng";
    private static final String user = "root";
    private static final String password = "root";
    protected PreparedStatement stmt = null;
    protected Connection conn = null;
    protected ResultSet rs = null;

    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName(driverClass);
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 获取prepareStatment对象
     *
     * @param sql
     * @param arr
     * @return
     */
    public PreparedStatement getStmt(String sql, Object[] arr) {
        try {
            stmt = getConn().prepareStatement(sql);
            if (arr != null) {
                for (int i = 0; i < arr.length; i++) {
                    stmt.setObject(i + 1, arr[i]);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stmt;
    }

    /**
     * 执行update操作
     *
     * @param sql
     * @throws SQLException
     */
    public int executeUpdate(String sql, Object[] arr) throws SQLException {
        try {
            return getStmt(sql, arr).executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("执行SQL操作失败:" + e.getMessage(), e);
        } finally {
            close(stmt, conn);
        }
    }

    /**
     * 执行query操作
     *
     * @param sql
     * @throws SQLException
     */
    public ResultSet executeQuery(String sql, Object[] arr) throws SQLException {
        try {
            rs = getStmt(sql, arr).executeQuery();
        } catch (SQLException e) {
            throw new SQLException("执行SQL查询失败" + e.getMessage(), e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 关闭所有
     *
     * @param stmt
     * @param conn
     * @throws SQLException
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn)
            throws SQLException {
        try {

            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();

        } catch (SQLException e) {
            throw new SQLException("关闭数据库连接资源失败!" + e.getMessage(), e);
        }

    }

    /**
     * 关闭 stmt, conn
     *
     * @param stmt
     * @param conn
     * @throws SQLException
     */
    public static void close(Statement stmt, Connection conn)
            throws SQLException {
        close(null, stmt, conn);
    }

    /**
     * 关闭连接
     *
     * @param conn
     * @throws SQLException
     */
    public static void close(Connection conn) throws SQLException {
        close(null, null, conn);
    }

    /**
     * 关闭Statement
     *
     * @param stmt
     * @throws SQLException
     */
    public static void close(Statement stmt) throws SQLException {
        close(null, stmt, null);
    }
}

