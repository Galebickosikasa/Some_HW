package com.example.somehw

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import info.hoang8f.widget.FButton

class MyAdapter : RecyclerView.Adapter<ViewHolder> {
    private var listItem : ArrayList<Item> = arrayListOf()

    constructor() : super()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)
        var view: View
        return when (viewType) {
            0 -> {
                view = layoutInflater.inflate (R.layout.holder_name, parent, false)
                ViewHolderZero (view)
            } 1 -> {
                view = layoutInflater.inflate (R.layout.holder_text, parent, false)
                ViewHolderOne (view)
            } 2 -> {
                view = layoutInflater.inflate (R.layout.holder_skill, parent, false)
                ViewHolderTwo (view)
            } else -> {
                view = layoutInflater.inflate (R.layout.holder_skills_header, parent, false)
                ViewHolderThree (view)
            }
        }
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemViewType(position: Int): Int {
        return listItem[position].type
    }

    class ViewHolderZero : RecyclerView.ViewHolder {
        private var image : ImageView
        private var name : String
        private var child : String
        private var url : String
        private lateinit var btn : Button

        constructor(itemView: View) : super(itemView) {
            image = itemView.findViewById (R.id.image)
            name = itemView.findViewById (R.id.name)
            child = itemView.findViewById (R.id.child)
            btn = itemView.findViewById(R.id.git) as FButton
            url = "kek" // TODO

        }

    }

    class ViewHolderOne : RecyclerView.ViewHolder {

        constructor(itemView: View) : super(itemView)

    }

    class ViewHolderTwo : RecyclerView.ViewHolder {

        constructor(itemView: View) : super(itemView)

    }

    class ViewHolderThree : RecyclerView.ViewHolder {

        constructor(itemView: View) : super(itemView)

    }
}