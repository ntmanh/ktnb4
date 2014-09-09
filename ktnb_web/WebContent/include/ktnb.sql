create or replace package ktnb_pck_util is
  function get_hash(p_username in varchar2,p_password in varchar2)  return varchar2;
  procedure create_user(p_ma_can_bo in varchar2);
  function tcvn2uni(pstr in varchar2) return varchar2;
  function get_tennsd(pstr in varchar2) return varchar2;
end;
/
create or replace package body ktnb_pck_util is
-------------------------------------------------------
function get_hash(p_username in varchar2,p_password in varchar2)  return varchar2 as
begin
  return dbms_obfuscation_toolkit.md5(input_string => upper(p_username) || '/' || upper(p_password));
end;
------------------------------------------------------
function marktran(str in varchar2) return VARCHAR2 is 
begin
 return translate(upper(trim(str)),'ĐĂÂÁÀẢÃẠẮẰẲẴẶẤẦẨẪẬÊÉÈẺẼẸẾỀỂỄỆÔƠÓÒỎÕỌỐỒỔỖỘỚỜỞỠỢƯÚÙỦŨỤỨỪỬỮỰÍÌỈĨỊÝỲỶỸỴ','DAAAAAAAAAAAAAAAAAEEEEEEEEEEEOOOOOOOOOOOOOOOOOUUUUUUUUUUUIIIIIYYYYY');
end;
-------------------------------------------------------------------
function get_tennsd(pstr in varchar2) return varchar2 as
p pls_integer;
str    varchar2(100):=marktran(pstr)||' ';
ketqua varchar2(100):='';
begin
   loop
      exit when str is null;
      p:=instr(str,' ');
      if (substr(str,p+1) is null) then        
         ketqua:=ketqua||substr(trim(str),1);            
      else   
         ketqua:=ketqua||substr(str,1,1);
      end if;
      str:=substr(str,p+1);
    end loop;
    return ketqua;
end;
------------------------------------------------------------------------
function check_user(p_ten_nsd in varchar2) return number as
v_ketqua integer;
begin
 select count(*) into v_ketqua from ktnb_nsd where ten_nsd=p_ten_nsd;
 if (v_ketqua<1) then
  return 0;
 end if; 
 select count(*) into v_ketqua from ktnb_nsd where ten_nsd like p_ten_nsd||'%';
 return  v_ketqua;
end;
----------------------------------------------------------------------------
procedure create_user(p_ma_can_bo in varchar2) is
v_tennsd varchar2(50);
v_matkhau varchar2(50);
v_ketqua integer;
begin
 select ktnb_pck_util.get_tennsd(ten) into v_tennsd from ktnb_dm_can_bo where ma=p_ma_can_bo;
 v_ketqua:=check_user(v_tennsd);
 if (v_ketqua>0) then
  v_tennsd:=v_tennsd||(v_ketqua+1);
 end if;
 v_matkhau:=get_hash(p_ma_can_bo,v_tennsd); 
 insert into ktnb_nsd (ten_nsd,mat_khau,ma_can_bo) values (v_tennsd,v_matkhau,p_ma_can_bo);
 commit;
 exception
 when others then
 raise;
end;
----------------------------------------------------------------
function tcvn2uni(pstr in varchar2) return varchar2 as
type arrs is table of pls_integer;
tcvn  constant arrs:=arrs(184,181,182,183,185,168,190,187,188,189,198,169,202,199,200,201,203,174,208,204,206,207,209,170,213,210,211,212,214,221,215,216,220,222,227,223,225,226,228,171,232,229,230,231,233,172,237,234,235,236,238,243,239,241,242,244,173,248,245,246,247,249,167,161,162,164,165,163,166,253,250,251,252,254);
utf   constant arrs:=arrs(50081,50080,14793379,50083,14793377,50307,14793391,14793393,14793395,14793397,14793399,50082,14793381,14793383,14793385,14793387,14793389,50321,50089,50088,14793403,14793405,14793401,50090,14793407,14793601,14793603,14793605,14793607,50093,50092,14793609,50345,14793611,50099,50098,14793615,50101,14793613,50100,14793617,14793619,14793621,14793623,14793625,50849,14793627,14793629,14793631,14793633,14793635,50106,50105,14793639,50601,14793637,50864,14793641,14793643,14793645,14793647,14793649,50320,50306,50050,50068,50848,50058,50863,50109,14793651,14793655,14793657,14793653);
n pls_integer;
p pls_integer;
str    varchar2(32767);
ketqua varchar2(32767):='';
begin
if (pstr is null) or (pstr='null')  then
 return null;
