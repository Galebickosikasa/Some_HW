package com.example.somehw

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox

class FilterActivity : AppCompatActivity() {
    private lateinit var btn : Button
    private lateinit var check_all : CheckBox
    private lateinit var check_one : CheckBox
    private lateinit var check_two : CheckBox
    private lateinit var check_inf : CheckBox
    private lateinit var sp : SharedPreferences
    private var mask = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)
        btn = findViewById (R.id.done)
        check_all = findViewById (R.id.check_all)
        check_one = findViewById (R.id.check_one)
        check_two = findViewById (R.id.check_two)
        check_inf = findViewById (R.id.check_inf)
        sp = getSharedPreferences ("mask", Context.MODE_PRIVATE)
        mask = sp.getInt ("mask", 7)
        make ()

        btn.setOnClickListener {
            sp.edit ().putInt ("mask", mask).apply ()
            finish ()
        }

        check_all.setOnClickListener{
            if (check_all.isChecked) {
                check_one.isChecked = true
                check_two.isChecked = true
                check_inf.isChecked = true
                mask = 7
            } else {
                check_one.isChecked = false
                check_two.isChecked = false
                check_inf.isChecked = false
                mask = 0
            }
//            Log.e ("kek", "mask + $mask")
        }

        check_one.setOnClickListener {
            mask = mask xor 1
            check_all.isChecked = false
            if (mask == 7) check_all.isChecked = true
//            Log.e ("kek", "mask + $mask")
        }

        check_two.setOnClickListener {
            mask = mask xor 2
            check_all.isChecked = false
            if (mask == 7) check_all.isChecked = true
//            Log.e ("kek", "mask + $mask")
        }

        check_inf.setOnClickListener {
            mask = mask xor 4
            check_all.isChecked = false
            if (mask == 7) check_all.isChecked = true
//            Log.e ("kek", "mask + $mask")
        }

    }

    private fun bit (msk: Int, i: Int) : Int {
        return (msk shr i) and 1
    }

    fun make () {
        if (mask == 7) {
            check_all.isChecked = true
            check_one.isChecked = true
            check_two.isChecked = true
            check_inf.isChecked = true
        }
        if (bit (mask, 0) == 1) {
            check_one.isChecked = true
        }
        if (bit (mask, 1) == 1) {
            check_two.isChecked = true
        }
        if (bit (mask, 2) == 1) {
            check_inf.isChecked = true
        }
    }
}