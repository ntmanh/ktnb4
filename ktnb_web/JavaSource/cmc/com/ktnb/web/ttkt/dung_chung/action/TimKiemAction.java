/*
 * Created on Dec 15, 2010
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.ttkt.dung_chung.action;

import cmc.com.ktnb.util.DetailInformation;
import cmc.com.ktnb.web.BaseDispatchAction;

/**
 * @author Nguyen Tien Dung
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TimKiemAction extends BaseDispatchAction{
	public DetailInformation[] removeItems(DetailInformation[] arrInput, String selectedItems){
		if(selectedItems.equals(""))
			return arrInput;
		int iCountOfRemoved = selectedItems.split(",").length;				
		DetailInformation[] arrOutput = new DetailInformation[arrInput.length - iCountOfRemoved];
		int index = 0;
		for(int i = 0; i< arrInput.length; i++){
			if(selectedItems.indexOf(arrInput[i].getCol0()) < 0){
				arrOutput[index] = arrInput[i];
				index++;
			}
		}
		return arrOutput;
	}

}
