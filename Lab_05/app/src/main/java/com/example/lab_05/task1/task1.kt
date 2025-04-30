package com.example.lab_05.task1

// Person-related classes
open class Person(val name: String, val id: String)

class User(_name: String, _id: String, val job: String) : Person(_name, _id)

class Librarian(_name: String, _id: String, val password: String) : Person(_name, _id)

// Library item hierarchy
abstract class LibraryItem( val title: String, val ISBN: String, val publications: String, val numOfPages: Int) {
    var available: Boolean = true
    abstract fun isAvailable(): Boolean
}

class Book(_title: String, _ISBN: String, _pub: String, _numOfPages: Int) : LibraryItem(_title, _ISBN, _pub, _numOfPages) {

    override fun isAvailable(): Boolean {
        return available
    }
}

class Journal(_title: String, _ISBN: String, _pub: String, _numOfPages: Int) : LibraryItem(_title, _ISBN, _pub, _numOfPages) {
    override fun isAvailable(): Boolean = available
}

class Magazine(_title: String, _ISBN: String, _pub: String, _numOfPages: Int) : LibraryItem(_title, _ISBN, _pub, _numOfPages) {
    override fun isAvailable(): Boolean = available
}

// Library database
class LibraryDataBase {
    val currLibrarian = Librarian("Soaad", "86731", "123")
    val listOfLibraryItems = mutableListOf<LibraryItem>()
    val users = mutableListOf<User>()
    val listOfBorrowedBooks = mutableMapOf<Book, String>()

    fun addBook(_book: Book) {
        _book.available = true
        listOfLibraryItems.add(_book)
    }

    fun lendBook(_book: Book, userId: String) {
        if (_book.isAvailable()) {
            _book.available = false
            listOfBorrowedBooks[_book] = userId
            println("Success")
        } else {
            println("Failed")
        }
    }

    fun receiveBookFromBorrower(_book: Book, userId: String) {
        if (listOfBorrowedBooks[_book] == userId) {
            _book.available = true
            listOfBorrowedBooks.remove(_book)
            println("Success")
        } else {
            println("Failed")
        }
    }

    fun viewAvailableBooks() {
        val availableBooks = listOfLibraryItems.filterIsInstance<Book>().filter { it.isAvailable() }
        if (availableBooks.isEmpty()) {
            println("No books available!")
        } else {
            for (book in availableBooks) {
                println("Book: ${book.title}, ISBN: ${book.ISBN}, Published by: ${book.publications}, Pages: ${book.numOfPages}")
            }
        }
    }

    fun searchForABook(_key: String): Book? {
        return listOfLibraryItems.filterIsInstance<Book>().find { it.ISBN == _key && it.isAvailable() }
    }

    fun getBookByISBN(_key: String): Book? {
        return listOfLibraryItems.filterIsInstance<Book>().find { it.ISBN == _key }
    }

    fun registerNewUser(userId: String) {
        println("Enter user name:")
        val userName = readln()
        println("Enter user job:")
        val userJob = readln()

        users.add(User(userName, userId, userJob))

        println("User $userName with ID $userId was added successfully!")
    }
}

// Main function with menu
fun main() {
    val db = LibraryDataBase()

    nameloop@ while (true) {
        println("Enter your admin name: ")
        val name = readlnOrNull()

        if (name.isNullOrBlank() || name != db.currLibrarian.name) {
            println("Enter a valid name!")
        } else {
            passloop@ while (true) {
                println("Enter your password: ")
                val pass = readlnOrNull()
                if (pass.isNullOrBlank() || pass != db.currLibrarian.password) {
                    println("Enter a valid password!")
                } else {
                    println("Login successful. Welcome ${db.currLibrarian.name}!")

                    commandloop@ while (true) {
                        println("1. Add Book \n2. View Available Books \n3. Search for a Book \n4. Lend Book \n5. Receive Book \n6. Exit")

                        when (readlnOrNull()) {
                            "1" -> {
                                println("Enter title:")
                                val title = readlnOrNull() ?: ""
                                println("Enter ISBN:")
                                val isbn = readlnOrNull() ?: ""
                                println("Enter publication:")
                                val pub = readlnOrNull() ?: ""
                                println("Enter number of pages:")
                                val pages = readlnOrNull()?.toIntOrNull() ?: 0

                                val newBook = Book(title, isbn, pub, pages)
                                db.addBook(newBook)
                                println("Book '$title' added.")
                            }

                            "2" -> db.viewAvailableBooks()

                            "3" -> {
                                println("Enter ISBN to search:")
                                val isbn = readlnOrNull() ?: ""
                                val found = db.searchForABook(isbn)
                                if (found != null) {
                                    println("Found: ${found.title}, ISBN: ${found.ISBN}")
                                } else {
                                    println("No books found with that ISBN!")
                                }
                            }

                            "4" -> {
                                println("Enter user ID:")
                                val userId = readlnOrNull()
                                if (userId.isNullOrBlank()) {
                                    println("Invalid ID!")
                                }
                                else {
                                    if (db.users.find { it.id == userId } == null) {
                                        db.registerNewUser(userId)
                                    }

                                    db.viewAvailableBooks()
                                    println("Enter ISBN of the book to lend:")
                                    val lendISBN = readlnOrNull() ?: ""
                                    val bookToLend = db.getBookByISBN(lendISBN)

                                    if (bookToLend != null) {
                                        db.lendBook(bookToLend, userId)
                                    } else {
                                        println("Book not found.")
                                    }
                                }
                            }

                            "5" -> {
                                println("Enter user ID:")
                                val userId = readlnOrNull()
                                if (userId.isNullOrBlank()) {
                                    println("Invalid ID!")
                                }
                                else {
                                    if (db.users.find { it.id == userId } == null) {
                                        println("No users found with this ID!")
                                    }
                                    else {
                                        println("Enter ISBN of the book to return:")
                                        val returnISBN = readlnOrNull() ?: ""
                                        val returnedBook = db.getBookByISBN(returnISBN)

                                        if (returnedBook != null) {
                                            db.receiveBookFromBorrower(returnedBook, userId)
                                        } else {
                                            println("No such borrowed book found")
                                        }
                                    }
                                }
                            }

                            "6" -> {
                                println("A D I O S")
                                break@nameloop
                            }

                            else -> println("INVARG! Try Again!")
                        }
                    }
                }
            }
        }
    }
}
