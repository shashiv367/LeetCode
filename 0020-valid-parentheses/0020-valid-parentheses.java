class Solution {
    public boolean isValid(String s) {
        char [] arr = new char[s.length()];
        int top = -1;
        for(char c : s.toCharArray()){
            if(top == -1){
                top++;
                arr[top] = c;
            }
            else{
                if(
                    (arr[top] == '(' && c == ')') ||
                    (arr[top] == '{' && c == '}') ||
                    (arr[top] == '[' && c == ']')
                ){
                    top--;
                }
                else{
                    top++;
                    arr[top] = c;
                }
            }
        }
        return (top == -1);
    }
}