else
   str:=substr(pstr,instr(pstr,':')+1)||',';
   loop
      exit when str is null;
      p:=instr(str,',');
      n:=to_number(substr(str,1,p-1));
      if n>127 then
        for i in 1..74 loop
          if n=tcvn(i) then
             n:=utf(i);
             exit;
          end if;
        end loop;
      end if;
      ketqua:=ketqua||chr(n);
      str:=substr(str,p+1);
    end loop;
    return ketqua;
end if;
end;
--------------------------------------------------------------------------------------
end;
/


DROP TABLE KTNB_DBLINK; 
CREATE TABLE KTNB_DBLINK 
(MA VARCHAR2(3)      NOT NULL, 
 MA_TINH VARCHAR2(3) NOT NULL, 
 CONSTRAINT KTNB_DBLINK_PK PRIMARY KEY (MA)   USING INDEX   TABLESPACE KTNB_DATA  ENABLE, 
 CONSTRAINT KTNB_DBLINK_UK1 UNIQUE (MA_TINH)  USING INDEX   TABLESPACE KTNB_DATA  ENABLE
);


REM INSERTING into ktnb_dblink
Insert into ktnb_dblink (MA,MA_TINH) values ('HAN','101');
Insert into ktnb_dblink (MA,MA_TINH) values ('HPH','103');
Insert into ktnb_dblink (MA,MA_TINH) values ('HDU','107');
Insert into ktnb_dblink (MA,MA_TINH) values ('HYE','109');
Insert into ktnb_dblink (MA,MA_TINH) values ('HNA','111');
Insert into ktnb_dblink (MA,MA_TINH) values ('NDI','113');
Insert into ktnb_dblink (MA,MA_TINH) values ('TBI','115');
Insert into ktnb_dblink (MA,MA_TINH) values ('NBI','117');
Insert into ktnb_dblink (MA,MA_TINH) values ('HGI','201');
Insert into ktnb_dblink (MA,MA_TINH) values ('CBA','203');
Insert into ktnb_dblink (MA,MA_TINH) values ('LCA','205');
Insert into ktnb_dblink (MA,MA_TINH) values ('BCA','207');
Insert into ktnb_dblink (MA,MA_TINH) values ('LSO','209');
Insert into ktnb_dblink (MA,MA_TINH) values ('TQU','211');
Insert into ktnb_dblink (MA,MA_TINH) values ('YBA','213');
Insert into ktnb_dblink (MA,MA_TINH) values ('TNG','215');
Insert into ktnb_dblink (MA,MA_TINH) values ('PTH','217');
Insert into ktnb_dblink (MA,MA_TINH) values ('VPH','219');
Insert into ktnb_dblink (MA,MA_TINH) values ('BGI','221');
Insert into ktnb_dblink (MA,MA_TINH) values ('BNI','223');
Insert into ktnb_dblink (MA,MA_TINH) values ('QNI','225');
Insert into ktnb_dblink (MA,MA_TINH) values ('DBI','301');
Insert into ktnb_dblink (MA,MA_TINH) values ('LCH','302');
Insert into ktnb_dblink (MA,MA_TINH) values ('SLA','303');
Insert into ktnb_dblink (MA,MA_TINH) values ('HBI','305');
Insert into ktnb_dblink (MA,MA_TINH) values ('THO','401');
Insert into ktnb_dblink (MA,MA_TINH) values ('NAN','403');
Insert into ktnb_dblink (MA,MA_TINH) values ('HTI','405');
Insert into ktnb_dblink (MA,MA_TINH) values ('QBI','407');
Insert into ktnb_dblink (MA,MA_TINH) values ('QTR','409');
Insert into ktnb_dblink (MA,MA_TINH) values ('TTH','411');
Insert into ktnb_dblink (MA,MA_TINH) values ('DAN','501');
Insert into ktnb_dblink (MA,MA_TINH) values ('QNA','503');
Insert into ktnb_dblink (MA,MA_TINH) values ('QNG','505');
Insert into ktnb_dblink (MA,MA_TINH) values ('BDI','507');
Insert into ktnb_dblink (MA,MA_TINH) values ('PHY','509');
Insert into ktnb_dblink (MA,MA_TINH) values ('KHH','511');
Insert into ktnb_dblink (MA,MA_TINH) values ('KTU','601');
Insert into ktnb_dblink (MA,MA_TINH) values ('GLA','603');
Insert into ktnb_dblink (MA,MA_TINH) values ('DLA','605');
Insert into ktnb_dblink (MA,MA_TINH) values ('DNO','606');
Insert into ktnb_dblink (MA,MA_TINH) values ('HCM','701');
Insert into ktnb_dblink (MA,MA_TINH) values ('LDO','703');
Insert into ktnb_dblink (MA,MA_TINH) values ('NTH','705');
Insert into ktnb_dblink (MA,MA_TINH) values ('BPH','707');
Insert into ktnb_dblink (MA,MA_TINH) values ('TNI','709');
Insert into ktnb_dblink (MA,MA_TINH) values ('BDU','711');
Insert into ktnb_dblink (MA,MA_TINH) values ('DON','713');
Insert into ktnb_dblink (MA,MA_TINH) values ('BTH','715');
Insert into ktnb_dblink (MA,MA_TINH) values ('BRV','717');
Insert into ktnb_dblink (MA,MA_TINH) values ('LAN','801');
Insert into ktnb_dblink (MA,MA_TINH) values ('DTH','803');
Insert into ktnb_dblink (MA,MA_TINH) values ('AGI','805');
Insert into ktnb_dblink (MA,MA_TINH) values ('TGI','807');
Insert into ktnb_dblink (MA,MA_TINH) values ('VLO','809');
Insert into ktnb_dblink (MA,MA_TINH) values ('BTR','811');
Insert into ktnb_dblink (MA,MA_TINH) values ('KGI','813');
Insert into ktnb_dblink (MA,MA_TINH) values ('CTH','815');
Insert into ktnb_dblink (MA,MA_TINH) values ('HAG','816');
Insert into ktnb_dblink (MA,MA_TINH) values ('TVI','817');
Insert into ktnb_dblink (MA,MA_TINH) values ('STR','819');
Insert into ktnb_dblink (MA,MA_TINH) values ('BLI','821');
Insert into ktnb_dblink (MA,MA_TINH) values ('CMA','823');
commit;

