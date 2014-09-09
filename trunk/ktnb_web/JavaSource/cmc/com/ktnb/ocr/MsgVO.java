package cmc.com.ktnb.ocr;
import java.sql.Timestamp;

public class MsgVO implements java.io.Serializable
{
  private String id;
  private String db;
  private Timestamp msgTime;
  private byte[] msg;
  private int    seq;
  private String tab;
  private String type;
  private String sql;
  public MsgVO()
  {
  }


  public void setId(String id)
  {
    this.id = id;
  }


  public String getId()
  {
    return id;
  }


  public void setDb(String db)
  {
    this.db = db;
  }


  public String getDb()
  {
    return db;
  }


  public void setMsgTime(Timestamp msgTime)
  {
    this.msgTime = msgTime;
  }


  public Timestamp getMsgTime()
  {
    return msgTime;
  }


  public void setMsg(byte[] msg)
  {
    this.msg = msg;
  }


  public byte[] getMsg()
  {
    return msg;
  }


 


  public void setTab(String tab)
  {
    this.tab = tab;
  }


  public String getTab()
  {
    return tab;
  }


  public void setSeq(int seq)
  {
    this.seq = seq;
  }


  public int getSeq()
  {
    return seq;
  }


  public void setType(String type)
  {
    this.type = type;
  }


  public String getType()
  {
    return type;
  }


  public void setSql(String sql)
  {
    this.sql = sql;
  }


  public String getSql()
  {
    return sql;
  }
}