package com.example.bbct_rmu.model.body


data class BodyUploadImage (var data:ArrayList<Data>){
    class Data(
        n_id:String,
        img_pro: String,
        img:String
    ){
        var n_id =""
        var img_pro =""
        var img =""

        init {
            this.n_id = n_id
            this.img_pro= img_pro
            this.img = img
        }
    }
}