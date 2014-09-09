package cmc.com.ktnb.vo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class Node {
	private String id;
	private String text;
	private boolean leaf = true;
	private boolean expanded = true;
	private List children = new ArrayList();
	private boolean checked = false;
	public Node(String id, String text) {
		this.id = id;
		this.text = text;
	}
	public Node(String id, String text, boolean checked) {
		this.id = id;
		this.text = text;
		this.checked = checked;
	}
	public JSONObject toJson(boolean check) throws Exception {
		JSONObject json = new JSONObject();
		json.put("id", id);
		json.put("text", text);
		json.put("expanded", new Boolean(expanded));
		if (check)
			json.put("checked", new Boolean(false));
		json.put("leaf", new Boolean(leaf));
		if (children.isEmpty())
			return json;
		JSONArray jsonArray = new JSONArray();
		Node node;
		for (Iterator iter = children.iterator(); iter.hasNext();) {
			node = (Node) iter.next();
			jsonArray.add(node.toJson(check));
		}
		json.put("children", jsonArray);
		return json;
	}
	//new to Json . set checked for every node
	public JSONObject toJson() throws Exception {
		JSONObject json = new JSONObject();
		json.put("id", id);
		json.put("text", text);
		json.put("expanded", new Boolean(expanded));
		json.put("checked", new Boolean(checked));
		json.put("leaf", new Boolean(leaf));
		if (children.isEmpty())
			return json;
		JSONArray jsonArray = new JSONArray();
		Node node;
		for (Iterator iter = children.iterator(); iter.hasNext();) {
			node = (Node) iter.next();
			jsonArray.add(node.toJson());
		}
		json.put("children", jsonArray);
		return json;
	}
	public void addChild(Node node) {
		leaf = false;
		children.add(node);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public void setExpanded(boolean b) {
		expanded = b;
	}
	public boolean isExpanded() {
		return expanded;
	}
	/**
	 * @return
	 */
	public boolean isChecked() {
		return checked;
	}
	/**
	 * @param b
	 */
	public void setChecked(boolean b) {
		checked = b;
	}
}