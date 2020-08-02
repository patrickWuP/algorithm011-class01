class Solution_860 {
    public boolean lemonadeChange(int[] bills) {
        int five, ten;
        
        for (int data : bills) {
            if (data == 5) five++;
            if (data == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            }
            if (data == 20) {
                if (ten > 0) {
                    if (five == 0) return false;
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five = five - 3; 
                } else {
                    return false;
                }
                
            }
        }
        return true;
    }
}