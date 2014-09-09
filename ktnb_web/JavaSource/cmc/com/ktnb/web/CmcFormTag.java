package cmc.com.ktnb.web;

import org.apache.struts.taglib.html.FormTag;

public class CmcFormTag extends FormTag {
	protected String autocomplete = null;

	public String getAutocomplete() {
		return autocomplete;

	}
	public void setAutocomplete(String autocomplete) {
		this.autocomplete = autocomplete;

	}
	protected void renderOtherAttributes(StringBuffer results) {
		if (autocomplete != null) {
			results.append(" autocomplete");
			results.append("=\"");
			results.append(autocomplete);
			results.append("\"");
		}
	}

}
