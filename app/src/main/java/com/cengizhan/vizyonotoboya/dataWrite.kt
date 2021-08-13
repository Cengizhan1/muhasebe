package com.cengizhan.vizyonotoboya

import java.time.LocalDate
import java.util.*

class dataWrite {

    var giderId:Int =0
    var giderTürü:String =""
    var giderAciklama:String =""
    var giderUcret:Int = 0
    var giderTarih:String = ""

    constructor(giderId:Int , giderTürü:String , giderAciklama:String , giderUcret:Int , giderTarih:String){
        this.giderId = giderId
        this.giderTürü = giderTürü
        this.giderAciklama = giderAciklama
        this.giderUcret = giderUcret
        this.giderTarih = giderTarih
    }
}