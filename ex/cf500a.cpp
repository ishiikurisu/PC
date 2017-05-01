#include<stdio.h>
#include<vector>
#include<list>
#define INF 1e9
using namespace std;

int main(){
    int n,t;
    scanf("%d %d",&n,&t);
    t--;
    vector<vector<int>> g(n,vector<int>());
    for(int i=0;i<n-1;++i){
        int a;
        scanf("%d",&a);
        g[i].push_back(i+a);
    }
    list<int> q;
    vector<int> d(n,INF);
    q.push_back(0),d[0]=0;
    while(!q.empty()){
        auto front = q.front();
        q.pop_front();
        for(int i=0;i<g[front].size();++i){
            d[g[front][i]]=d[front]+1;
            q.push_back(g[front][i]);
        }
    }
    if(d[t]==INF) printf("NO\n"); else printf("YES\n");
    return 0;
}
