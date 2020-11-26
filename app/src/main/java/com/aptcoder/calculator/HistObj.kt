package com.aptcoder.calculator

class HistObj {


    var expresion:String=""
    var Result:String=""
    var dateToOrder:Long=0
    constructor(){
        //for firebase
    }

    constructor(expresion: String, Result: String, dateToOrder: Long) {
        this.expresion = expresion
        this.Result = Result
        this.dateToOrder = dateToOrder
    }


}