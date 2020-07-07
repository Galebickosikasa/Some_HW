package com.example.somehw

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import info.hoang8f.widget.FButton

class MyAdapter (context: Context): RecyclerView.Adapter<ViewHolder>() {
    private var listItem : ArrayList<Item> = arrayListOf()
    private val onGitClick : OnGitClick

    interface OnGitClick {
        fun onGitClick ()
    }

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
        when (listItem[position].type) {
            0 -> {
                val viewHolderZero = holder as ViewHolderZero
                viewHolderZero.bind (listItem[position])
            } 1 -> {
                val viewHolderOne = holder as ViewHolderOne
                viewHolderOne.bind(listItem[position])
            } 2 -> {
                val viewHolderTwo = holder as ViewHolderTwo
                viewHolderTwo.bind(listItem[position])
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return listItem[position].type
    }

    fun addItem (item: Item) {
        listItem.add (item)
        notifyItemChanged (itemCount - 1)
    }

    inner class ViewHolderZero : ViewHolder, View.OnClickListener {
        var image : ImageView
        var name : TextView
        var child : TextView
        var btn : Button

        constructor(itemView: View) : super(itemView) {
            image = itemView.findViewById (R.id.image)
            name = itemView.findViewById (R.id.name)
            child = itemView.findViewById (R.id.child)
            btn = itemView.findViewById(R.id.git) as FButton
        }

        override fun onClick(v: View?) {
            onGitClick.onGitClick ()
        }

        fun bind (item: Item) {
            name.text = item.name
            child.text = item.child
            btn.setOnClickListener (this)
        }
    }

    class ViewHolderOne : ViewHolder {
        private var title : TextView
        private var text : TextView

        constructor(itemView: View) : super(itemView) {
            title  = itemView.findViewById (R.id.title)
            text = itemView.findViewById (R.id.text)
        }

        fun bind (item: Item) {
            title.text = item.title
            text.text = item.text
        }

    }

    class ViewHolderTwo : ViewHolder {
        private var lang : TextView
        private var time : TextView

        constructor(itemView: View) : super(itemView) {
            lang = itemView.findViewById (R.id.lang)
            time = itemView.findViewById (R.id.time)
        }

        fun bind (item: Item) {
            lang.text = item.lang
            time.text = item.time
        }

    }

    class ViewHolderThree : ViewHolder {

        constructor(itemView: View) : super(itemView)

    }

    init {
        onGitClick = context as OnGitClick
    }
}