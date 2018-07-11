package com.example.caritas_heena.sqliteusingkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var usersDBHelper : UsersDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        usersDBHelper = UsersDBHelper(this)
    }
    fun addUser(v:View){

        var username=this.edittext_name.text.toString();
        var userid=this.edittext_userid.text.toString();
        var age=this.edittext_age.text.toString();
        var result = usersDBHelper.insertUser(UserModel(userid=userid, name = username, age=age))
        this.edittext_userid.setText(" ")
        this.edittext_name.setText(" ")
        this.edittext_age.setText(" ")
        this.textview_result.text = "Added User : "+result
    }

    fun showAllUsers(v:View){
        var users = usersDBHelper.readAllUsers()
        this.ll_entries.removeAllViews()
        users.forEach {
            var tv_user = TextView(this)
            tv_user.textSize = 30F
            tv_user.text = it.name.toString() + " - " + it.age.toString()
            this.ll_entries.addView(tv_user)
        }
        this.textview_result.text = "Fetched " + users.size + " users"
    }
}
