package com.cengizhan.vizyonotoboya

class workDataWrite {

    var alıcıAd:      String =""
    var telefon:      Long    = 0
    var tahminiTeslim:String = ""
    var arabaModel:   String = ""
    var yapılanis:    String = ""
    var ucret:        Int    = 0

    constructor(alıcıAd:String , telefon:Long , tahminiTeslim:String , arabaModel:String , yapılanis:String , ucret:Int){
        this.alıcıAd       = alıcıAd
        this.telefon       = telefon
        this.tahminiTeslim = tahminiTeslim
        this.arabaModel    = arabaModel
        this.yapılanis     = yapılanis
        this.ucret         = ucret
    }

}