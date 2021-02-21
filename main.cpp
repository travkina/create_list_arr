#include <stdlib.h>
#include <iostream>
#include <list>
#include <vector>
#include <set>
#include <cctype>

using namespace std;

//компаратор для сортировки по убыванию 
bool compare_nocase (const int& a, const int& b)
{
    return a > b;
}

int main()
{
    set <int> sizeArrays;
    list<int> L;
    list<int>::iterator it;
    int sizeList;
    int sizeArr;
    bool checkUnq;
    
    do {
    	cout << "Enter list size: ";
    	cin >> sizeList;
    } while (sizeList == 0);
     
    vector <list<int>> arrList(sizeList);
     
    for (int i=0; i<sizeList; i++){
    	// Каждый массив имеет случайный размер
	// Размеры массивов не должны совпадать
	do {
	    sizeArrays.insert(rand() % 100 + 1);
	} while (sizeArrays.size() < sizeList);
    };
    set <int> :: iterator itSizeArray = sizeArrays.begin();
    //сгенерировать n-массивов
    for(int i=0;i<sizeList;i++){
        if (L.empty()) {
            //заполнить массивы случайными числами
            for(int j = 0;j<*itSizeArray;j++){
                L.push_back(rand() % 1000 + 1);
            }
            itSizeArray++;
            if ((i+1)%2 == 0) L.sort();
            else  L.sort(compare_nocase);
            arrList.at(i) = L; 
        }
        L.clear();
    }
    for(int i=0; i<sizeList; i++){
        L = arrList[i];
        cout << "[" << (i+1) << "]: ";
        for(it = L.begin(); it != L.end(); it++)
            cout << (*it) << " ";
            cout << "\n" << endl;
    }

    L.clear();
    arrList.clear();
    sizeArrays.clear();
    
    return 0;
}

