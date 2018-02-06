// BookController.aidl
package com.xy.aidl_server;

import com.xy.aidl_server.Book;
// Declare any non-default types here with import statements

interface BookController {

    List<Book> getBoolList();

    void addBookInOut(inout Book book);

}
