package cmc.com.ktnb.pl.hb.entity;



/**
 * KntcPhanCongId entity. @author MyEclipse Persistence Tools
 */

public class KntcPhanCongId extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {


    // Fields    

     private String maHs;
     private String maCanbo;


    // Constructors

    /** default constructor */
    public KntcPhanCongId() {
    }

    
    /** full constructor */
    public KntcPhanCongId(String maHs, String maCanbo) {
        this.maHs = maHs;
        this.maCanbo = maCanbo;
    }

   
    // Property accessors

    public String getMaHs() {
        return this.maHs;
    }
    
    public void setMaHs(String maHs) {
        this.maHs = maHs;
    }

    public String getMaCanbo() {
        return this.maCanbo;
    }
    
    public void setMaCanbo(String maCanbo) {
        this.maCanbo = maCanbo;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof KntcPhanCongId) ) return false;
		 KntcPhanCongId castOther = ( KntcPhanCongId ) other; 
         
		 return ( (this.getMaHs()==castOther.getMaHs()) || ( this.getMaHs()!=null && castOther.getMaHs()!=null && this.getMaHs().equals(castOther.getMaHs()) ) )
 && ( (this.getMaCanbo()==castOther.getMaCanbo()) || ( this.getMaCanbo()!=null && castOther.getMaCanbo()!=null && this.getMaCanbo().equals(castOther.getMaCanbo()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getMaHs() == null ? 0 : this.getMaHs().hashCode() );
         result = 37 * result + ( getMaCanbo() == null ? 0 : this.getMaCanbo().hashCode() );
         return result;
   }   





}