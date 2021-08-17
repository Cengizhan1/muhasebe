package com.cengizhan.vizyonotoboya

class workDataWrite {

    var workId:       Long   = 0
    var control:      Boolean= true
    var alıcıAd:      String = ""
    var telefon:      String = ""
    var tahminiTeslim:String = ""
    var arabaModel:   String = ""
    var yapılanis:    String = ""
    var ucret:        Int    = 0
    var workTarih:    String = ""

    constructor(workId:Long , control:Boolean , alıcıAd:String , telefon:String , tahminiTeslim:String , arabaModel:String , yapılanis:String , ucret:Int , workTarih:String){
        this.workId        = workId
        this.control       = control
        this.alıcıAd       = alıcıAd
        this.telefon       = telefon
        this.tahminiTeslim = tahminiTeslim
        this.arabaModel    = arabaModel
        this.yapılanis     = yapılanis
        this.ucret         = ucret
        this.workTarih         = workTarih
    }

}