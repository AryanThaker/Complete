package com.example.complete

data class register (var username:String,var password:String)
{
    var name:String=""
    var email:String=""
    var number:Long=0
    constructor(name:String,username:String,password:String,email:String,number:Long):this(username,password)
    {
        this.name=name
        this.email=email
        this.number=number

    }
}