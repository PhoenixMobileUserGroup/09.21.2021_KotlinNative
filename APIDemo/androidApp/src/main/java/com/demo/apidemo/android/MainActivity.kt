package com.demo.apidemo.android

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.demo.apidemo.Controllers.CatApiController
import com.demo.apidemo.Models.Image
import com.squareup.picasso.Picasso
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

suspend fun getImage(): Image {
    return CatApiController().getImage()[0];
}

class MainActivity : AppCompatActivity() {
    private val mainScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context: Context = this
        val imageView: ImageView = findViewById(R.id.imageView)
        val getButton: Button = findViewById(R.id.getButton)
        val progressBar: ProgressBar =  findViewById(R.id.progressBar)

        getButton.setOnClickListener {
            mainScope.launch  {
                val image = getImage()
                progressBar.visibility = View.VISIBLE
                Picasso.with(context)
                    .load(image.url)
                    .into(imageView, object: com.squareup.picasso.Callback {
                        override fun onSuccess() {
                            progressBar.setVisibility(View.GONE)
                        }
                        override fun onError() {
                        }
                    })
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }
}