create or replace package KTNB_PCK_LOAD is
  procedure prc_load_can_bo_tinc(p_ma_tinh in varchar2);
  procedure prc_load_phong_tinc(p_ma_tinh in varchar2);
  procedure prc_load_tinh;
  procedure prc_load_huyen;
  procedure prc_load_cqt;
end;
/
create or replace package body ktnb_pck_load is
--------------------------------------------------------------
/* lay du lieu danh muc cac tinh thanh tu tintc*/
procedure prc_load_tinh is
begin
  delete ktnb_dm_tinh;
  for c in (select province,dump(prov_name) prov_name from ttc_province@tintc) loop
    insert into ktnb_dm_tinh (ma,ten) values (c.province,ktnb_pck_util.tcvn2uni(c.prov_name));
  end loop;
  commit;
  exception
  when others then
    raise;
end;
--------------------------------------------------------------
/* lay du lieu danh muc cac quan huyen tu tintc*/
procedure prc_load_huyen is
begin
 delete ktnb_dm_huyen;
 for c in (select dist_code,province,dump(dist_name) dist_name from ttc_district@tintc) loop
    insert into ktnb_dm_huyen(ma,ma_tinh,ten) values (c.dist_code,c.province,ktnb_pck_util.tcvn2uni(c.dist_name));
 end loop;
 commit;
 exception
 when others then
   raise;
