(function($) {
	$.extend({
		// jixedbar plugin method
		jixedbar: new function(options) {
			var defaults = { // default options
					showOnTop: true, // show bar on top, instead of default bottom
					transparent: false, // enable/disable bar's transparent effect
					opacity: 0.9, // default bar opacity
					opaqueSpeed: "fast", // default opacity speed effect
					slideSpeed: "fast", // default slide effect
					menuFadeSpeed: 250, // menu fade effect
					tooltipFadeSpeed: "slow", // tooltip fade effect
					tooltipFadeOpacity: 0.8 // tooltip fade opacity effect
				};
			var options = $.extend(defaults, options); // merge defaults and options object
			var ie6 = (navigator.appName == "Microsoft Internet Explorer" && parseInt(navigator.appVersion) == 4 && navigator.appVersion.indexOf("MSIE 6.0") != -1);
			var ie7 = (document.all && !window.opera && window.XMLHttpRequest); // ...but I guess this is a much more accurate method
			var button_active = false; // active button flag
			var active_button_name = ""; // name of current active button
			var element_obj; // reference to bar's element
			// jixedbar constructor
			this.construct = function() {
				return this.each(function() {
					var obj = $(this); // reference to selected element
					//var screen = jQuery(this); // reference to client screen size
					//var fullScreen = screen.width(); // get screen width
					//var centerScreen = (fullScreen/2) * (1); // get screen center
					var hideBar = false; // default bar hide/show status
					element_obj = obj; // set bar's element object for public method use					
					if ($(this).checkCookie("JXID")) { // check if cookie already exists
						if ($(this).readCookie("JXHID") == "true") 	this.hideBar = true; // hide bar
					} else { // else drop cookie
						$(this).createCookie("JXID", $(this).genRandID()); // set random ID and create cookie
						$(this).createCookie("JXHID", false); // set bar hide to false then create cookie
					}
					// set html and body style for jixedbar to work
					/*
					if (($.browser.msie && ie6) || ($.browser.msie && ie7)) {
		                $("html").css({"overflow" : "hidden", "height" : "100%"});
		                $("body").css({"margin": "0px", "overflow": "auto", "height": "100%"});
					} else {
						$("html").css({"height" : "100%"});
						$("body").css({"margin": "0px", "height": "100%"});
					}
					*/
					if (($.browser.msie && ie6) || ($.browser.msie && ie7)) pos = "absolute";
					else													pos = "inherit";
					if ($(".jx-bar-button-right", this).exists()) 	$("<ul />").attr("id","jx-hid-con-id").insertBefore($(this).find(".jx-bar-button-right:first")); 
					else  											$("<ul />").attr("id","jx-hid-con-id").appendTo(this);
					if ($.browser.msie && ie6) 			$("#jx-hid-con-id").css({"width": "780px", "float": "left"}); // fix hide container width to prevent float drop issue on IE6 (any width other than "auto" or none specified)
					else if ($.browser.msie && ie7) 	$("#jx-hid-con-id").css({"width": "780px", "float": "left"}); // fix hide container width to prevent float drop issue on IE7
					if (defaults.showOnTop)		hideIndicator = "jx-hide-top"; // on the top
					else 						hideIndicator = "jx-hide"; // on the bottom
					// insert the hide button indicator and add appropriate CSS class
					$("#jx-hid-con-id").html('<li alt="Hide toolbar"><a id="jx-hid-btn-id" class="' + hideIndicator + '"></a></li>');
					$("#jx-hid-con-id").addClass("jx-bar-button-right");
					// insert hide button separator and CSS class
					$("<span />").attr("id", "jx-hid-sep-id").insertAfter("#jx-hid-con-id");
					$("#jx-hid-sep-id").addClass("jx-hide-separator");
					// add click event on hide button
					$("#jx-hid-btn-id").parent().click(function() {
						$("#jx-menu-con-id").fadeOut();
						$(obj).slideToggle(defaults.slideSpeed, function() {
							$(this).createCookie("JXHID", true); // set bar hide to true
							if (!$(this).checkCookie("JXID")) { // check if cookie JXID exists, if not create one
								$(this).createCookie("JXID", $(this).genRandID()); // set random ID and drop cookie
							}
							$("#jx-uhid-con-id").slideToggle(defaults.slideSpeed);
						});
						return false;
					});

					$(this).css({"overflow": "hidden","position": pos});
					if (defaults.showOnTop) $(this).css({"top": "0px"});				
					else 					$(this).css({"bottom": "0px"});
					$(this).addClass("jx-bar");
					$(this).addClass("jx-bar-button");
					// calculate and adjust bar to the center
					//marginLeft = centerScreen-($(this).width()/2);
					//$(this).css({"margin-left": marginLeft});
					// fix image vertical alignment and border
					$("img", obj).css({"vertical-align": "bottom","border": "#fff solid 0px"});
					// check for alt attribute and set it as button text
					$(this).find("img").each(function() {
						if ($(this).attr("alt") != "") { // if image's ALT attribute is not empty then do the code below
							altName = "&nbsp;" + $(this).attr("alt"); // set button text using the image's ALT attribute
							$(this).parent().append(altName); // append it
						}
					});
					// check of transparency is enabled
					if (defaults.transparent) $(this).fadeTo(defaults.opaqueSpeed, defaults.opacity); // do transparent effect
					// create menu container first before creating the tooltip container, so tooltip will be on foreground
					$("<div />").attr("id", "jx-menu-con-id").appendTo("body");
					// add transparency effect on menu container if "transparent" is true
					if (defaults.transparent) $("#jx-menu-con-id").fadeTo(defaults.opaqueSpeed, defaults.opacity);
					$("<div />").attr("id", "jx-uhid-con-id").appendTo("body");
					$("#jx-uhid-con-id").addClass("jx-show");
					$("#jx-uhid-con-id").css({"overflow": "hidden","position": pos,"margin-left":($(this).offset().left + $(this).width()) - $("#jx-uhid-con-id").width()});
					// set show/unhide location: top or bottom
					if (defaults.showOnTop)   $("#jx-uhid-con-id").css({"top": "0px"});				
					else 					  $("#jx-uhid-con-id").css({"bottom": "0px"});				
					if (defaults.transparent) $("#jx-uhid-con-id").fadeTo(defaults.opaqueSpeed, defaults.opacity); 
					if (this.hideBar)   $(this).css({"display":"none"});				
					else 				$("#jx-uhid-con-id").css({"display":"none"});
					$("<ul />").attr("id", "jx-uhid-itm-id").appendTo($("#jx-uhid-con-id"));
					if (defaults.showOnTop) unhideIndicator = "jx-show-button-top";
					else 					unhideIndicator = "jx-show-button";
					$("#jx-uhid-itm-id").html('<li alt="Show toolbar"><a id="jx-uhid-btn-id" class="' + unhideIndicator + '"></a></li>');
					$("#jx-uhid-con-id").addClass("jx-bar-button"); // add CSS style on show/unhide button based on the current theme
					// add click event on show/unhide button
					$("#jx-uhid-con-id").click(function() {
						$(this).slideToggle(defaults.slideSpeed, function() {
							$(this).createCookie("JXHID", false); // set bar hide to false
							if (!$(this).checkCookie("JXID")) { // check if cookie JXID exists, if not create one
								$(this).createCookie("JXID", $(this).genRandID()); // set random ID and drop cookie
							}
							$(obj).slideToggle(defaults.slideSpeed); // slide toggle effect
							if (active_button_name != "") $("#jx-menu-con-id").fadeIn(); 
							// re-set unhide/show button position
							$("#jx-uhid-con-id").css({"margin-left": ($(obj).offset().left + $(obj).width()) - $("#jx-uhid-con-id").width()});
							// re-set menu container position
							if (button_active) 	$("#jx-menu-con-id").css({"margin-left": $("#" + active_button_name).parent().offset().left});
						});
						return false;
					});
					// fix PNG transparency problem on IE6
					if ($.browser.msie && ie6) {
						$(this).find("li").each(function() {
							$(this).find("img").each(function() {
								imgPath = $(this).attr("src");
								altName = $(this).attr("alt");
								if (altName == "") { // workaround for IE6 bug: Menu item text does not show up on the popup menu
									altName = "&nbsp;&nbsp;" + $(this).attr("title");
								}
								srcText = $(this).parent().html();
								$(this).parent().html( // wrap with span element
									'<span style="cursor:pointer;display:inline-block;filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src=\'' + imgPath + '\');">' + srcText + '</span>&nbsp;' + altName
								);
							});
							$(this).find("img").each(function() {
								$(this).attr("style", "filter:progid:DXImageTransform.Microsoft.Alpha(opacity=0);"); // show image
							});
						});
					}
					
					// adjust bar on window resize event
					/*$(window).resize(
						function(){
							var screen = jQuery(this); // reference to client/viewers screen
							var screenWidth = screen.width(); // get current screen width
							var centerScreen = (screenWidth / 2) * (1); // get current screen center
							var marginLeft = centerScreen - ($(obj).width() / 2); // re-calculate and adjust bar's position
							$(obj).css({"margin-left": marginLeft}); // do it!
							
							// set unhide/show button
							$("#jx-uhid-con-id").css({
								"margin-left": ($(obj).offset().left + $(obj).width()) - $("#jx-uhid-con-id").width()
							});
							
							if (button_active) { // check if we have an active button
								$("#jx-menu-con-id").css({
									"margin-left": $("#" + active_button_name).parent().offset().left // fix menu position on resize
								});
							}

						}
					);*/
					
					// hide first level menu
					$("li", obj).find("ul").each(function() {
						$(this).css({"display": "none"}); 
					});
					// create menu ID
					i = 1;
					$("li", obj).find("ul").each(function() {
						$(this).attr("id", "nav" + i);
						$(this).parent().find("a:first").attr("href", "#"); // replace href attribute
						$(this).parent().find("a:first").attr("name", "nav" + i); // replace href attribute				
						if (defaults.showOnTop) 		buttonIndicator = "jx-arrow-down"; // top
						else 							buttonIndicator = "jx-arrow-up"; // bottom
						if (($.browser.msie && ie6) || ($.browser.msie && ie7)) 	$("<div />").attr("class", buttonIndicator).insertBefore($(this).parent().find("a")).css({"background-position": "top"});
						else 														$("<div />").attr("class", buttonIndicator).insertAfter($(this).parent().find("a"));
						// add click event (button)
						$(this).parent().find("a:first").click(function() {
							var elemID = $(this).attr("id"); // get ID (whether there is an ID or none)					
							var barTooltipID = elemID + "jx-ttip-id"; // set a tooltip ID
							var barTooltipWrapperID = barTooltipID + "_wrapper";
							$("#" + barTooltipID).remove(); // remove tooltip element
							$("#" + barTooltipWrapperID).remove(); // remove tooltip's element DIV wrapper
							if ((button_active) && (active_button_name == $(this).attr("name"))) { // is this an active button?
								if (defaults.showOnTop)		buttonIndicator = "jx-arrow-down"; // top
								else 						buttonIndicator = "jx-arrow-up"; // bottom
								$(this).parent().find("div").attr("class", buttonIndicator); // change button indicator
								$("#jx-menu-con-id").fadeOut(defaults.menuFadeSpeed); // remove/hide menu using fade effect
								$(this).parent().removeClass("jx-nav-menu-active"); // remove active state for this button (style)
								button_active = false; // remove button's active state
								active_button_name = "";
								$(this).blur(); // unfocus link/href
							} else {
								if (defaults.showOnTop) buttonIndicator = "jx-arrow-up";
								else 					buttonIndicator = "jx-arrow-down";
								$(this).parent().find("div").attr("class", buttonIndicator); // change button indicator
								$("#jx-menu-con-id").css({"display": "none"}); // hide menu container
								$("#jx-menu-con-id").html("<ul>" + $(this).parent().find("ul").html() + "</ul>");
								$("#jx-menu-con-id").css({"overflow": "hidden","position": pos,"margin-left": $(this).parent().offset().left});
								// set menu container location: top or bottom
								if (defaults.showOnTop) $("#jx-menu-con-id").css({"top": "0px","margin-top": $(obj).height() + 6});
								else					$("#jx-menu-con-id").css({"bottom": "0px","margin-bottom": $(obj).height() + 6});
								$("#jx-menu-con-id").addClass("jx-nav-menu");
								if ($.browser.msie && ie6) 	 $("#jx-menu-con-id ul li a").css({"width": "100%"}); // IE6 and IE7 right padding/margin fix
								$(this).parent().addClass("jx-nav-menu-active"); // add active state CSS style
								if (active_button_name != "") { // remove/hide any active button (on-clicked state)
									$("a[name='" + active_button_name + "']").parent().removeClass("jx-nav-menu-active");
									$("a[name='" + active_button_name + "']").parent().removeClass("jx-nav-menu-active-rounded");
									if (defaults.showOnTop) buttonIndicator = "jx-arrow-down";
									else 					buttonIndicator = "jx-arrow-up";
									$("a[name='" + active_button_name + "']").parent().find("div").attr("class", buttonIndicator);
								}
								button_active = true; // change button's active state
								active_button_name = $(this).attr("name"); // save button name for future reference (e.g. remove active state)
								$(this).blur(); // unfocus link/href
								$("#jx-menu-con-id").fadeIn(defaults.menuFadeSpeed); // show menu container and its item(s)
							}
							return false; // prevent normal click action
						});
						i = i + 1;
					});
					
					// nav items click event
					$("li", obj).click(function () {
						if ($("ul", this).exists()) {
							$(this).find("a:first").click();
							return false;
						} else if ($(this).parent().attr("id") == "jx-hid-con-id") {
							return false; // do nothing
						}
						
						if ($("a", this).exists()) { // check if there are A tag (href) to follow
							window.location = $(this).find("a:first").attr("href"); // emulate normal click event action (e.g. follow link)
						}
						return false;
					});
					
				});
				
			}; // end method construct
			
			/**
			 * additional public methods
			 */
			
			// get jixedbar's options (variables)
			this.getOptions = function() {return options;};
			// check if IE6
			this.isIE6 = function() {return ie6;};
			// check if IE7
			this.isIE7 = function() {return ie7;};
			// check if there are active button
			this.hasActiveButton = function() {return button_active;};
			// return active button name
			this.getActiveButtonName = function() {	return active_button_name;};
			// get tooltip container object
			this.getTooltipObject = function() {return $("#jx-ttip-con-id");};
			// create object container
			this.createObjectContainer = function(name) {
				name = typeof(name) != 'undefined' ? name : "jx-obj-con-id"; // default object container name
				// create custom object container
				$("<div />").attr("id", name).appendTo("body"); // create div element and append in html body
				$("#" + name).css({"height": "auto","margin-left": "0px","width": "100%","overflow": "hidden","position": pos});
				// set custom object container: top or bottom
				if (defaults.showOnTop) $("#" + name).css({"margin-top": $(element_obj).height() + 6,"top": "0px"});
				else 					$("#" + name).css({"margin-bottom": $(element_obj).height() + 6,"bottom": "0px"});
				return $("#" + name);
			};
		} // end jixedbar plugin method
	}); // end jquery extend method
	
$.fn.extend({ // extend jQuery.fn object
    jixedbar: $.jixedbar.construct
});
	
})(jQuery); // end of anonymous function
jQuery.fn.exists = function(){return jQuery(this).length>0;};
jQuery.fn.createCookie = function(cookie_name, value) {
	var expiry_date = new Date(2037, 01, 01); // virtually, never expire!
	document.cookie = cookie_name + "=" + escape(value) + ";expires=" + expiry_date.toUTCString();
};
jQuery.fn.checkCookie = function(cookie_name) {
	if (document.cookie.length > 0) {
  		cookie_start = document.cookie.indexOf(cookie_name + "=");
  			if (cookie_start != -1) {
    			cookie_start = cookie_start + cookie_name.length + 1;
    			cookie_end = document.cookie.indexOf(";", cookie_start);
    			if (cookie_end == -1) {
    				cookie_end = document.cookie.length;
    				return true;
    			}
			}
  	}
	return false;
};
jQuery.fn.extractCookieValue = function(value) {
	  if ((endOfCookie = document.cookie.indexOf(";", value)) == -1) {
	     endOfCookie = document.cookie.length;
	  }
	  return unescape(document.cookie.substring(value, endOfCookie));
};
jQuery.fn.readCookie = function(cookie_name) {
	  var numOfCookies = document.cookie.length;
	  var nameOfCookie = cookie_name + "=";
	  var cookieLen = nameOfCookie.length;
	  var x = 0;
	  while (x <= numOfCookies) {
	        var y = (x + cookieLen);
	        if (document.cookie.substring(x, y) == nameOfCookie)
	           return (this.extractCookieValue(y));
	           x = document.cookie.indexOf(" ", x) + 1;
	           if (x == 0){
	              break;
	           }
	  }
	  return (null);
};
jQuery.fn.genRandID = function() {
	var id = "";
	var str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	for(var i=0; i < 24; i++) {
		id += str.charAt(Math.floor(Math.random() * str.length));
	}
    return id;
};