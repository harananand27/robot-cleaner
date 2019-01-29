package robotcleaner;

import lombok.Data;

@Data
public class Solution {

    private int[] coords = new int[2];
    private int patches;

    Solution(int[] coords, int patches) {
        this.coords = coords;
        this.patches = patches;
    }
}