end;
---------------------------------------------------------------
/* lay du lieu danh muc co quan thue tu tintc*/
procedure prc_load_cqt is
begin
  delete ktnb_dm_cqt;
  for c in (select tin_taxo_id,dump(taxo_name) taxo_name  from  ttc_taxoffice@tintc) loop
     insert into ktnb_dm_cqt (ma,ten) values (c.tin_taxo_id,ktnb_pck_util.tcvn2uni(c.taxo_name));
  end loop;
  commit;
  exception
  when others then
    raise;
end;
--------------------------------------------------------------------
/*
lay du lieu thong tin ve danh muc phong ban tu tinc
ma_tinh : han,hcm...
*/
procedure prc_load_phong_tinc(p_ma_tinh in varchar2) is
p_cur     sys_refcursor;
v_ma      varchar2(7);
v_ma_cqt  varchar2(5);
v_name    varchar2(1000);
v_ma_tinh varchar2(4);
begin
select ma_tinh||'%' into v_ma_tinh from ktnb_dblink where ma=upper(p_ma_tinh);
delete ktnb_dm_phong where ma like v_ma_tinh;
open p_cur for 'select depa_id,taxo_id,dump(depa_name) depa_name from tin_department@tinc_'||p_ma_tinh;
  loop
      fetch p_cur into v_ma,v_ma_cqt,v_name;
      exit when p_cur%notfound;
      insert into ktnb_dm_phong(ma,ma_cqt,ten) values(v_ma,v_ma_cqt,ktnb_pck_util.tcvn2uni(v_name));
  end loop;
close p_cur;
commit;
exception
when others then
 raise;
end;
-----------------------------------------------------------------------
/*lay du lieu thong tin ve cac can bo tu tinc*/
procedure prc_load_can_bo_tinc(p_ma_tinh in varchar2) is
p_cur sys_refcursor;
v_ma       varchar2(10);
v_ma_phong varchar2(7);
v_name     varchar2(1000);
v_start_date  date;
v_finish_date date;
v_ma_tinh varchar2(4);
begin
select ma_tinh||'%' into v_ma_tinh from ktnb_dblink where ma=upper(p_ma_tinh);
delete ktnb_dm_can_bo where ma like v_ma_tinh;
open p_cur for 'select staff_id,depa_id,dump(staff_name) staff_name,start_date,finish_date from tin_staff@tinc_'||p_ma_tinh;
  loop
      fetch p_cur into v_ma,v_ma_phong,v_name,v_start_date,v_finish_date;
      exit when p_cur%notfound;
      insert into ktnb_dm_can_bo(ma,ma_phong,ten,ngay_hluc_tu,ngay_hluc_den) values (v_ma,v_ma_phong,ktnb_pck_util.tcvn2uni(v_name),v_start_date,v_finish_date);
  end loop;
close p_cur;
commit;
exception
when others then
 raise;
end;
---------------------------------------------------------------------------------
end;
/


