package models;

import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import db.DB;
import models.Product;

public class ProductDAO {
	public static java.sql.Statement st = null;
	public static java.sql.PreparedStatement ps = null;
	public static java.sql.ResultSet rs = null;
	public static Connection conn = null;

	public static Product getProductByID(int id){
		Product pro = null;
		try {
	    	conn = DB.getConexion();  	
	    	st = conn.createStatement();
	    	rs = st.executeQuery("SELECT * FROM product WHERE id = '"+id+"'");
	        while (rs.next()) {
	        	pro = new Product(rs.getInt("id"),rs.getString("name"),rs.getString("description"),rs.getInt("price"),rs.getString("img")/*B-constructor-attribute-zone*/

/*Code injected by: Rating-AlterProductDAO*/
,rs.getInt("num_rates"),rs.getInt("total_rates")
/*Code injected by: Rating-AlterProductDAO*/
);
	        }
	        rs.close();
	    } catch (Exception e) { e.printStackTrace(); }		
		return pro;
	}
	
	public static ArrayList<Product> getProducts(){
	    ArrayList<Product> products = new ArrayList<Product>();
	    try {
	    	conn = DB.getConexion();
	    	st = conn.createStatement();
	        String s = "SELECT * FROM product";
	        rs = st.executeQuery(s);
	        while (rs.next()) {
	        	Product one_product = new Product(rs.getInt("id"),rs.getString("name"),rs.getString("description"),rs.getInt("price"),rs.getString("img")/*B-constructor-attribute-zone2*/

/*Code injected by: Rating-AlterProductDAO*/
,rs.getInt("num_rates"),rs.getInt("total_rates")
/*Code injected by: Rating-AlterProductDAO*/
);
	        	products.add(one_product);
	        }
	        rs.close();
	    } catch (Exception e) { e.printStackTrace(); }

	    return products;
	}

	/*B-method-zone*/

/*Code injected by: Cart-AlterProductDAO*/
public static ArrayList<Product> getProductsByIds(String ids){
       ArrayList<Product> products = new ArrayList<Product>();
       try {
         conn = DB.getConexion();
         st = conn.createStatement();
           rs = st.executeQuery("SELECT * FROM product WHERE id IN ("+ids+");");
           while (rs.next()) {
            Product one_product = new Product(rs.getInt("id"),rs.getString("name"),rs.getInt("price"),rs.getString("img"));
            products.add(one_product);
           }
           rs.close();
       } catch (Exception e) { e.printStackTrace(); }

       return products;
   }
/*Code injected by: Cart-AlterProductDAO*/


/*Code injected by: Rating-AlterProductDAO2*/
public static void updateRating(Product p){  
      try {
         conn = DB.getConexion();
         
         st = conn.createStatement();
         st.executeUpdate("UPDATE product set "
               + " total_rates='"+p.getTotal_rates()+"',"
               + " num_rates='"+p.getNum_rates()+"'"
               + "  WHERE id = '"+p.getId()+"';");    
      }
      catch(Exception e){  e.printStackTrace(); }
      finally{
         try { rs.close(); } catch (Exception e) { e.printStackTrace(); }
      }
   }
/*Code injected by: Rating-AlterProductDAO2*/


/*Code injected by: ProductManagement-AlterProductDAO*/
public static void remove(int id){  
    try {
      conn = DB.getConexion();      
      st = conn.createStatement();
        st.executeUpdate("DELETE from product WHERE id ='"+id+"';");  
    }
    catch(Exception e){ e.printStackTrace(); }
    finally{
      try { rs.close(); } catch (Exception e) { e.printStackTrace(); }
    }
  }
  
  public static void insert(Product p){  
    try {
      conn = DB.getConexion();      
      st = conn.createStatement();
        st.executeUpdate("INSERT INTO product (name, description, price, img) VALUES ('"+p.getName()+"', '"+p.getDescription()+"', '"+p.getPrice()+"', '"+p.getImg()+"');");    
    }
    catch(Exception e){ e.printStackTrace(); }
    finally{
      try { rs.close(); } catch (Exception e) { e.printStackTrace(); }
    }
  }
/*Code injected by: ProductManagement-AlterProductDAO*/


}
