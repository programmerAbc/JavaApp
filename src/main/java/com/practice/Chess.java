package com.practice;

public class Chess {
    String data;
    int targetLength;
    int maxRow;
    int maxColumn;

    public Chess(int maxRow, int maxColumn, int targetLength, String data) {
        if (maxRow <= 0 || maxColumn <= 0) throw new RuntimeException("ERROR INPUT");
        if (targetLength <= 0) throw new RuntimeException("ERROR INPUT");
        if (data == null || data.isEmpty() || data.length() != maxRow * maxColumn)
            throw new RuntimeException("ERROR INPUT");
        this.data = data;
        this.maxRow = maxRow;
        this.maxColumn = maxColumn;
        this.targetLength = targetLength;
    }

    public boolean find() {
        return scanRow() || scanColumn() || scanBackSlash() | scanForwardSlash();
    }

    // ---
    public boolean scanRow() {
        for (int r = 0; r < maxRow; ++r) {
            int len = 1;
            char lastChar = '.';
            for (int c = 0; c < maxColumn; ++c) {
                if (data.charAt(r * maxColumn + c) == '.') {
                    len = 1;
                    lastChar = '.';
                } else if (data.charAt(r * maxColumn + c) == lastChar) {
                    len++;
                    if (len >= targetLength) {
                        return true;
                    }
                } else {
                    len = 1;
                    lastChar = data.charAt(r * maxColumn + c);
                }
            }
        }
        return false;
    }

    // |
    public boolean scanColumn() {
        for (int c = 0; c < maxColumn; ++c) {
            int len = 1;
            char lastChar = '.';
            for (int r = 0; r < maxRow; ++r) {
                if (data.charAt(r * maxColumn + c) == '.') {
                    len = 1;
                    lastChar = '.';
                } else if (data.charAt(r * maxColumn + c) == lastChar) {
                    len++;
                    if (len >= targetLength) {
                        return true;
                    }
                } else {
                    len = 1;
                    lastChar = data.charAt(r * maxColumn + c);
                }
            }
        }
        return false;
    }

    // /
    public boolean scanForwardSlash() {
        for (int b = 0; b <= maxRow + maxColumn - 2; ++b) {
            int len = 1;
            char lastChar = '.';
            for (int x = 0; x < maxColumn; ++x) {
                int y = -x + b;
                if (y < 0 || y >= maxRow) {
                    len = 1;
                    lastChar = '.';
                } else if (data.charAt(y * maxColumn + x) == '.') {
                    len = 1;
                    lastChar = '.';
                } else if (data.charAt(y * maxColumn + x) == lastChar) {
                    len++;
                    if (len >= targetLength) {
                        return true;
                    }
                } else {
                    len = 1;
                    lastChar = data.charAt(y * maxColumn + x);
                }
            }
        }
        return false;
    }

    // \
    public boolean scanBackSlash() {
        for (int b = -(maxColumn - 1); b <= maxRow - 1; ++b) {
            int len = 1;
            char lastChar = '.';
            for (int x = 0; x < maxColumn; ++x) {
                int y = x + b;
                if (y < 0 || y >= maxRow) {
                    len = 1;
                    lastChar = '.';
                } else if (data.charAt(y * maxColumn + x) == '.') {
                    len = 1;
                    lastChar = '.';
                } else if (data.charAt(y * maxColumn + x) == lastChar) {
                    len++;
                    if (len >= targetLength) {
                        return true;
                    }
                } else {
                    len = 1;
                    lastChar = data.charAt(y * maxColumn + x);
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Chess chess=new Chess(40,54,3,"...*.................*.................*..................*.................*.................*..................*.................*.................*..................*.................*.................*............................................................................................................................++++..............++++..............+++++..........................................................................................................................................................................................*.................*.................*................*.................*.................*................*.................*.................*................*.................*.................*...........................................................................................................................................................................................................................................................................................................................................*.................*.................*..................*.................*.................*..................*.................*.................*..................*.................*.................*............................................................................................................................++++..............++++..............++++...........................................................................................................................................................................................*.................*.................*................*.................*.................*................*.................*.................*................*.................*.................*........................................................................................................................................................................................................................................................................................................................................");
        if (chess.find()){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }

    }
}
