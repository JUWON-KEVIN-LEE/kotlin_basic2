package com.immymemine.kevin.kotlinbasic2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var x = this
        var y = x as Context

        var data = listOf("ONE", "TWO", "THREE", "FOUR")
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, data)

        spinner.adapter = adapter // property 사용
                // interface 구현할 때 object 표시
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }

//        button.setOnClickListener { textView.text = "Hello Kotlin!" }
        var intent = Intent(this, Main2Activity::class.java) // <<< :: class 함수 return Class<T>
        button.setOnClickListener { startActivity(intent) }
    }
}

class CustomAdapter : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = LayoutInflater.from(parent?.context).inflate(R.layout.activity_main, parent, false)
        view?.button?.setOnClickListener { view?.textView?.text = "Hello Kotlin!" }
        return view
    }

    override fun getItem(position: Int): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemId(position: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}