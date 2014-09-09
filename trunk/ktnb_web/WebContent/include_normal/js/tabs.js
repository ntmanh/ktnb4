/***************************/
//@Author: Adrian "yEnS" Mato Gondelle & Ivan Guardado Castro
//@website: www.yensdesign.com
//@email: yensamg@gmail.com
//@license: Feel free to use it, but keep this credits please!					
/***************************/

$(document).ready(function(){
	$(".tab > a").click(function(e){
		switch(e.target.id){
			case "tab1":
				//change status & style menu
				$("#tab1").addClass("active");
				$("#tab2").removeClass("active");
				$("#tab3").removeClass("active");
				$("#tab4").removeClass("active");
				
			break;
			case "tab2":
				//change status & style menu
				$("#tab1").removeClass("active");
				$("#tab2").addClass("active");
				$("#tab3").removeClass("active");
				$("#tab4").removeClass("active");
			break;
			case "tab3":
				//change status & style menu
				$("#tab1").removeClass("active");
				$("#tab2").removeClass("active");
				$("#tab3").addClass("active");
				$("#tab4").removeClass("active");
				break;
			case "tab4":
				//change status & style menu
				$("#tab1").removeClass("active");
				$("#tab2").removeClass("active");
				$("#tab3").removeClass("active");
				$("#tab4").addClass("active");
				break;
		}
		//alert(e.target.id);
		return false;
	});
});