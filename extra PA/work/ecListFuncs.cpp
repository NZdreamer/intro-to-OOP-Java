/*  Name:
 *  USC NetID:
 *  CS 455 Sping 2021
 *
 *  See ecListFuncs.h for specification of each function.
 *
 *  NOTE: remove the print statements below as you implement each function
 *  or you will receive no credit for that function
 *
 */

#include <string>
#include <cassert>

// for istringstream
#include <sstream>

// iostream only needed for the "not implemented yet" messages in starter code
#include <iostream>

#include "ecListFuncs.h"

using namespace std;

// *********************************************************
// Node constructors: do not change
Node::Node(int item) { 
   data = item;
   next = NULL;
}

Node::Node(int item, Node *n) {
   data = item;
   next = n;
}
// *********************************************************


ListType buildList(const string & listString) {

   cout << "*** WARNING: buildList has not been implemented yet. ***" << endl;
   return NULL;  // stub code to get it to compile
}


string listToString(ListType list) {

   cout << "*** WARNING: listToString has not been implemented yet. ***" << endl;
   return "";  // stub code to get it to compile
}


void removeLastInstance(ListType & list, int target) {

   cout << "*** WARNING: removeLastInstance has not been implemented yet. ***" << endl;
}


void splitAtIndex(ListType &list, int index, ListType &a, ListType &b) {

   assert(index >= 0);
   a = NULL;
   b = NULL;

   cout << "*** WARNING: splitAtIndex has not been implemented yet. ***" << endl;
}

