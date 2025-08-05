class Solution {
    public double check(int[][] sq, double line) {
        double above = 0;
        double below = 0;
        for (int[] i : sq) {
            int y = i[1];
            int l = i[2];
            double tot = (double) l * l;
            if (y >= line) {
                above += tot;
            } else if (y + l <= line) {
                below += tot;
            } else {
                double ab = (y + l - line) * l;
                double be = (line - y) * l;
                above += ab;
                below += be;
            }
        }
        return above - below;
    }

    public double separateSquares(int[][] squares) {
        double left = 0;
        double right = 2 * 1e9;
        double res = 0;
        for (int i = 0; i < 60; i++) {
            double mid = (left + right) / 2.0;
            if (check(squares, mid) > 0 ) {
                res = Math.min(res,mid);
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
