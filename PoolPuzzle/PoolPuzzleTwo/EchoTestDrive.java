package PoolPuzzle.PoolPuzzleTwo;

public class EchoTestDrive {
    public static void main(final String[] args) {

        int x = 0;

        /*
         * Output should be: helloooo... helloooo... helloooo... hellooo... 24
         */

        // counter will keep track of ouput should count up to 4
       Echo e1 = new Echo();
       Echo e2 = new Echo();
        
        while(x < 4){
            e1.hello();
            //
            if(){
                e2.count = e2.count + 1;
            }
            if(){
                e1.count = e2.count + e1.count;

            }
            x = x + 1;
        }
        
    }
}
