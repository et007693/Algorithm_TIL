class Solution {
    public long solution(int price, int money, int count) {
        long tmp = 0;
        for (int i=1; i<=count; i++) {
            tmp += price*i;
        }
        
        if (tmp > money) {
            return tmp - money;
        } else {
            return 0;
        }
    }
}