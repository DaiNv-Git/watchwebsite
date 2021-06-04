package Web.Model;

public class Account {
private int id;
private String  user;
private String  pass;
private int  isSell;
public Account() {
	
}
public Account(int id,String  user,String  pass,int  isSell,int  isAdmin) {
	this.id=id;
	this.user=user;
	this.pass=pass;
	this.isSell=isSell;
	this.isAdmin=isAdmin;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getPassword() {
	return pass;
}
public void setPassword(String password) {
	this.pass = password;
}
public int getIsSell() {
	return isSell;
}
public void setIsSell(int isSell) {
	this.isSell = isSell;
}
public int getIsAdmin() {
	return isAdmin;
}
public void setIsAdmin(int isAdmin) {
	this.isAdmin = isAdmin;
}
private int  isAdmin;
@Override
public String toString() {
	return "Account [id=" + id + ", user=" + user + ", password=" + pass + ", isSell=" + isSell + ", isAdmin="
			+ isAdmin + "]";
}

}
