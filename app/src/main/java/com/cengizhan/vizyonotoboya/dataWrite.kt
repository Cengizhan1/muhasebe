package com.cengizhan.vizyonotoboya

import java.time.LocalDate
import java.util.*

class dataWrite {

    var giderId:Long =0
    var giderControl:Boolean = true
    var giderTürü:String =""
    var giderAciklama:String =""
    var giderUcret:Int = 0
    var giderTarih:String = ""

    constructor(giderId:Long , giderControl:Boolean , giderTürü:String , giderAciklama:String , giderUcret:Int , giderTarih:String){
        this.giderId = giderId
        this.giderControl = giderControl
        this.giderTürü = giderTürü
        this.giderAciklama = giderAciklama
        this.giderUcret = giderUcret
        this.giderTarih = giderTarih
    }
}