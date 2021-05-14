// Name:
// USC NetID:
// CS 455 PA5
// Spring 2021

// pa5list.cpp
// a program to test the linked list code necessary for a hash table chain

// You are not required to submit this program for pa5.

// We gave you this starter file for it so you don't have to figure
// out the #include stuff.  The code that's being tested will be in
// listFuncs.cpp, which uses the header file listFuncs.h

// The pa5 Makefile includes a rule that compiles these two modules
// into one executable.

#include <iostream>
#include <string>
#include <cassert>

using namespace std;

#include "listFuncs.h"


void testEmpty() {
   ListType empty;
   initList(empty);
   cout << "an empty list: ";
   printList(empty);
   cout << endl;
      cout << "find a in empty list: " << find(empty, "a") << endl;
   cout << "remove a from empth list " << removeKey(empty, "a") << endl;

}


int main() {
testEmpty();

   ListType list;
   initList(list);
   cout << "an empty list: " ;
   printList(list);
    cout << "find a in empty list: " << find(list, "a") << endl;

   insertFront(list, "a", 1);
   printList(list);
    cout << insertFront(list, "b", 2);
   printList(list);
   cout << "has b? " << hasKey(list, "b") << endl;
   cout << "has a ? " << hasKey(list, "a") << endl;
   cout << "has c ? " << hasKey(list, "c") << endl;
    cout << "insert b ? " << insertFront(list, "b", 3) << endl;
   printList(list);
   cout << "list num = " << getNum(list) << endl;
    cout << "find a : " << find(list, "a") << endl;
    cout << "find c : " << find(list, "c") << endl;
    insertFront(list, "c", 3);
    printList(list);

    cout << "list num = " << getNum(list) << endl;
    cout << "remove b: " << removeKey(list, "b") << endl;
    printList(list);
   cout << "remove c : " << removeKey(list, "c") << endl;
    printList(list);
    cout << "remove a : " << removeKey(list, "a") << endl;
    printList(list);


   return 0;
}
