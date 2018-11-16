package com.leostudio.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        clubList.layoutManager = LinearLayoutManager(this)
        clubList.adapter = RecyclerViewAdapter(this, items) {
            val toast = Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT)
            toast.show()
//         val intent = Intent(this, DetailActivity::class.java)
//            startActivity(intent)
            onItemClick(it)
        }
    }


    private fun onItemClick(itemData: Item) {
        startActivity<DetailActivity>(
            DetailActivity.CLUB_NAME to itemData.name,
            DetailActivity.CLUB_IMAGE to itemData.image,
            DetailActivity.CLUB_DESC to itemData.desc
        )
    }

    private var items: MutableList<Item> = mutableListOf()

    private fun initData() {
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val desc = resources.getStringArray(R.array.club_description)
        items.clear()
        for (i in name.indices) {
            items.add(
                Item(
                    name[i],
                    image.getResourceId(i, 0),
                    desc[i]
                )
            )
        }
        image.recycle()
    }
}

