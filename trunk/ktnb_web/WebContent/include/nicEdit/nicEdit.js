var bkExtend=function(){var a=arguments;if(a.length==1){a=[this,a[0]]}for(var b in a[1]){a[0][b]=a[1][b]}return a[0]};function bkClass(){}bkClass.prototype.construct=function(){};bkClass.extend=function(b){var a=function(){if(arguments[0]!==bkClass){return this.construct.apply(this,arguments)}};var c=new this(bkClass);bkExtend(c,b);a.prototype=c;a.extend=this.extend;return a};var bkElement=bkClass.extend({construct:function(b,a){if(typeof(b)=="string"){b=(a||document).createElement(b)}b=$BK(b);return b},appendTo:function(a){a.appendChild(this);return this},appendBefore:function(a){a.parentNode.insertBefore(this,a);return this},addEvent:function(b,a){bkLib.addEvent(this,b,a);return this},setContent:function(a){this.innerHTML=a;return this},pos:function(){var b=curtop=0;var c=obj=this;if(obj.offsetParent){do{b+=obj.offsetLeft;curtop+=obj.offsetTop}while(obj=obj.offsetParent)}var a=(!window.opera)?parseInt(this.getStyle("border-width")||this.style.border)||0:0;return[b+a,curtop+a+this.offsetHeight]},noSelect:function(){bkLib.noSelect(this);return this},parentTag:function(a){var b=this;do{if(b&&b.nodeName&&b.nodeName.toUpperCase()==a){return b}b=b.parentNode}while(b);return false},hasClass:function(a){return this.className.match(new RegExp("(\\s|^)nicEdit-"+a+"(\\s|$)"))},addClass:function(a){if(!this.hasClass(a)){this.className+=" nicEdit-"+a}return this},removeClass:function(a){if(this.hasClass(a)){this.className=this.className.replace(new RegExp("(\\s|^)nicEdit-"+a+"(\\s|$)")," ")}return this},setStyle:function(a){var c=this.style;for(var b in a){switch(b){case"float":c.cssFloat=c.styleFloat=a[b];break;case"opacity":c.opacity=a[b];c.filter="alpha(opacity="+Math.round(a[b]*100)+")";break;case"className":this.className=a[b];break;default:c[b]=a[b]}}return this},getStyle:function(a,b){var c=(!b)?document.defaultView:b;if(this.nodeType==1){return(c&&c.getComputedStyle)?c.getComputedStyle(this,null).getPropertyValue(a):this.currentStyle[bkLib.camelize(a)]}},remove:function(){this.parentNode.removeChild(this);return this},setAttributes:function(a){for(var b in a){this[b]=a[b]}return this}});var bkLib={isMSIE:(navigator.appVersion.indexOf("MSIE")!=-1),addEvent:function(b,c,a){(b.addEventListener)?b.addEventListener(c,a,false):b.attachEvent("on"+c,a)},toArray:function(b){var c=b.length,a=new Array(c);while(c--){a[c]=b[c]}return a},noSelect:function(b){if(b.setAttribute&&b.nodeName.toLowerCase()!="input"&&b.nodeName.toLowerCase()!="textarea"){b.setAttribute("unselectable","on")}for(var a=0;a<b.childNodes.length;a++){bkLib.noSelect(b.childNodes[a])}},camelize:function(a){return a.replace(/\-(.)/g,function(c,b){return b.toUpperCase()})},inArray:function(a,b){return(bkLib.search(a,b)!=null)},search:function(a,b){for(var c=0;c<a.length;c++){if(a[c]==b){return c}}return null},cancelEvent:function(a){a=a||window.event;if(a.preventDefault&&a.stopPropagation){a.preventDefault();a.stopPropagation()}return false},domLoad:[],domLoaded:function(){if(arguments.callee.done){return}arguments.callee.done=true;for(i=0;i<bkLib.domLoad.length;i++){bkLib.domLoad[i]()}},onDomLoaded:function(a){this.domLoad.push(a);if(document.addEventListener){document.addEventListener("DOMContentLoaded",bkLib.domLoaded,null)}else{if(bkLib.isMSIE){document.write("<style>.nicEdit-main p { margin: 0; }</style><script id=__ie_onload defer "+((location.protocol=="https:")?"src='javascript:void(0)'":"src=//0")+"><\/script>");$BK("__ie_onload").onreadystatechange=function(){if(this.readyState=="complete"){bkLib.domLoaded()}}}}window.onload=bkLib.domLoaded}};function $BK(a){if(typeof(a)=="string"){a=document.getElementById(a)}return(a&&!a.appendTo)?bkExtend(a,bkElement.prototype):a}var bkEvent={addEvent:function(a,b){if(b){this.eventList=this.eventList||{};this.eventList[a]=this.eventList[a]||[];this.eventList[a].push(b)}return this},fireEvent:function(){var a=bkLib.toArray(arguments),b=a.shift();if(this.eventList&&this.eventList[b]){for(var c=0;c<this.eventList[b].length;c++){this.eventList[b][c].apply(this,a)}}}};function __(a){return a}Function.prototype.closure=function(){var a=this,c=bkLib.toArray(arguments),b=c.shift();return function(){if(typeof(bkLib)!="undefined"){return a.apply(b,c.concat(bkLib.toArray(arguments)))}}};Function.prototype.closureListener=function(){var a=this,b=bkLib.toArray(arguments),c=b.shift();return function(d){d=d||window.event;if(d.target){var e=d.target}else{var e=d.srcElement}return a.apply(c,[d,e].concat(b))}};var nicEditorConfig=bkClass.extend({buttons:{bold:{name:__("Click to Bold"),command:"Bold",tags:["B","STRONG"],css:{"font-weight":"bold"},key:"b"},italic:{name:__("Click to Italic"),command:"Italic",tags:["EM","I"],css:{"font-style":"italic"},key:"i"},underline:{name:__("Click to Underline"),command:"Underline",tags:["U"],css:{"text-decoration":"underline"},key:"u"},left:{name:__("Left Align"),command:"justifyleft",noActive:true},center:{name:__("Center Align"),command:"justifycenter",noActive:true},right:{name:__("Right Align"),command:"justifyright",noActive:true},justify:{name:__("Justify Align"),command:"justifyfull",noActive:true},ol:{name:__("Insert Ordered List"),command:"insertorderedlist",tags:["OL"]},ul:{name:__("Insert Unordered List"),command:"insertunorderedlist",tags:["UL"]},subscript:{name:__("Click to Subscript"),command:"subscript",tags:["SUB"]},superscript:{name:__("Click to Superscript"),command:"superscript",tags:["SUP"]},strikethrough:{name:__("Click to Strike Through"),command:"strikeThrough",css:{"text-decoration":"line-through"}},removeformat:{name:__("Remove Formatting"),command:"removeformat",noActive:true},indent:{name:__("Indent Text"),command:"indent",noActive:true},outdent:{name:__("Remove Indent"),command:"outdent",noActive:true},hr:{name:__("Horizontal Rule"),command:"insertHorizontalRule",noActive:true}},iconsPath:"nicEditorIcons.gif",buttonList:["save","bold","italic","underline","left","center","right","justify","ol","ul","fontSize","fontFamily","fontFormat","indent","outdent","image","upload","link","unlink","forecolor","bgcolor"],iconList:{bgcolor:1,forecolor:2,bold:3,center:4,hr:5,indent:6,italic:7,justify:8,left:9,ol:10,outdent:11,removeformat:12,right:13,save:24,strikethrough:15,subscript:16,superscript:17,ul:18,underline:19,image:20,link:21,unlink:22,close:23,arrow:25}});var nicEditors={nicPlugins:[],editors:[],registerPlugin:function(b,a){this.nicPlugins.push({p:b,o:a})},allTextAreas:function(b){var a=document.getElementsByTagName("textarea");for(var c=0;c<a.length;c++){nicEditors.editors.push(new nicEditor(b).panelInstance(a[c]))}return nicEditors.editors},findEditor:function(b){var c=nicEditors.editors;for(var a=0;a<c.length;a++){if(c[a].instanceById(b)){return c[a].instanceById(b)}}}};var nicEditor=bkClass.extend({construct:function(b){this.options=new nicEditorConfig();bkExtend(this.options,b);this.nicInstances=new Array();this.loadedPlugins=new Array();var a=nicEditors.nicPlugins;for(var c=0;c<a.length;c++){this.loadedPlugins.push(new a[c].p(this,a[c].o))}nicEditors.editors.push(this);bkLib.addEvent(document.body,"mousedown",this.selectCheck.closureListener(this))},panelInstance:function(c,b){c=this.checkReplace($BK(c));var a=new bkElement("DIV").setStyle({width:(parseInt(c.getStyle("width"))||c.clientWidth)+"px"}).appendBefore(c);this.setPanel(a);return this.addInstance(c,b)},checkReplace:function(b){var a=nicEditors.findEditor(b);if(a){a.removeInstance(b);a.removePanel()}return b},addInstance:function(c,b){c=this.checkReplace($BK(c));if(c.contentEditable||!!window.opera){var a=new nicEditorInstance(c,b,this)}else{var a=new nicEditorIFrameInstance(c,b,this)}this.nicInstances.push(a);return this},removeInstance:function(b){b=$BK(b);var c=this.nicInstances;for(var a=0;a<c.length;a++){if(c[a].e==b){c[a].remove();this.nicInstances.splice(a,1)}}},removePanel:function(a){if(this.nicPanel){this.nicPanel.remove();this.nicPanel=null}},instanceById:function(b){b=$BK(b);var c=this.nicInstances;for(var a=0;a<c.length;a++){if(c[a].e==b){return c[a]}}},setPanel:function(a){this.nicPanel=new nicEditorPanel($BK(a),this.options,this);this.fireEvent("panel",this.nicPanel);return this},nicCommand:function(b,a){if(this.selectedInstance){this.selectedInstance.nicCommand(b,a)}},getIcon:function(b,a){var c=this.options.iconList[b];var d=(a.iconFiles)?a.iconFiles[b]:"";return{backgroundImage:"url('"+((c)?this.options.iconsPath:d)+"')",backgroundPosition:((c)?((c-1)*-18):0)+"px 0px"}},selectCheck:function(b,a){var c=false;do{if(a.className&&a.className.indexOf("nicEdit")!=-1){return false}}while(a=a.parentNode);this.fireEvent("blur",this.selectedInstance,a);this.lastSelectedInstance=this.selectedInstance;this.selectedInstance=null;return false}});nicEditor=nicEditor.extend(bkEvent);var nicEditorInstance=bkClass.extend({isSelected:false,construct:function(c,f,g){this.ne=g;this.elm=this.e=c;this.options=f||{};newX=parseInt(c.getStyle("width"))||c.clientWidth;newY=parseInt(c.getStyle("height"))||c.clientHeight;this.initialHeight=newY-8;var b=(c.nodeName.toLowerCase()=="textarea");if(b||this.options.hasPanel){var h=(bkLib.isMSIE&&!((typeof document.body.style.maxHeight!="undefined")&&document.compatMode=="CSS1Compat"));var e={width:newX+"px",border:"1px solid #ccc",borderTop:0,overflowY:"auto",overflowX:"hidden"};e[(h)?"height":"maxHeight"]=(this.ne.options.maxHeight)?this.ne.options.maxHeight+"px":null;this.editorContain=new bkElement("DIV").setStyle(e).appendBefore(c);var a=new bkElement("DIV").setStyle({width:(newX-8)+"px",margin:"4px",minHeight:newY+"px"}).addClass("main").appendTo(this.editorContain);c.setStyle({display:"none"});a.innerHTML=c.innerHTML;if(b){a.setContent(c.value);this.copyElm=c;var d=c.parentTag("FORM");if(d){bkLib.addEvent(d,"submit",this.saveContent.closure(this))}}a.setStyle((h)?{height:newY+"px"}:{overflow:"hidden"});this.elm=a}this.ne.addEvent("blur",this.blur.closure(this));this.init();this.blur()},init:function(){this.elm.setAttribute("contentEditable","true");if(this.getContent()==""){this.setContent("<br />")}this.instanceDoc=document.defaultView;this.elm.addEvent("mousedown",this.selected.closureListener(this)).addEvent("keypress",this.keyDown.closureListener(this)).addEvent("focus",this.selected.closure(this)).addEvent("blur",this.blur.closure(this)).addEvent("keyup",this.selected.closure(this));this.ne.fireEvent("add",this)},remove:function(){this.saveContent();if(this.copyElm||this.options.hasPanel){this.editorContain.remove();this.e.setStyle({display:"block"});this.ne.removePanel()}this.disable();this.ne.fireEvent("remove",this)},disable:function(){this.elm.setAttribute("contentEditable","false")},getSel:function(){return(window.getSelection)?window.getSelection():document.selection},getRng:function(){var a=this.getSel();if(!a){return null}return(a.rangeCount>0)?a.getRangeAt(0):a.createRange()},selRng:function(a,b){if(window.getSelection){b.removeAllRanges();b.addRange(a)}else{a.select()}},selElm:function(){var c=this.getRng();if(c.startContainer){var b=c.startContainer;if(c.cloneContents().childNodes.length==1){for(var d=0;d<b.childNodes.length;d++){var a=b.childNodes[d].ownerDocument.createRange();a.selectNode(b.childNodes[d]);if(c.compareBoundaryPoints(Range.START_TO_START,a)!=1&&c.compareBoundaryPoints(Range.END_TO_END,a)!=-1){return $BK(b.childNodes[d])}}}return $BK(b)}else{return $BK((this.getSel().type=="Control")?c.item(0):c.parentElement())}},saveRng:function(){this.savedRange=this.getRng();this.savedSel=this.getSel()},restoreRng:function(){if(this.savedRange){this.selRng(this.savedRange,this.savedSel)}},keyDown:function(b,a){if(b.ctrlKey){this.ne.fireEvent("key",this,b)}},selected:function(b,a){if(!a){a=this.selElm()}if(!b.ctrlKey){var c=this.ne.selectedInstance;if(c!=this){if(c){this.ne.fireEvent("blur",c,a)}this.ne.selectedInstance=this;this.ne.fireEvent("focus",c,a)}this.ne.fireEvent("selected",c,a);this.isFocused=true;this.elm.addClass("selected")}return false},blur:function(){this.isFocused=false;this.elm.removeClass("selected")},saveContent:function(){if(this.copyElm||this.options.hasPanel){this.ne.fireEvent("save",this);(this.copyElm)?this.copyElm.value=this.getContent():this.e.innerHTML=this.getContent()}},getElm:function(){return this.elm},getContent:function(){this.content=this.getElm().innerHTML;this.ne.fireEvent("get",this);return this.content},setContent:function(a){this.content=a;this.ne.fireEvent("set",this);this.elm.innerHTML=this.content},nicCommand:function(b,a){document.execCommand(b,false,a)}});var nicEditorIFrameInstance=nicEditorInstance.extend({savedStyles:[],init:function(){var b=this.elm.innerHTML.replace(/^\s+|\s+$/g,"");this.elm.innerHTML="";(!b)?b="<br />":b;this.initialContent=b;this.elmFrame=new bkElement("iframe").setAttributes({src:"javascript:;",frameBorder:0,allowTransparency:"true",scrolling:"no"}).setStyle({height:"100px",width:"100%"}).addClass("frame").appendTo(this.elm);if(this.copyElm){this.elmFrame.setStyle({width:(this.elm.offsetWidth-4)+"px"})}var a=["font-size","font-family","font-weight","color"];for(itm in a){this.savedStyles[bkLib.camelize(itm)]=this.elm.getStyle(itm)}setTimeout(this.initFrame.closure(this),50)},disable:function(){this.elm.innerHTML=this.getContent()},initFrame:function(){var b=$BK(this.elmFrame.contentWindow.document);b.designMode="on";b.open();var a=this.ne.options.externalCSS;b.write("<html><head>"+((a)?'<link href="'+a+'" rel="stylesheet" type="text/css" />':"")+'</head><body id="nicEditContent" style="margin: 0 !important; background-color: transparent !important;">'+this.initialContent+"</body></html>");b.close();this.frameDoc=b;this.frameWin=$BK(this.elmFrame.contentWindow);this.frameContent=$BK(this.frameWin.document.body).setStyle(this.savedStyles);this.instanceDoc=this.frameWin.document.defaultView;this.heightUpdate();this.frameDoc.addEvent("mousedown",this.selected.closureListener(this)).addEvent("keyup",this.heightUpdate.closureListener(this)).addEvent("keydown",this.keyDown.closureListener(this)).addEvent("keyup",this.selected.closure(this));this.ne.fireEvent("add",this)},getElm:function(){return this.frameContent},setContent:function(a){this.content=a;this.ne.fireEvent("set",this);this.frameContent.innerHTML=this.content;this.heightUpdate()},getSel:function(){return(this.frameWin)?this.frameWin.getSelection():this.frameDoc.selection},heightUpdate:function(){this.elmFrame.style.height=Math.max(this.frameContent.offsetHeight,this.initialHeight)+"px"},nicCommand:function(b,a){this.frameDoc.execCommand(b,false,a);setTimeout(this.heightUpdate.closure(this),100)}});var nicEditorPanel=bkClass.extend({construct:function(b,e,a){this.elm=b;this.options=e;this.ne=a;this.panelButtons=new Array();this.buttonList=bkExtend([],this.ne.options.buttonList);this.panelContain=new bkElement("DIV").setStyle({overflow:"hidden",width:"100%",border:"1px solid #cccccc",backgroundColor:"#efefef"}).addClass("panelContain");this.panelElm=new bkElement("DIV").setStyle({margin:"2px",marginTop:"0px",zoom:1,overflow:"hidden"}).addClass("panel").appendTo(this.panelContain);this.panelContain.appendTo(b);var d=this.ne.options;var c=d.buttons;for(button in c){this.addButton(button,d,true)}this.reorder();b.noSelect()},addButton:function(buttonName,options,noOrder){var button=options.buttons[buttonName];var type=(button.type)?eval("(typeof("+button.type+') == "undefined") ? null : '+button.type+";"):nicEditorButton;var hasButton=bkLib.inArray(this.buttonList,buttonName);if(type&&(hasButton||this.ne.options.fullPanel)){this.panelButtons.push(new type(this.panelElm,buttonName,options,this.ne));if(!hasButton){this.buttonList.push(buttonName)}}},findButton:function(b){for(var a=0;a<this.panelButtons.length;a++){if(this.panelButtons[a].name==b){return this.panelButtons[a]}}},reorder:function(){var b=this.buttonList;for(var c=0;c<b.length;c++){var a=this.findButton(b[c]);if(a){this.panelElm.appendChild(a.margin)}}},remove:function(){this.elm.remove()}});var nicEditorButton=bkClass.extend({construct:function(b,a,c,d){this.options=c.buttons[a];this.name=a;this.ne=d;this.elm=b;this.margin=new bkElement("DIV").setStyle({"float":"left",marginTop:"2px"}).appendTo(b);this.contain=new bkElement("DIV").setStyle({width:"20px",height:"20px"}).addClass("buttonContain").appendTo(this.margin);this.border=new bkElement("DIV").setStyle({backgroundColor:"#efefef",border:"1px solid #efefef"}).appendTo(this.contain);this.button=new bkElement("DIV").setStyle({width:"18px",height:"18px",overflow:"hidden",zoom:1,cursor:"pointer"}).addClass("button").setStyle(this.ne.getIcon(a,c)).appendTo(this.border);this.button.addEvent("mouseover",this.hoverOn.closure(this)).addEvent("mouseout",this.hoverOff.closure(this)).addEvent("mousedown",this.mouseClick.closure(this)).noSelect();if(!window.opera){this.button.onmousedown=this.button.onclick=bkLib.cancelEvent}d.addEvent("selected",this.enable.closure(this)).addEvent("blur",this.disable.closure(this)).addEvent("key",this.key.closure(this));this.disable();this.init()},init:function(){},hide:function(){this.contain.setStyle({display:"none"})},updateState:function(){if(this.isDisabled){this.setBg()}else{if(this.isHover){this.setBg("hover")}else{if(this.isActive){this.setBg("active")}else{this.setBg()}}}},setBg:function(a){switch(a){case"hover":var b={border:"1px solid #666",backgroundColor:"#ddd"};break;case"active":var b={border:"1px solid #666",backgroundColor:"#ccc"};break;default:var b={border:"1px solid #efefef",backgroundColor:"#efefef"}}this.border.setStyle(b).addClass("button-"+a)},checkNodes:function(a){var b=a;do{if(this.options.tags&&bkLib.inArray(this.options.tags,b.nodeName)){this.activate();return true}}while(b=b.parentNode&&b.className!="nicEdit");b=$BK(a);while(b.nodeType==3){b=$BK(b.parentNode)}if(this.options.css){for(itm in this.options.css){if(b.getStyle(itm,this.ne.selectedInstance.instanceDoc)==this.options.css[itm]){this.activate();return true}}}this.deactivate();return false},activate:function(){if(!this.isDisabled){this.isActive=true;this.updateState();this.ne.fireEvent("buttonActivate",this)}},deactivate:function(){this.isActive=false;this.updateState();if(!this.isDisabled){this.ne.fireEvent("buttonDeactivate",this)}},enable:function(a,b){this.isDisabled=false;this.contain.setStyle({opacity:1}).addClass("buttonEnabled");this.updateState();this.checkNodes(b)},disable:function(a,b){this.isDisabled=true;this.contain.setStyle({opacity:0.6}).removeClass("buttonEnabled");this.updateState()},toggleActive:function(){(this.isActive)?this.deactivate():this.activate()},hoverOn:function(){if(!this.isDisabled){this.isHover=true;this.updateState();this.ne.fireEvent("buttonOver",this)}},hoverOff:function(){this.isHover=false;this.updateState();this.ne.fireEvent("buttonOut",this)},mouseClick:function(){if(this.options.command){this.ne.nicCommand(this.options.command,this.options.commandArgs);if(!this.options.noActive){this.toggleActive()}}this.ne.fireEvent("buttonClick",this)},key:function(a,b){if(this.options.key&&b.ctrlKey&&String.fromCharCode(b.keyCode||b.charCode).toLowerCase()==this.options.key){this.mouseClick();if(b.preventDefault){b.preventDefault()}}}});var nicPlugin=bkClass.extend({construct:function(b,a){this.options=a;this.ne=b;this.ne.addEvent("panel",this.loadPanel.closure(this));this.init()},loadPanel:function(b){var c=this.options.buttons;for(var a in c){b.addButton(a,this.options)}b.reorder()},init:function(){}});var nicPaneOptions={};var nicEditorPane=bkClass.extend({construct:function(b,c,d,a){this.ne=c;this.elm=b;this.pos=b.pos();this.contain=new bkElement("div").setStyle({zIndex:"99999",overflow:"hidden",position:"absolute",left:this.pos[0]+"px",top:this.pos[1]+"px"});this.pane=new bkElement("div").setStyle({fontSize:"12px",border:"1px solid #ccc",overflow:"hidden",padding:"4px",textAlign:"left",backgroundColor:"#ffffc9"}).addClass("pane").setStyle(d).appendTo(this.contain);if(a&&!a.options.noClose){this.close=new bkElement("div").setStyle({"float":"right",height:"16px",width:"16px",cursor:"pointer"}).setStyle(this.ne.getIcon("close",nicPaneOptions)).addEvent("mousedown",a.removePane.closure(this)).appendTo(this.pane)}this.contain.noSelect().appendTo(document.body);this.position();this.init()},init:function(){},position:function(){if(this.ne.nicPanel){var c=this.ne.nicPanel.elm;var a=c.pos();var b=a[0]+parseInt(c.getStyle("width"))-(parseInt(this.pane.getStyle("width"))+8);if(b<this.pos[0]){this.contain.setStyle({left:b+"px"})}}},toggle:function(){this.isVisible=!this.isVisible;this.contain.setStyle({display:((this.isVisible)?"block":"none")})},remove:function(){if(this.contain){this.contain.remove();this.contain=null}},append:function(a){a.appendTo(this.pane)},setContent:function(a){this.pane.setContent(a)}});var nicEditorAdvancedButton=nicEditorButton.extend({init:function(){this.ne.addEvent("selected",this.removePane.closure(this)).addEvent("blur",this.removePane.closure(this))},mouseClick:function(){if(!this.isDisabled){if(this.pane&&this.pane.pane){this.removePane()}else{this.pane=new nicEditorPane(this.contain,this.ne,{width:(this.width||"270px"),backgroundColor:"#fff"},this);this.addPane();this.ne.selectedInstance.saveRng()}}},addForm:function(f,b){this.form=new bkElement("form").addEvent("submit",this.submit.closureListener(this));this.pane.append(this.form);this.inputs={};for(itm in f){var e=f[itm];var c="";if(b){c=b.getAttribute(itm)}if(!c){c=e.value||""}var a=f[itm].type;if(a=="title"){new bkElement("div").setContent(e.txt).setStyle({fontSize:"14px",fontWeight:"bold",padding:"0px",margin:"2px 0"}).appendTo(this.form)}else{var g=new bkElement("div").setStyle({overflow:"hidden",clear:"both"}).appendTo(this.form);if(e.txt){new bkElement("label").setAttributes({"for":itm}).setContent(e.txt).setStyle({margin:"2px 4px",fontSize:"13px",width:"50px",lineHeight:"20px",textAlign:"right","float":"left"}).appendTo(g)}switch(a){case"text":this.inputs[itm]=new bkElement("input").setAttributes({id:itm,value:c,type:"text"}).setStyle({margin:"2px 0",fontSize:"13px","float":"left",height:"20px",border:"1px solid #ccc",overflow:"hidden"}).setStyle(e.style).appendTo(g);break;case"select":this.inputs[itm]=new bkElement("select").setAttributes({id:itm}).setStyle({border:"1px solid #ccc","float":"left",margin:"2px 0"}).appendTo(g);for(opt in e.options){var d=new bkElement("option").setAttributes({value:opt,selected:(opt==c)?"selected":""}).setContent(e.options[opt]).appendTo(this.inputs[itm])}break;case"content":this.inputs[itm]=new bkElement("textarea").setAttributes({id:itm}).setStyle({border:"1px solid #ccc","float":"left"}).setStyle(e.style).appendTo(g);this.inputs[itm].value=c}}}new bkElement("input").setAttributes({type:"submit"}).setStyle({backgroundColor:"#efefef",border:"1px solid #ccc",margin:"3px 0","float":"left",clear:"both"}).appendTo(this.form);this.form.onsubmit=bkLib.cancelEvent},submit:function(){},findElm:function(e,a,b){var c=this.ne.selectedInstance.getElm().getElementsByTagName(e);for(var d=0;d<c.length;d++){if(c[d].getAttribute(a)==b){return $BK(c[d])}}},removePane:function(){if(this.pane){this.pane.remove();this.pane=null;this.ne.selectedInstance.restoreRng()}}});var nicButtonTips=bkClass.extend({construct:function(a){this.ne=a;a.addEvent("buttonOver",this.show.closure(this)).addEvent("buttonOut",this.hide.closure(this))},show:function(a){this.timer=setTimeout(this.create.closure(this,a),400)},create:function(a){this.timer=null;if(!this.pane){this.pane=new nicEditorPane(a.button,this.ne,{fontSize:"12px",marginTop:"5px"});this.pane.setContent(a.options.name)}},hide:function(a){if(this.timer){clearTimeout(this.timer)}if(this.pane){this.pane=this.pane.remove()}}});nicEditors.registerPlugin(nicButtonTips);var nicSelectOptions={buttons:{fontSize:{name:__("Select Font Size"),type:"nicEditorFontSizeSelect",command:"fontsize"},fontFamily:{name:__("Select Font Family"),type:"nicEditorFontFamilySelect",command:"fontname"},fontFormat:{name:__("Select Font Format"),type:"nicEditorFontFormatSelect",command:"formatBlock"}}};var nicEditorSelect=bkClass.extend({construct:function(b,a,c,d){this.options=c.buttons[a];this.elm=b;this.ne=d;this.name=a;this.selOptions=new Array();this.margin=new bkElement("div").setStyle({"float":"left",margin:"2px 1px 0 1px"}).appendTo(this.elm);this.contain=new bkElement("div").setStyle({width:"90px",height:"20px",cursor:"pointer",overflow:"hidden"}).addClass("selectContain").addEvent("click",this.toggle.closure(this)).appendTo(this.margin);this.items=new bkElement("div").setStyle({overflow:"hidden",zoom:1,border:"1px solid #ccc",paddingLeft:"3px",backgroundColor:"#fff"}).appendTo(this.contain);this.control=new bkElement("div").setStyle({overflow:"hidden","float":"right",height:"18px",width:"16px"}).addClass("selectControl").setStyle(this.ne.getIcon("arrow",c)).appendTo(this.items);this.txt=new bkElement("div").setStyle({overflow:"hidden","float":"left",width:"66px",height:"14px",marginTop:"1px",fontFamily:"sans-serif",textAlign:"center",fontSize:"12px"}).addClass("selectTxt").appendTo(this.items);if(!window.opera){this.contain.onmousedown=this.control.onmousedown=this.txt.onmousedown=bkLib.cancelEvent}this.margin.noSelect();this.ne.addEvent("selected",this.enable.closure(this)).addEvent("blur",this.disable.closure(this));this.disable();this.init()},disable:function(){this.isDisabled=true;this.close();this.contain.setStyle({opacity:0.6})},enable:function(a){this.isDisabled=false;this.close();this.contain.setStyle({opacity:1})},setDisplay:function(a){this.txt.setContent(a)},toggle:function(){if(!this.isDisabled){(this.pane)?this.close():this.open()}},open:function(){this.pane=new nicEditorPane(this.items,this.ne,{width:"88px",padding:"0px",borderTop:0,borderLeft:"1px solid #ccc",borderRight:"1px solid #ccc",borderBottom:"0px",backgroundColor:"#fff"});for(var c=0;c<this.selOptions.length;c++){var d=this.selOptions[c];var a=new bkElement("div").setStyle({overflow:"hidden",borderBottom:"1px solid #ccc",width:"88px",textAlign:"left",overflow:"hidden",cursor:"pointer"});var b=new bkElement("div").setStyle({padding:"0px 4px"}).setContent(d[1]).appendTo(a).noSelect();b.addEvent("click",this.update.closure(this,d[0])).addEvent("mouseover",this.over.closure(this,b)).addEvent("mouseout",this.out.closure(this,b)).setAttributes("id",d[0]);this.pane.append(a);if(!window.opera){b.onmousedown=bkLib.cancelEvent}}},close:function(){if(this.pane){this.pane=this.pane.remove()}},over:function(a){a.setStyle({backgroundColor:"#ccc"})},out:function(a){a.setStyle({backgroundColor:"#fff"})},add:function(b,a){this.selOptions.push(new Array(b,a))},update:function(a){this.ne.nicCommand(this.options.command,a);this.close()}});var nicEditorFontSizeSelect=nicEditorSelect.extend({sel:{1:"1&nbsp;(8pt)",2:"2&nbsp;(10pt)",3:"3&nbsp;(12pt)",4:"4&nbsp;(14pt)",5:"5&nbsp;(18pt)",6:"6&nbsp;(24pt)"},init:function(){this.setDisplay("Font&nbsp;Size...");for(itm in this.sel){this.add(itm,'<font size="'+itm+'">'+this.sel[itm]+"</font>")}}});var nicEditorFontFamilySelect=nicEditorSelect.extend({sel:{arial:"Arial","comic sans ms":"Comic Sans","courier new":"Courier New",georgia:"Georgia",helvetica:"Helvetica",impact:"Impact","times new roman":"Times","trebuchet ms":"Trebuchet",verdana:"Verdana"},init:function(){this.setDisplay("Font&nbsp;Family...");for(itm in this.sel){this.add(itm,'<font face="'+itm+'">'+this.sel[itm]+"</font>")}}});var nicEditorFontFormatSelect=nicEditorSelect.extend({sel:{p:"Paragraph",pre:"Pre",h6:"Heading&nbsp;6",h5:"Heading&nbsp;5",h4:"Heading&nbsp;4",h3:"Heading&nbsp;3",h2:"Heading&nbsp;2",h1:"Heading&nbsp;1"},init:function(){this.setDisplay("Font&nbsp;Format...");for(itm in this.sel){var a=itm.toUpperCase();this.add("<"+a+">","<"+itm+' style="padding: 0px; margin: 0px;">'+this.sel[itm]+"</"+a+">")}}});nicEditors.registerPlugin(nicPlugin,nicSelectOptions);var nicLinkOptions={buttons:{link:{name:"Add Link",type:"nicLinkButton",tags:["A"]},unlink:{name:"Remove Link",command:"unlink",noActive:true}}};var nicLinkButton=nicEditorAdvancedButton.extend({addPane:function(){this.ln=this.ne.selectedInstance.selElm().parentTag("A");this.addForm({"":{type:"title",txt:"Add/Edit Link"},href:{type:"text",txt:"URL",value:"http://",style:{width:"150px"}},title:{type:"text",txt:"Title"},target:{type:"select",txt:"Open In",options:{"":"Current Window",_blank:"New Window"},style:{width:"100px"}}},this.ln)},submit:function(b){var a=this.inputs.href.value;if(a=="http://"||a==""){alert("You must enter a URL to Create a Link");return false}this.removePane();if(!this.ln){var c="javascript:nicTemp();";this.ne.nicCommand("createlink",c);this.ln=this.findElm("A","href",c)}if(this.ln){this.ln.setAttributes({href:this.inputs.href.value,title:this.inputs.title.value,target:this.inputs.target.options[this.inputs.target.selectedIndex].value})}}});nicEditors.registerPlugin(nicPlugin,nicLinkOptions);var nicColorOptions={buttons:{forecolor:{name:__("Change Text Color"),type:"nicEditorColorButton",noClose:true},bgcolor:{name:__("Change Background Color"),type:"nicEditorBgColorButton",noClose:true}}};var nicEditorColorButton=nicEditorAdvancedButton.extend({addPane:function(){var a={0:"00",1:"33",2:"66",3:"99",4:"CC",5:"FF"};var f=new bkElement("DIV").setStyle({width:"270px"});for(var d in a){for(var h in a){for(var j in a){var e="#"+a[d]+a[j]+a[h];var b=new bkElement("DIV").setStyle({cursor:"pointer",height:"15px","float":"left"}).appendTo(f);var g=new bkElement("DIV").setStyle({border:"2px solid "+e}).appendTo(b);var c=new bkElement("DIV").setStyle({backgroundColor:e,overflow:"hidden",width:"11px",height:"11px"}).addEvent("click",this.colorSelect.closure(this,e)).addEvent("mouseover",this.on.closure(this,g)).addEvent("mouseout",this.off.closure(this,g,e)).appendTo(g);if(!window.opera){b.onmousedown=c.onmousedown=bkLib.cancelEvent}}}}this.pane.append(f.noSelect())},colorSelect:function(a){this.ne.nicCommand("foreColor",a);this.removePane()},on:function(a){a.setStyle({border:"2px solid #000"})},off:function(a,b){a.setStyle({border:"2px solid "+b})}});var nicEditorBgColorButton=nicEditorColorButton.extend({colorSelect:function(a){this.ne.nicCommand("hiliteColor",a);this.removePane()}});nicEditors.registerPlugin(nicPlugin,nicColorOptions);var nicImageOptions={buttons:{image:{name:"Add Image",type:"nicImageButton",tags:["IMG"]}}};var nicImageButton=nicEditorAdvancedButton.extend({addPane:function(){this.im=this.ne.selectedInstance.selElm().parentTag("IMG");this.addForm({"":{type:"title",txt:"Add/Edit Image"},src:{type:"text",txt:"URL",value:"http://",style:{width:"150px"}},alt:{type:"text",txt:"Alt Text",style:{width:"100px"}},align:{type:"select",txt:"Align",options:{none:"Default",left:"Left",right:"Right"}}},this.im)},submit:function(c){var b=this.inputs.src.value;if(b==""||b=="http://"){alert("You must enter a Image URL to insert");return false}this.removePane();if(!this.im){var a="javascript:nicImTemp();";this.ne.nicCommand("insertImage",a);this.im=this.findElm("IMG","src",a)}if(this.im){this.im.setAttributes({src:this.inputs.src.value,alt:this.inputs.alt.value,align:this.inputs.align.value})}}});nicEditors.registerPlugin(nicPlugin,nicImageOptions);var nicSaveOptions={buttons:{save:{name:__("Save this content"),type:"nicEditorSaveButton"}}};var nicEditorSaveButton=nicEditorButton.extend({init:function(){if(!this.ne.options.onSave){this.margin.setStyle({display:"none"})}},mouseClick:function(){var b=this.ne.options.onSave;var a=this.ne.selectedInstance;b(a.getContent(),a.elm.id,a)}});nicEditors.registerPlugin(nicPlugin,nicSaveOptions);