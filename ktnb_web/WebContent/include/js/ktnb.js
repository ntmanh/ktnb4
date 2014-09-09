//var auth=Math.random();
var index,des,win;
var hasChanged = false;
var sep=" ",empty="",comma=",",dot=".",numCheck="0123456789";
var dec=",",date_separator="/";
var time_separator = ":";
var arrClassName={0:'r0',1:'r1',2:'r2'};
var filterNumber=/^([-]?[0-9]*|[-]?\d*[\,\.]\d{1}?\d*)$/;
var filterInt=/^[-]?\d+$/;
var filterEmail=/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
var rgx=/(\d+)(\d{3})/;
message_error_notnull="Ph\u1EA3i nh\u1EADp s\u1ED1 li\u1EC7u cho tr\u01B0\u1EDDng n\u00E0y !";
message_error_du_lieu_khong_hop_le="D\u1EEF li\u1EC7u kh\u00F4ng h\u1EE3p l\u1EC7";
message_error_xac_nhan_xoa="X\u00E1c nh\u1EADn x\u00F3a?";
message_error_ngay_khong_hop_le="Ng\u00E0y kh\u00F4ng h\u1EE3p l\u1EC7!";
message_error_sai_logic_ngay_thang="Sai logic ng\u00E0y th\u00E1ng";
chua_chon_ban_ghi="B\u1EA1n ch\u01B0a ch\u1ECDn b\u1EA3n ghi n\u00E0o!";
message_ghi_thanh_cong="Ghi th\u00E0nh c\u00F4ng!";
message_ghi_khong_thanh_cong="L\u1ED7i khi ghi d\u1EEF li\u1EC7u!!!";
language={"sProcessing": "\u0110ang x\u1EED l\u00FD...",
		"sLengthMenu": "Hi\u1EC7n _MENU_",
		"sZeroRecords": "Kh\u00F4ng t\u00ECm th\u1EA5y b\u1EA3n ghi n\u00E0o!",
		"sEmptyTable": "Kh&#244;ng c&#243; d&#7919; li&#7879;u",
		"sInfo": "_START_ - _END_ T\u1ED5ng s\u1ED1 _TOTAL_",
		"sInfoEmpty": "Kh&#244;ng c&#243; d&#7919; li&#7879;u",
		"sInfoFiltered": "(T\u00ECm ki\u1EBFm tr\u00EAn _MAX_ b\u1EA3n ghi)",
		"sInfoPostFix": "",
		"sSearch": "T\u00ECm ki\u1EBFm:",
		"sUrl": "",
		"oPaginate":{"sFirst":" |<< ","sPrevious":" < ","sNext":" > ","sLast":" >>| "}};
function checkTen(i){
 if (i<10) i="0"+i;
 return i;
}
//Nhap so
function isBaseNumber(ctrName, type) {
    var ctr=eval(ctrName);
    var val=ctr.value;
	var delimChar = "";
	if (trim(val).length<1) 
		return true;
	if(comma_sep == comma)
		delimChar = (val.indexOf(",") != -1) ? "," : ".";
	else
		delimChar = (val.indexOf(".") != -1) ? "." : ",";
    //Xoa het ky tu trang
    //val=val.toString().replace(/\s/g,empty);
    val=val.split(delimChar).join(comma_sep);
    val=val.split(thousand_sep).join(empty);
    //Su dung regular expression
    if (type=="i")  
    	objRegExp=/^(-?\d+)$/;      //truong hop la so nguyen
    else
        objRegExp =/^(-?)(\d*|\d*[\,\.]\d{1}?\d*)$/; 
    
    if (!objRegExp.test(val)) {
		showMessage(message_error_du_lieu_khong_hop_le);
        ctr.focus();
        ctr.select();
        return  false; 
    }
    val=val.toString().replace(/\,/g,dot);
    if (type=="%" && val>100) {
       showMessage(message_error_du_lieu_khong_hop_le);
        ctr.focus();
        ctr.select();
        return  false; 
    }
    ctr.value = formatNumber2String(val);
    return  true; 
}

function formatNumber2String(num) {
    var objRegExp = "";
    var strRep = "";    
    var x=Math.pow(10,precision); 
    var delimChar = "";
	if(comma_sep == comma)
		delimChar = (num.indexOf(",") != -1) ? "," : ".";
	else
		delimChar = (num.indexOf(".") != -1) ? "." : ",";
    //num=num.toString().replace(/\s/g,empty);
    num=num.split(delimChar).join(comma_sep);
    num=num.split(thousand_sep).join(empty);
    num=num.toString().replace(/\,/g,dot);

    if(isNaN(num)) num="0";
    num=Math.floor(num*x+0.50000000001);
    var cents = 0;
    if(num < 0){
    	cents = (num * -1) % x;
    	num=Math.floor((num * -1)/x) * -1;
    }
    else{
    	cents = num%x;
    	num=Math.floor(num/x);
    }
    if (cents!=0)  {
        var len=cents.toString().length;
        if (len<precision)
            for (i=1;i<=precision-len;i++)  
            	cents="0"+cents;
    }
    if(cents == 0){
    	objRegExp = new RegExp('(-?[0-9]+)([0-9]{3})');
    	strRep = "$1"+thousand_sep+"$2";
    	num = num + "";    	
    }
    else{
    	objRegExp = new RegExp('(-?[0-9]+)([0-9]{3})([\.\,])');
    	strRep = "$1"+thousand_sep+"$2$3";
    	num = num + comma_sep + cents;
    }
	for (;;){
		o = num;
		num = num.replace(objRegExp, strRep);
		if (o == num)
			break;
	}
	return num;
}

function parseString2Number (num){
	if (trim(num).length<1) 
		return 0;

 	num=num.toString().replace(/\s/g,empty);
	num=num.split(String.fromCharCode(160)).join(empty);
 	num=num.toString().replace(/\,/g,dot);
  	
  	return Number(num);
}
//Ket thuc nhap so
function imposeMaxLength(Object)
{
  if(Object.value.length >=2000)
  {
  		alert("D\u1EEF li\u1EC7u qu\u00E1 gi\u1EDBi h\u1EA1n 2000 k\u00FD t\u1EF1!");
  		//Giu lai 2k ky tu
  		Object.value = Object.value.substring(0,2000);
  		Object.focus();
  		return false;
  }
  return true;
}
function d2str(d){
  return (new String (checkTen(d.getDate())+date_separator+checkTen(d.getMonth()+1)+date_separator+d.getFullYear()));
}
var now=new Date();
var dayarr=new Array("Ch&#7911; nh&#7853;t", "Th&#7913; Hai", "Th&#7913; Ba", "Th&#7913; T&#432;", "Th&#7913; N&#259;m", "Th&#7913; S&#225;u", "Th&#7913; B&#7849;y");
var day=dayarr[now.getDay()];
var date_transaction=d2str(now);
function goHome(){
 	window.location='index.do';	
}
function goHomeKntc(){
 	window.location='index_kntc.do';	
}
function goHomeTtkt(){
 	window.location='ttkt_index.do';	
}
function goHomeReport(){
 	window.location='index_report.do';	
}
function goHomeTTCP(){
 	window.location='index_ttcp.do';	
}
function goHomeSys(){
 	window.location='index_system.do';	
}
function goTab(index){
 jQuery.fn.createCookie("TABI",index);
 goHome();
}
function goBack(){
	history.go(-1);
}
function isArray(obj){return(typeof(obj.length)=="undefined")?false:true;}
function check(lists,checkallChk)
{
  checkflag=checkallChk.checked;
  if (isArray(lists))
   {
      for (i=0;i<lists.length;i++)
        lists[i].checked=checkflag;
   }
   else   lists.checked=checkflag;
}
function getCheck(obj)
{
    var s="";
    if (isArray(obj))
    {
      for(i=0;i<obj.length;i++)
      {
        if (obj[i].checked)  s=s+','+obj[i].value;
      }
    }
    else
    {
      if (obj.checked)      s=s+','+obj.value;
    }
    return s.substring(1);
}
function getCheckReport(obj)
{
    var s="";
    if (isArray(obj))
    {
      for(i=0;i<obj.length;i++)
      {
        if (obj[i].checked)  s=s+';'+obj[i].value;
      }
    }
    else
    {
      if (obj.checked)      s=s+';'+obj.value;
    }
    return s.substring(1);
}
function ncr2u(s)
{
    if (s==null)  return null;
    else
        {
              var len=s.length;
              var result='';
              var foundIndex;
              var startIndex=0;
              while (startIndex<len)
              {
                  foundIndex=s.indexOf('&#',startIndex);
                    if (foundIndex==-1)
                     {
                       result+=s.substring(startIndex);
                       break;
                     }
                   result+=s.substring(startIndex,foundIndex);
                   startIndex=s.indexOf(';',foundIndex);
                      if (startIndex==-1)
                       {
                          result+=s.substring(foundIndex);
                          break;
                       }
                      var tok=s.substring(foundIndex+2,startIndex);
                      var radix=10;
                       if (tok.charAt(0)=='x')
                          {
                             radix=16;
                             tok=tok.substring(1,tok.length());
                          }
                          result+=String.fromCharCode(parseInt(tok,radix));
                          startIndex++;
              }
              return result;
        }
}
function isRequired(ctrName,msg)
{
	  var ctr=eval(ctrName);
	  var val=ctr.value;
	  if (trim(val).length<1) { 
	     if (!isEmpty(msg)) alert(msg);
	     else               alert(message_error_notnull);
	     ctr.focus();
	     return false;
	  }
  	return true;
}
function isRequiredId(ctrName,msg)
{
	if(isExist(ctrName)){
	  var ctr=eval(ctrName);
	  var val=ctr.value;
	  if (trim(val).length<1) { 
	     if (!isEmpty(msg)) alert(msg);
	     else               alert(message_error_notnull);
	     ctr.focus();
	     return false;
	  } 
	}   
  	return true;
}
function showConfirm(key) 
{
 //return confirm(ncr2u(key));
  return confirm(key);
}
function showMessage(key) 
{
  //alert(ncr2u(key));
  alert(key);
}
function trim(s) 
{ 
  return s.toString().replace(/^\s*/,"").replace(/\s*$/, "");
}
function isEmpty(val)
{
  return(val==null||trim(val)=="");
}
function checkNull(ctr)
{
   if (isEmpty(ctr.value))
   {
     showMessage(message_error_notnull);
     $(ctr).effect('highlight',null,1000).focus().select();
     return false;
   }
   return true;
}
function round(num,precision){return num.toFixed(precision);}
function checkGrid(grid,col,ctrcheckall)
{
	i=0;
	try
  {
		while(true)
    {
			ctrChk=document.forms[0].elements[grid+"["+i+"]."+col];
			ctrChk.checked=ctrcheckall.checked;
			i++;
		}
	}
  catch(Exception){}
}
function getElement(grid,col,row)
{
  ename=grid+"["+row+"]"+"."+col;
  return document.forms[0].elements[ename];
}
function onSort(sortValue)
{
  if (document.forms[0].sortDirection.value=="asc") document.forms[0].sortDirection.value="desc";
  else                                              document.forms[0].sortDirection.value="asc";
  document.forms[0].sort.value=sortValue;
  document.forms[0].method.value='sort';
  document.forms[0].submit();
}
function setPa4Grid(arrayName,rowNum,cid,cname,id,name)
{
   if (!isEmpty(id))
   {
	    try
	    {
	      var i=0;
	      while (true)
	      {
	         e=document.forms[0].elements[arrayName+"["+i+"]."+cid];
	         if (i!=rowNum && e.value==id)
	         {
	           showMessage(message_error_da_co_ban_ghi_nay);
	           return false;
	         }
	         i++;
	      }
	    } catch (Exception) {}
      try
      {
	      document.forms[0].elements[arrayName+"["+rowNum+"]"+"."+cid].value=id;
	      document.forms[0].elements[arrayName+"["+rowNum+"]"+"."+cname].value=name;
      } catch (Exception) {}
    }
    return true;
}
function compareNumber(ctrName1,ctrName2,type)
{
    ctr1=eval(ctrName1);
    ctr2=eval(ctrName2);
    num1=convertStringToNumber(ctr1.value);
    num2=convertStringToNumber(ctr2.value);
    if ((num1<=0)||(num2<=0))       return true;
    if ((type==">")&&(num1>num2))   return true;
    if ((type==">=")&&(num1>=num2)) return true;
    if ((type=="<")&&(num1<num2))   return true;
    if ((type=="<=")&&(num1<=num2)) return true;
    if ((type=="=")&&(num1==num2))  return true;
    showMessage(message_error_du_lieu_khong_hop_le);
    $(ctr1).effect('highlight',null,1000);
    $(ctr2).effect('highlight',null,1000).focus();
    return false;
}
function padleft(val,num) 
{
    var re = new RegExp(".{" + num + "}$");
    var pad = "";
    do  
    {
      pad+="0";
    }
    while(pad.length<num);
    return re.exec(pad+val)[0];
}
function padright(val,num)
{
    var re=new RegExp("^.{" + num + "}");
    var pad = "";
    do 
    {
      pad+="0";
    }
    while (pad.length < num);
    return re.exec(val+pad)[0];
}
function displayNumber(nStr,precision)
{
  var fix=2;
  if (precision) fix=precision;
  nStr+='';
  x=nStr.split('.');
  x1=x[0];
  x2=x.length>1?'.'+padright(x[1],fix):'';
  while (rgx.test(x1)) 
	x1=x1.replace(rgx,'$1'+' '+'$2');
  return x1+x2;
}
function convertStringToNumber(num)
{
  if (isEmpty(num)) return 0;
  num=trim(num.toString()).replace(/\s/g,empty).replace(/\,/g,dot).split(String.fromCharCode(160)).join(empty);
  return Number(num);
}

