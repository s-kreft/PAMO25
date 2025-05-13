package com.example.bmiapp

fun main() {

    /**
     * #1 Complete the code to make the program print "Mary is 20 years old" to standard output:
     */
    fun exercise1() {
        val name = "Mary"
        val age = 20

        println("$name is $age years old")
    }

    /**
     * #2 Explicitly declare the correct type for each variable:
     */
    fun exercise2() {
        val a: Int = 1000
        val b: String = "log message"
        val c: Double = 3.14
        val d: Long = 100_000_000_000_000
        val e: Boolean = false
        val f: Char = '\n'
    }

    /**
     * #3 You have a list of “green” numbers and a list of “red” numbers.
     * Complete the code to print how many numbers there are in total.
     */
    fun exercise3() {
        val greenNumbers = listOf(1, 4, 23)
        val redNumbers = listOf(17, 2)
        println(greenNumbers.count() + redNumbers.count())
    }

    /**
     * #4 You have a set of protocols supported by your server. A user requests to use a particular protocol.
     * Complete the program to check whether the requested protocol
     * is supported or not (isSupported must be a Boolean value).
     */
    fun exercise4() {
        val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
        val requested = "smtp"
        val isSupported = requested.uppercase();
        println("Support for $requested: $isSupported")
    }

    /**
     * #5 Define a map that relates integer numbers from 1 to 3 to their corresponding spelling.
     * Use this map to spell the given number.
     */
    fun exercise5() {
        val number2word = mapOf(1 to "one", 2 to "two", 3 to "three");
        val n = 2
        println("$n is spelt as '${number2word[2]}'")
    }
    /***
     * #6 Using a when expression, update the following program so that when you input the names of GameBoy buttons,
     * the actions are printed to output
     */
    fun exercise6() {
        val button = "A"
        println(when (button) { "A" -> "Yes" "B" -> "No" "X" -> "Menu" "Y" -> "Nothing" else -> "There is no such button" }
        )
    }

    /**
     * #7 Define a data class Employee with two properties: one for a name, and another for a salary. Make sure that the
     * property for salary is mutable, otherwise you won’t
     * get a salary boost at the end of the year! The main function demonstrates how you can use this data class.
     */
    fun exercise7() {
        data class Employee(val name: String, var salary: Int)

        val emp = Employee("Mary", 20)
        println(emp)
        emp.salary += 10
        println(emp)
    }
    /**
     * #8 You have a list of words. Use for and if to print only the words that start with the letter l.
     */
    fun exercise8() {
        val words = listOf("dinosaur", "limousine", "magazine", "language")
        for (w in words) { if (w.startsWith("l")) println(w) }
    }

    /**
     * #9 You have a list of actions supported by a web service, a common prefix for all requests, and an ID of a particular
     * resource. To request an action title over the
     * resource with ID: 5, you need to create the following URL: https://example.com/book-info/5/title.
     * Use a lambda expression to create a list of URLs from the list of
     * actions.
     */
    fun exercise9() {
        val actions = listOf("title", "year", "author")
        val prefix = "https://example.com/book-info"
        val id = 5
        val urls = actions.map { action
            -> "$prefix/$id/$action" }
        println(urls)
    }

    /**
     * #10 Write a function that takes an Int value and an action (a function with type () -> Unit) which then repeats the action
     * the given number of times. Then use this function
     * to print “Hello” 5 times.
     */
    fun exercise10() {
        fun repeatN(n: Int, action: () -> Unit) {
            for (i in 1..n) { action() }
        }
        repeatN(5) { println("Hello") }
    }

    /**
     * #11 Using a when expression, update the following program so
     * that it prints the corresponding actions when you input the names of game console buttons.
     * Button Action
     * A Yes
     * B No
     * X Menu
     * Y Nothing
     * Other There is no such button
     */
    fun exercise11() {
        val button = "A"
        println (when (button) {
            "A" -> "Yes"
            "B" -> "No"
            "X" -> "Menu"
            "Y" -> "Nothing"
            else -> "There is no such button"
        })
                }

    /**
     * #12 You have a program that counts pizza slices until there’s a whole pizza with 8 slices. Refactor this program in two ways:
     * Use a while loop.
     * Use a do-while loop.
     */
    fun exercise12() {
        var pizzaSlices = 0
        pizzaSlices++
        do {
            println("There's only $pizzaSlices slice/s of pizza :(")
            pizzaSlices++
        } while (pizzaSlices < 8)
        println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
    }
}