#include<stdio.h>
#include<list>
#include<vector>
#define INF 1e9
using namespace std;

int main(){
    int n,m;
    scanf("%d %d",&n,&m);
    if(m<=n) return 0&printf("%d\n",n-m);
    vector<int> d(2*m+5,INF);
    list<int> q;q.push_back(n);d[n]=0;
    while(!q.empty()){
        int e = q.front();
        q.pop_front();
        if(e>=0) q.push_back(e-1),d[e-1]=(d[e-1]==INF)?d[e]+1:d[e-1];
        if(e<=m) q.push_back(2*e),d[2*e]=(d[2*e]==INF)?d[e]+1:d[2*e];
        if(e==m) return 0&printf("%d\n",d[m]);
    }
    return 0;
}
