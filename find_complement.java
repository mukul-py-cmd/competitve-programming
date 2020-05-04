class Solution {
    public int findComplement(int num) {
        if (num == 0)
            return 1;
        int bits = (int)(Math.log(num)/Math.log(2)) +1;
        long c = (long)Math.pow(2,bits) -1;
        System.out.print(c);
        return (int)((c) ^ (long)num);
    }
}