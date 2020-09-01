package com.example.bbct_rmu.rest
import android.content.Context
import android.content.SharedPreferences


class Preferrences (private var context: Context){

    companion object{
        private const val FILENAME = "app_project"
        private  const val USERNAME ="u_username"
        private  const val ID ="u_id"
        private  const val STATUS ="status"
        private const val IMAGEFILE ="img"
        private const val NAME ="name"
        private const val IDIMAGE ="IdImage"
        private const val IDITEM ="IdItem"
        private const val AGE = "age"
        private const val SEX="sex"
        private const val EMAIL="email"
        private const val PHONE="phone"
        private const val ADRESS="adress"

    }


    fun getAge():String{
        return getString(AGE)?:""
    }
    fun getSex():String{
        return getString(SEX) ?:""
    }
    fun getEmail():String{
        return getString(EMAIL) ?:""
    }
    fun getPhone():String{
        return getString(PHONE) ?:""
    }
    fun getAdress():String{
        return getString(ADRESS) ?:""
    }


    fun getIDItem():String{
        return getString(IDITEM) ?:""
    }

    fun getID():String{
        return getString(ID) ?:""
    }

    fun getStatus():String{
        return getString(STATUS) ?:""
    }

    fun getUsername():String{
        return getString(USERNAME) ?:""
    }

    fun getName():String{
        return getString(NAME)?:""
    }

    fun getImagefile():String{
        return getString(IMAGEFILE)?:""
    }




    fun GetIDImg():String{
        return getString(IDIMAGE)?:""
    }

    private fun getString(key: String): String?{
        return getShareadPreferrences().getString(key,null)
    }

    fun clearDataLogout(){
        saveString(USERNAME,"")
    }

    internal fun clear(){
        getShareadPreferrences().edit().clear().apply()
    }

    fun saveIDItem(iditem: String){
        saveString(IDITEM,iditem)
    }

    fun saveID(password: String){
        saveString(ID,password)
    }

    fun saveUsername(username: String){
        saveString(USERNAME,username)
    }

    fun saveStatus(status: String){
        saveString(STATUS,status)
    }

    fun saveImg(img:String){
        saveString(IMAGEFILE,img)
    }

    fun saveIDImg(password:String){
        saveString(IDIMAGE,password)
    }

    fun saveName(name:String){
        saveString(NAME,name)
    }
    fun saveAge(age: String){
        saveString(AGE,age)
    }
    fun saveSex(sex: String){
        saveString(SEX,sex)
    }
    fun saveEmail(email:String){
        saveString(EMAIL,email)
    }
    fun savePhone(phone: String){
        saveString(PHONE,phone)
    }
    fun saveAdress(adress: String){
        saveString(ADRESS,adress)
    }





    private fun saveString(key:String,value: String){
        val editor = getShareadPreferrences().edit()
        editor.putString(key,value)
        editor.apply()
    }

    private fun getShareadPreferrences(): SharedPreferences {
        return context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE)
    }




















}