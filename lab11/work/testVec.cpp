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

int main()
{
    vector<int> v = readVals();
    printVals(v);
}

