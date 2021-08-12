package com.cengizhan.vizyonotoboya

class odemeDataWrite {

    var workId:Int = 0
    var odemeTutar:Int =0
    var odemeId:Int = 0
    var odemeTarih:String = ""

    constructor(workId:Int , odemeTutar:Int , odemeId:Int , odemeTarih:String){
        this.workId = workId
        this.odemeTutar = odemeTutar
        this.odemeId = odemeId
        this.odemeTarih = odemeTarih
    }
}