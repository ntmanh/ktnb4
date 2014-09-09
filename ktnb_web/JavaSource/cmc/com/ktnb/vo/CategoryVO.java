package cmc.com.ktnb.vo;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

public class CategoryVO implements JSONAware
{
  private String id;
  private String name;
  private String url;
  public CategoryVO(String id,String name,String url)
	{
	  this.id=id;
	  this.name=name;
	  this.url = url;
	}
  public CategoryVO(String id,String name)
  {
    this.id=id;
	this.name=name;
  }
  public void setId(String id)
  {
    this.id = id;
  }
  public String getId()
  {
    return id;
  }
  public void setName(String name)
  {
    this.name= name;
  }
  public String getName()
  {
    return name;
  }
  public String toJSONString(){
	StringBuffer sb = new StringBuffer();
    sb.append("{");
    sb.append(JSONObject.escape("id"));
    sb.append(":\""+JSONObject.escape(id)+"\",");
    sb.append(JSONObject.escape("name"));
    sb.append(":\""+JSONObject.escape(name)+"\"");
    sb.append("}");
    return sb.toString();
 }
/**
 * @return
 */
public String getUrl() {
	return url;
}

/**
 * @param string
 */
public void setUrl(String string) {
	url = string;
}

}