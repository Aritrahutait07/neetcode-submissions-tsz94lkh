class Solution {
public:
    double myPow(double x, int n) {
        if(n==0) return 1;
        if(n==1) return x;
        if(n%2==0){
            double ans = myPow(x,n/2) * myPow(x,n/2);
            return ans;
        }else if(n%2!=0 && n>0){
            double ans = x * myPow(x,n/2) * myPow(x,n/2);
            return ans;
        }else{
            double ans = 1/x * myPow(x,n/2) * myPow(x,n/2);
            return ans;
        }
    }
};
