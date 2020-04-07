package com.example.konzatu

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val intent:Intent=getIntent()
        val selectedText:String=intent.getStringExtra("Text")
        val selectedPhoto:Int=intent.getIntExtra("photo",0)

        val textView:TextView=findViewById(R.id.selected_text)
        textView.setText(selectedText)
        val imageView:ImageView=findViewById(R.id.selected_photo)
        imageView.setImageResource(selectedPhoto)
    }
}
