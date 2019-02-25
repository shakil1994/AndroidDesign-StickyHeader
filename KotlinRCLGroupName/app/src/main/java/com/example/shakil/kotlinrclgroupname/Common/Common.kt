package com.example.shakil.kotlinrclgroupname.Common

import com.example.shakil.kotlinrclgroupname.Model.Person
import java.util.*

object Common {
    val VIEWTYPE_GROUP = 0
    val VIEWTYPE_PERSON = 1
    val REQUEST_CODE = 1000

    var alphabet_available: MutableList<String> = ArrayList()

    /*
    This function will sort list by Alphabet
    */
    fun sortList(list: ArrayList<Person>): ArrayList<Person> {
        list.sortWith(Comparator { person1, person2 -> person1!!.name!!.compareTo(person2!!.name!!) })
        return list
    }


    /*
    After sorted , this function will add alphabet character to list
    */
    fun addAlphabets(list: ArrayList<Person>): ArrayList<Person> {
        var i : Int = 0
        val customList = ArrayList<Person>()
        val firstMember = Person()
        firstMember.name = list[0].name!![0].toString() //Get First character
        firstMember.viewType = VIEWTYPE_GROUP // Set viewType in header
        alphabet_available.add(list[0].name!![0].toString()) // Add to available list

        customList.add(firstMember)

        while (i < list.size - 1) {
            val person = Person()

            //Get first character in name
            val name1 = list[i].name!![0]
            val name2 = list[i + 1].name!![0]
            if (name1 == name2) {
                list[i].viewType = VIEWTYPE_PERSON
                customList.add(list[i])
            } else {
                list[i].viewType = VIEWTYPE_PERSON
                customList.add(list[i])
                person.name = name2.toString()
                person.viewType = VIEWTYPE_GROUP
                alphabet_available.add(name2.toString())
                customList.add(person)
            }
            i++
        }
        list[i].viewType = VIEWTYPE_PERSON
        customList.add(list[i])
        return customList
    }

    /*This function will return index of name in list*/
    fun findPositionWithName(name: String, list: ArrayList<Person>): Int {
        for (i in list.indices) {
            if (list[i].name == name) {
                return i
            }
        }
        return -1
    }

    /*This function will generate an Alphabets list A -> Z*/
    fun genAlphabetList(): ArrayList<String> {
        val result = ArrayList<String>()
        for (i in 65..90) { //65 is ASCII CODE = A, 90 = Z
            //val character = i.toChar()
            result.add(i.toChar().toString())
        }
        return result
    }

    /*This function will create an Person group with fake name*/
    fun genPersonGroup(): ArrayList<Person> {

        val personList = ArrayList<Person>()

        var person = Person("Adnan", "Staff", -1)
        personList.add(person)

        person = Person("Atiq", "Staff", -1)
        personList.add(person)

        person = Person("Anondita", "Staff", -1)
        personList.add(person)

        person = Person("Any", "Staff", -1)
        personList.add(person)

        person = Person("Bela", "Staff", -1)
        personList.add(person)

        person = Person("Bristi", "Staff", -1)
        personList.add(person)

        person = Person("Bithi", "Staff", -1)
        personList.add(person)

        person = Person("Billal", "Staff", -1)
        personList.add(person)

        person = Person("Dulal", "Staff", -1)
        personList.add(person)

        person = Person("Dinesh", "Staff", -1)
        personList.add(person)

        person = Person("Chad", "Staff", -1)
        personList.add(person)

        person = Person("Chitra", "Staff", -1)
        personList.add(person)

        person = Person("Choiti", "Staff", -1)
        personList.add(person)

        person = Person("Chinmoy", "Staff", -1)
        personList.add(person)

        person = Person("Hasan", "Staff", -1)
        personList.add(person)

        person = Person("Hemil", "Staff", -1)
        personList.add(person)

        person = Person("Hridoy", "Staff", -1)
        personList.add(person)

        person = Person("Hanif", "Staff", -1)
        personList.add(person)

        person = Person("Shakil", "Staff", -1)
        personList.add(person)

        person = Person("Sumiya", "Staff", -1)
        personList.add(person)

        person = Person("Shanti", "Staff", -1)
        personList.add(person)

        person = Person("Shrabonty", "Staff", -1)
        personList.add(person)

        person = Person("Tanmoy", "Staff", -1)
        personList.add(person)

        person = Person("Tanha", "Staff", -1)
        personList.add(person)

        person = Person("Tania", "Staff", -1)
        personList.add(person)

        person = Person("Trisha", "Staff", -1)
        personList.add(person)

        person = Person("Kamrul", "Staff", -1)
        personList.add(person)

        person = Person("Kamal", "Staff", -1)
        personList.add(person)

        person = Person("Iqram", "Staff", -1)
        personList.add(person)

        person = Person("Iqbal", "Staff", -1)
        personList.add(person)

        person = Person("Nowrin", "Staff", -1)
        personList.add(person)

        person = Person("Nihal", "Staff", -1)
        personList.add(person)

        return personList
    }
}