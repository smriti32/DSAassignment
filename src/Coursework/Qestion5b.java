package Coursework;


import java.util.Arrays;
public class Qestion5b {
    public static int batteryReplacement(int[][] serviceCenters, int targetMiles, int startChargeCapacity) {
        // sort service centers by the miles at which they are located
        Arrays.sort(serviceCenters, (a, b) -> a[0] - b[0]);
        int count = 0; // initialize counter to keep track of number of service centers visited
        int curMiles = startChargeCapacity; // initialize current miles to startChargeCapacity
        int i = 0; // initialize index of service center
        while (curMiles < targetMiles) { // loop until current miles reaches target miles
            int maxMiles = 0; // initialize maximum miles that can be traveled from current service center
            while (i < serviceCenters.length && serviceCenters[i][0] <= curMiles) {
                // loop through all service centers that can be reached from current service center
                // and update maxMiles accordingly
                maxMiles = Math.max(maxMiles, serviceCenters[i][1]);
                i++;
            }
            if (maxMiles == 0) { // if there are no service centers that can be reached from current service center, return -1
                return -1;
            }
            curMiles = maxMiles + curMiles; // update current miles
            count++; // increment counter
        }
        return count; // return number of service centers visited
    }

    public static void main(String[] args) {
        int[][] serviceCenters = {{10,60},{20,30},{30,30},{60,40}}; // input service centers
        int targetMiles = 100; // input target miles
        int startChargeCapacity = 10; // input starting charge capacity
        System.out.println(batteryReplacement(serviceCenters, targetMiles, startChargeCapacity)); // print output
    }
}
