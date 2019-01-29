package robotcleaner;

import lombok.Data;

@Data
public class Solution {

    private int[] coords = new int[2];
    private int patchesCleaned;

    Solution(int[] coords, int patchesCleaned) {
        this.coords = coords;
        this.patchesCleaned = patchesCleaned;
    }
}
