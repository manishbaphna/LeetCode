

/*

Maximize bankruptcy
A finance company is carrying out a study on the worst stock investments and would like to acquire a program to do so. The program must be able to analyze a chronological series of stock values in order to show the largest loss that it is possible to make by buying a share at a given time and selling it at a later date. The loss will be expressed as the difference between the two values. If there is no loss, it will be considered 0.

You will receive a list as input, containing the stock values arranged in order, from the date of their introduction to the last known value. The values are integers.

You must return the maximal loss p, expressed negatively if there is a loss, otherwise 0.

The list can be of significant size (up to 100000 elements). Each value is an integer between 0 and 2^31.

Example
stock_prices = (3, 2, 4, 2, 1, 5)

The function must return -3.
 */

class StockPriceLoss {

    static int maxLoss(int[] arr){

        if (arr.length <= 1)
            return 0;
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = arr[0];
        int loss = 0;

        for (int i=1;i <arr.length; ++i) {
            minPrice = arr[i];
            if ( maxPrice - minPrice < 0 )
                maxPrice = arr[i];
            else {
                loss = Math.max( loss, maxPrice - minPrice);
            }
        }

        return -loss;
    }

    public static void main(String[] args) {
        int loss = maxLoss(new int[] {3,2,4,1,1,5});  // -3
        System.out.println(maxLoss(new int[] {1,2,3})); //0
        System.out.println(maxLoss(new int[] {4,3,2}));  // -2
        System.out.println(maxLoss(new int[] {1,100,1,200,199, 180,110})); // -99
        System.out.println(maxLoss(new int[] {1})); // 0
        System.out.println(maxLoss(new int[] {360206605, 753529295, 289276846, 389601008, 956209493, 759816072, 21292839, 95253218, 761349009, 529261257}));//-934916654
        System.out.println(maxLoss(new int[] {1,1})); //0


    }
}
