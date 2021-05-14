// Name: Yufei Lu
// USC NetID: yufeilu
// CSCI 455 PA5
// Spring 2021


#include <iostream>

#include <cassert>

#include "listFuncs.h"

using namespace std;

Node::Node(const string &theKey, int theValue) {
   key = theKey;
   value = theValue;
   next = NULL;
}

Node::Node(const string &theKey, int theValue, Node *n) {
   key = theKey;
   value = theValue;
   next = n;
}

//*************************************************************************
// put the function definitions for your list functions below

// initiate a empty list
void initList(ListType &list) {
   list = NULL;
}

/**
 * insert a Node into list from front, return false if key already exist
 */
bool insertFront(ListType &list, const string & key, int value) {
   if (hasKey(list, key)) {
      return false;
   }
   Node* p = new Node(key, value, list);
   list = p;
   return true;
}

/*
* whether the list contains the key
*/
bool hasKey(ListType & list, const string & key) {
   if (list == NULL) {
      return false;
   }
   ListType p = list;

   while (p != NULL) {
      if (p->key == key) {
          return true;
      }
      p = p->next;
   }
   return false;
   
}

/**
 * find the key in the list, return the pointer to that node
 */
ListType find(ListType & list, const string & key) {
   if (!hasKey(list, key)) {
      return NULL;
   }
   else if (list == NULL) {
      return NULL;
   }
   else {
      ListType p = list;
      while (p != NULL) {
         if (p->key == key) {
            return p;
         }
        p = p->next;
      }
   }
    return NULL;
}

/*
* remove the node by key from list, return false iff key is not contained
*/
bool removeKey(ListType & list, const string & key) {
   if (!hasKey(list, key)) {
      return false;
   }
   ListType p = list;
   if (p->next == NULL) {
      delete p;
      list = NULL;
      return true;
   }
   if (p->key == key) {
      Node * deadGuy = p;
      list = p->next;
      delete deadGuy;
      return true;
   }
   while (p->next != NULL) {
      if (p->next->key == key) {
         Node * deadGuy = p->next;
         p->next = p->next->next;
         delete deadGuy;
         return true;
      }
   }
   return false;
}

// print the all element in the list in a form: 
//key1 value1
//key2 value2
void printList(const ListType & list) {
   if (list != NULL) {
      ListType p = list;
      while (p->next != NULL) {
         cout << p->key << " " << p->value << endl;
         p = p->next;
      }
      cout << p->key << " " << p->value << endl;
   }
}

// get the number of pairs in the list
int getNum(const ListType list) {
   if (list == NULL) {
      return 0;
   }
   ListType p = list;
   int num = 1;
   while (p->next != NULL) {
      num++;
      p = p->next;
   }
   return num;
}

