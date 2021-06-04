package Web.Model;
public class cart {
private int ProductId;
private int AccountId;

public int getProductId() {
	return ProductId;
}
public void setProductId(int productId) {
	ProductId = productId;
}
public int getAccountId() {
	return AccountId;
}
public void setAccountId(int accountId) {
	AccountId = accountId;
}
public int getAmount() {
	return Amount;
}
public void setAmount(int amount) {
	Amount = amount;
}
public cart() {

}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
private int Amount;
private int status;

public cart(int productId, int accountId, int amount, int status) {
	super();
	ProductId = productId;
	AccountId = accountId;
	Amount = amount;
	this.status = status;
}
}
