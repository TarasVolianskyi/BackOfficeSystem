package sample;

import java.sql.*;

public class ProductsHelper {

    public static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DATABASE_PATH = "jdbc:mysql://localhost/eCommerceFirst?user=root&password=fr43edsw21qa";
    public static final String TABLE_NAME = "Products";

    public Statement openConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DATABASE_DRIVER);
        Connection myConnection = (Connection) DriverManager.getConnection(DATABASE_PATH);
        return (Statement) myConnection.createStatement();
    }

    public PreparedStatement openPreparedConnection(String qwery) throws ClassNotFoundException, SQLException {
        Class.forName(DATABASE_DRIVER);
        Connection myConnection = (Connection) DriverManager.getConnection(DATABASE_PATH);
        return (PreparedStatement) myConnection.prepareStatement(qwery);
    }

    public void insert(String name, String pass) {
        String qwery = String.format("insert INTO %s (name, pass, loginDate) values ('%s','%s',NOW())",
                TABLE_NAME, name, pass);
        makeTransaction(qwery);
    }

    public void preparedInsert(String name, int price, String category, int delivId, String charact) {
        String qwery = "insert INTO Products (Pr_name, Pr_price, Pr_catgr, Deliv_id, Pr_charact) values (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = openPreparedConnection(qwery);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, price);
            preparedStatement.setString(3, category);
            preparedStatement.setInt(4, delivId);
            preparedStatement.setString(5, charact);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String qwery = String.format("delete from %s where Pr_id = %d ", TABLE_NAME, id);
        makeTransaction(qwery);
    }

    public void deleteAll() {
        String qwery = String.format("delete from %s ", TABLE_NAME);
        makeTransaction(qwery);
    }

    public void deleteWithLimit(int fromID, int toID) {
        String qwery = String.format("delete from %s where Pr_id>%d and Pr_id<%d", TABLE_NAME, fromID - 1, toID + 1);
        makeTransaction(qwery);
    }

    public void update(String name, int price, String categor, int deliv_id, String charact, int id) {
        //String qwery = "update " + TABLE_NAME + " set Pr_name=?, Pr_price=?, Pr_catgr=?, Deliv_id=?, Pr_charact=? where Pr_id=?";

        if (name != "") {
            String qweryName = "update " + TABLE_NAME + " set Pr_name=? where Pr_id=?";
            try {
                PreparedStatement preparedStatement = openPreparedConnection(qweryName);
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, id);
                preparedStatement.execute();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (price != 0) {
            String qweryPrice = "update " + TABLE_NAME + " set Pr_price=? where Pr_id=?";
            try {
                PreparedStatement preparedStatement = openPreparedConnection(qweryPrice);
                preparedStatement.setInt(1, price);
                preparedStatement.setInt(2, id);
                preparedStatement.execute();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (categor != "") {
            String qweryCategor = "update " + TABLE_NAME + " set Pr_catgr=? where Pr_id=?";
            try {
                PreparedStatement preparedStatement = openPreparedConnection(qweryCategor);
                preparedStatement.setString(1, categor);
                preparedStatement.setInt(2, id);
                preparedStatement.execute();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (deliv_id != 0) {
            String qweryDeilvId = "update " + TABLE_NAME + " set Deliv_id=? where Pr_id=?";
            try {
                PreparedStatement preparedStatement = openPreparedConnection(qweryDeilvId);
                preparedStatement.setInt(1, deliv_id);
                preparedStatement.setInt(2, id);
                preparedStatement.execute();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (charact != "") {
            String qweryCategor = "update " + TABLE_NAME + " set Pr_charact=? where Pr_id=?";
            try {
                PreparedStatement preparedStatement = openPreparedConnection(qweryCategor);
                preparedStatement.setString(1, charact);
                preparedStatement.setInt(2, id);
                preparedStatement.execute();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }

  /*  public void printAll() {
        String qwery = String.format("select * from  %s", TABLE_NAME);
        try {
            Statement statement = openConnection();
            ResultSet resultSet = statement.executeQuery(qwery);//save all data from table
            while (resultSet.next()) {
                User myUser = new User();
                myUser.setId(resultSet.getInt("id"));
                myUser.setName(resultSet.getString("name"));
                myUser.setPass(resultSet.getString("pass"));
                myUser.setLoginDate(resultSet.getString("loginDate"));
                System.out.println(myUser);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printSomePart(int fromID, int toId) {
        String qwery = String.format("select * from  %s where id>%d and id<%d", TABLE_NAME, fromID-1, toId+1);
        try {
            Statement statement = openConnection();
            ResultSet resultSet = statement.executeQuery(qwery);//save all data from table
            while (resultSet.next()) {
                User myUser = new User();
                myUser.setId(resultSet.getInt("id"));
                myUser.setName(resultSet.getString("name"));
                myUser.setPass(resultSet.getString("pass"));
                myUser.setLoginDate(resultSet.getString("loginDate"));
                System.out.println(myUser);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    public void makeTransaction(String qwery) {
        try {
            Statement statement = openConnection();
            statement.execute(qwery);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
