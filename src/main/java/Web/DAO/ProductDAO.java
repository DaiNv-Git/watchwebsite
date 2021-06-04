package Web.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Web.Contex.dbContex;
import Web.Model.Account;
import Web.Model.Category;
import Web.Model.Product;
public class ProductDAO {
	Connection con = null;
	PreparedStatement statement = null;
	ResultSet rs = null;

	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<>();
		String sql = "Select * from product";
		try {
			con = new dbContex().getConnection();
			statement = con.prepareStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public Product getLast() {
		String sql = "select * from product order by id desc limit 1";
		try {
			con = new dbContex().getConnection();
			statement = con.prepareStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public List<Category> getAllCategory() {
		List<Category> list = new ArrayList<>();
		String sql = "Select * from Category";
		try {
			con = new dbContex().getConnection();
			statement = con.prepareStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				list.add(new Category(rs.getInt(1), rs.getString(2)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<Product> getProductByCID(String cid) throws SQLException {
		List<Product> list = new ArrayList<>();
		String sql = "Select * from product" + " Where cateId=?";
		try {
			con = new dbContex().getConnection();
			statement = con.prepareStatement(sql);
			statement.setString(1, cid);
			rs = statement.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public Product getProductByID(String id) throws SQLException {

		String sql = "Select * from product" + " Where id=?";
		try {
			con = new dbContex().getConnection();
			statement = con.prepareStatement(sql);
			statement.setString(1, id);
			rs = statement.executeQuery();
			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	public List<Product> SearchByName(String txtSearch) throws SQLException {
		List<Product> list = new ArrayList<>();
		String sql = "Select * from product" + " Where name like ?";
		try {
			con = new dbContex().getConnection();
			statement = con.prepareStatement(sql);
			statement.setString(1, "%" + txtSearch + "%");
			rs = statement.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public Account Login(String username, String pass) {
		String query = "select * from Account "+"where user = ?" +" and pass= ?";
		try {
			con = new dbContex().getConnection();
			statement = con.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, pass);
			rs = statement.executeQuery();
			while(rs.next()) {
				Account a = new Account(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5));
							return a;
			}
		} catch (Exception e) {
			System.out.println("loi");
		}
		return null;
		
}
	public Account CheckAccount(String username) {
		String query = "select * from Account "+"where user = ?" ;
		try {
			con = new dbContex().getConnection();
			statement = con.prepareStatement(query);
			statement.setString(1, username);
			rs = statement.executeQuery();
			while(rs.next()) {
				Account a = new Account(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5));
							return a;
			}
		} catch (Exception e) {
			System.out.println("loi");
		}
		return null;	
}
	public void signUp(String user , String pass) {
		String sql = "Insert into account(user,pass,isSell,isAdmin) "+"values(?,?,0,0)";
		try {
			con = new dbContex().getConnection();
			statement = con.prepareStatement(sql);
			statement.setString(1, user);
			statement.setString(2, pass);
			statement.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public List<Product> getProductBySellId() throws SQLException {
		List<Product> list = new ArrayList<>();
		String sql = "Select * from product";
		try {
			con = new dbContex().getConnection();
			statement = con.prepareStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public void delete(String pid) {
		String query="delete from product "+"where id=?";
		try {
			con = new dbContex().getConnection();
			statement = con.prepareStatement(query);
			statement.setString(1, pid);
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void insertProduct(String name , String image,String price,String title , String description,String pcategory) {
		String query = "Insert into product(name,image,price,title,description,cateId) "+"values(?,?,?,?,?,?)";
		try {
			con = new dbContex().getConnection();
			statement = con.prepareStatement(query);
			statement.setString(1, name);	
			statement.setString(2, image);
			statement.setString(3, price);
			statement.setString(4, title);
			statement.setString(5, description);
			statement.setString(6,pcategory);
			statement.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void EditProduct(String name , String image,String price,String title , String description,String pcategory) {
	String query = "update product set name =\"?\",image=\"?\",price=\"?\",title=\"?\",description=\"?\" where id = ?;";
		try {
			con = new dbContex().getConnection();
			statement = con.prepareStatement(query);
			statement.setString(1, name);	
			statement.setString(2, image);
			statement.setString(3, price);
			statement.setString(4, title);
			statement.setString(5, description);
			statement.setString(6,pcategory);
			statement.executeUpdate();
		}catch (Exception e) {
		}
		
	}

	public List<Account> getAllAcount() {
		List<Account> listA = new ArrayList<>();
		String sql = "Select * from Account";
		try {
			con = new dbContex().getConnection();
			statement = con.prepareStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				listA.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)
						));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listA;
	}
	public void deleteA(String Aid) {
		String query="delete from Account "+"where uId=?";
		try {
			con = new dbContex().getConnection();
			statement = con.prepareStatement(query);
			statement.setString(1, Aid);
			statement.executeUpdate();
		} catch (Exception e) {
			
		}
	}
	public void AddAccount(String user , String pass,int isSell,int isAdmin) {
		String sql = "Insert into account(user,pass,isSell,isAdmin) "+"values(?,?,?,?)";
		try {
			con = new dbContex().getConnection();
			statement = con.prepareStatement(sql);
			statement.setString(1, user);
			statement.setString(2, pass);
			statement.setInt(3, isSell);
			statement.setInt(4, isAdmin);
			statement.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}