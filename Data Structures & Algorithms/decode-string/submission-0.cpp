class Solution {
public:
    int i = 0;

    string decodeString(string s) {
        string result = "";
        int k = 0;

        while (i < s.length()) {
            char ch = s[i];

            if (isdigit(ch)) {
                k = k * 10 + (ch - '0');
                i++;
            }
            else if (ch == '[') {
                i++;

                string decodedStr = decodeString(s);

                for (int j = 0; j < k; j++) {
                    result += decodedStr;
                }

                k = 0;
            }
            else if (ch == ']') {
                i++;
                break;
            }
            else {
                result += ch;
                i++;
            }
        }

        return result;
    }
};