function isNumberInt(ctrName) 
{ 
  ctr=eval(ctrName);
  x=ctr.value;
  return ( (typeof x === typeof 1) && (null !== x) && isFinite(x) );
}
function isNumber(ctrName,type) 
{
  ctr=eval(ctrName);
  val=ctr.value;
  if (isEmpty(val)) return true;
  val=trim(val.toString()).replace(/\s/g,empty).replace(/\,/g,dot).split(String.fromCharCode(160)).join(empty);
  ok=true;
  if (type=="i") ok=filterInt.test(val);
  else           ok=filterNumber.test(val);
  if (!ok ||(type=="%" && val>100)) 
  {
      showMessage("Ch\u1EC9 \u0111\u01B0\u1EE3c nh\u1EADp d\u1EEF li\u1EC7u d\u1EA1ng s\u1ED1 cho tr\u01B0\u1EDDng n\u00E0y!!!");
      $(ctr).effect('highlight',null,1000).focus().select();
      return  false;
  }
  var fix=(type=="%")?4:3;
  ctr.value=displayNumber(val,fix); 
  return  true;
}

function isDouble(ctrName){
	ctr=eval(ctrName);
 	val=ctr.value;
	if(val!=null && val != ""){
		var pattern = /^\d+.?\d*/;
	    if ( val.match(pattern)==null ){
	    	showMessage("Ch\u1EC9 \u0111\u01B0\u1EE3c nh\u1EADp d\u1EEF li\u1EC7u d\u1EA1ng s\u1ED1 th\u1EADp ph\u00E2n cho tr\u01B0\u1EDDng n\u00E0y!!!");
	    	$(ctr).effect('highlight',null,1000).focus().select();
	    	return false;
	    }
    }
	return true;
}

function formatInt(evt)
{
 charCode=(evt.which)?evt.which:(window.event?window.event.keyCode:0);
 return (charCode<=31||(charCode>=48&&charCode<=57));
}
function formatNumber(evt, control)
{
  charCode=(evt.which)?evt.which:(window.event?window.event.keyCode:0);
  key=String.fromCharCode(charCode);
  if(key==dec||key==dot){
  	if(control.value.indexOf(key) >= 0)
  		return false; 
  	if(key == dec){
  		if(control.value.indexOf(dot) >= 0) 
  			return false;
  	}else{
  		if(control.value.indexOf(dec) >= 0)
  			return false;
  	}
  	return true;
  }
  return (charCode<=31||(charCode>=48&&charCode<=57));
}
function formatInt(evt)
{ 
  charCode=(evt.which)?evt.which:(window.event?window.event.keyCode:0);
  key=String.fromCharCode(charCode);
  return (charCode<=31||(charCode>=48&&charCode<=57));
}
function formatDate(evt,ctrName) 
{
  if (!formatInt(evt)) return false;
  var ctr=eval(ctrName);
  var val=ctr.value;
  var len=val.length;
  if (len==2||len==5)  ctr.value=val+date_separator;
  return true;
}
function formatDateMonth(evt,ctrName) 
{
  if (!formatInt(evt)) return false;
  var ctr=eval(ctrName);
  var val=ctr.value;
  var len=val.length;
  if (len==2)  ctr.value=val+date_separator;
  return true;
}
function isMonth(ctrName)
{
   ctr=eval(ctrName);
   strDate=ctr.value;
   if (isEmpty(strDate)) return true;
   len=strDate.length;
   if (len!=5&&len!=7)
   {
    showMessage(message_error_ngay_khong_hop_le);
    $(ctr).effect('highlight',null,1000).focus().select();
    return false;
   }
   var arr=strDate.split(date_separator),strD,strM,strY;
   if (arr.length!=2)
   {
      showMessage(message_error_ngay_khong_hop_le);
      $(ctr).effect('highlight',null,1000).focus().select();
      return false;
   }
   else
   {
        strY=arr[1];
        if (strY.length==2) strY="20"+strY;
        strD=01;
        strM=arr[0];
   }
   if (!validDate(strD,strM,strY))
    {
      showMessage(message_error_ngay_khong_hop_le);
      $(ctr).effect('highlight',null,1000).focus().select();
      return false;
    }
    if (len==5) ctr.value=strM+date_separator+strY;
    return true;
}
function compareTime(time1Control, time2Control, operation, strMessage){	
	if(isEmpty(time1Control.value) || isEmpty(time2Control.value) || isEmpty(operation))
		return true;
	time1ToString = time1Control.value.split(' ')[1].split('/')[2] + time1Control.value.split(' ')[1].split('/')[1] + time1Control.value.split(' ')[1].split('/')[0] + time1Control.value.split(' ')[0].split(':')[0] + time1Control.value.split(' ')[0].split(':')[1];
	time2ToString = time2Control.value.split(' ')[1].split('/')[2] + time2Control.value.split(' ')[1].split('/')[1] + time2Control.value.split(' ')[1].split('/')[0] + time2Control.value.split(' ')[0].split(':')[0] + time2Control.value.split(' ')[0].split(':')[1];
	if(parseInt(time1ToString) > parseInt(time2ToString) && operation == '>')
		return true;
	if(parseInt(time1ToString) >= parseInt(time2ToString) && operation == '>=')
		return true;
	if(parseInt(time1ToString) <= parseInt(time2ToString) && operation == '<=')
		return true;
	if(parseInt(time1ToString) < parseInt(time2ToString) && operation == '<')
		return true;
	else{
		try{
			$(time1Control).effect('highlight',null,1000);
		}catch(err1){
		}
		try{
			$(time2Control).effect('highlight',null,1000);
		}catch(err1){
		}
		
		if(strMessage){
			alert(strMessage);
		}else{
			alert('Sai logic v\u1EC1 th\u1EDDi gian!');
		}
		return false;			
	}
}
function isTime(ctrName)
{
   ctr=eval(ctrName);
   strDate=ctr.value;
   if (isEmpty(strDate)) return true;
   len=strDate.length;
   var strTime;
   if (len!=14&&len!=16)
   {
   	
    //showMessage(message_error_ngay_khong_hop_le);
    alert('Th\u1EDDi \u0111i\u1EC3m kh\u00F4ng h\u1EE3p l\u1EC7!')
    $(ctr).effect('highlight',null,1000).focus().select();
    return false;
   }
   var arr=strDate.split(date_separator),strD,strM,strY;
   if (arr.length!=3)
   {
      showMessage(message_error_ngay_khong_hop_le);
      $(ctr).effect('highlight',null,1000).focus().select();
      return false;
   }
   else
   {	 
        strY=arr[2];        
        if (strY.length==2) strY="20"+strY;
        strD=arr[0].split(' ')[1];        
        strM=arr[1];
   }
   if (!validDate(strD,strM,strY))
    {
      alert('Th\u1EDDi \u0111i\u1EC3m kh\u00F4ng h\u1EE3p l\u1EC7!')
      $(ctr).effect('highlight',null,1000).focus().select();
      return false;
    }
    strTime = strDate.split(' ')[0];
    arrTime = strTime.split(':') 
    hh = arrTime[0];
    mm = arrTime[1];
    if(!(parseInt(mm) < 60 && parseInt(hh) < 24)){
    	alert('Th\u1EDDi \u0111i\u1EC3m kh\u00F4ng h\u1EE3p l\u1EC7!')
	    $(ctr).effect('highlight',null,1000).focus().select();
	    return false;
    }
    if (len==14) ctr.value= strTime + ' ' + strD+date_separator+strM+date_separator+strY;
    return true;
}
function formatTime(evt,ctrName) 
{
  if (!formatInt(evt)) return false;
  var ctr=eval(ctrName);
  var val=ctr.value;
  var len=val.length;
  if(len==2)
  	ctr.value=val + time_separator;
  if(len==5)
  	ctr.value=val + ' ';
  if (len==8||len==11)   
  	ctr.value=val+date_separator;
  return true;
}

