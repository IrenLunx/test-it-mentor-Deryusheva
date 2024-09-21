package src;

class CharactersInfo {

    private final char[] chars;
    private final String str;

    public CharactersInfo(char[] chars, String str) {
        this.chars = chars;
        this.str = str;
    }

    public char getExistingChar() {

        char ch = 0;
        for (char c : chars) {
            if (str.contains(String.valueOf(c))) {
                ch = c;
                break;
            }
        }
        return ch;
    }

    public int getCountOperations() {

        int count = 0;
        for (char c : chars) {
            for (char ch : str.toCharArray()) {
                if (ch == c) {
                    count++;
                }
            }
        }
        return count;
    }
}
