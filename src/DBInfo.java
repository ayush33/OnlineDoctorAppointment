import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

public class DBInfo 
{
	 static Connection con;
	 static Vector<String> header;
	  static Vector<Vector<String>> outer;
 
  static
  {
	  try
	  {
		  Class.forName("com.mysql.jdbc.Driver");
		  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinedoctor","root","rat");  
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
  }
  
  public static Vector<String> getDoctor(String s)
  {
	  Vector<String>  v=new Vector<>();
	  String query= "select * from doctor  where category=?";
	  try
	  {
		  PreparedStatement ps=con.prepareStatement(query);
		  
		  ps.setString(1, s);
		  
		  ResultSet res=ps.executeQuery();
		  while(res.next())
		  {
			 v.add(res.getString(1)); 
			
		  }
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  return v;
  }
  public static Vector<String> getCategory()
  {
	  Vector<String>  v=new Vector<>();
	  String query="select * from doctor";
	  try
	  {
		  PreparedStatement ps=con.prepareStatement(query);
		  ResultSet res=ps.executeQuery();
		  while(res.next())
		  {
			 v.add(res.getString(2)); 
		  }
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  return v;
  }
  public static Vector<String> getfees()
  {
	  Vector<String>  v=new Vector<>();
	  String query="select * from doctor";
	  try
	  {
		  PreparedStatement ps=con.prepareStatement(query);
		  ResultSet res=ps.executeQuery();
		  while(res.next())
		  {
			 v.add(res.getString(3)); 
		  }
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  return v;
  }
  
  public static  Vector<String> getdoctor1()
  {
	  Vector<String>  v=new Vector<>();
	  String query = "select * from doctor";
	  try
	  {
		  PreparedStatement ps=con.prepareStatement(query);
		  ResultSet res=ps.executeQuery();
		  while(res.next())
		  {
			 v.add(res.getString(1)); 
		  }
		 }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	return v;
  }
  public static  Vector<String> getappointment()
  {
	  Vector<String>  v=new Vector<>();
	  String query = "select * from appointment";
	  try
	  {
		  PreparedStatement ps=con.prepareStatement(query);
		  ResultSet res=ps.executeQuery();
		  while(res.next())
		  {
			 v.add(res.getString(1)); 
		  }
		 }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	return v;
  }
  public static  Vector<String> getmedicine()
  {
	  Vector<String>  v=new Vector<>();
	  String query = "select name from medicine ";
	  try
	  {
		  PreparedStatement ps=con.prepareStatement(query);
		  ResultSet res=ps.executeQuery();
		  while(res.next())
		  {
			 v.add(res.getString(1)); 
		  }
		 }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	return v;
  }
 
  public static String medicine1(String s)
  {
	  String i=null;
		String query="select * from medicine where name=?";
		try
		{
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, s);
		ResultSet res=ps.executeQuery();
		while(res.next())
		{
			i=res.getString(2);
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return i;
  
}
  public static String medicine2(String s)
  {
	  String i=null;
		String query="select * from medicine where name=?";
		try
		{
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, s);
		ResultSet res=ps.executeQuery();
		while(res.next())
		{
			i=res.getString(3);
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return i;
  
} public static  Vector<String> getdoctor4()
{
	  Vector<String>  v=new Vector<>();
	  String query = "select Name from doctor ";
	  try
	  {
		  PreparedStatement ps=con.prepareStatement(query);
		  ResultSet res=ps.executeQuery();
		  while(res.next())
		  {
			 v.add(res.getString(1)); 
		  }
		 }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	return v;
}
public static String doctor1(String s)
{
	  String i=null;
		String query="select * from doctor where Name=?";
		try
		{
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, s);
		ResultSet res=ps.executeQuery();
		while(res.next())
		{
			i=res.getString(2);
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return i;

}
public static String doctor2(String s)
{
	  String i=null;
		String query="select * from doctor where Name=?";
		try
		{
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,s);
		ResultSet res=ps.executeQuery();
		while(res.next())
		{
			i=res.getString(3);
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return i;
  }
}