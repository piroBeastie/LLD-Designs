package SnakeAndLadder;

import java.util.*;

public class Board {
    private final int size;
    private final int max;
    private final Map<Integer, Integer> jumps;
    private final Random rand;

    public Board(int size) {
        this.size = size;
        this.max = size * size;
        this.jumps = new HashMap<>();
        this.rand = new Random();
    }

    public int getSize() {
        return size;
    }

    public int getMax() {
        return max;
    }

    public int getJump(int pos) {
        return jumps.getOrDefault(pos, pos);
    }

    public void addJump(Jump jump) {
        if (isValidJump(jump)) {
            jumps.put(jump.getStart(), jump.getEnd());
        }
    }

    private boolean isValidJump(Jump jump) {
        int start = jump.getStart();
        int end = jump.getEnd();

        if (start <= 1 || start >= max) return false;
        if (end <= 1 || end > max) return false;
        if (start == end) return false;

        // No duplicate start/end
        if (jumps.containsKey(start) || jumps.containsValue(start)) return false;
        if (jumps.containsKey(end) || jumps.containsValue(end)) return false;

        // Check cycle
        int curr = end;
        Set<Integer> visited = new HashSet<>();

        while (jumps.containsKey(curr)) {
            if (curr == start) return false;
            if (!visited.add(curr)) return false;
            curr = jumps.get(curr);
        }

        return true;
    }

    public void placeRandomJumps(int count) {
        int attempts = 0;

        while (jumps.size() < count && attempts < 1000) {
            attempts++;

            int start = rand.nextInt(max - 2) + 2;
            int end = rand.nextInt(max - 2) + 2;

            if (start == end) continue;

            addJump(new Jump(start, end));
        }
    }
}