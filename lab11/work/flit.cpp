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

int main()
{
    vector<int> v = readVals();
    cout << "Vector: ";
    printVals(v);
    cout << "Filtered vector: ";
    vector<int> filted = valsGT0(v);
    printVals(filted);
    cout << "Original vector: ";
    printVals(v);
}

