package com.project.wukay.wukayapp

import android.app.Dialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_levels.*

class LevelsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_levels)




        imageOption.setOnClickListener(){



            val view = layoutInflater.inflate(R.layout.popoption,null )

            val pop = PopupWindow(view,
                                LinearLayout.LayoutParams.WRAP_CONTENT, // Width of popup window
                          LinearLayout.LayoutParams.WRAP_CONTENT // Window height
                                   )



                pop.showAtLocation(imageOption,5,200,500)





        }


    }




}
