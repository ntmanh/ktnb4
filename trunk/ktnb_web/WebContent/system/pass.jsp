<%@ include file="/top_bar_change_pass.jsp"%>
<div id="divPass" style="margin-left: 240px; width: 300px; height: 200px; margin-top: 50px;"></div>
	<script type="text/javascript">
			Ext.apply(Ext.form.VTypes,{
			   password: function(val,field){
			      if (field.initialPassField){
			         var pwd = Ext.getCmp(field.initialPassField);
			         return (val==pwd.getValue());
			      }
			      return true;
			   }
			   ,passwordText:'M\u1EADt kh\u1EA9u nh\u1EAFc l\u1EA1i kh\u00F4ng \u0111\u00FAng !'
			});
			var form=new Ext.FormPanel({
			    id:'form'
			    ,title:'Thay &#273;&#7893;i M&#7853;t kh&#7849;u'
			    ,width:300
			    ,bodyStyle:'padding:5px;'
			    ,renderTo:'divPass'
			    ,items: 
			    [
				 {xtype:'textfield',id:'pass1',fieldLabel:'M&#7853;t kh&#7849;u m&#7899;i',inputType:'password',allowBlank: false,minLength:4,maxLength:15,msgTarget:'side',validationEvent:false}
				,{xtype:'textfield',id:'pass2',fieldLabel:'Nh&#7855;c l&#7841;i',inputType:'password',allowBlank:false,minLength:4,maxLength:15,msgTarget:'side',vtype:'password',initialPassField:'pass1',validationEvent:false}
			    ]
			    ,buttons: 
			    [
				   {
				    text:'Thay m&#7853;t kh&#7849;u'
				    ,icon:'image/solution.gif'
				    ,handler: function(){
						Ext.getCmp('form').getForm().submit(
			    		 {
				   			url:'pass.do'
				   		   ,success: function(f, action){
				   			 showMsg('\u0110\u00E3 thay \u0111\u1ED5i MK !!! <br/> Ch\u01B0\u01A1ng tr\u00ECnh s\u1EBD t\u1EF1 \u0111\u1ED9ng quay v\u1EC1 trang ch\u1EE7 sau 3 gi\u00E2y!!!',null);
				   			 window.setTimeout("window.location='index.do'",3000);
			     			 //window.location='index.do';
			    			}
			    		   ,failure: function(f, action){showFailure(action);}	  
				     	 }
					    );
			 	     } 
				   }
			    ]
			});
	</script>
<%@ include file="/bottom.jsp"%>