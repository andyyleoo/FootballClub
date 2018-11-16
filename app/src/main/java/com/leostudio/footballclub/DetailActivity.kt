package com.leostudio.footballclub

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val CLUB_NAME = "name"
        const val CLUB_IMAGE = "image"
        const val CLUB_DESC = "description"
    }

    private var clubName: String = ""
    private var clubImage: Int = 0
    private var clubDesc: String = ""

    lateinit var name_tv: TextView
    lateinit var image_iv: ImageView
    lateinit var desc_tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_detail)

        verticalLayout {
            padding = dip(20)

            image_iv = imageView()
                .lparams(
                    width = dip(wrapContent),
                    height = 100
                ) {
                    gravity = Gravity.CENTER
                }

            name_tv = textView {
                textSize = 25f
                typeface = Typeface.DEFAULT_BOLD
                gravity = Gravity.CENTER
                padding = 20
            }

            desc_tv = textView {
                textAlignment = View.TEXT_ALIGNMENT_INHERIT
                topPadding = 15

            }
        }

        clubName = intent.getStringExtra(CLUB_NAME)
        clubImage = intent.getIntExtra(CLUB_IMAGE, 0)
        clubDesc = intent.getStringExtra(CLUB_DESC)

        Picasso.get().load(clubImage).resize(100, 100).into(image_iv)
        name_tv.text = clubName
        desc_tv.text = clubDesc

    }
}
