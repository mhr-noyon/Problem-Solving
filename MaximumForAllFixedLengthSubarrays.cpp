#include <bits/stdc++.h>
using namespace std;

#define endl "\n"
#define ll long long

void file(){
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
    freopen("error.txt","w",stderr);
}

bool isPrime(int n){
    if(n<2) return false;
    if(n==2) return true;
    for(int i=2;i*i<=n;i++){
        if(n%i==0) return false;
    }
    return true;
}
void sieve(){
    vector<int> isPrime();
}
// void solve(){
//     for(int i=1;i<=100000;i++){
//         int x = i;
//         cerr<<"\nFor: "<<i<<": ";
//         int c = 0;
//         for(int j=2;j*j<=i;j++){
//             if(x%j==0){
//                 while(x%j==0){
//                     x /= j;
//                 }
//                 c++;
//                 cerr<<j<<" ";
//             }
//         }   
//         if(x>1){
//             cerr<<x<<" ";
//             c++;
//         }
//         cout<<i<<": "<<c<<endl;
//     }
// }

void solve(){
    int n, k;
    cin>>n>>k;
    vector<int> v(n);
    for(int i=0;i<n;i++) cin>>v[i];
    deque<int> dq;
    int mx = v[0];
    dq.push_back(0);
    for(int i=1;i<k;i++){
        int ind = dq.back();
        while(v[ind]<v[i]){
            dq.pop_back();
            if(dq.empty()) break;
            ind = dq.back();
        }
        dq.push_back(i);
        mx = max(mx, v[i]);
    }
    cout<<mx<<endl;

    for(int i=k;i<n;i++){
        int ind = dq.back();
        while(v[ind]<v[i]){
            dq.pop_back();
            if(dq.empty()) break;
            ind = dq.back();
        }
        dq.push_back(i);
        mx = max(mx, v[i]);
        cout<<mx<<endl;
    }
}
int main(){
    file();

    int _T = 1;
    cin>>_T;
    for(int i=1;i<=_T;i++){
        // cout<<"Case "<<i<<": ";
        cerr<<"\n\nCase "<<i<<": \n";
        solve();
    }
    return 0;
}
