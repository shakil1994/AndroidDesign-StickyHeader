package com.example.shakil.androidrclgrouplist.Common;

import com.example.shakil.androidrclgrouplist.Model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Common {
    public static final int VIEWTYPE_GROUP = 0;
    public static final int VIEWTYPE_PERSON = 1;
    public static final int RESULT_CODE = 1000;
    public static List<String> alphabet_available = new ArrayList<>();

    /*
    Function to sort person list name by alphabet
    */
    public static ArrayList<Person> sortList(ArrayList<Person> people){
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person person, Person t1) {
                return person.getName().compareTo(t1.getName());
            }
        });
        return people;
    }

    /*
    After sorted , this function will add alphabet character to list
    */
    public static ArrayList<Person> addAlphabets(ArrayList<Person> list){
        int i = 0;
        ArrayList<Person> customList = new ArrayList<>();
        Person firstPosition = new Person();
        firstPosition.setName(String.valueOf(list.get(0).getName().charAt(0)));
        firstPosition.setViewType(VIEWTYPE_GROUP);
        //Add first character to group header list
        alphabet_available.add(String.valueOf(list.get(0).getName().charAt(0)));
        customList.add(firstPosition);

        for (i = 0; i < list.size() - 1; i++){
            Person person = new Person();
            //Get first character in name
            char name1 = list.get(i).getName().charAt(0);
            char name2 = list.get(i).getName().charAt(0);

            if (name1 == name2){
                list.get(i).setViewType(VIEWTYPE_PERSON);
                customList.add(list.get(i));
            }
            else {
                list.get(i).setViewType(VIEWTYPE_PERSON);
                customList.add(list.get(i));
                person.setName(String.valueOf(name2));
                person.setViewType(VIEWTYPE_GROUP);
                alphabet_available.add(String.valueOf(name2));
                customList.add(person);
            }
        }

        list.get(i).setViewType(VIEWTYPE_PERSON);
        customList.add(list.get(i));
        return customList;
    }

    /*This function with return position of string in list*/
    public static int findPositionWithName(String name, ArrayList<Person> list){
        for(int i = 0; i < list.size(); i++){
            if (list.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1; // -1 if not found
    }

    /*This function will generate an Alphabets list*/
    public static ArrayList<String> getAlphabet(){
        ArrayList<String> result = new ArrayList<>();
        for (int i = 65; i <= 90; i++){
            char character = (char) i;
            result.add(String.valueOf(character));
        }
        return result;
    }

    /*This function will create an Person group with random name*/
    public static ArrayList<Person> genPeopleGroup() {
        ArrayList<Person> personList = new ArrayList<>();

        Person person = new Person("Adnan", "Staff", -1);
        personList.add(person);

        person = new Person("Atiq", "Staff", -1);
        personList.add(person);

        person = new Person("Anondita", "Staff", -1);
        personList.add(person);

        person = new Person("Any", "Staff", -1);
        personList.add(person);

        person = new Person("Bela", "Staff", -1);
        personList.add(person);

        person = new Person("Bristi", "Staff", -1);
        personList.add(person);

        person = new Person("Bithi", "Staff", -1);
        personList.add(person);

        person = new Person("Billal", "Staff", -1);
        personList.add(person);

        person = new Person("Dulal", "Staff", -1);
        personList.add(person);

        person = new Person("Dinesh", "Staff", -1);
        personList.add(person);

        person = new Person("Chad", "Staff", -1);
        personList.add(person);

        person = new Person("Chitra", "Staff", -1);
        personList.add(person);

        person = new Person("Choiti", "Staff", -1);
        personList.add(person);

        person = new Person("Chinmoy", "Staff", -1);
        personList.add(person);

        person = new Person("Hasan", "Staff", -1);
        personList.add(person);

        person = new Person("Hemil", "Staff", -1);
        personList.add(person);

        person = new Person("Hridoy", "Staff", -1);
        personList.add(person);

        person = new Person("Hanif", "Staff", -1);
        personList.add(person);

        person = new Person("Shakil", "Staff", -1);
        personList.add(person);

        person = new Person("Sumiya", "Staff", -1);
        personList.add(person);

        person = new Person("Shanti", "Staff", -1);
        personList.add(person);

        person = new Person("Shrabonty", "Staff", -1);
        personList.add(person);

        person = new Person("Tanmoy", "Staff", -1);
        personList.add(person);

        person = new Person("Tanha", "Staff", -1);
        personList.add(person);

        person = new Person("Tania", "Staff", -1);
        personList.add(person);

        person = new Person("Trisha", "Staff", -1);
        personList.add(person);

        person = new Person("Kamrul", "Staff", -1);
        personList.add(person);

        person = new Person("Kamal", "Staff", -1);
        personList.add(person);

        person = new Person("Iqram", "Staff", -1);
        personList.add(person);

        person = new Person("Iqbal", "Staff", -1);
        personList.add(person);

        person = new Person("Nowrin", "Staff", -1);
        personList.add(person);

        person = new Person("Nihal", "Staff", -1);
        personList.add(person);

        return personList;
    }
}
