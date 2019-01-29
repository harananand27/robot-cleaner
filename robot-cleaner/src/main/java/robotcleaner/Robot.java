package robotcleaner;

import lombok.Data;

import java.util.ArrayList;

@Data
class Robot {

    public int[] roomSize = new int[2];
    public int[] coords = new int[2];
    public ArrayList<int[]> patches = new ArrayList<>();
    public String instructions;

    Robot(int[] roomSize, int[] coords, ArrayList<int[]> patches, String instructions) {
        this.roomSize = roomSize;
        this.coords = coords;
        this.patches = patches;
        this.instructions = instructions;
    }
}
