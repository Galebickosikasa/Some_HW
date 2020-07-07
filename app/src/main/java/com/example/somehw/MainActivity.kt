package com.example.somehw

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), MyAdapter.OnGitClick, MyAdapter.OnFilterClick {
    private lateinit var recycler: RecyclerView
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler = findViewById (R.id.recycler_view)
        adapter = MyAdapter (this)
        recycler.adapter = adapter
        val llm = LinearLayoutManager (this)
        recycler.layoutManager = llm
        val itemDecorator = MyItemDecorator (10)
        recycler.addItemDecoration (itemDecorator)
        val item1 = Item (0, "Глеб Колышев", "2 класс")
        val item2 = Item (1, "Хто я ?", "Проект мы пока думаем, так что тут без спойлеров\n" +
        "Импера́торский пингви́н (лат. Aptenodytes forsteri) — самый крупный и тяжёлый из современных видов семейства пингвиновых. Его средний рост составляет около 122 см, а вес колеблется между 22 и 45 кг. Голова и задняя часть тела чёрная, брюшная часть — белая, к верху становящаяся жёлтой. Как и все пингвиновые, императорские пингвины не умеют летать. Вместе с королевским пингвином относится к роду императорских пингвинов (Aptenodytes). Видовое латинское название дано в честь немецкого учёного Иоганна Форстера (1729—1798).")
        val item3 = Item (3)
        val item4 = Item (2, "C++", "2 года")
        val item5 = Item (2, "Python 3", "2.5 года")
        val item6 = Item (2, "Java", "1 год")
        val item7 = Item (2, "Kotlin", "2 месяца")
        val item8 = Item (2, "Bash", "полгода")
        val item9 = Item (2, "Plain text", "17 лет")
        val item10 = Item (2, "Watching movies", "9999 лет")

        adapter.addItem (item1)
        adapter.addItem (item2)
        adapter.addItem (item3)
        adapter.addItem (item4)
        adapter.addItem (item5)
        adapter.addItem (item6)
        adapter.addItem (item7)
        adapter.addItem (item8)
        adapter.addItem (item9)
        adapter.addItem (item10)

        check ()
    }

    override fun onGitClick() {
        val browserIntent = Intent (Intent.ACTION_VIEW, Uri.parse("https://github.com/Galebickosikasa"))
        startActivity(browserIntent)
    }

    fun check () {
        val sp = getSharedPreferences ("mask", Context.MODE_PRIVATE)
        val mask = sp.getInt ("mask", 7)
        adapter.filter (mask)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        check ()
    }

    override fun onFilterClick() {
        val intent = Intent (Constants.FILTER_ACTIVITY_PATH)
        startActivityForResult (intent, 1)
//        Toast.makeText (this, "kek", Toast.LENGTH_SHORT).show ()
    }
}