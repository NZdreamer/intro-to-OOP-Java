#include <iostream>
#include <vector>
using namespace std;

vector<int> readVals() {
    vector<int> v;
    int val;
    while (cin >> val) {
        v.push_back(val);
    }
   return v;

}

void printVals(vector<int> v) {
    for (vector<int>::size_type i = 0; i < v.size(); i++) {
        cout << v[i] << " ";
    }
    cout << endl;
}

// returns a vector of values from v that are greater than 0
// these values are in the same relative order as they are in v.
vector<int> valsGT0(vector<int> v) {
    vector<int> filted;
    for (vector<int>::size_type i = 0; i < v.size(); i++) {
        if (v[i] > 0) {
            filted.push_back(v[i]);
        }
    }
    return filted;
}

/**
 * returns location of last instance of target in v or -1 if not found
 */ 
int findLast(vector<int> v, int target) {
    for (vector<int>::size_type i = v.size() - 1; i >= 0; i--) {
        if (v[i] == target) {
            return i;
        }
    }
    return -1;
}

void testFindLast(vector<int> v, int target) {
    cout << "The last instance of " << target << " is at position " << findLast(v, target) << endl;
}

int main()
{
    vector<int> v = readVals();
    cout << "Vector: ";
    printVals(v);
    vector<int> filted = valsGT0(v);
    //printVals(filted);

    int target = 1;
    testFindLast(v, target);
}