function LeapYear(intY) 
{
	
    if (intY % 100 == 0)
          if (intY % 400 == 0)   return true;    
    else    
      if ((intY % 4) == 0) return true;    
    return false;
}
function validDateTime(ctrName,msg){
	var ctr=eval(ctrName);
  	var val=ctr.value;
	var REG_TIME_DATE = /^(0[0-9]|[1][0-9]|2[0-4])\:([0-5][0-9]|60) (0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(19|20)\d\d$/;
	if(!REG_TIME_DATE.test(val)){
		if(msg!=null) alert(msg);
		else alert(' Nh\u1EADp sai \u0111\u1ECBnh d\u1EA1ng ng\u00E0y gi\u1EDD\n'+
					'V\u00ED d\u1EE5 \u0111\u1ECBnh d\u1EA1ng \u0111\u00FAng : \n'+
					'1. hh:mm dd/mm/yyyy\n'+
					'2. 24:59 30/02/2012\n'+
					'3. 13:30 15/11/1999');
		ctr.focus();
		return false;
	}
	return true;
}

function validDate(strD,strM,strY)
{
    intY=parseInt(strY,10);
    if (isNaN(intY)) return false;
    intD=parseInt(strD,10);
    if (isNaN(intD)) return false;
    if (intD<1)      return false;
    intM=parseInt(strM,10);
    if (isNaN(intM))      return false;
    if (intM>12||intM<1)  return false;
    if ((intM == 1 || intM == 3 || intM == 5 || intM == 7 || intM == 8 || intM == 10 || intM == 12) && (intD > 31)) return false;
    if ((intM == 4 || intM == 6 || intM == 9 || intM == 11) && (intD > 30)) return false;
    if (intM == 2) {
     if (LeapYear(intY))     
      if (intD>29) return false;     
     else     
      if (intD>28) return false;     
    }
    return true;
}
function isEmail(ctrName) 
{
  ctr=eval(ctrName);
  val=ctr.value; 
  if (isEmpty(val)) return true;
  if (!filterEmail.test(val)) 
  {
    showMessage(message_error_du_lieu_khong_hop_le);
    $(ctr).effect('highlight',null,1000).focus().select();
    return false;
  }
  return true;
}
function isDate(ctrName)
{
   ctr=eval(ctrName);
   strDate=ctr.value;
   if (isEmpty(strDate)) return true;
   len=strDate.length;
   if (len!=8&&len!=10)
   {
    showMessage(message_error_ngay_khong_hop_le);
    $(ctr).effect('highlight',null,1000).focus().select();
    return false;
   }
   var arr=strDate.split(date_separator),strD,strM,strY;
   if (arr.length!=3)
   {
      showMessage(message_error_ngay_khong_hop_le);
      $(ctr).effect('highlight',null,1000).focus().select();
      return false;
   }
   else
   {
        strY=arr[2];
        if (strY.length==2) strY="20"+strY;
        strD=arr[0];
        strM=arr[1];
   }
   if (!validDate(strD,strM,strY))
    {
      showMessage(message_error_ngay_khong_hop_le);
      $(ctr).effect('highlight',null,1000).focus().select();
      return false;
    }
    if (len==8) ctr.value=strD+date_separator+strM+date_separator+strY;
    return true;
}
function d2n(strDate)
{	
   var arr=strDate.split(date_separator);
   var strD=arr[0],strM=arr[1],strY=arr[2];
   return parseInt(strY+strM+strD);
} 
function compareDate(fromDate,toDate, strMessage) 
{
  ctr1=eval(fromDate);
  ctr2=eval(toDate);
  f=ctr1.value;
  t=ctr2.value;
  if (isEmpty(f)||isEmpty(t)) return true;
  if (d2n(f)>d2n(t)) 
  {
    //showMessage(message_error_sai_logic_ngay_thang);
    if(strMessage)
    	alert(strMessage);
    else
    	alert('T\u1EEB ng\u00E0y ph\u1EA3i nh\u1ECF h\u01A1n \u0111\u1EBFn ng\u00E0y!');
    $(ctr1).effect('highlight',null,1000);
    $(ctr2).effect('highlight',null,1000);
    return false;
  } 
  return true;
}
function compareDateAndTime(ctrDate,ctrTime,operation, strMessage)
{
	if(isEmpty(ctrDate.value) || isEmpty(ctrDate.value) || isEmpty(operation))
		return true;
	time2date = ctrTime.value.split(' ')[1];
	if(d2n(time2date)>d2n(ctrDate.value) && operation == '>')
		return true;
	if(d2n(time2date)>=d2n(ctrDate.value) && operation == '>=')
		return true;
	if(d2n(time2date)<d2n(ctrDate.value) && operation == '<')
		return true;
	if(d2n(time2date)<=d2n(ctrDate.value) && operation == '<=')
		return true;
	else{
		try{
			$(ctrDate).effect('highlight',null,1000);
		}catch(err1){
		}
		try{
			$(ctrTime).effect('highlight',null,1000);
		}catch(err1){
		}
		
		if(strMessage){
			alert(strMessage);
		}else{
			alert('Sai logic v\u1EC1 th\u1EDDi gian!');
		}
		return false;			
	}
}
function compare2Date(fromDate,toDate, focusControl)
{
  ctr1=eval(fromDate);
  ctr2=eval(toDate);
  f=ctr1.value;
  t=ctr2.value;
  if (isEmpty(f)||isEmpty(t)) return true;
  if (d2n(f)>d2n(t)) 
  {
    showMessage(message_error_sai_logic_ngay_thang);
    $(ctr1).effect('highlight',null,1000);
    $(ctr2).effect('highlight',null,1000);
    return false;
  } 
  return true;
}
function splitS(val) {return val.split(/,\s*/);}
function extractLast(term) {return splitS(term).pop();}
function normalizeString4SQL(source)
  {
    var sVal;
    try
    {    
        sVal = new String(source);        
        if(sVal!='' && sVal!='undefined' && sVal!='null')
        {
          sVal = sVal.replace('&','%26'); 
          sVal = sVal.replace('%','%25');                     
          sVal = sVal.replace('(','%28'); 
          sVal = sVal.replace(')','%29'); 
          sVal = sVal.replace("'","%92");
        }
    }
    catch (exception){
    }    
    return sVal;    
  }
function encodeURL(url)
{ 
  if (url.indexOf("%3F")!=-1 || url.indexOf("%3D")!=-1 || url.indexOf("%2F")!=-1 ) 
  {
    return url;
  }
  url=encodeURIComponent(url);
  url=url.replace(/%2F/g,"/");
  url=url.replace(/%3D/g,"=");
  url=url.replace(/%3F/g,"?");
  url=url.replace(/%26/g,"&");
  url=url.replace(/%3A/g,":");
  return url;
}
function openWindow(url,w,h,features)
{
  ww=(isEmpty(w))?650:w;
  hh=(isEmpty(h))?550:h;
  winProperty='height='+hh+',width='+ww+',top='+(screen.height-hh)/2+',left='+(screen.width-ww)/2+',';
  if (features) winProperty+=features
  else 			winProperty+='menubar=no,toolbar=no,location=no,status=no,scrollbars=yes,resizable=yes';
  win=window.open(url,'',winProperty);
  win.focus();
}
function openModalDialog(url,w,h,features){ 
  ww=(isEmpty(w))?screen.width:w;  
  hh=(isEmpty(h))?screen.height*3/4:h;
  winProperty='dialogHeight='+hh+'px;dialogWidth='+ww +'px;';
  if (features) winProperty+=features
  else 			
  	winProperty+='resizable=no;scroll=yes';
  window.showModalDialog(url,'',winProperty);
}
function onChangeData(ctrName,changeFlag,inx){
	document.forms[0].elements[ctrName+'['+inx+'].'+changeFlag].value = 1
	hasChanged = true;
}

jQuery.fn.dataTableExt.oApi.fnSetFilteringDelay = function ( oSettings, iDelay ) {
	var	
		_that = this,
		iDelay = (typeof iDelay == 'undefined') ? 250 : iDelay;
	this.each( function ( i ) {
		$.fn.dataTableExt.iApiIndex = i;
		var
			$this = this, 
			oTimerId = null, 
			sPreviousSearch = null,
			anControl = $( 'input', _that.fnSettings().aanFeatures.f );		
			anControl.unbind( 'keyup' ).bind( 'keyup', function() {
			var $$this = $this;
			if (sPreviousSearch === null || sPreviousSearch != anControl.val()) {
				window.clearTimeout(oTimerId);
				sPreviousSearch = anControl.val();	
				oTimerId = window.setTimeout(function() {
					$.fn.dataTableExt.iApiIndex = i;
					_that.fnFilter( anControl.val() );
				}, iDelay);
			}
		});		
		return this;
	} );
	return this;
}
function show(id){
	if (document.getElementById){
		obj = document.getElementById(id);
		if (obj.style.display == "none")
			obj.style.display = "";			
	}
} 
function hide(id){
	if (document.getElementById){
		obj = document.getElementById(id);
		if (obj.style.display == "")
			obj.style.display = "none";
	}
} 
function getUrlParam(paramName, urlString){
  
  paramName = paramName.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");
  var regexS = "[\\?&]"+paramName+"=([^&#]*)";
  var regex = new RegExp( regexS );  
  var url;
  if(isEmpty(urlString))
  	url = window.location.href;
  else url = urlString;
  var results = regex.exec(url);
  if( results == null )
    return "";
  else
    return results[1];
}
function setVisibleButton(){
		/*allButon = document.getElementsByTagName("input");
		for(i = 0; i< allButon.length; i++){
			if(allButon[i].type.toLowerCase()=='button' && allButon[i].name != 'closetheForm')
				allButon[i].disabled = "true";
		}*/
		
}
function downLoadBienBan(fileId){
	downLoadWinDow = window.open('UploadAction.do?method=downLoadBienBan&ma_file=' + fileId);
	downLoadWinDow.focus(); 
}
Date.prototype.getDaysInMonth = function(utc) {
	var m = utc ? this.getUTCMonth() : this.getMonth();
	// If feb.
	if (m == 1)
	return this.isLeapYear() ? 29 : 28;
	// If Apr, Jun, Sep or Nov return 30; otherwise 31
	return (m == 3 || m == 5 || m == 8 || m == 10) ? 30 : 31;
}
var strHolidayDay;
function getNumOfHolidayDay(fromDate, toDate){
	if(isEmpty(strHolidayDay))
		return 0;
	var reVal = 0;
	arrHolidayDay = strHolidayDay.split(';');
	for(var i = 0; i< arrHolidayDay.length; i++){
		if((d2n(fromDate) <= d2n(arrHolidayDay[i]))&&(d2n(arrHolidayDay[i])<= d2n(toDate)))
			reVal++;
	} 
	return reVal;
}
function isHoliday(dayToCheck, mothToCheck, yearToCheck){	
	if (strHolidayDay.indexOf(dayToCheck + '/' + mothToCheck + '/' + yearToCheck) >= 0)
		return true;
	var tempDate = new Date(yearToCheck, eval(mothToCheck - 1), dayToCheck);
	if(tempDate.getDay() == 0 || tempDate.getDay() == 6)
		return true;
	return false;	
}
function getNumOfDaysInMonth(theYear, theMonth){
	if ((theMonth == 1 || theMonth == 3 || theMonth == 5 || theMonth == 7 || theMonth == 8 || theMonth == 10 || theMonth == 12)) return 31;
    if ((theMonth == 4 || theMonth == 6 || theMonth == 9 || theMonth == 11)) return 30;
    if (theMonth == 2) {
     if (LeapYear(theYear))     
     	return 29;     
     else     
     	return 28;     
    }

}
function increateDate(){	
	date++;
	if(date > getNumOfDaysInMonth(year, eval(moth + 1))){
		date = 1;
		moth ++;
		if(moth == 12){
			moth = 0;
			year++;
		} 
	}
	
	var tempDate;
	var tempMoth;
	if(date<10)
		tempDate = '0' + date;
	else 
		tempDate = date;
	if(moth<9)
		tempMoth = '0' + eval(moth + 1);
	else
		tempMoth = eval(moth + 1);
	if(isHoliday(tempDate, tempMoth, year)){		
		increateDate()
	}
		
}
var year, moth, date;// Cac bien chua ngay thang nam, theo kieu javascript
function caculateDate(ctrFromDateName, ctrToDateName, numOfDate){		
	if(isEmpty(document.getElementsByName(ctrFromDateName)[0].value))
		return;
	arrFromDate = document.getElementsByName(ctrFromDateName)[0].value.split('/');	
	year = parseInt(arrFromDate[2], 10);
	moth = parseInt(arrFromDate[1], 10) - 1;	
	date = parseInt(arrFromDate[0], 10);	
	numOfDate = parseInt(numOfDate, 10);			
	for(var i = 0; i< numOfDate - 1; i++) 
		increateDate();
	if(date <10)
		date = "0" + date;
	if(moth <9)
		moth = "0" + eval(moth + 1);
	else
		moth = moth + 1;
	document.getElementsByName(ctrToDateName)[0].value = date + '/' + moth + '/' + year;	
}
function showLovCqt(ten){ 
	url = 'tim_kiem_cqt.do';
	if(!isEmpty(ten))
		url += '?tenCqt=' + ten;	
	openWindow(url, '600', '450', 'menubar=no,toolbar=no,location=no,status=no,scrollbars=no,resizable=no');
}
function showLovNhanVien(maCqt, tenNhanVien){
	url = 'tim_kiem_canBo.do';
	if(!isEmpty(maCqt))
		url += '?maCqt=' + maCqt;
	if(!isEmpty(tenNhanVien.value))
		url += '&tenNhanVien=' +encodeURIComponent (tenNhanVien.value)+'&type=view';
	openWindow(url, '600', '470', 'menubar=no,toolbar=no,location=no,status=no,scrollbars=no,resizable=no');
}
function showLovNhanVien(maCqt, tenNhanVien, isNsd){
	url = 'tim_kiem_canBo.do';
	if(!isEmpty(maCqt))
		url += '?maCqt=' + maCqt;
	if(!isEmpty(tenNhanVien.value))
		url += '&tenNhanVien=' +encodeURIComponent (tenNhanVien.value)+'&type=view';
	if(!isEmpty(isNsd))
		url += '&isNsd=' + isNsd;
	openWindow(url, '600', '470', 'menubar=no,toolbar=no,location=no,status=no,scrollbars=no,resizable=no');
}
function showLovNhanVienWithCQTrucThuoc(maCqt, tenNhanVien){
	url = 'tim_kiem_canBo.do';
	if(!isEmpty(maCqt))
		url += '?maCqt=' + maCqt;
	if(!isEmpty(tenNhanVien.value))
		url += '&tenNhanVien=' +encodeURIComponent (tenNhanVien.value)+'&type=view';
	url+= '&cqtt=true';	
	openWindow(url, '600', '470', 'menubar=no,toolbar=no,location=no,status=no,scrollbars=no,resizable=no');
}
function getChucVuCoDau(chucVuKhongDau){ 
	if(chucVuKhongDau == "Truong doan")
		return "Tr\u01B0\u1EDFng \u0111o\u00E0n";
	else if(chucVuKhongDau == "Pho doan")
		return "Ph\u00F3 \u0111o\u00E0n";
	else
		return "Th\u00E0nh vi\u00EAn \u0111o\u00E0n";
}
function replaceAll(strInput, strToSeach, strToReplace){
	if(strToSeach == strToReplace)
		return strInput;
	while(strInput.indexOf(strToSeach) >=0){
		strInput = strInput.replace(strToSeach, strToReplace);
	}
	return strInput;
}
// Check NVARCHAR2 type
function checkNvarchar2(controlName, message){
	control = document.getElementsByName(controlName)[0];
	if(control.value.length > 4000){
		if(message)
			alert(message)
		else 
			alert('D\u1EEF li\u1EC7u b\u1EA1n nh\u1EADp qu\u00E1 d\u00E0i, \u0111\u1EC1 ngh\u1ECB nh\u1EADp t\u00F3m t\u1EAFt n\u1ED9i dung sau \u0111\u00F3 ch\u1ECDn \u0111\u00EDnh k\u00E8m file!');		
		control.focus();
		return false;
	}
	return true;
}
// Table Object ntdung
function TableObject(tableId, isSoTT, btnXoaId, btnThemId){	
	// properties 
	this.innerTable = document.getElementById(tableId);
	this.isSoTT = isSoTT;
	this.numOfRow = this.innerTable.rows.length;
	this.numOfCheckedRow = 0;
	this.numOfColumn = this.innerTable.rows[0].cells.length;
	
	// method
	// public
	this.deleteSelectedRow = deleteSelectedRow;
	this.deleteRowByIndex = deleteRowByIndex;
	this.reFormatStyle = reFormatStyle;
	this.reFormatStyleIncludeHeader = reFormatStyleIncludeHeader;
	this.addRow = addRow;
	this.updateRow = updateRow;
	this.selectAllRow = selectAllRow; 
	this.getSelectedRow = getSelectedRow;
	this.getNumOfSelectedRow = getNumOfSelectedRow;
	this.getSelectedIndex = getSelectedIndex;
	// private
	this.addRowWithNewIndex = addRowWithNewIndex;
	this.copyRowContent = copyRowContent;
	
	// Gan su kien cho checkbox dau tien neu la checkbox
	var thisInstance = this;
	firstRow = this.innerTable.rows[0];
	checkBoxSelectAll = firstRow.cells[this.numOfColumn - 1].childNodes[0];
	try{
		checkBoxSelectAll.onclick = function(){
			selectAll(thisInstance);
		}
	}catch(err){
		
	}
	// Gan su kien xoa
	document.getElementById(btnXoaId).onclick = function(){
		thisInstance.deleteSelectedRow();
	}
}

function TableObjectExtra(tableId, isSoTT){	
	// properties 
	this.innerTable = document.getElementById(tableId);
	this.isSoTT = isSoTT;
	this.numOfRow = this.innerTable.rows.length;
	this.numOfCheckedRow = 0;
	this.numOfColumn = this.innerTable.rows[0].cells.length;
	
	// method
	// public
	this.deleteSelectedRow = deleteSelectedRow;
	this.deleteRowByIndex = deleteRowByIndex;
	this.reFormatStyle = reFormatStyle;
	this.reFormatStyleIncludeHeader = reFormatStyleIncludeHeader;
	this.addRow = addRow;
	this.updateRow = updateRow;
	this.selectAllRow = selectAllRow; 
	this.getSelectedRow = getSelectedRow;
	this.getNumOfSelectedRow = getNumOfSelectedRow;
	this.getSelectedIndex = getSelectedIndex;
	// private
	this.addRowWithNewIndex = addRowWithNewIndex;
	this.copyRowContent = copyRowContent;
	
	// Gan su kien cho checkbox dau tien neu la checkbox
	var thisInstance = this;
	firstRow = this.innerTable.rows[0];
	checkBoxSelectAll = firstRow.cells[this.numOfColumn - 1].childNodes[0];
	try{
		checkBoxSelectAll.onclick = function(){
			selectAll(thisInstance);
		}
	}catch(err){
		
	}
	// Gan su kien xoa
	//document.getElementById(btnXoaId).onclick = function(){
	//	thisInstance.deleteSelectedRow();
	//}
}

function getSelectedIndex(){
	var allRows = this.innerTable.rows;
	for(var i = 1; i < allRows.length; i++){
		if(allRows[i].cells[this.numOfColumn - 1].childNodes[0].checked){ 
			return i;
		}	
	}
}
function compareToCurrentYear(control, operation){	
	if(isEmpty(control.value))
		return true;
	if(isEmpty(operation))
		return true;  
	comparedYear = control.value.split('/')[2];
	currentYear = new Date().getFullYear();
	if(parseInt(comparedYear) > parseInt(currentYear) && operation == '>')
		return true;
	else if(parseInt(comparedYear) >= parseInt(currentYear) && operation == '>=')
		return true;
	else if(parseInt(comparedYear) < parseInt(currentYear) && operation == '<')
		return true;
	else if(parseInt(comparedYear) <= parseInt(currentYear) && operation == '<=')
		return true;
	else if(parseInt(comparedYear) == parseInt(currentYear) && operation == '=')
		return true;
	else if(parseInt(comparedYear) == eval(parseInt(currentYear) + 1) && operation == '++')
		return true;
	else if(parseInt(comparedYear) <= eval(parseInt(currentYear) + 1) && operation == '<=++')
		return true;
	return false;
}
function compareToTheYear(control, theYear, operation){	
	if(isEmpty(control.value))
		return true;
	if(isEmpty(theYear))
		return true;
	if(isEmpty(operation))
		return true;  
	comparedYear = control.value.split('/')[2];
	if(parseInt(comparedYear) > parseInt(theYear) && operation == '>')
		return true;
	else if(parseInt(comparedYear) >= parseInt(theYear) && operation == '>=')
		return true;
	else if(parseInt(comparedYear) < parseInt(theYear) && operation == '<')
		return true;
	else if(parseInt(comparedYear) <= parseInt(theYear) && operation == '<=')
		return true;
	else if(parseInt(comparedYear) == parseInt(theYear) && operation == '=')
		return true;
	else if(parseInt(comparedYear) == eval(parseInt(theYear) + 1) && operation == '++')
		return true;	
	$(control).effect('highlight',null,1000);
	return false;
}

function getSelectedRow(){
	var allRows = this.innerTable.rows;
	for(var i = 1; i < allRows.length; i++){
		if(allRows[i].cells[this.numOfColumn - 1].childNodes[0].checked){
			return allRows[i];
			break;
		}	
	}
}
function getNumOfSelectedRow(){
	var iReturn = 0;
	var allRows = this.innerTable.rows;
	for(var i = 1; i < allRows.length; i++){
		if(allRows[i].cells[this.numOfColumn - 1].childNodes[0].checked)
			iReturn++;
	}
	return iReturn;
}
function selectAll(tblObjectInstance){
	allRows = tblObjectInstance.innerTable.rows;
	for(i = 1; i< allRows.length; i++){
		if(!allRows[i].cells[tblObjectInstance.numOfColumn - 1].childNodes[0].disabled)
			allRows[i].cells[tblObjectInstance.numOfColumn - 1].childNodes[0].checked = allRows[0].cells[tblObjectInstance.numOfColumn - 1].childNodes[0].checked;
	}	
	if(allRows[0].cells[tblObjectInstance.numOfColumn - 1].childNodes[0].checked)
		tblObjectInstance.numOfCheckedRow = allRows.length - 1;
	else
		tblObjectInstance.numOfCheckedRow = 0;
	
}
function selectAllRow(){ 
	allRows = this.innerTable.rows;
	for(i = 1; i< allRows.length; i++)
		allRows[i].cells[this.numOfColumn - 1].childNodes[0].checked = allRows[0].cells[this.numOfColumn - 1].childNodes[0].checked;
	if(allRows[0].cells[this.numOfColumn - 1].childNodes[0].checked)
		this.numOfCheckedRow = allRows.length - 1;
	else
		this.numOfCheckedRow = 0;
}
function reFormatStyleIncludeHeader(){
	for(var iRowIndex = 0; iRowIndex < this.numOfRow; iRowIndex++){
		// Chinh lai style
		if(iRowIndex%2 == 0)
			this.innerTable.rows[iRowIndex].className  = 'row1';
		else
			this.innerTable.rows[iRowIndex].className  = 'row2'; 
							
		// Chinh lai cot STT neu co
		if(this.isSoTT)
			this.innerTable.rows[iRowIndex].cells[0].innerHTML = iRowIndex + 1;
		
	}
}
function reNameControl(controlToRename, newIndex){
	controlName = controlToRename.name;
	if(!isEmpty(controlName)){
		if(controlName.indexOf("]") > 0 && controlName.indexOf("[") > 0){
			newName = controlName.split("[")[0] + "[" + newIndex + "]" + controlName.split("]")[1];
			controlToRename.name = newName;
		}
	}	
	
}
function reFormatStyle(){
	// Chinh lai style, so thu tu, ten cac control trong grid
	for(i = 1; i < this.numOfRow; i++){
		// Chinh lai style
		if(i%2 == 1)
			this.innerTable.rows[i].className  = 'row1';
		else
			this.innerTable.rows[i].className  = 'row2'; 
							
		// Chinh lai cot STT neu co
		if(this.isSoTT)
			this.innerTable.rows[i].cells[0].innerHTML = i;
		// Doi Ten cac control theo chi so
		selectedRow = this.innerTable.rows[i];
		for(iCellIndex = 0; iCellIndex < this.numOfColumn; iCellIndex++){
			selectedCell = selectedRow.cells[iCellIndex];
			controlInCell = selectedCell.childNodes;
			for(iControlIndex = 0; iControlIndex < controlInCell.length; iControlIndex++){
				try{
					controlName = controlInCell[iControlIndex].name;
					if(controlName.indexOf("]") > 0 && controlName.indexOf("[") > 0){
						newIndex = i-1;
						newName = controlName.split("[")[0] + "[" + newIndex + "]" + controlName.split("]")[1];
						controlInCell[iControlIndex].name = newName;
					}
				}
				catch(err){
				}
				
			}
		} 
	}
}
function deleteRowByIndex(indexOfDeleteRow){	
	this.innerTable.deleteRow(indexOfDeleteRow);
	this.numOfRow --;	
}
function copyRowContent(row){
	rowDescription = new Array();
	var firstIndex = this.isSoTT?1:0;
	for(var iCellIndex = firstIndex; iCellIndex< this.numOfColumn; iCellIndex++)
		rowDescription.push(row.cells[iCellIndex].innerHTML);
	return rowDescription;
}
function getIndex(rowContent){
	for(var i = 0; i < rowContent.length; i++)
		if(rowContent[i].indexOf('[') >0 && rowContent[i].indexOf(']') >0)
			return rowContent[i].split('[')[1].split(']')[0];
}
function addRowWithNewIndex(rowDescription, rowIndex){
	insertedRow = this.innerTable.insertRow(-1);			
	// Lay chi so cu
	var oldIndex = getIndex(rowDescription);
	if(!this.isSoTT){
		for(var i = 0; i< rowDescription.length; i++){			
			// Thay [chi so cu] thanh [chi so moi]
			var strTemp = replaceAll(rowDescription[i],'['+ oldIndex + ']','[' + rowIndex + ']');
			// Thay (chi so cu) thanh (chi so moi)
			strTemp = replaceAll(strTemp,'('+oldIndex + ')','(' + rowIndex + ')');
			insertedRow.insertCell(i).innerHTML = strTemp;
		}
	}else{
		insertedRow.insertCell(0).innerHTML = this.numOfRow;
		for(var i = 0; i< rowDescription.length; i++){			
			// Thay [chi so cu] thanh [chi so moi]
			var strTemp = replaceAll(rowDescription[i],'['+ oldIndex + ']','[' + rowIndex + ']');
			// Thay (chi so cu) thanh (chi so moi)
			strTemp = replaceAll(strTemp,'('+oldIndex + ')','(' + rowIndex + ')');
			insertedRow.insertCell(i+1).innerHTML = strTemp;
		}
		// Can le cot so thu tu
		insertedRow.cells[0].align = "center";
	}		
	this.numOfRow++;
	// Can le cot check box.
	insertedRow.cells[this.numOfColumn - 1].align = "center";	
		
	
}
function deleteSelectedRow(){	
	// Cache cac dong khong duoc chon
	tableRows = this.innerTable.rows;
	arrTemp = new Array();// Mang chua rowdescription cua cac dong khong duoc chon
	for(i = 1; i< tableRows.length; i++){
		checkBox = tableRows[i].cells[this.numOfColumn - 1].childNodes[0];
		if(!checkBox.checked)
			arrTemp.push(this.copyRowContent(tableRows[i]));
	}
	if(arrTemp.length == this.numOfRow - 1){
		alert('B\u1EA1n ch\u01B0a ch\u1ECDn b\u1EA3n ghi n\u00E0o!');
		return;
	}
	// Xoa tat ca cac dong cua bang
	while(true){
		try{
			this.innerTable.deleteRow(1);
		}catch(err){
			break;
		}
	}
	this.numOfRow = 1;
	// Insert toan bo cac dong vua duoc cache
	for(i = 0; i< arrTemp.length; i++){
		this.addRowWithNewIndex(arrTemp[i], i);
	}
	// Gan lai gia tri cac thuoc tinh cua object
	this.numOfCheckedRow = 0;
	
	// formate lai style
	for(i = 1; i < this.innerTable.rows.length; i++){
		// Chinh lai style
		if(i%2 == 1)
			this.innerTable.rows[i].className  = 'row1';
		else
			this.innerTable.rows[i].className  = 'row2';
	} 
}
function updateRow(rowDescription){
	var selectedRow = this.getSelectedRow();
	if(selectedRow == null){
		alert('B\u1EA1n ch\u01B0a ch\u1ECDn d\u00F2ng n\u00E0o!');
		return;
	}
	if(!this.isSoTT)
		for(i = 0; i< rowDescription.length; i++)
			selectedRow.cells[i].innerHTML = rowDescription[i];
	else{
		stt = this.numOfRow - 1;
		selectedRow.cells[0].innerHTML = stt;
		for(i = 0; i< rowDescription.length; i++)
			selectedRow.cells[i+1].innerHTML = rowDescription[i];
	}
	
}
function addRow(rowDescription, rowindex){	
	this.numOfRow++;
	if(rowindex){
		insertedRow = this.innerTable.insertRow(rowindex);
	}	
	else{
				
		insertedRow = this.innerTable.insertRow(-1);	
		if(this.numOfRow%2 == 0) 
			insertedRow.className = 'row1' 
		else 
			insertedRow.className = 'row2'
	}	
	if(!this.isSoTT)
		for(i = 0; i< rowDescription.length; i++)
			insertedRow.insertCell(i).innerHTML = rowDescription[i];
	else{
		stt = this.numOfRow - 1;
		insertedRow.insertCell(0).innerHTML = stt;
		for(i = 0; i< rowDescription.length; i++)
			insertedRow.insertCell(i+1).innerHTML = rowDescription[i];
	}
	// Can le cot so thu tu va check box.
	insertedRow.cells[this.numOfColumn - 1].align = "center";	
	if(this.isSoTT)
		insertedRow.cells[0].align = "center";		
	
	
}
function selectThisRow(rowCheckBox, tableObjectInstance){
	if(rowCheckBox.checked){
		tableObjectInstance.numOfCheckedRow++;
		if(tableObjectInstance.numOfCheckedRow == tableObjectInstance.numOfRow-1)
			tableObjectInstance.innerTable.rows[0].cells[tableObjectInstance.numOfColumn - 1].childNodes[0].checked = true;
	}	
	else{
		tableObjectInstance.numOfCheckedRow--;
		if(tableObjectInstance.numOfCheckedRow == 0)
			tableObjectInstance.innerTable.rows[0].cells[tableObjectInstance.numOfColumn - 1].childNodes[0].checked = false;
	}
		
}
function inBienBan(url){
	var xmlHttpReq = false;
    if (window.XMLHttpRequest) {
        xmlHttpReq = new XMLHttpRequest(); 
    }
    else if (window.ActiveXObject) {
        xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
    } 
    xmlHttpReq.open('POST', url, true); 
    xmlHttpReq.setRequestHeader("Content-type","application/x-www-form-urlencoded; charset=utf-8");    
    xmlHttpReq.send();
} 
var numOfTab = 0;
var numOfLevel1Tab = 0;
var	numOfLevel2Tab = 0;
var changeTabAfterSave = true;
function findForm(formAction){ 
	for(i = 0; i< document.forms.length; i++){
		if(document.forms[i].action == formAction)
			return document.forms[i];
	}
	return null;
} 
function xmlhttpPost(url) {
    var xmlHttpReq = false;
    var self = this;
    // Xhr per Mozilla/Safari/Ie7
    if (window.XMLHttpRequest) {
        self.xmlHttpReq = new XMLHttpRequest(); 
    }
    // per tutte le altre versioni di IE 
    else if (window.ActiveXObject) {
        self.xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
    } 
    self.xmlHttpReq.open('POST', url, true); 
    self.xmlHttpReq.setRequestHeader("Content-type","application/x-www-form-urlencoded; charset=utf-8");
    self.xmlHttpReq.onreadystatechange = function() {
    	if (self.xmlHttpReq.readyState==4 && self.xmlHttpReq.status==200){
			var saveStatus = self.xmlHttpReq.responseText;
		  	if(isEmpty(saveStatus) || saveStatus.indexOf('cucsess') >= 0 || saveStatus.indexOf('returnId') >= 0){		  		
		  		alert('L\u01B0u th\u00E0nh c\u00F4ng');
		  			
		  		if(saveStatus.indexOf('returnId') >= 0){
		  			saveStatus = saveStatus.split(':')[1];
		  		}
				try{					
					xuLySaveThanhCongCuaTungForm(saveStatus);				
				}catch(err){}
				if(changeTabAfterSave){					
					// Chuyen tab
					try{
						if(isLevel2TabActive){
							if(level2ActiveTab < numOfLevel2Tab - 1){
								level2ActiveTab++;
								var tempTab={selected:level2ActiveTab,select:function(event,level2Tab){jQuery.fn.createCookie(getTab1IndexInCookKie(),level2Tab.index); setLevel2ActiveTab(level2Tab.index)}};                  
			  					$("#level2Tab").tabs(tempTab); 	  					
							}else{
								if(level1ActiveTab < numOfLevel1Tab - 1){
									level1ActiveTab++;
									var tempTab={selected:level1ActiveTab,select:function(event,level1Tab){jQuery.fn.createCookie(getTab2IndexInCookKie(),level1Tab.index); setLevel1ActiveTab(level1Tab.index)}};                
			  						$("#level1Tab").tabs(tempTab); 
								}
							} 
						}else{
							if(level1ActiveTab < numOfLevel1Tab - 1){
								level1ActiveTab++;
								var tempTab={selected:level1ActiveTab,select:function(event,level1Tab){jQuery.fn.createCookie(getTab1IndexInCookKie(),level1Tab.index); setLevel1ActiveTab(level1Tab.index)}};                
			  					$("#level1Tab").tabs(tempTab); 
							}
						}
						}catch(err){
							if(activeTab < numOfTab - 1)
								activeTab++;
							var tabOpts={selected:activeTab,select:function(event,tab){jQuery.fn.createCookie(getTabIndexInCookKie(), tab.index); setActiveTab(tab.index);}};
							$("#tab").tabs(tabOpts);
						}	
						
					}else{
						changeTabAfterSave = true;
					}
					
						
			}else{
				try{
					xuLySaveKhongThanhCongCuaTungForm(saveStatus);	
				}catch(err){
					
				}
			}	
		}    	
    }
    self.xmlHttpReq.send(createSubmitString());
}



// ntdung submit form dung Ajax.

/* Simple AJAX Code-Kit (SACK) v1.6.1 */
/* ©2005 Gregory Wild-Smith */
/* www.twilightuniverse.com */
/* Software licenced under a modified X11 licence,
   see documentation or authors website for more details */

function sack(file) {
	this.xmlhttp = null;

	this.resetData = function() {
		this.method = "POST";
  		this.queryStringSeparator = "?";
		this.argumentSeparator = "&";
		this.URLString = "";
		this.encodeURIString = true;
  		this.execute = false;
  		this.element = null;
		this.elementObj = null;
		this.requestFile = file;
		this.vars = new Object();
		this.responseStatus = new Array(2);
  	};

	this.resetFunctions = function() { 
  		this.onLoading = function() { };
  		this.onLoaded = function() { };
  		this.onInteractive = function() { };
  		this.onCompletion = function() {};
  		this.onError = function() {};
		this.onFail = function() {};
	};

	this.reset = function() {
		this.resetFunctions();
		this.resetData();
	};

	this.createAJAX = function() {
		try {
			this.xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e1) {
			try {
				this.xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e2) {
				this.xmlhttp = null;
			}
		}

		if (! this.xmlhttp) {
			if (typeof XMLHttpRequest != "undefined") {
				this.xmlhttp = new XMLHttpRequest();
			} else {
				this.failed = true;
			}
		}
	};

	this.setVar = function(name, value){
		this.vars[name] = Array(value, false);
	};

	this.encVar = function(name, value, returnvars) {
		if (true == returnvars) {
			return Array(encodeURIComponent(name), encodeURIComponent(value));
		} else {
			this.vars[encodeURIComponent(name)] = Array(encodeURIComponent(value), true);
		}
	}

	this.processURLString = function(string, encode) {
		encoded = encodeURIComponent(this.argumentSeparator);
		regexp = new RegExp(this.argumentSeparator + "|" + encoded);
		varArray = string.split(regexp);
		for (i = 0; i < varArray.length; i++){
			urlVars = varArray[i].split("=");
			if (true == encode){
				this.encVar(urlVars[0], urlVars[1]);
			} else {
				this.setVar(urlVars[0], urlVars[1]);
			}
		}
	}

	this.createURLString = function(urlstring) {
		if (this.encodeURIString && this.URLString.length) {
			this.processURLString(this.URLString, true);
		}

		if (urlstring) {
			if (this.URLString.length) {
				this.URLString += this.argumentSeparator + urlstring;
			} else {
				this.URLString = urlstring;
			}
		}

		// prevents caching of URLString
		this.setVar("rndval", new Date().getTime());

		urlstringtemp = new Array();
		for (key in this.vars) {
			if (false == this.vars[key][1] && true == this.encodeURIString) {
				encoded = this.encVar(key, this.vars[key][0], true);
				delete this.vars[key];
				this.vars[encoded[0]] = Array(encoded[1], true);
				key = encoded[0];
			}

			urlstringtemp[urlstringtemp.length] = key + "=" + this.vars[key][0];
		}
		if (urlstring){
			this.URLString += this.argumentSeparator + urlstringtemp.join(this.argumentSeparator);
		} else {
			this.URLString += urlstringtemp.join(this.argumentSeparator);
		}
	}

	this.runResponse = function() {
		eval(this.response);
	}

	this.runAJAX = function(urlstring) {
		if (this.failed) {
			this.onFail();
		} else {
			this.createURLString(urlstring);
			if (this.element) {
				this.elementObj = document.getElementById(this.element);
			}
			if (this.xmlhttp) {
				var self = this;
				if (this.method == "GET") {
					totalurlstring = this.requestFile + this.queryStringSeparator + this.URLString;
					this.xmlhttp.open(this.method, totalurlstring, true);
				} else { 
					this.xmlhttp.open(this.method, this.requestFile, true);
					try {
						this.xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
					} catch (e) { }
				}

				this.xmlhttp.onreadystatechange = function() {
					switch (self.xmlhttp.readyState) {
						case 1:
							self.onLoading();
							break;
						case 2:
							self.onLoaded();
							break;
						case 3:
							self.onInteractive();
							break;
						case 4:
							self.response = self.xmlhttp.responseText;
							
							self.responseXML = self.xmlhttp.responseXML;
							self.responseStatus[0] = self.xmlhttp.status;
							self.responseStatus[1] = self.xmlhttp.statusText;

							if (self.execute) {
								self.runResponse();
								
							}

							if (self.elementObj) {
								elemNodeName = self.elementObj.nodeName;
								elemNodeName = elemNodeName.toLowerCase();
								if (elemNodeName == "input"
								|| elemNodeName == "select"
								|| elemNodeName == "option"
								|| elemNodeName == "textarea") {
									self.elementObj.value = self.response;
								} else {
									self.elementObj.innerHTML = self.response;
								}
							}
							if (self.responseStatus[0] == "200") {
								self.onCompletion();
							} else {
								self.onError();
							}
							/* These lines were added by Alf Magne Kalleland ref. info on the sack home page. It prevents memory leakage in IE */
							self.URLString = "";
							delete self.xmlhttp['onreadystatechange'];
							self.xmlhttp=null;
							self.responseStatus=null;
							self.response=null;
							self.responseXML=null;
							
							break;
					}
				};

				this.xmlhttp.send(this.URLString);
			}
		}
	};

	this.reset();
	this.createAJAX();
}



/************************************************************************************************************
Ajax form submit
Copyright (C) 2007  DTHMLGoodies.com, Alf Magne Kalleland

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA

Dhtmlgoodies.com., hereby disclaims all copyright interest in this script
written by Alf Magne Kalleland.

Alf Magne Kalleland, 2007
Owner of DHTMLgoodies.com


************************************************************************************************************/	

var DHTMLSuite = new Object();

DHTMLSuite.formUtil = function()
{
	
	
	
}

DHTMLSuite.getEl = function(elRef){
	if(typeof elRef=='string'){
		if(document.getElementById(elRef))return document.getElementById(elRef);
		if(document.forms[elRef])return document.forms[elRef];
		if(document[elRef])return document[elRef];
		if(window[elRef])return window[elRef];
	}
	return elRef;	// Return original ref.
	
}
	
DHTMLSuite.formUtil.prototype = 
{
	// {{{ getFamily
    /**
     *	Return an array of elements with the same name
     *	@param Object el - Reference to form element
     *	@param Object formRef - Reference to form
     *
     * @public
     */		
	getFamily : function(el,formRef)
	{
		var els = formRef.elements;
		var retArray = new Array();
		for(var no=0;no<els.length;no++){
			if(els[no].name == el.name)retArray[retArray.length] = els[no];
		}
		return retArray;		
	}
	// }}}
	
	,
	// {{{ hasFileInputs()
    /**
     *	Does the form has file inputs?
     *	@param Object formRef - Reference to form
     *
     * @public
     */		
	hasFileInputs : function(formRef)
	{	
		var els = formRef.elements;
			for(var no=0;no<els.length;no++){
				if(els[no].tagName.toLowerCase()=='input' && els[no].type.toLowerCase()=='file')return true;	
			}
			return false;
		
		
	}
	// }}}
	,	
	// {{{ getValuesAsArray()
    /**
     *	Return value of form as associative array
     *	@param Object formRef - Reference to form
     *
     * @public
     */		
	getValuesAsArray : function(formRef)
	{
		var retArray = new Object();
		formRef = DHTMLSuite.getEl(formRef);
		var els = formRef.elements;
		for(var no=0;no<els.length;no++){
			if(els[no].disabled)continue;
			var tag = els[no].tagName.toLowerCase();
			switch(tag){
				case "input": 
					var type = els[no].type.toLowerCase();
					if(!type)type='text';
					switch(type){
						case "text":
						case "image":
						case "hidden":
						case "password":
							retArray[els[no].name] = els[no].value;
							break;
						case "checkbox":
							var boxes = this.getFamily(els[no],formRef);
							if(boxes.length>1){
								retArray[els[no].name] = new Array();
								for(var no2=0;no2<boxes.length;no2++){
									if(boxes[no2].checked){
										var index = retArray[els[no].name].length;
										retArray[els[no].name][index] = boxes[no2].value;
									}
								}								
							}else{
								if(els[no].checked)retArray[els[no].name] = els[no].value;
							}
							break;	
						case "radio":
							if(els[no].checked)retArray[els[no].name] = els[no].value;
							break;		
						
					}	
					break;	
				case "select":
					var string = '';			
					var mult = els[no].getAttribute('multiple');
					if(mult || mult===''){
						retArray[els[no].name] = new Array();
						for(var no2=0;no2<els[no].options.length;no2++){
							var index = retArray[els[no].name].length;
							if(els[no].options[no2].selected)retArray[els[no].name][index] = els[no].options[no2].value;	
						}
					}else{
						retArray[els[no].name] = els[no].options[els[no].selectedIndex].value;
					}
					break;	
				case "textarea":
					retArray[els[no].name] = els[no].value;
					break;					
			}			
		}
		return retArray;		
	}
	// }}}
	,	
	// {{{ getValue()
    /**
     *	Return value of form element
     *	@param Object formEl - Reference to form element
     *
     * @public
     */
	getValue : function(formEl)
	{
		switch(formEl.tagName.toLowerCase()){
			case "input":
			case "textarea": return formEl.value;
			case "select": return formEl.options[formEl.selectedIndex].value;			
		}
		
	}
	// }}}
	,	
	// {{{ areEqual()
    /**
     *	Check if two form elements have the same value
     *	@param Object input1 - Reference to form element
     *	@param Object input2 - Reference to form element
     *
     * @public
     */	
	areEqual : function(input1,input2)
	{
		input1 = DHTMLSuite.getEl(input1);
		input2 = DHTMLSuite.getEl(input2);	
		if(this.getValue(input1)==this.getValue(input2))return true;
		return false;		
	}	
}
	
/************************************************************************************************************
*	Form submission class
*
*	Created:						March, 6th, 2007
*	@class Purpose of class:		Ajax form submission class
*			
*	Css files used by this script:	form.css
*
*	Demos of this class:			demo-form-validator.html
*
* 	Update log:
*
************************************************************************************************************/


/**
* @constructor
* @class Form submission
* Demo: <a href="../../demos/demo-form-validator.html" target="_blank">demo-form-validator.html</a>		
*
* @param Associative array of properties, possible keys: <br>
*	formRef - Reference to form<br>
*	method - How to send the form, "GET" or "POST", default is "POST"
*	reponseEl - Where to display response from ajax
*	action - Where to send form data
*	responseFile - Alternative response file. This will be loaded dynamically once the script receives response from the file specified in "action".
*		
* @version				1.0
* @version 1.0
* @author	Alf Magne Kalleland(www.dhtmlgoodies.com)
**/

DHTMLSuite.variableStorage = new Object();
DHTMLSuite.variableStorage.arrayDSObjects = new Array();

DHTMLSuite.form = function(propArray)
{
	var formRef; 
	var method;
	var responseEl; 
	var action;
	var responseFile;
	
	var formUtil;
	var objectIndex;
	var sackObj;
	var coverDiv;
	var layoutCSS;
	var iframeName;
	
	this.method = 'POST';
	this.sackObj = new Array();
	this.formUtil = new DHTMLSuite.formUtil();
	this.layoutCSS = 'form.css';
	
	
		
	this.objectIndex = DHTMLSuite.variableStorage.arrayDSObjects.length;
	DHTMLSuite.variableStorage.arrayDSObjects[this.objectIndex] = this;	
		
	
	if(propArray)this.__setInitProperties(propArray);
	
}
DHTMLSuite.form.prototype = 
{
	// {{{ submit()
    /**
     *	Submits the form
     *
     * @public
     */		
	submit : function()
	{
		this.__createCoverDiv();
		var index = this.sackObj.length;
		if(this.formUtil.hasFileInputs(this.formRef)){
			this.__createIframe();
			this.formRef.submit();
			
		}else{
			this.__createSackObject(index);			
			this.__populateSack(index);			
			this.sackObj[index].runAJAX();

		}
		this.__positionCoverDiv();
		return false;
	}
	// }}}
	,
	__createIframe : function()
	{
		if(this.iframeName)return;
		var ind = this.objectIndex;
		var div = document.createElement('DIV');
		document.body.appendChild(div);
		this.iframeName = 'DHTMLSuiteForm' + this.getUniqueId();
		div.innerHTML = '<iframe style="visibility:hidden;width:5px;height:5px" id="' + this.iframeName + '" name="' + this.iframeName + '" onload="parent.DHTMLSuite.variableStorage.arrayDSObjects[' + ind + '].__getIframeResponse()"></iframe>'; 
		
		this.formRef.method = this.method;
		this.formRef.action = this.action;
		this.formRef.target = this.iframeName;	
		if(!this.formRef.enctype)this.formRef.enctype = 'multipart/form-data';		
	}
	,
	// {{{ getUniqueId()
    /**
     *
     *  Returns a unique numeric id
     *
     *
     * 
     * @public
     */		
	getUniqueId : function()
	{
		var no = Math.random() + '';
		no = no.replace('.','');		
		var no2 = Math.random() + '';
		no2 = no2.replace('.','');		
		return no + no2;		
	}	 
	// }}}
	,
	// {{{ __getIframeResponse()
    /**
     *	Form has been submitted to iframe - move content from iframe
     *
     * @private 
     */	
	__getIframeResponse : function()
	{  
		if(this.responseEl){		
			if(this.responseFile){
				if(!this.responseEl.id)this.responseEl.id = 'DHTMLSuite_formResponse' + DHTMLSuite.getUniqueId();
				var dynContent = new DHTMLSuite.dynamicContent();
				dynContent.loadContent(this.responseEl.id,this.responseFile);				
			}else{		   
				this.responseEl.innerHTML = self.frames[this.iframeName].document.body.innerHTML;
				this.__evaluateJs(this.responseEl);
				this.__evaluateCss(this.responseEl);	
			}						
		}	
		if(isEmpty(this.responseEl.innerHTML) || this.responseEl.innerHTML == 'cucsess'){
			alert('L\u01B0u th\u00E0nh c\u00F4ng');		
			try{
				xuLySaveThanhCongCuaTungForm();				
			}catch(err121){
			}	
			try{				
				if(isLevel2TabActive){
					if(level2ActiveTab < numOfLevel2Tab - 1){
						level2ActiveTab++;
						var tempTab={selected:level2ActiveTab,select:function(event,level2Tab){jQuery.fn.createCookie(getTab1IndexInCookKie(),level2Tab.index); setLevel2ActiveTab(level2Tab.index)}};                  
	  					$("#level2Tab").tabs(tempTab); 	  					
					}else{
						if(level1ActiveTab < numOfLevel1Tab - 1){
							level1ActiveTab++;
							var tempTab={selected:level1ActiveTab,select:function(event,level1Tab){jQuery.fn.createCookie(getTab2IndexInCookKie(),level1Tab.index); setLevel1ActiveTab(level1Tab.index)}};                
	  						$("#level1Tab").tabs(tempTab);
						}	 
					}
				}else{
					if(level1ActiveTab < numOfLevel1Tab - 1){
						level1ActiveTab++;
						var tempTab={selected:level1ActiveTab,select:function(event,level1Tab){jQuery.fn.createCookie(getTab1IndexInCookKie(),level1Tab.index); setLevel1ActiveTab(level1Tab.index)}};                
	  					$("#level1Tab").tabs(tempTab); 
					}
				}
			}catch(err){
				if(activeTab < numOfTab - 1)
				activeTab++;
				var tabOpts={selected:activeTab,select:function(event,tab){jQuery.fn.createCookie(getTabIndexInCookKie(), tab.index); setActiveTab(tab.index);}};
				$("#tab").tabs(tabOpts);
			}
			
			
		}else{
			try{
				xuLySaveKhongThanhCongCuaTungForm(this.responseEl.innerHTML);	
			}catch(err){
				
			}
			
		}
		this.coverDiv.style.display='none';
		this.__handleCallback('onComplete');
		
	}
	// }}}
	,
	// {{{ __positionCoverDiv()
    /**
     *	Position cover div
     *
     * @private
     */	 
	__positionCoverDiv : function()
	{	
		if(!this.responseEl)return;
		try{
			var st = this.coverDiv.style;
			st.left = this.getLeftPos(this.responseEl) + 'px';	
			st.top = this.getTopPos(this.responseEl) + 'px';	
			st.width = this.responseEl.offsetWidth + 'px';	
			st.height = this.responseEl.offsetHeight + 'px';	
			st.display='block';
		}catch(e){
		}
	}
	// }}}
	,
	// {{{ __createCoverDiv()
    /**
     *	Submits the form
     *
     * @private
     */		
	__createCoverDiv : function()
	{	
		if(this.coverDiv)return;
		this.coverDiv = document.createElement('DIV');
		var el = this.coverDiv;
		el.style.overflow='hidden';
		el.style.zIndex = 1000;
		el.style.position = 'absolute';

		document.body.appendChild(el);
		
		var innerDiv = document.createElement('DIV');
		innerDiv.style.width='105%';
		innerDiv.style.height='105%';
		innerDiv.className = 'DHTMLSuite_formCoverDiv';
		innerDiv.style.opacity = '0.2';
		innerDiv.style.filter = 'alpha(opacity=20)';		
		el.appendChild(innerDiv);
		
		var ajaxLoad = document.createElement('DIV');
		ajaxLoad.className = 'DHTMLSuite_formCoverDiv_ajaxLoader';
		el.appendChild(ajaxLoad);		
	}
	// }}}
	,
	// {{{ __createSackObject()
    /**
     *	Create new sack object
     *
     * @private
     */		
	__createSackObject : function(ajaxIndex)
	{		
		var ind = this.objectIndex;
		this.sackObj[ajaxIndex] = new sack();
		this.sackObj[ajaxIndex].requestFile = this.action;	
		this.sackObj[ajaxIndex].method = this.method;		
		this.sackObj[ajaxIndex].onCompletion = function(){ DHTMLSuite.variableStorage.arrayDSObjects[ind].__getResponse(ajaxIndex); }
	}
	// }}}
	,
	// {{{ __getResponse()
    /**
     *	Get response from ajax
     *
     * @private
     */	
	__getResponse : function(ajaxIndex)
	{

		if(this.responseEl){
	
			if(this.responseFile){

				if(!this.responseEl.id)this.responseEl.id = 'DHTMLSuite_formResponse' + DHTMLSuite.getUniqueId();
				var dynContent = new DHTMLSuite.dynamicContent();
				dynContent.loadContent(this.responseEl.id,this.responseFile);				
			}else{		
				this.responseEl.innerHTML = this.sackObj[ajaxIndex].response;
				this.__evaluateJs(this.responseEl);
				this.__evaluateCss(this.responseEl);	
			}				
		}	
		
		this.coverDiv.style.display='none';
		this.sackObj[ajaxIndex] = null;
		this.__handleCallback('onComplete');
	}
	,
	// {{{ isArray()
    /**
     * Return true if element is an array
     *
     * @param Object el = Reference to HTML element
     * @public
     */		
	isArray : function(el)
	{
		if(el.constructor.toString().indexOf("Array") != -1)return true;
		return false;
	}	
	// }}}
	,
	// {{{ __populateSack()
    /**
     *	Populate sack object with form data
     *	@param ajaxIndex - index of current sack object
     *
     * @private
     */	
	__populateSack : function(ajaxIndex)
	{
		var els = this.formUtil.getValuesAsArray(this.formRef);		
		for(var prop in els){
			if(this.isArray(els[prop])){
				for(var no=0;no<els[prop].length;no++){
					var name = prop + '[' + no + ']';
					if(prop.indexOf('[')>=0){ // The name of the form field is already indicating an array
						name = prop.replace('[','[' + no);	
					}
					this.sackObj[ajaxIndex].setVar(name,els[prop][no]);	
				}
			}else{
				this.sackObj[ajaxIndex].setVar(prop,els[prop]);			
			}			
		}		
	}
	// }}}
	,
	// {{{ __setInitProperties()
    /**
     *	Fill object with data sent to the constructor
     *	@param Array props - Associative Array("Object") of properties
     *
     * @private
     */		
	__setInitProperties : function(props)
	{	
		if(props.formRef)this.formRef = DHTMLSuite.getEl(props.formRef);
		if(props.method)this.method = props.method;
		if(props.responseEl)this.responseEl = DHTMLSuite.getEl(props.responseEl);
		if(props.action)this.action = props.action;
		if(props.responseFile)this.responseFile = props.responseFile;
		if(props.callbackOnComplete)this.callbackOnComplete = props.callbackOnComplete;
		if(!this.action)this.action = this.formRef.action;
		if(!this.method)this.method = this.formRef.method;
	}	
	// }}}
	,
	// {{{ __handleCallback()
    /**
     *	Execute callback
     *	@param String action - Which callback action
     *
     * @private
     */	
	__handleCallback : function(action)
	{
		var callbackString = '';
		switch(action){
			case "onComplete":
				callbackString = this.callbackOnComplete;
				break;	
			
			
		}	
		if(callbackString){
			if(callbackString.indexOf('(')==-1)callbackString = callbackString + '("' + this.formRef.name + '")';
			eval(callbackString);
		}
		
	}
	,	
	// {{{ __evaluateJs()
    /**
     * Evaluate Javascript in the inserted content
     *
     * @private
     */	
	__evaluateJs : function(obj)
	{
		obj = DHTMLSuite.getEl(obj);
		
		var scriptTags = obj.getElementsByTagName('SCRIPT');
		var string = '';
		var jsCode = '';
		for(var no=0;no<scriptTags.length;no++){	
			if(scriptTags[no].src){
		        var head = document.getElementsByTagName("head")[0];
		        var scriptObj = document.createElement("script");
		
		        scriptObj.setAttribute("type", "text/javascript");
		        scriptObj.setAttribute("src", scriptTags[no].src);  	
			}else{
				if(DHTMLSuite.clientInfoObj.isOpera){
					jsCode = jsCode + scriptTags[no].text + '\n';
				}
				else
					jsCode = jsCode + scriptTags[no].innerHTML;	
			}			
		}
		if(jsCode)this.__installScript(jsCode);
	}
	// }}}
	,
	// {{{ __installScript()
    /**
     *  "Installs" the content of a <script> tag.
     *
     * @private        
     */		
	__installScript : function ( script )
	{		
		try{
		    if (!script)
		        return;		
	        if (window.execScript){        	
	        	window.execScript(script)
	        }else if(window.jQuery && jQuery.browser.safari){ // safari detection in jQuery
	            window.setTimeout(script,0);
	        }else{        	
	            window.setTimeout( script, 0 );
	        } 
		}catch(e){
			
		}
	}	
	// }}}
	,
	// {{{ __evaluateCss()
    /**
     *  Evaluates css
     *
     * @private        
     */	
	__evaluateCss : function(obj)
	{
		obj = DHTMLSuite.getEl(obj);
		var cssTags = obj.getElementsByTagName('STYLE');
		var head = document.getElementsByTagName('HEAD')[0];
		for(var no=0;no<cssTags.length;no++){
			head.appendChild(cssTags[no]);
		}	
	}	
	// }}}
	,
	// {{{ getLeftPos()
    /**
     * This method will return the left coordinate(pixel) of an HTML element
     *
     * @param Object el = Reference to HTML element
     * @public
     */	
	getLeftPos : function(el)
	{	 
		/*
		if(el.getBoundingClientRect){ // IE
			var box = el.getBoundingClientRect();	
			return (box.left/1 + Math.max(document.body.scrollLeft,document.documentElement.scrollLeft));
		}
		*/
		if(document.getBoxObjectFor){
			if(el.tagName!='INPUT' && el.tagName!='SELECT' && el.tagName!='TEXTAREA')return document.getBoxObjectFor(el).x
		}		 
		var returnValue = el.offsetLeft;
		while((el = el.offsetParent) != null){ 
			if(el.tagName!='HTML'){
				returnValue += el.offsetLeft;
				if(document.all)returnValue+=el.clientLeft;
			}
		}
		return returnValue;
	}
	// }}}
	,
	// {{{ getTopPos()
    /**
     * This method will return the top coordinate(pixel) of an HTML element/tag
     *
     * @param Object el = Reference to HTML element
     * @public
     */	
	getTopPos : function(el)
	{	
		/*
		if(el.getBoundingClientRect){	// IE
			var box = el.getBoundingClientRect();	
			return (box.top/1 + Math.max(document.body.scrollTop,document.documentElement.scrollTop));
		}
		*/	
		if(document.getBoxObjectFor){
			if(el.tagName!='INPUT' && el.tagName!='SELECT' && el.tagName!='TEXTAREA')return document.getBoxObjectFor(el).y
		}
		
		var returnValue = el.offsetTop;
		while((el = el.offsetParent) != null){
			if(el.tagName!='HTML'){
				returnValue += (el.offsetTop - el.scrollTop);
				if(document.all)returnValue+=el.clientTop;
			}
		} 
		return returnValue;
	}
}
//Check if object exist
function isExist(objId) {
	if (document.getElementById(objId)) { return true; } 
	else { return false; }
}
// ntdung, read only all field in forms
function readOnlyAllFieldInForm(theForm){
	
	
}

function disableAllField(){
	var allInputFields = document.getElementsByTagName('input') 
	for(i = 0; i< allInputFields.length; i++){		 
		if(allInputFields[i].type.toLowerCase()=='button'){
			if(allInputFields[i].name != 'closetheForm')
				allInputFields[i].disabled = true; 
				
		}else if(allInputFields[i].type.toLowerCase()=='text'){
			allInputFields[i].readOnly = true;
		}else if(allInputFields[i].type.toLowerCase()=='radio'){
			allInputFields[i].disabled = true;
		}else if(allInputFields[i].type.toLowerCase()=='checkbox'){
			allInputFields[i].disabled = true;
		}
	}
	allSelect = document.getElementsByTagName('select');
	for(i = 0; i< allSelect.length; i++)
		allSelect[i].disabled = true;
		
	allTextArea = document.getElementsByTagName('TEXTAREA')
	for(i = 0; i< allTextArea.length; i++)
		allTextArea[i].readOnly = true;
}


function fnGetSelected( oTableLocal )
{
	var aReturn = new Array();
	var aTrs = oTableLocal.fnGetNodes();
	
	for ( var i=0 ; i<aTrs.length ; i++ )
	{
		if ( $(aTrs[i]).hasClass('row_selected') )
		{
			aReturn.push( aTrs[i] );
		}
	}
	return aReturn;
}
//Get checked value of radio
function getCheckedValue(radioObj) {
	if(!radioObj)
		return "";
	var radioLength = radioObj.length;
	if(radioLength == undefined)
		if(radioObj.checked)
			return radioObj.value;
		else
			return "";
	for(var i = 0; i < radioLength; i++) {
		if(radioObj[i].checked) {
			return radioObj[i].value;
		}
	}
	return "";
}
function redirectNoId(link){
	window.location.href = link;
}
function redirect(link){
	var id = getParam('id');
	//alert (id);
	if(id==null){
		id = document.getElementsByName("maHoSo").value;		
		if(id==null){
			alert ('Ho so khong ton tai!');
		}
		else{
			link = link+id;
		}
	}else{
		link = link+id;
	}
	var r = getParam('r');
	if(r=='rol'){
		link = link +'&r=rol';
	}
	window.location.href = link;
}
function getParam(name){
   if(name=(new RegExp('[?&]'+encodeURIComponent(name)+'=([^&]*)')).exec(location.search))
      return decodeURIComponent(name[1]);
}
function isYear(ctrName) {
	var ctr = eval(ctrName);
	var year = ctr.value;
    var text = /^[0-9]+$/;
    if (year.value != 0) {
        if ((year != "") && (!text.test(year))) {

            alert("Nh\u1EADp n\u0103m sinh");
            $(ctr).effect('highlight',null,1000).focus().select();
            return false;
        }

        if (year.length != 4) {
            alert("N\u0103m kh\u00F4ng h\u1EE3p l\u1EC7!");
            $(ctr).effect('highlight',null,1000).focus().select();
            return false;
        }
        var current_year=new Date().getFullYear();
        if((year < 1920) || (year > current_year))
            {
            alert("N\u0103m t\u1EEB 1920 \u0111\u1EBFn nay!");
            $(ctr).effect('highlight',null,1000).focus().select();
            return false;
            }
        return true;
    }
}

(function() {
  // Private array of chars to use
  var CHARS = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');

  Math.uuid = function (len, radix) {
    var chars = CHARS, uuid = [], i;
    radix = radix || chars.length;

    if (len) {
      // Compact form
      for (i = 0; i < len; i++) uuid[i] = chars[0 | Math.random()*radix];
    } else {
      // rfc4122, version 4 form
      var r;

      // rfc4122 requires these characters
      uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
      uuid[14] = '4';

      // Fill in random data.  At i==19 set the high bits of clock sequence as
      // per rfc4122, sec. 4.1.5
      for (i = 0; i < 36; i++) {
        if (!uuid[i]) {
          r = 0 | Math.random()*16;
          uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
        }
      }
    }

    return uuid.join('');
  };

  // A more performant, but slightly bulkier, RFC4122v4 solution.  We boost performance
  // by minimizing calls to random()
  Math.uuidFast = function() {
    var chars = CHARS, uuid = new Array(36), rnd=0, r;
    for (var i = 0; i < 36; i++) {
      if (i==8 || i==13 ||  i==18 || i==23) {
        uuid[i] = '-';
      } else if (i==14) {
        uuid[i] = '4';
      } else {
        if (rnd <= 0x02) rnd = 0x2000000 + (Math.random()*0x1000000)|0;
        r = rnd & 0xf;
        rnd = rnd >> 4;
        uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
      }
    }
    return uuid.join('');
  };

  // A more compact, but less performant, RFC4122v4 solution:
  Math.uuidCompact = function() {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
      var r = Math.random()*16|0, v = c == 'x' ? r : (r&0x3|0x8);
      return v.toString(16);
    });
  };
})();