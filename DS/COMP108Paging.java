//
// Coded by Prudence Wong 2021-12-29
// Updated 2023-02-25
//
// NOTE: You are allowed to add additional methods if you need.
//
// Name:
// Student ID:
//
// Time Complexity and explanation: You can use the following variables for easier reference.
// n denotes the number of requests, p denotes the size of the cache
// n and p can be different and there is no assumption which one is larger
//
// noEvict(): The worst case complexity here would be O(np), where every time is a miss. Here we have to traverse the entire cache(p) to find that there is no hit.
//
// evictLRU(): The worst case complexity here would be O(np), in the case where every time last element gets requested. This would be the complexity where everytime we have a new element request(which means every request is a miss).
//
//

class COMP108Paging {

    // no eviction
    // Aim:
    // do not evict any page
    // count number of hit and number of miss, and find the hit-miss pattern; return
    // an object COMP108PagingOutput
    // Input:
    // cArray is an array containing the cache with cSize entries
    // rArray is an array containing the requeset sequence with rSize entries
    static COMP108PagingOutput noEvict(int[] cArray, int cSize, int[] rArray, int rSize) {
        COMP108PagingOutput output = new COMP108PagingOutput();

        for (int j, i = 0; i < rSize; i++) {
            for (j = 0; j < cSize; j++) {
                if (cArray[j] == rArray[i]) {
                    output.hitCount++;
                    output.hitPattern += "h";
                    break;
                }
            }
            if (j == cSize) {
                output.missCount++;
                output.hitPattern += "m";
            }
        }
        output.cache = arrayToString(cArray, cSize);
        return output;
    }

    // evict LRU
    // Aim:
    // if a request is not in cache, evict the page that hasn't been used for the
    // longest amount of time
    // count number of hit and number of miss, and find the hit-miss pattern; return
    // an object COMP108PagingOutput
    // Input:
    // cArray is an array containing the cache with cSize entries
    // rArray is an array containing the requeset sequence with rSize entries
    static COMP108PagingOutput evictLRU(int[] cArray, int cSize, int[] rArray, int rSize) {
        COMP108PagingOutput output = new COMP108PagingOutput();

        int[] array = new int[cSize];
        for (int i = -cSize; i < 0; i++) {
            array[i + cSize] = i;
        }

        for (int j, i = 0; i < rSize; i++) {
            for (j = 0; j < cSize; j++) {
                if (cArray[j] == rArray[i]) {
                    output.hitCount++;
                    output.hitPattern += "h";
                    array[j] = i;
                    break;
                }
            }
            if (j == cSize) {
                output.missCount++;
                output.hitPattern += "m";
                int k = 0;
                for (j = 0; j < cSize; j++) {
                    if (array[j] < array[k])
                        k = j;
                }
                array[k] = i;
                cArray[k] = rArray[i];
            }
        }

        output.cache = arrayToString(cArray, cSize);
        return output;
    }

    // Assume that size is always sufficient.
    static class Queue {
        int[] array;
        int front = 0, rear = -1;

        public Queue(int n) {

        }

        public int pop() {
            if (front + 1 == 2048) {
                front = 0;
                return array[2048 - 1];
            } else {
                return array[front++];
            }
        }

        public void push(int x) {
            if (rear + 1 == 2048) {
                rear = 0;
                array[rear] = x;
            } else {
                array[++rear] = x;
            }
        }
    }

    // DO NOT change this method
    // this will turn the cache into a String
    // Only to be used for output, do not use it to manipulate the cache
    static String arrayToString(int[] array, int size) {
        String outString = "";

        for (int i = 0; i < size; i++) {
            outString += array[i];
            outString += ",";
        }
        return outString;
    }

}
