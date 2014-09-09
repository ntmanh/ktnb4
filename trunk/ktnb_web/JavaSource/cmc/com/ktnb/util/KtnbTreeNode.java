/*
 * Created on Dec 20, 2010
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;


import cmc.com.ktnb.vo.CategoryVO;

/**
 * @author Nguyen Tien Dung
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class KtnbTreeNode implements javax.swing.tree.TreeNode {
	private String id;
	private String ma;
	private String text;
	private KtnbTreeNode parent;
	boolean isLeaf = true;
	private Collection listChild;
	private int level;
	public KtnbTreeNode(String ma, String text) {
		this.ma = ma;
		this.text = text;
	}
	public KtnbTreeNode(String ma, String text, int level) {
		this.ma = ma;
		this.text = text;
		this.level = level;
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#getChildCount()
	 */
	public int getChildCount() {
		
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#getAllowsChildren()
	 */
	public boolean getAllowsChildren() {
		
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#isLeaf()
	 */
	public boolean isLeaf() {
		
		return isLeaf;
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#children()
	 */
	public Enumeration children() {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#getParent()
	 */
	public TreeNode getParent() {
		
		return parent;
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#getChildAt(int)
	 */
	public TreeNode getChildAt(int childIndex) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#getIndex(javax.swing.tree.TreeNode)
	 */
	public int getIndex(TreeNode node) {
		
		return 0;
	}

	/**
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return
	 */
	public String getMa() {
		return ma;
	}

	/**
	 * @return
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param string
	 */
	public void setId(String string) {
		id = string;
	}

	/**
	 * @param string
	 */
	public void setMa(String string) {
		ma = string;
	}

	/**
	 * @param string
	 */
	public void setText(String string) {
		text = string;
	}
	public static KtnbTreeNode buidTree(String rootId) {
		return null;
	}

	/**
	 * @return
	 */
	public Collection getListChild() {
		return listChild;
	}

	/**
	 * @param collection
	 */
	public void setListChild(Collection collection) {
		listChild = collection;
	}

	/**
	 * 
	 */
	public void addChild() throws Exception {
		ArrayList arrChilList = (ArrayList) getChildByMa(ma);
		if (!Formater.isNull(arrChilList)) {
			isLeaf = false;
			setListChild(arrChilList);
			for (int i = 0; i < listChild.size(); i++) {
				KtnbTreeNode child =
					((KtnbTreeNode) ((ArrayList) listChild).get(i));
				child.setLevel(this.level + 1);
				child.addChild();
			}
		}

	}

	/**
	 * @param ma
	 * @return
	 */
	private Collection getChildByMa(String ma) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Collection retval = new ArrayList();
		String sql = "select * from ktnb_dm t where t.parent_id = " + ma + " and hien_thi=1 and ngay_het_hl is null order by ma";
//		String sql = "select * from ktnb_dm t where t.parent_id = " + ma + " and hien_thi=1 order by ma";
		try {
			conn = DataSourceConfiguration.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				KtnbTreeNode vo = new KtnbTreeNode(rs.getString(1), rs.getString(2), this);
				retval.add(vo);
			}
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return retval;
	}

	/**
	 * @param string
	 * @param string2
	 * @param node
	 */
	public KtnbTreeNode(String ma, String text, KtnbTreeNode parent) {
		
		this.ma = ma;
		this.text = text;
		this.parent = parent;
	}

	/**
	 * @param node
	 */
	public void setParent(KtnbTreeNode node) {
		parent = node;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

	

}
