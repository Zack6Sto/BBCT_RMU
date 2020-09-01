package com.example.bbct_rmu.model.body

data class BodyImageS
    (var dataS:ArrayList<Data>){
    class Data(
        n_id:String,
        img_normal: String,
        img:String
    ){
        var n_id =""
        var img_normal =""
        var img =""

        init {
            this.n_id = n_id
            this.img_normal= img_normal
            this.img = img
        }
    }
}