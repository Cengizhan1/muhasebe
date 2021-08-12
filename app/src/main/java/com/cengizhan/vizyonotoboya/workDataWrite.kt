package com.cengizhan.vizyonotoboya

class workDataWrite {

    var workId:       Int    = 0
    var alıcıAd:      String = ""
    var telefon:      Long   = 0
    var tahminiTeslim:String = ""
    var arabaModel:   String = ""
    var yapılanis:    String = ""
    var ucret:        Int    = 0

    constructor(workId:Int , alıcıAd:String , telefon:Long , tahminiTeslim:String , arabaModel:String , yapılanis:String , ucret:Int){
        this.workId        = workId
        this.alıcıAd       = alıcıAd
        this.telefon       = telefon
        this.tahminiTeslim = tahminiTeslim
        this.arabaModel    = arabaModel
        this.yapılanis     = yapılanis
        this.ucret         = ucret
    }

}