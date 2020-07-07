package com.example.somehw

class Item {
    var type : Int = 0

    var name : String = ""
    var child : String = ""
    var url : String = ""
    var img : String = ""

    var title : String = ""
    var text : String = ""

    var lang : String = ""
    var time : String = ""

    constructor(type: Int, name: String, child: String, url: String, img: String) { // 0
        this.type = type
        this.name = name
        this.child = child
        this.url = url
        this.img = img
    }

    constructor(type: Int, a: String, b: String) { // 1, 2
        this.type = type
        if (type == 1) {
            this.title = a
            this.text = b
        } else {
            this.lang = a
            this.time = b
        }
    }

    constructor(type: Int) { // 3
        this.type = type
    }

}