insert into ktnb_dm_phong values ('0000001','Ban Lãnh đạo','00000');
insert into ktnb_dm_phong values ('0000003','Ban Tổ chức cán bộ','00000');
insert into ktnb_dm_phong values ('0000005','Ban Pháp chế Chính sách','00000');
insert into ktnb_dm_phong values ('0000007','Ban KTNB','00000');
insert into ktnb_dm_phong values ('0000009','Ban Thanh tra','00000');
insert into ktnb_dm_phong values ('0000011','CNTT','00000');
insert into ktnb_dm_phong values ('0000013','Ban Tuyên truyền Hỗ trợ','00000');
insert into ktnb_dm_phong values ('0000015','Ban Quản lý nợ','00000');
insert into ktnb_dm_phong values ('0000017','Ban Dự toán thu thuế','00000');
insert into ktnb_dm_phong values ('0000019','Ban DN nhà nước','00000');
insert into ktnb_dm_phong values ('0000021','Ban DN khác','00000');
insert into ktnb_dm_phong values ('0000023','Ban Đầu tư nước ngoài','00000');
insert into ktnb_dm_phong values ('0000025','Ban Thu nhập cá nhân','00000');
insert into ktnb_dm_phong values ('0000027','Ban DNL','00000');
insert into ktnb_dm_phong values ('0000029','Ban tài sản','00000');
insert into ktnb_dm_phong values ('0000031','Ban Tài vụ QT','00000');
commit;
DELETE ktnb_dm_cqt   where upper(TEN) like '%LỰC%';
DELETE ktnb_dm_cqt   where ma like '105%';
DELETE ktnb_dm_HUYEN where ma_tinh='105';
DELETE ktnb_dm_TINH  where ma='105';
commit;

drop table KTNB_DM; 
CREATE TABLE KTNB_DM 
   (MA 		  VARCHAR2(8) 	NOT NULL, 
	TEN 	  VARCHAR2(100) NOT NULL, 
	PARENT_ID VARCHAR2(8), 
	CONSTRAINT KTNB_DM_PK PRIMARY KEY (MA),
	CONSTRAINT KTNB_DM_KTNB_DM_FK FOREIGN KEY (PARENT_ID) REFERENCES KTNB_DM(MA) 
   ) TABLESPACE KTNB_DATA;

 insert into KTNB_DM values ('10','Danh mục nội dung TTKT',null);
 insert into KTNB_DM values ('11','Danh mục chức vụ',null);
 insert into KTNB_DM values ('12','Thời hạn TTKT',null);
 
 insert into KTNB_DM values ('1001','TTKT việc thực hiện đăng ký, cấp mã số thuế','10');
 insert into KTNB_DM values ('1002','TTKT công tác khai thuế, tính thuế','10');
 insert into KTNB_DM values ('1003','TTKT việc ấn định thuế đối với người nộp thuế','10');
 insert into KTNB_DM values ('1004','TTKT nội dung nộp thuế','10');
 insert into KTNB_DM values ('1005','TTKT công tác hoàn thuế GTGT','10');
 insert into KTNB_DM values ('1006','TTKT công tác miễn thuế, giảm thuế','10');
 insert into KTNB_DM values ('1007','TTKT công tác xoá nợ tiền thuế, tiền phạt','10');
 insert into KTNB_DM values ('1008','TTKT công tác thanh tra thuế','10');
 insert into KTNB_DM values ('1009','TTKT công tác kiểm tra thuế','10');
 insert into KTNB_DM values ('1010','TTKT công tác xử lý vi phạm pháp luật về thuế','10');
 insert into KTNB_DM values ('1011','TTKT công tác giải quyết khiếu nại, tố cáo về thuế','10');
 insert into KTNB_DM values ('1012','TTKT công tác tổ chức cán bộ','10');
 insert into KTNB_DM values ('1013','TTKT công tác sử dụng kinh phí ngành','10');
 insert into KTNB_DM values ('1014','TTKT công tác xây dựng cơ bản ngành','10'); 
 insert into KTNB_DM values ('1015','TTKT việc thực hiện chế độ quản lý ấn chỉ thuế','10');
 insert into KTNB_DM values ('101501','TTKT việc thực hiện chế độ in, quản lý sử dụng ấn chỉ thuế','1015');
 insert into KTNB_DM values ('101502','TTKT công tác quản lý và sử dụng hoá đơn','1015');
 
 