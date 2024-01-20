#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

int main() {
    int n, i, a[10000], c = 0, z = 0, l, r, k;
    cin >> n >> k;

    // Read input array and count negative numbers (c) and remember the last negative index (z)
    for (i = 0; i < n; i++) {
        cin >> a[i];
        if (a[i] < 0) {
            z = i;
            c++;
        }
    }

    int ans = INT_MAX;

    // Case 1: If all elements are non-negative
    if (c == 0) {
        ans = a[0];
        for (i = 0; i < k - 1; i++) {
            ans += abs(a[i] - a[i + 1]);
        }
    }
    // Case 2: If all elements are negative
    else if (c == n) {
        ans = abs(a[n - 1]);
        for (i = n - 1; i >= k - 1; i--) {
            ans += abs(a[i] - a[i - 1]);
        }
    }
    // Case 3: Mixed positive and negative elements
    else {
        l = max(0, z - k + 1);
        r = min(n - 1, z + k);

        // Iterate through possible subarrays
        for (int i = l; i + k <= r; i++) {
            int ll = i, rr = i + k;
            int s1 = a[z + 1];

            // Calculate the total time to light candles moving to the right
            for (int j = z + 1; j < rr - 1; j++) {
                s1 += abs(a[j] - a[j + 1]);
            }
            s1 = s1 * 2;
            s1 += abs(a[z]);

            // Calculate the total time to light candles moving to the left
            for (int j = z; j > ll; j--) {
                s1 += abs(a[j] - a[j - 1]);
            }

            int s2 = abs(a[z]);

            // Calculate the total time to light candles moving to the left
            for (int j = z; j > ll; j--) {
                s2 += abs(a[j] - a[j - 1]);
            }
            s2 = s2 * 2;
            s2 += abs(a[z]);

            // Calculate the total time to light candles moving to the right
            for (int j = z + 1; j < rr - 1; j++) {
                s2 += abs(a[j] - a[j + 1]);
            }

            // Choose the minimum time among the two directions
            ans = min(min(s1, s2), ans);
        }
    }

    cout << ans << endl;

    return 0;
}
