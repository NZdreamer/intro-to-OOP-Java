// Name: Yufei Lu
// USC NetID: yufeilu
// CSCI 455 PA5
// Spring 2021

// Table.cpp  Table class implementation


#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>

// for hash function called in private hashCode method defined below
#include <functional>

using namespace std;


// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"


//*************************************************************************


Table::Table() {
   hashSize = HASH_SIZE;
   table = new ListType[HASH_SIZE];
}


Table::Table(unsigned int hSize) {
   hashSize = hSize;
   table = new ListType[hSize];
}


int * Table::lookup(const string &key) {
   int hc = hashCode(key);
   ListType nodeFound = find(table[hc], key);
   if (nodeFound == NULL) {
      return NULL;
   }
   else {
      return &(nodeFound->value);
   }
}


bool Table::remove(const string &key) {
   int hc = hashCode(key);
   return removeKey(table[hc], key);
}


bool Table::insert(const string &key, int value) {
   int hc = hashCode(key);
   return insertFront(table[hc], key, value);
}


int Table::numEntries() const {
   int num = 0;
   for (int i = 0; i < hashSize; i++) {
      num += getNum(table[i]);
   }
   return num;
}


void Table::printAll() const {
   for (int i = 0; i < hashSize; i++) {
      printList(table[i]);
   }
}


void Table::hashStats(ostream &out) const {
   out << "number of buckets: " << hashSize << endl;
   out << "number of entries: " << numEntries() << endl;
   int nonEmptyNum = 0;
   int longestChain = 0;
   for (int i = 0; i < hashSize; i++) {
      if (getNum(table[i]) != 0) {
         nonEmptyNum++;
         if (getNum(table[i]) > getNum(table[longestChain])) {
            longestChain = i;
         }
      }
   }
   out << "number of non-empty buckets: " << nonEmptyNum << endl;
   out << "longest chain: " << longestChain << endl;
}


// hash function for a string
// (we defined it for you)
// returns a value in the range [0, hashSize)
unsigned int Table::hashCode(const string &word) const {

   // Note: calls a std library hash function for string (it uses the good hash
   //   algorithm for strings that we discussed in lecture).
   return hash<string>()(word) % hashSize;

}


// add definitions for your private methods here

