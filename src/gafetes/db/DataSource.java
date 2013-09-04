package gafetes.db;
public class DataSource
{
  private String name;
  private String driver;
  private String url;
  private String password;
  private String userName;

  public DataSource(String name, String driver, String url, String userName, String password)
  {
    this.name = name;
    this.driver = driver;
    this.url = url;
    this.userName = userName;
    this.password = password;    
  }
  
  
  public DataSource()
  {
    
  }


  public String getName()
  {
    return name;
  }

  public String getDriver()
  {
    return driver;
  }
  
  public void setDriver(String driver)
  {
    this.driver = driver;
  }

  public String getURL()
  {
    return url;
  }
	
  public void setURL(String url)
  {
     this.url = url;
  }

  public String getPassword()
  {
    return password;
  }
  
  public void setPassword(String password)
  {
     this.password = password;
  }

  public String getUserName()
  {
    return userName;
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
}