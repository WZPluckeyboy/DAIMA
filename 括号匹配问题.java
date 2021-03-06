//括号匹配问题
import java.util.Stack;
class  Solution{
    public boolean isValid(String s){
        if(s==null){
            throw new UnsupportedOperationException ( "字符串为空" );
        }
        Stack<Character> stack=new Stack <Character> ();
        char[ ] arrays=s.toCharArray ();
        for(char data: arrays){
            if(data=='('||data=='['||data=='{'){
                stack.push ( data );
            }
            else {
                if (stack.isEmpty ( )) {
                    return false;
                }
                char ch = stack.pop ( );
                if (( ch == '(' && data == ')' ) || ( ch == '[' && data == ']' ) || ( ch == '{' && data == '}' )) {
                    continue;
                }
                return false;
            }
                }
                return stack.isEmpty ();
            }

        }
public class 括号匹配问题 {
    public static void main(String[] args) {
        Solution solution=new Solution ();
        System.out.println ( solution.isValid ("[)}"));
    }
}
