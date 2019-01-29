package robotcleaner;

import java.util.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class RobotController {

    private int patchesCleaned;
    private Map<int[], Integer> cleaned = new HashMap<>();

    @PostMapping("/robotclean")
    public
    @ResponseBody
    Solution newSolution(@RequestBody Robot newRobot) {
        patchesCleaned = 0;
        char[] instructions = newRobot.instructions.toCharArray();
        int[] coord = newRobot.coords;
        int[] previousCoord;
        for (char i : instructions) {
            previousCoord = Arrays.copyOf(coord, 2);
            switch (i) {
                case 'N':
                    coord[1]++;
                    break;
                case 'S':
                    coord[1]--;
                    break;
                case 'E':
                    coord[0]++;
                    break;
                case 'W':
                    coord[0]--;
                    break;
                default:
                    break;
            }
            coord = (isCoordValid(coord, newRobot.roomSize)) ? coord : previousCoord;
            if (!cleaned.containsKey(coord)) {
                cleaned.put(coord, 0);
            }
            isAtDirtPatch(coord, newRobot.patches);
        }
        return new Solution(coord, patchesCleaned);
    }

    private void isAtDirtPatch(int[] coord, ArrayList<int[]> patches) {
        for (int[] patch : patches) {
            if (Arrays.equals(coord, patch) && cleaned.get(coord) == 0) {
                patchesCleaned++;
                cleaned.put(coord, 1);
            }
        }
    }

    private Boolean isCoordValid(int[] coord, int[] roomSize) {
        return coord[0] > 0 && coord[0] <= roomSize[0] && coord[1] > 0 && coord[1] <= roomSize[1];
    }

}
