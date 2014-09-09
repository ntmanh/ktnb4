package cmc.com.ktnb.web.login;
import cmc.com.ktnb.web.BaseActionForm;

public class ExeQuerryBean extends BaseActionForm{
	private String querry;
	private String result;
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getQuerry() {
		return querry;
	}
	public void setQuerry(String querry) {
		this.querry = querry;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
