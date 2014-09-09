var dsIdThanhVienDoan;
var dsChucVuTrongDoan;
function getChucVuTvd(tvdId){
	chucVu = findChucVuById(tvdId);
	chucVuVn = "";
	switch (chucVu){
		case "Truong doan":
			chucVuVn = "Tr\u01B0\u1EDFng \u0111o\u00E0n"
			break;
		case "Pho doan":
			chucVuVn = "Ph\u00F3 \u0111o\u00E0n"
			break;
		default:
			chucVuVn = "Th\u00E0nh vi\u00EAn \u0111o\u00E0n"
			break;
	}
	return chucVuVn;
} 
function findChucVuById(idCanBo){   
	for(var i = 0; i< dsIdThanhVienDoan.length; i++)   
		if(dsIdThanhVienDoan[i] == idCanBo)
			return dsChucVuTrongDoan[i]; 
} 
function xemThongTinChung(){
	window.open('cuoc_ttkt.do?method=view&type=qd&cuocTtktId=' + document.getElementsByName('idCuocTtkt')[0].value);
}