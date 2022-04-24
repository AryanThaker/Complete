package com.example.complete

data class Register (var s_username:String, var s_password:String)
{
    var s_name:String=""
    var s_email:String=""
    var s_number:Long=0
    constructor(s_name:String,s_username:String,s_password:String,s_email:String,s_number:Long):this(s_username,s_password)
    {
        this.s_name=s_name
        this.s_email=s_email
        this.s_number=s_number

    }
}