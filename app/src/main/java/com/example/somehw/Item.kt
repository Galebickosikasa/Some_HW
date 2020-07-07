package com.example.somehw

class Item {
    var type : Int = 0

    var name : String = ""
    var child : String = ""

    var title : String = ""
    var text : String = ""

    var lang : String = ""
    var time : String = ""

    constructor(type: Int, a: String, b: String) { // 0, 1, 2
        this.type = type
        if (type == 0) {
            this.name = a
            this.child = b
        } else if(type == 1) {
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