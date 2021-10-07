package com.example.commentsender

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.android.volley.toolbox.StringRequest
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    val url = "https://dry-beyond-05746.herokuapp.com/comment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val sendBtn = findViewById<Button>(R.id.button)
        val jsonobj = JSONObject()

        sendBtn.setOnClickListener {
            val author = findViewById<EditText>(R.id.author)
            val authorTxt = author.text.toString().trim()
            val comment = findViewById<EditText>(R.id.comment)
            val commentTxt = comment.text.toString().trim()

            jsonobj.put("author",authorTxt)
            jsonobj.put("comment",commentTxt)
            val que = Volley.newRequestQueue(this)
            val req = JsonObjectRequest(Request.Method.POST,url,jsonobj, Response.Listener{

            },Response.ErrorListener {

            }
            )
            que.add(req)

        }
    }

}

